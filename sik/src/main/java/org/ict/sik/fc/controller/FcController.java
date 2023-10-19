package org.ict.sik.fc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;


import org.ict.sik.brand.model.service.BrandService;
import org.ict.sik.brand.model.vo.Brand;
import org.ict.sik.common.Paging;

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
		Fc fc = (Fc)session.getAttribute("loginMember");
		logger.info("fclogin : " + fc);
		mv.setViewName("franchisee/fr_main");
		return mv;
	}
	

	
	//브랜드 공지사항 띄우기
	@Autowired
	private BrandService brandService;

	@RequestMapping("selectBrandListFr.do")
	public ModelAndView brandListMethod(@RequestParam(name = "page", required = false) String page, ModelAndView mv) {

		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}

		// 한 페이지 공지 10개 씩 출력되게 한다면
		int limit = 10;

		// 총 페이지 수 계산을 위한 공지글 총 갯수 조회

		int listCount = brandService.selectListCount();
		Paging paging = new Paging(listCount, currentPage, limit, "selectBrandList.do");
		paging.calculator();

		// 페이지에 출력할 목록 조회해 옴
		ArrayList<Brand> list = brandService.selectList(paging);


		if (list != null && list.size() > 0) {
			mv.addObject("listCount", listCount);
			mv.addObject("list", list);
			mv.addObject("paging", paging);
			mv.addObject("currentPage", currentPage);
			mv.addObject("limit", limit);

			mv.setViewName("brand/brandListView");
		} else {
			mv.addObject("message", "브랜드 공지를 읽어오지 못했습니다.");

			mv.setViewName("common/error");
		}
		return mv;
	}
	

	
	
}
