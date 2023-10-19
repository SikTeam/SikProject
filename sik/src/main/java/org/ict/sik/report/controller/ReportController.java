package org.ict.sik.report.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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

	// 결재페이지 리스트로 가기
	@RequestMapping("reportList.do")
	public ModelAndView reportList(@RequestParam(name = "page", required = false) String page, ModelAndView mv,
			HttpSession session) {
    
		// session 에서 memberId 받아오기
		Member member = (Member) session.getAttribute("loginMember");
		String memberId = member.getMemberId();

		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}

		int limit = 10;
		int listCount = reportSignService.listCount(memberId);
		logger.info("listCount : " + listCount);

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
			mv.addObject("list2", list2);
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

	// 결재자 정보 불러오기
	@RequestMapping(value = "addApprover.do", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String ApproverMemberSelect(HttpServletResponse response,
			@RequestParam(name = "dept", required = false) String dept,
			@RequestParam(name = "position", required = false) String position) throws IOException {

		logger.info(dept + "/" + position);

		MemberDeptPosition dp = new MemberDeptPosition(dept, position);

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


	// 결재 등록 페이지 이동하면서 reportId 생성 및 임시저장 보고서 생성하기
	@RequestMapping("getReportId.do")
	public ModelAndView getReportId(ModelAndView mv, HttpServletRequest request) {
		Report report = new Report();
		ReportSign reSign = new ReportSign();
		// reportId 생성하기
		String reportId = reportService.getReportId();
		report.setReportId(reportId);

		// session 에서 memberId 받아오기
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginMember");

		// 1번 결재자로 등록하기 위해 결재자No 생성
		int countApproval = reportSignService.countApproval(reportId) + 1;

		// report값 세팅
		report.setReportId(reportId);
		// reportSign값 세팅
		reSign.setReportId(reportId);
		reSign.setReportSignCounter(countApproval);
		reSign.setMemberId(member.getMemberId());
		reSign.setReSign("Y");
		// report 임시저장
		int reportResult = reportService.insertReport(report);
		// reportSign 임시저장
		int reportSignResult = reportSignService.insertReport(reSign);

		if (reportResult > 0 && reportSignResult > 0) {
			mv.addObject("reportId", reportId);

			mv.setViewName("report/insertReport");
		} else {
			mv.addObject("message", "결재창 불러오기 실패.");
			mv.setViewName("common/error");
		}
		return mv;
	}

	// 결재 라인 등록
	@RequestMapping(value = "approvalLine.do", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String approvalLine(HttpServletResponse response,
			@RequestParam(name = "memberId", required = false) String memberId,
			@RequestParam(name = "reportId", required = false) String reportId) throws IOException {

		logger.info(reportId + "/" + memberId);

		Report report = new Report();
		ReportSign reSign = new ReportSign();
		report.setReportId(reportId);
		reSign.setReportId(reportId);
		reSign.setMemberId(memberId);
		reSign.setReSign("Y");

		// 동일한 결재자가 있는지 체크 있으면 error 체크
		int sameMemberCheck = reportSignService.sameMemberCheck(reSign);
		logger.info("================== sameMemberCheck : "+sameMemberCheck);
		if (sameMemberCheck > 0) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			JSONObject errorJson = new JSONObject();
			errorJson.put("error", "동일한 참조/결재자가 있습니다.");
			return errorJson.toJSONString();
		} else {
			// 미미 ★
			response.setContentType("application/json; charset=utf-8");
			// 지금 사인이 몇번째인지 알아보는 작업
			int countApproval = reportSignService.countApproval(reportId) + 1;

			reSign.setReportSignCounter(countApproval);

			// 결재자 정보 등록
			int reportSignResult = reportSignService.insertReport(reSign);
			ArrayList<ReportSign> relist = reportSignService.selectApproval(reSign);
			ArrayList<MemberDeptPosition> memberList = memberService.selectApprovalList(reportId);

			if (reportSignResult > 0) {

				JSONObject sendJson = new JSONObject();
				JSONArray jarr = new JSONArray();
				JSONArray jarr2 = new JSONArray();

				for (ReportSign r : relist) {
					JSONObject job = new JSONObject();

					job.put("reportId", URLEncoder.encode(r.getReportId(), "UTF-8"));
					job.put("memberId", URLEncoder.encode(r.getMemberId(), "UTF-8"));
					job.put("reSign", URLEncoder.encode(r.getReSign(), "UTF-8"));
					job.put("reRead", URLEncoder.encode(r.getReRead(), "UTF-8"));
					job.put("reportSignCounter", r.getReportSignCounter());

					jarr.add(job);
				}

				for (MemberDeptPosition m : memberList) {
					JSONObject job2 = new JSONObject();

					job2.put("memberName", URLEncoder.encode(m.getMemberName(), "UTF-8"));
					job2.put("deptName", URLEncoder.encode(m.getDeptName(), "UTF-8"));
					job2.put("positionName", URLEncoder.encode(m.getPositionName(), "UTF-8"));

					jarr2.add(job2);
				}

				sendJson.put("relist", jarr);
				sendJson.put("memberList", jarr2);
				logger.info("sendJson : " + sendJson.toString());

				return sendJson.toJSONString();

			} else {
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				JSONObject errorJson = new JSONObject();
				errorJson.put("error", "결재보고서 임시저장 실패");
				return errorJson.toJSONString();
			}
		}
	}
	
	// 참조 라인 등록
	@RequestMapping(value = "referenceLine.do", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String referenceLine(HttpServletResponse response,
			@RequestParam(name = "memberId", required = false) String memberId,
			@RequestParam(name = "reportId", required = false) String reportId) throws IOException {

		logger.info(reportId + "/" + memberId);

		Report report = new Report();
		ReportSign reSign = new ReportSign();
		report.setReportId(reportId);
		reSign.setReportId(reportId);
		reSign.setMemberId(memberId);
		reSign.setReSign("N");

		// 동일한 결재자가 있는지 체크 있으면 error 체크
		int sameMemberCheck = reportSignService.sameMemberCheck(reSign);
		logger.info("================== sameMemberCheck : "+sameMemberCheck);
		if (sameMemberCheck > 0) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			JSONObject errorJson = new JSONObject();
			errorJson.put("error", "동일한 참조/결재자가 있습니다.");
			return errorJson.toJSONString();
		} else {
			// 미미 ★
			response.setContentType("application/json; charset=utf-8");
			// 지금 사인이 몇번째인지 알아보는 작업

			// 결재자 정보 등록
			int reportSignResult = reportSignService.insertReport(reSign);
			ArrayList<ReportSign> relist = reportSignService.selectApproval(reSign);
			ArrayList<MemberDeptPosition> memberList = memberService.selectApprovalList(reportId);

			if (reportSignResult > 0) {

				JSONObject sendJson = new JSONObject();
				JSONArray jarr = new JSONArray();
				JSONArray jarr2 = new JSONArray();

				for (ReportSign r : relist) {
					JSONObject job = new JSONObject();

					job.put("reportId", URLEncoder.encode(r.getReportId(), "UTF-8"));
					job.put("memberId", URLEncoder.encode(r.getMemberId(), "UTF-8"));
					job.put("reSign", URLEncoder.encode(r.getReSign(), "UTF-8"));
					job.put("reRead", URLEncoder.encode(r.getReRead(), "UTF-8"));
					job.put("reportSignCounter", r.getReportSignCounter());

					jarr.add(job);
				}

				for (MemberDeptPosition m : memberList) {
					JSONObject job2 = new JSONObject();

					job2.put("memberName", URLEncoder.encode(m.getMemberName(), "UTF-8"));
					job2.put("deptName", URLEncoder.encode(m.getDeptName(), "UTF-8"));
					job2.put("positionName", URLEncoder.encode(m.getPositionName(), "UTF-8"));

					jarr2.add(job2);
				}

				sendJson.put("relist", jarr);
				sendJson.put("memberList", jarr2);
				logger.info("sendJson : " + sendJson.toString());

				return sendJson.toJSONString();

			} else {
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				JSONObject errorJson = new JSONObject();
				errorJson.put("error", "결재보고서 임시저장 실패");
				return errorJson.toJSONString();
			}
		}
	}
	

	// 결재 보고서 저장
	@RequestMapping(value = "reportUpdate.do", method = RequestMethod.POST)
	public String reportInsert(Model model, HttpServletRequest request,

			@RequestParam(name = "reTitle", required = false) String reTitle,
			@RequestParam(name = "reContent", required = false) String reContent,
			@RequestParam(name = "reportId", required = false) String reportId,
			@RequestParam(name = "reFile", required = false) MultipartFile mfile) {

		Report report = new Report();
		report.setReTitle(reTitle);
		report.setReContent(reContent);
		report.setReportId(reportId);
		String savePath = request.getSession().getServletContext().getRealPath("resources/common/images/report");
		String renameFileName = null;

		logger.info("savePath : " + savePath);

		// 첨부 파일이 있을 때
		if (!mfile.isEmpty()) {
			// 파일이름 추출
			String fileName = mfile.getOriginalFilename();

			// 파일명 변경
			if (fileName != null && fileName.length() > 0) {

				// 바꿀 파일명 생성
				renameFileName = report.getReportId();
				renameFileName += "." + fileName.substring(fileName.lastIndexOf(".") + 1);

				logger.info("fileName : " + fileName + ", " + renameFileName);
				try {
					// 저장 폴더에 파일명 바꾸기
					mfile.transferTo(new File(savePath + "\\" + renameFileName));
				} catch (IOException e) {
					e.printStackTrace();
					model.addAttribute("message", "첨부파일 저장실패");
					return "common/error";
				}
			} // 파일명 바꾸기
			report.setReFile(renameFileName);

		} // 첨부파일 있을 때


		if (reportService.updateReport(report) > 0) {
			return "redirect:reportList.do";
		} else {
			model.addAttribute("message", "새 게시글 등록 실패");
			return "common/error";
		}
	}
	
	@RequestMapping(value = "deleteReport.do", method = RequestMethod.POST)
	public String deleteReport(HttpServletRequest request,
			@RequestParam(name = "reportId", required = false) String reportId) {
		logger.info("reportId : "+reportId);
		
		return " ";
	}
	

}
