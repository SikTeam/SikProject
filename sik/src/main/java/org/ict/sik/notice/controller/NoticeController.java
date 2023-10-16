package org.ict.sik.notice.controller;

import java.util.ArrayList;

import org.ict.sik.common.Paging;
import org.ict.sik.notice.model.service.NoticeService;
import org.ict.sik.notice.model.vo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("brandNoticeListView.do")
	public ModelAndView noticeListViewMethod(@RequestParam("page") String page,ModelAndView mv) {
		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}

		// 한 페이지 공지 10개 씩 출력되게 한다면
		int limit = 10;

		// 총 페이지 수 계산을 위한 공지글 총 갯수 조회
		int listCount = noticeService.selectListCount();
		Paging paging = new Paging(listCount, currentPage, limit, "selectBrandList.do");
		paging.calculator();

		// 페이지에 출력할 목록 조회해 옴
		ArrayList<Notice> list = noticeService.selectList(paging);
		
		if (list != null && list.size() > 0) {
			mv.addObject("listCount", listCount);
			mv.addObject("list", list);
			mv.addObject("paging", paging);
			mv.addObject("currentPage", currentPage);
			mv.addObject("limit", limit);
			mv.setViewName("brand/brandListView");
		} else {
			mv.addObject("message", "브랜드 리스트를 읽어오지 못했습니다.");
			mv.setViewName("common/error");
		}
		return mv;
	}
}
