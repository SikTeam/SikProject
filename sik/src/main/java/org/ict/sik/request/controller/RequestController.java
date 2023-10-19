package org.ict.sik.request.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.ict.sik.request.model.vo.FranchiseeRequest;
import org.ict.sik.request.model.vo.Request;
import org.ict.sik.request.service.RequestService;
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
	
	//요청사항 쓰기 페이지 이동 처리용
	@RequestMapping(value="requestwriteform.do")
	public String moveRequestWritePage() {
		return "franchisee/fr_request/requestWriteForm";
	}

	
	//요청 처리용---------------------------------------------
	
	//요청사항 작성
	@RequestMapping(value="rinsert.do", method= {RequestMethod.POST, RequestMethod.GET})
	public String insertRequestMehtod(FranchiseeRequest franchiseeRequest, Model model, HttpServletRequest hsrequest) {
		
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
			@RequestParam(name="limit", required=false) String limitStr, ModelAndView mv) {
		int currentPage = 1;

		int requestCount = requestService.selectListCount();
		ArrayList<FranchiseeRequest> list = requestService.selectList();
		
		
//		if (page != null) {
//			currentPage = Integer.parseInt(page);
//		}
//		
//		// 한 페이지에 요청사항 10개씩 출력되게 
//		int limit = 10;
//		if (limitStr != null) {
//			limit = Integer.parseInt(limitStr);
//		}
//		// 총 페이지 수 계산을 위한 게시글 총 개수 조회
//		int listCount = requestService.selectListCount();
//		// 페이지 관련 항목 계산 처리
//		Paging paging = new Paging(listCount, currentPage, limit, "rlist.do");
//		paging.calculator();
//
//		// 페이지에 출력할 목록 조회
//		ArrayList<Request> list = requestService.selectList(paging);
//
//		if (list != null && list.size() > 0) {
//			model.addAttribute("list", list);
//			model.addAttribute("paging", paging);
//			model.addAttribute("currentPage", currentPage);
//			model.addAttribute("limit", limit);
		mv.addObject("list", list);
		mv.setViewName("franchisee/fr_request/fr_requestListView");
			return mv;
//		} else {
//			model.addAttribute("message", currentPage + " 요청사항 목록 조회 실패!");
//
//			return "common/error";
//		}
	}
}
	
	

