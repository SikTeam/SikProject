package org.ict.sik.notice.controller;

import static org.ict.sik.common.AuthorityCheck.Authority;


import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ict.sik.brand.model.service.BrandService;
import org.ict.sik.brand.model.vo.Brand;

import org.ict.sik.common.FileNameChange;

import org.ict.sik.common.Paging;
import org.ict.sik.common.Search;
import org.ict.sik.member.model.service.MemberService;
import org.ict.sik.member.model.vo.Member;
import org.ict.sik.notice.model.service.NoticeService;
import org.ict.sik.notice.model.vo.BrandNotice;

import org.ict.sik.notice.model.vo.Notice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private BrandService brandService;
	@Autowired
	private MemberService memberService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("brandNoticeListView.do")
	public ModelAndView noticeListViewMethod(@RequestParam(name = "page", required = false) String page,
			@RequestParam(name = "brand", required = false) String brand,
			@RequestParam(name = "keyword", required = false) String keyword,
			@RequestParam(name = "action", required = false) String action,
			@RequestParam("board") String boardName,
			ModelAndView mv, HttpServletRequest request) {
		logger.info("keyword : " + keyword);
		if(keyword == null || keyword.equals("")) {
			action = null;
		}
		logger.info("action : " + action);
		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
			logger.info("currentPage"+currentPage);
		}
		
		HttpSession session = request.getSession();
		Member loginMember = (Member) session.getAttribute("loginMember");
		logger.info("loginMember : " + loginMember);
		Map<String, String> roll = Authority(loginMember, boardName,
				memberService.selectRollList(loginMember.getMemberId()));
		if (roll == null) {
			// 권한이 없음
		}
		

		logger.info("roll : " + roll);
		// 한 페이지 공지 10개 씩 출력되게 한다면
		int limit = 10;
		// 총 페이지 수 계산을 위한 공지글 총 갯수 조회
		Search search = new Search();
		
		int listCount = 0;

		if (brand == null || brand.equals("all")) {
			if (keyword == null) {
				listCount = noticeService.selectListCount();
			} else {
				search.setKeyword(keyword);
				listCount = noticeService.selectListCount(search);
			}
		} else {
			search.setBrand(brand);
			logger.info("search.brand : " + search.getBrand());
			if (keyword == null) {
				listCount = noticeService.selectListCount(search);
			} else {

				search.setKeyword(keyword);
				listCount = noticeService.selectListCount(search);
			}
		}
		String url = "brandNoticeListView.do";


		Paging paging = new Paging(listCount, currentPage, limit, url);
		paging.calculator();
		paging.setBoard(boardName);
		search.setStartRow(paging.getStartRow());
		search.setEndRow(paging.getEndRow());

		// 페이지에 출력할 목록 조회해 옴
		ArrayList<BrandNotice> list = noticeService.selectList(search);

		ArrayList<Brand> brandList = brandService.selectList();
		if (list != null && list.size() > 0) {
			mv.addObject("action", action);
			mv.addObject("board", boardName);

			mv.addObject("listCount", listCount);
			mv.addObject("list", list);
			mv.addObject("brandList", brandList);
			mv.addObject("paging", paging);
			mv.addObject("currentPage", currentPage);
			mv.addObject("limit", limit);

			mv.addObject("roll", roll);
			mv.addObject("keyword",keyword);

			mv.setViewName("brand/notice/brandNoticeListView");
		} else {
			mv.addObject("message", "브랜드 리스트를 읽어오지 못했습니다.");
			mv.setViewName("common/error");
		}
		return mv;
	}


	@RequestMapping("noticeDetailView.do")
	public ModelAndView noticeDetailViewMethod(@RequestParam("noid") String noId, @RequestParam("page") String page,
			ModelAndView mv) {
		int result = noticeService.updateAddReadCount(noId);
		BrandNotice notice = noticeService.selectDetail(noId);
		if (notice != null) {
			mv.addObject("page", page);
			mv.addObject("notice", notice);
			mv.setViewName("brand/notice/noticeDetailView");
		} else {
			mv.addObject("message", noId + "번 공지사항을 읽어오는대 실패함");

			mv.setViewName("common/error");
		}
		return mv;
	}


	@RequestMapping("brandNoticeInsert.do")
	public ModelAndView brandNoticeInsertMethod(@RequestParam("roll") String check, @RequestParam("board") String board,
			ModelAndView mv) {
		if (check.equals("Y")) {
			ArrayList<Brand> brandList = brandService.selectList();
			logger.info("check " + check);
			logger.info("board" + board);
			mv.addObject("board", board);
			mv.addObject("brandList", brandList);
			mv.setViewName("brand/notice/brandNoticeInsertView");
		}
		return mv;
	}

	@RequestMapping(value = "noticeInsert.do", method = RequestMethod.POST)
	public ModelAndView noticeInsertMethod(Notice notice, ModelAndView mv,
			@RequestParam(name = "OriginalFile", required = false) MultipartFile mfile, HttpServletRequest request,
			@RequestParam("board") String board) {
		mv.addObject("board", board);
		
		String savePath = request.getSession().getServletContext().getRealPath("resources/notice_upfiles");
		String renameFileName = null;

		if (!mfile.isEmpty()) {
			// 전송온 파일이름 추출함
			String fileName = mfile.getOriginalFilename();

			// 저장폴더에는 변경된 이름으로 저장처리
			// 파일 이름바꾸기함 : 년월일시분초.확장자
			if (fileName != null && fileName.length() > 0) {
				// 바꿀 파일명에 대한 문자열 만들기

				renameFileName = FileNameChange.change(fileName, "yyyyMMddHHmmss");
				logger.info("첨부파일명 확인 : " + fileName + ", " + renameFileName);
				try {
					// 저장 폴더에 파일명 바꾸기 처리
					mfile.transferTo(new File(savePath + "\\" + renameFileName));

				} catch (IOException e) {
					e.printStackTrace();
					mv.addObject("message", "첨부파일 저장 실패!");
					mv.setViewName("common/error");
					return mv;
				}
			} // 파일명 바꾸기
				// notice 객체에 첨부파일 정보 저장 처리
			notice.setNoFile(renameFileName);
		}
		notice.setNoId(Integer.toString(noticeService.selectListCount()+1));
		logger.info("notice : " + notice);
		if(noticeService.insertNotice(notice) <= 0) {
			mv.addObject("message", "첨부파일 저장 실패!");
			mv.setViewName("common/error");
			return mv;
		}
		mv.setViewName("redirect:brandNoticeListView.do");

		return mv;
	}

}
