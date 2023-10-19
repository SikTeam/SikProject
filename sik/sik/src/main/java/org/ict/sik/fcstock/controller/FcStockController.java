package org.ict.sik.fcstock.controller;

import java.util.ArrayList;

import org.ict.sik.common.Paging;
import org.ict.sik.common.Search;
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

	@RequestMapping("fcStock.do")
	public String moveFcStockMethod() {
		return "stock/fcStock";
	}
	
	@RequestMapping(value = "searchFcName.do", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView searchFcNameMethod(
	        @RequestParam(name = "page", required = false) String page,
	        @RequestParam("keyword") String keyword,
	        @RequestParam("searchOption") String searchOption, // 검색 옵션 파라미터 추가
	        ModelAndView mv) {
	    int currentPage = 1;
	    if (page != null) {
	        currentPage = Integer.parseInt(page);
	    }

	    int limit = 10;
	    int listCount = fcstockService.selectListFcCount(keyword, searchOption); // 검색 옵션을 포함한 카운트
	    Paging paging = new Paging(listCount, currentPage, limit, "searchFcName.do");
	    paging.calculator();
	    Search search = new Search();
	    search.setKeyword(keyword);
	    search.setStartRow(paging.getStartRow());
	    search.setEndRow(paging.getEndRow());
	    search.setSearchOption(searchOption); // 검색 옵션을 설정

	    ArrayList<FcStock> list = fcstockService.selectListFcName(search);

	    if (list != null && list.size() > 0) {
	        mv.addObject("listCount", listCount);
	        mv.addObject("list", list);
	        mv.addObject("paging", paging);
	        mv.addObject("currentPage", currentPage);
	        mv.addObject("limit", limit);
	    }

	    mv.setViewName("stock/fcStock");

	    return mv;
	}
	
}
