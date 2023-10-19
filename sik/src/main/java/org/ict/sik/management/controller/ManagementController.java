package org.ict.sik.management.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.ict.sik.fc.model.vo.Fc;
import org.ict.sik.management.model.service.ManagementService;
import org.ict.sik.management.model.vo.Management;
import org.ict.sik.request.model.service.RequestService;
import org.ict.sik.request.model.vo.FranchiseeRequest;
import org.ict.sik.request.model.vo.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ManagementController {
 
	private Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	@Autowired
	ManagementService managementService;

	@Autowired
	RequestService requestService;

	
	
	//뷰페이지 이동 처리용 -------------------------------------
	
	//요청사항 작성 페이지 이동
	@RequestMapping(value="requestManageWriteForm.do")
	public String moveRequestWritePage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Fc fc = (Fc)session.getAttribute("loginMember");
		logger.info("loginMember fc : " + fc);
		return "franchisee/fr_request/requestWriteForm";

	}
	
	//요청 처리용---------------------------------------------
	
	

	//요청사항글 등록 처리용  
	@RequestMapping(value="requestinsert.do", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView insertRequestMethod (Request inRequest, 
			ModelAndView mv, HttpServletRequest request,HttpSession session) {
		int managementCount = managementService.selectCount();
		logger.info("Count" + managementCount);
		Management management = new Management();
		management.setMgId(Integer.toString(managementCount+1));
		Fc loginMember = (Fc)session.getAttribute("loginMember");
		//logger.info("loginMember fc : " + loginMember);
		management.setMemberId(loginMember.getMemberId());
		management.setFranchiseId(loginMember.getFcId());
		management.setMgClassify("REQUEST");
		
		int managementInsert = managementService.insertOriginRequestManage(management);
		
		inRequest.setMgId(management.getMgId());
		int requestInsert = requestService.insertOriginRequest(inRequest);
		
		logger.info("성공여부 :" + managementInsert + ", " + requestInsert);
		mv.setViewName("franchisee/fr_main");
		return mv;
	}

	
	//요청사항게시글 상세보기 처리용
	@RequestMapping("rdetail.do")
	public ModelAndView requestDetailMethod (@RequestParam("mgId") String mgId,
			@RequestParam(name = "page", required = false) String page, ModelAndView mv,HttpServletRequest request, Request inRequest){ 
		logger.info("mgId : " + mgId);
		FranchiseeRequest fcr = new FranchiseeRequest();
		
		HttpSession session = request.getSession();
		Fc loginMember = (Fc)session.getAttribute("loginMember");
		fcr.setMgId(mgId);
		fcr.setFcId(loginMember.getFcId());
		logger.info("fcr : " + fcr);
		FranchiseeRequest viewFcr = managementService.selectManagementDetail(fcr);
		logger.info("viewFcr : " + viewFcr);
		//출력할 페이지 지정
		int currentPage = 1;
		
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}
		if(mgId != null) {
			mv.addObject("management", viewFcr);
			
			mv.setViewName("franchisee/fr_request/requestDetailView");
		} else {
			mv.addObject("message", mgId + " 번 글 상세보기에 실패하였습니다.");
			mv.setViewName("common/error");
		}
	
	
		return mv;
	}

}
