package org.ict.sik.notice.controller;

import java.util.ArrayList;

import org.ict.sik.brand.model.service.BrandService;
import org.ict.sik.brand.model.vo.Brand;
import org.ict.sik.common.Paging;
import org.ict.sik.common.Search;
import org.ict.sik.notice.model.service.NoticeService;
import org.ict.sik.notice.model.vo.BrandNotice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private BrandService brandService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@RequestMapping("brandNoticeListView.do")
	public ModelAndView noticeListViewMethod(@RequestParam("page") String page,
			@RequestParam(name = "brand", required = false) String brand,
			@RequestParam(name = "keyword", required = false) String keyword,
			ModelAndView mv) {
		logger.info("넘어온값 확인 : { brand : " + brand + ", page :" + page+", keyword : " + keyword+"}");
		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}
		// 한 페이지 공지 10개 씩 출력되게 한다면
		int limit = 10;
		// 총 페이지 수 계산을 위한 공지글 총 갯수 조회
		Search search = new Search();
		
		int listCount = 0;
		if(brand == null || brand.equals("all")) {
			if(keyword == null) {
				listCount = noticeService.selectListCount();
			}else {
				search.setKeyword(keyword);
				listCount = noticeService.selectListCount(search);
			}
		}else {
			search.setBrand(brand); // 브랜드 명으로 브랜드 아이디 가져와야함
			if(keyword == null) {
				listCount = noticeService.selectListCount(search);
			}else {
				search.setKeyword(keyword);
				listCount = noticeService.selectListCount(search);
			}
		}
		
		Paging paging = new Paging(listCount, currentPage, limit, "selectBrandList.do");
		paging.calculator();
		search.setStartRow(paging.getStartRow());
		search.setEndRow(paging.getEndRow());
		
		// 페이지에 출력할 목록 조회해 옴
		ArrayList<BrandNotice> list = noticeService.selectList(search);
		
		ArrayList<Brand> brandList = brandService.selectList();
		if (list != null && list.size() > 0) {
			mv.addObject("listCount", listCount);
			mv.addObject("list", list);
			mv.addObject("brandList", brandList);
			mv.addObject("paging", paging);
			mv.addObject("currentPage", currentPage);
			mv.addObject("limit", limit);
			mv.setViewName("brand/notice/brandNoticeListView");
		} else {
			mv.addObject("message", "브랜드 리스트를 읽어오지 못했습니다.");
			mv.setViewName("common/error");
		}
		return mv;
	}
	
	@RequestMapping("noticeDetailView.do")
	public ModelAndView noticeDetailViewMethod(@RequestParam("noid") String noId,
			@RequestParam("page") String page,
			ModelAndView mv) {
		BrandNotice notice = noticeService.selectDetail(noId);
		if(notice != null) {
			mv.addObject("page", page);
			mv.addObject("notice", notice);
			mv.setViewName("brand/notice/noticeDetailView");
		}else {
			mv.addObject("message", noId+"번 공지사항을 읽어오는대 실패함");
			mv.setViewName("common/error");
		}
		return mv;
	}
	
	
	
	//가맹점 메인화면 - 공지사항 상세보기 요청 처리용
	
}
