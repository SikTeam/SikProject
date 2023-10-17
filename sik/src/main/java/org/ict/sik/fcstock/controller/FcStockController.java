package org.ict.sik.fcstock.controller;

import java.util.ArrayList;

import org.ict.sik.common.Paging;
import org.ict.sik.common.Search;
import org.ict.sik.fc.model.service.FcService;
import org.ict.sik.fc.model.vo.Fc;
import org.ict.sik.fcstock.model.service.FcStockService;
import org.ict.sik.fcstock.model.vo.FcStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FcStockController {
	@Autowired
	private FcStockService fcstockService;

	@Autowired
	private FcService fcService;
	
	@RequestMapping("fcStock.do")
	public String moveFcStockMethod() {
		return "stock/fcStock";
	}
	
	
	@RequestMapping(value = "searchFcName.do", method = RequestMethod.POST)
	public ModelAndView searchFcNameMehtod(@RequestParam(name = "page", required = false) String page,
			@RequestParam("keyword") String keyword, ModelAndView mv) {
		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}

		// 한 페이지 공지 10개 씩 출력되게 한다면
		int limit = 10;

		// 총 페이지 수 계산을 위한 공지글 총 갯수 조회
		int listCount = fcstockService.selectListFcNameCount(keyword);
		Paging paging = new Paging(listCount, currentPage, limit, "searchFcName.do");
		paging.calculator();
		Search search = new Search();
		search.setKeyword(keyword);
		search.setStartRow(paging.getStartRow());
		search.setEndRow(paging.getEndRow());
		
		ArrayList<FcStock> fc =fcstockService.selectList(paging);
		
		// 페이지에 출력할 목록 조회해 옴
		ArrayList<FcStock> list = fcstockService.selectListFcName(search);

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
}
