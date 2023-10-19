package org.ict.sik.item.controller;

import java.util.ArrayList;

import org.ict.sik.common.Paging;
import org.ict.sik.common.Search;
import org.ict.sik.fcstock.model.vo.FcStock;
import org.ict.sik.item.model.service.ItemService;
import org.ict.sik.item.model.vo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping("itemList.do")
	public String moveItemListMethod(@RequestParam(name = "page", required = false) String page,
			@RequestParam(name = "limit", required = false) String limitStr, Model model) {
		  int currentPage = 1;
		  
		  if (page != null) { 
			  currentPage = Integer.parseInt(page); 
		  }
		  
		  int limit = 10; 
		  if (limitStr != null) { 
			  limit = Integer.parseInt(limitStr); 
		  }
		  
		  int listCount = itemService.selectListCount();
		  
		  Paging paging = new Paging(listCount, currentPage, limit, "itemList.do");
		  paging.calculator();
		  
		  ArrayList<Item> items = (ArrayList<Item>) itemService.getAllItems(paging);
		  
		  model.addAttribute("paging", paging); 
		  model.addAttribute("currentPage", currentPage);
		  model.addAttribute("limit", limit); 
		  model.addAttribute("items", items);
		 
		 return ("item/itemList");
		
	}
	
	@RequestMapping(value = "searchItemName.do", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView searchItemNameMethod(
	        @RequestParam(name = "page", required = false) String page,
	        @RequestParam("keyword") String keyword,
	        @RequestParam("searchOption") String searchOption, // 검색 옵션 파라미터 추가
	        ModelAndView mv) {
	    int currentPage = 1;
	    if (page != null) {
	        currentPage = Integer.parseInt(page);
	    }

	    int limit = 10;
	    int listCount = itemService.selectListItemCount(keyword, searchOption); // 검색 옵션을 포함한 카운트
	    Paging paging = new Paging(listCount, currentPage, limit, "searchItemName.do");
	    paging.calculator();
	    Search search = new Search();
	    search.setKeyword(keyword);
	    search.setStartRow(paging.getStartRow());
	    search.setEndRow(paging.getEndRow());
	    search.setSearchOption(searchOption); // 검색 옵션을 설정

	    ArrayList<Item> items = itemService.selectListItemName(search);

	    if (items != null && items.size() > 0) {
	        mv.addObject("listCount", listCount);
	        mv.addObject("items", items);
	        mv.addObject("paging", paging);
	        mv.addObject("currentPage", currentPage);
	        mv.addObject("limit", limit);
	    }

	    mv.setViewName("item/itemList");

	    return mv;
	}
	
}
