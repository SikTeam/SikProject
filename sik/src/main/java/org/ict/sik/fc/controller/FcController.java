package org.ict.sik.fc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.ict.sik.brand.model.vo.Brand;
import org.ict.sik.common.Paging;
import org.ict.sik.common.Search;
import org.ict.sik.fc.model.service.FcService;
import org.ict.sik.fc.model.vo.Fc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FcController {
	@Autowired
	private FcService fcService;
	
	private static final Logger logger = LoggerFactory.getLogger(FcController.class);
	
	@RequestMapping("fcLogin.do")
	public ModelAndView fcLoginMethod(ModelAndView mv, HttpSession session, SessionStatus status) {
		Fc fc = (Fc)session.getAttribute("fc");
		logger.info("fclogin : " + fc);
		mv.setViewName("franchisee/fr_main");
		return mv;
	}
	
	@RequestMapping("selectFcList.do")
	public ModelAndView fcListMethod(@RequestParam(name = "page", required = false) String page, ModelAndView mv) {
		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}

		// 한 페이지 공지 10개 씩 출력되게 한다면
		int limit = 10;

		// 총 페이지 수 계산을 위한 공지글 총 갯수 조회
		int listCount = fcService.selectListCount();
		Paging paging = new Paging(listCount, currentPage, limit, "selectFcList.do");
		paging.calculator();

		// 페이지에 출력할 목록 조회해 옴
		ArrayList<Fc> list = fcService.selectList(paging);

		if (list != null && list.size() > 0) {
			mv.addObject("listCount", listCount);
			mv.addObject("list", list);
			mv.addObject("paging", paging);
			mv.addObject("currentPage", currentPage);
			mv.addObject("limit", limit);
			mv.setViewName("stock/fcStock");
		} else {
			mv.addObject("message", "브랜드 리스트를 읽어오지 못했습니다.");
			mv.setViewName("common/error");
		}
		return mv;
	}

	@RequestMapping(value = "searchFc.do", method = RequestMethod.POST)
	public ModelAndView searchFcMehtod(@RequestParam(name = "page", required = false) String page,
			@RequestParam("keyword") String keyword, ModelAndView mv) {
		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}

		// 한 페이지 공지 10개 씩 출력되게 한다면
		int limit = 10;

		// 총 페이지 수 계산을 위한 공지글 총 갯수 조회
		int listCount = fcService.selectListFcCount(keyword);
		Paging paging = new Paging(listCount, currentPage, limit, "searchFc.do");
		paging.calculator();
		Search search = new Search();
		search.setKeyword(keyword);
		search.setStartRow(paging.getStartRow());
		search.setEndRow(paging.getEndRow());
		// 페이지에 출력할 목록 조회해 옴
		ArrayList<Fc> list = fcService.selectFcListName(search);

		if (list != null && list.size() > 0) {
			mv.addObject("listCount", listCount);
			mv.addObject("list", list);
			mv.addObject("paging", paging);
			mv.addObject("currentPage", currentPage);
			mv.addObject("limit", limit);
			mv.setViewName("stock/fcStock");
		} else {
			mv.addObject("message", "검색에 실패했습니다.");
			mv.setViewName("common/error");
		}
		return mv;
	}
	
	@RequestMapping("brandStock.do")
	public String movebrandStockMethod() {
		return "stock/brandStock";
	}
	
}
