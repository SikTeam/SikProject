package org.ict.sik.request.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ict.sik.fc.model.vo.Fc;
import org.ict.sik.request.model.service.RequestService;
import org.ict.sik.request.model.vo.FranchiseeRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class RequestController {
	
	private Logger logger = LoggerFactory.getLogger(RequestController.class);
	
	@Autowired 
	RequestService requestService;
	
	//뷰페이지 이동 처리용 -------------------------------------
	

	
	//요청 처리용---------------------------------------------
	
	//요청사항 작성
	@RequestMapping(value="rinsert.do", method= {RequestMethod.POST, RequestMethod.GET})
	public String insertRequestMethod(FranchiseeRequest franchiseeRequest, Model model, HttpServletRequest hsrequest) {
		
		logger.info("rinsert.do : " + franchiseeRequest);
		
		if(requestService.insertOriginRequest(franchiseeRequest) > 0) {
			return "redirect:rlist.do";
		} else {
			model.addAttribute("message", "새 요청사항 등록 실패");
			return "common/error";
		}
	}
	
	//요청사항 목록보기 요청 처리용 (페이징)
	@RequestMapping("rlist.do")
	public ModelAndView requestListMethod(@RequestParam(name="page", required= false) String page,
			@RequestParam(name="limit", required=false) String limitStr, ModelAndView mv, HttpSession session) {
		int currentPage = 1;
		
		Fc loginMember = (Fc)session.getAttribute("loginMember");
		
		
		//int requestCount = requestService.selectListCount();
		ArrayList<FranchiseeRequest> list = requestService.selectList(loginMember.getFcId());
		
		
		mv.addObject("list", list);
		mv.setViewName("franchisee/fr_request/fr_requestListView");
			return mv;

	}
}
	
	

