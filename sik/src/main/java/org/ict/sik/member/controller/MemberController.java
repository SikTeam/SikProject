package org.ict.sik.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.ict.sik.common.Paging;
import org.ict.sik.member.model.service.MemberService;
import org.ict.sik.member.model.vo.Member;
import org.ict.sik.member.model.vo.MemberDeptPosition;
import org.ict.sik.roll.model.vo.Roll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

		ArrayList<Roll> rollList = memberService.selectRollList(member.getMemberId());
		ArrayList<String> boardList = new ArrayList<String>();
		ArrayList<String> numRollList = new ArrayList<String>();
		
		for(int i = 0; i < rollList.size(); i++) {
			String roll = new Roll(rollList.get(i)).getRoll();
			String board = roll.substring(0, roll.length()-4);
			String numRoll = roll.substring(roll.length()-4,roll.length());
			boardList.add(board);
			numRollList.add(numRoll);
		}
		
		
		if (loginMember != null) {
			if (loginMember.getAdminYn().equals("Y")) {
				session.setAttribute("loginMember", loginMember);
				status.setComplete();
			} else if (rollList.size() > 0 && loginMember.getAdminYn().equals("N")) {
				session.setAttribute("loginMember", loginMember);
				mv.addObject("board", boardList);
				mv.addObject("numRollList", numRollList);
				logger.info("boardList : " + boardList);
				logger.info("numRollList : " + numRollList);
			}
			mv.setViewName("main");
		} else {
			mv.addObject("message", "로그인 실패!");
			mv.setViewName("common/error");

		}
		return mv;
	}

	// 직원조회 페이지 보내기용
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
	// 직급별 직원조회 페이지 보내기용

	// 부서별 직원조회 페이지 보내기용
}
