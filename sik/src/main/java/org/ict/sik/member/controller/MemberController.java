package org.ict.sik.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.ict.sik.common.Paging;
import org.ict.sik.common.Search;
import org.ict.sik.member.model.service.MemberService;
import org.ict.sik.member.model.vo.Member;
import org.ict.sik.member.model.vo.MemberDeptPosition;
import org.ict.sik.roll.model.vo.Roll;
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
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;

	@RequestMapping("login.do")
	public ModelAndView loginMethod(ModelAndView mv, HttpSession session, SessionStatus status) {
		Member member = (Member) session.getAttribute("member");
		logger.info("login.do : " + member);
		Member loginMember = null;

		loginMember = (Member) memberService.selectLogin(member);

		ArrayList<Roll> rollList = memberService.selectRollList(loginMember.getMemberId());
		ArrayList<String> boardList = new ArrayList<String>();
		
		for(int i = 0; i < rollList.size(); i++) {
			String roll = new Roll(rollList.get(i)).getRoll();
			String board = roll.substring(0, roll.length()-4);
			boardList.add(board);
		}
		
		
		if (loginMember != null) {
			if (loginMember.getAdminYn().equals("Y")) {
				session.setAttribute("loginMember", loginMember);
				status.setComplete();
			} else if (rollList.size() > 0 && loginMember.getAdminYn().equals("N")) {
				session.setAttribute("loginMember", loginMember);
				session.setAttribute("board", boardList);
			}
			mv.setViewName("main");
		} else {
			mv.addObject("message", "로그인 실패!");
			mv.setViewName("common/error");
		}
		
		
		
		return mv;
	}

	// 직원조회 페이지 보내기용 (페이징)
	@RequestMapping("mlist.do")
	public ModelAndView MemberListViewMethod(
			@RequestParam(name="page", required=false) String page,
			ModelAndView mv) {
		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}
		
		//한페이지에 목록 10개씩 출력되게 한다면
		int limit = 10;
		//회원 목록 전체 갯수 조회해 옴
		int listCount = memberService.selectlistCount();
		Paging paging = new Paging(listCount, currentPage, limit, "mlist.do");
		paging.calculator();	//페이징 계산
		
		
		ArrayList<MemberDeptPosition> list = memberService.selectList(paging);
		
		if(list != null && list.size() > 0) {
			mv.addObject("list", list);
			mv.addObject("paging", paging);
			mv.setViewName("member/memberListView");
		}else {
			mv.addObject("message", currentPage + "페이지 회원 목록 조회 실패요 돌아가소");
			mv.setViewName("common/error");
		}
		return mv;
	}

	//직원 사번으로 검색용 (페이징)
	@RequestMapping(value="msearchMId.do", method=RequestMethod.POST)
	public ModelAndView memberSearchIdMethod(
			@RequestParam("keyword") String keyword,
			@RequestParam(name="limit", required=false) String slimit,
			@RequestParam(name="page", required=false) String page,
			
			ModelAndView mv) {
		
		//검색 결과에 대한 페이징 처리
		//출력할 페이지 지정
		int currentPage = 1;
		//전송온 페이지 값이 있다면 추출
		if(page != null) {
			currentPage = Integer.parseInt(page);
		}
		
		//한 페이지당 출력할 목록 갯수 지정
		int limit = 10;
		//전송 온 limit 값이 있다면
		if(slimit != null) {
			limit = Integer.parseInt(slimit);
		}
		
		//총 페이지수 계산을 위한 검색 결과 적용된 총 목록 갯수 조회
		int listCount = memberService.selectSearchIdCount(keyword);
		
		//뷰 페이지에 사용할 페이징 관련 값 계산 처리
		Paging paging = new Paging(listCount, currentPage, limit, "msearchMId.do");
		paging.calculator();
		
		//서비스 메소드 호출하고 리턴결과 다루기
		Search search = new Search();
		search.setStartRow(paging.getStartRow());
		search.setEndRow(paging.getEndRow());
		search.setKeyword(keyword);
		
		ArrayList<MemberDeptPosition> list = memberService.selectSearchId(search);
		
		//받은 결과에 따라 성공/실패 페이지 내보내기
		if(list != null && list.size() > 0) {
			mv.addObject("list", list);
			mv.addObject("paging", paging);
			mv.addObject("currentPage", currentPage);
			mv.addObject("limit", limit);
			mv.addObject("keyword", keyword);
			mv.setViewName("member/memberListView");
		}else {
			mv.addObject(keyword + " 검색 결과가 존재하지 않습니다.");
			mv.setViewName("common/error");
		}
		
		return mv;
	}
	//직원 부서로 검색용 (페이징)
	
	//직원 직급으로 검색용 (페이징)
	
	//직원 등록날짜 검색용 (페이징)
	
}
