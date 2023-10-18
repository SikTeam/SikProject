package org.ict.sik.report.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ict.sik.common.Paging;
import org.ict.sik.common.Search;
import org.ict.sik.member.model.service.MemberService;
import org.ict.sik.member.model.vo.Member;
import org.ict.sik.member.model.vo.MemberDeptPosition;
import org.ict.sik.report.model.service.ReportService;
import org.ict.sik.report.model.vo.Report;
import org.ict.sik.reportsign.model.service.ReportSignService;
import org.ict.sik.reportsign.model.vo.ReportSign;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReportController {
	private static final Logger logger = LoggerFactory.getLogger(ReportController.class);
	@Autowired
	private ReportService reportService;
	@Autowired
	private ReportSignService reportSignService;

	@Autowired
	private MemberService memberService;

	//결재페이지 리스트
	@RequestMapping("reportList.do")
	public ModelAndView reportList(@RequestParam(name = "page", required = false) String page, ModelAndView mv, HttpSession session) {
		Member member = (Member)session.getAttribute("loginMember");
		String memberId = member.getMemberId();
		int currentPage = 1;
		if(page != null) {
			currentPage = Integer.parseInt(page);
		}
		
		int limit = 10;
		int listCount = reportSignService.listCount(memberId);
		logger.info("listCount : "+listCount);
		
		Paging paging = new Paging(listCount, currentPage, limit, "reportList.do");
		paging.calculator();
		
		Search search = new Search();
		search.setStartRow(paging.getStartRow());
		search.setEndRow(paging.getEndRow());
		search.setKeyword(memberId);
		
		ArrayList<ReportSign> list = reportSignService.selectList(search);
		ArrayList<Report> list2 = reportService.selectList(search);
		logger.info(search + memberId);

		if (list != null && list.size() > 0) {
			mv.addObject("list", list);
			mv.addObject("list2",list2);
			mv.addObject("paging", paging);
			mv.addObject("currentPage", currentPage);
			mv.addObject("limit", limit);
			mv.addObject("memberId", memberId);
			mv.setViewName("report/reportList");
		} else {
			mv.addObject("message", "결재리스트 없다.");
			mv.setViewName("common/error");
		}
		return mv;
	}
	
	//결재자 정보 불러오기
	@RequestMapping(value="addApprover.do", method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String ApproverMemberSelect(
			HttpServletResponse response,
			@RequestParam(name="dept", required=false) String dept,
			@RequestParam(name="position", required=false) String position
			) throws IOException {
		
		logger.info(dept+"/"+position);
		
		MemberDeptPosition dp = new MemberDeptPosition(dept,position);
		
		ArrayList<MemberDeptPosition> list = memberService.addApprover(dp);
		response.setContentType("application/json; charset=utf-8");
		
		JSONObject sendJson = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		
		for (MemberDeptPosition mdp : list) {
	        JSONObject jsonObject = new JSONObject();
	        
	        jsonObject.put("memberName", URLEncoder.encode(mdp.getMemberName(), "utf-8"));
	        jsonObject.put("memberId", URLEncoder.encode(mdp.getMemberId(), "utf-8"));
	        
	        jsonArray.add(jsonObject);
	    }
		sendJson.put("list", jsonArray);
		
		return sendJson.toJSONString();
	}
	
	//결재 등록 페이지 이동
	@RequestMapping("getReportId.do")
	public ModelAndView getReportId(ModelAndView mv) {
		String reportId = reportService.getReportId();
		
		ArrayList<MemberDeptPosition> list = memberService.selectFullList();
		
		logger.info(reportId);
		if (reportId != null) {
			mv.addObject("reportId", reportId);
			mv.addObject("list", list);
			mv.setViewName("report/insertReport");
		} else {
			mv.addObject("message", "결재창 불러오기 실패.");
			mv.setViewName("common/error");
		}
		return mv;
	}
	
	//결재 라인 등록
	@RequestMapping(value="approvalLine.do", method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String approvalLine(
			HttpServletResponse response,
			@RequestParam(name="memberId", required=false) String memberId,
			@RequestParam(name="reportId", required=false) String reportId
			) throws IOException {
		logger.info(reportId+"/"+memberId);
		
		Report report = new Report();
		ReportSign reSign = new ReportSign();
		response.setContentType("application/json; charset=utf-8");
		int countApproval = reportSignService.countApproval(reportId);
		Search search = new Search();
		search.setKeyword(memberId);
		ArrayList<MemberDeptPosition> memberList = memberService.selectSearchId(search);
		
		report.setReportId(reportId);
		reSign.setReportId(reportId);
		reSign.setMemberId(memberId);
		reSign.setReportSignCounter(countApproval);
		
		int reportResult= 0;
		
		if(countApproval == 1) {
			reportResult = reportService.insertReport(report);
		}
		
		int reportSignResult = reportSignService.insertReport(reSign);
		ArrayList<ReportSign> list = reportSignService.selectApproval(reSign);
		
		if(reportSignResult > 0) {
			
			JSONObject sendJson = new JSONObject();
			JSONArray jarr = new JSONArray();
			
			for(ReportSign r : list) {
				JSONObject job = new JSONObject();
				
				job.put("reportId", URLEncoder.encode(r.getReportId(), "UTF-8"));
				job.put("memberId", URLEncoder.encode(r.getMemberId(), "UTF-8"));
				job.put("reSign", URLEncoder.encode(r.getReSign(), "UTF-8"));
				job.put("reRead", URLEncoder.encode(r.getReRead(), "UTF-8"));
				job.put("reportSignCounter", r.getReportSignCounter());
				
				jarr.add(job);
			}
			sendJson.put("list", jarr);
			
		return sendJson.toJSONString();
		
		}else {
		    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		    JSONObject errorJson = new JSONObject();
		    errorJson.put("error", "결재보고서 임시저장 실패");
		    return errorJson.toJSONString();
		}
	}
	
	

}
