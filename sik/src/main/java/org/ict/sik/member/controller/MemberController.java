package org.ict.sik.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.ict.sik.member.model.service.MemberService;
import org.ict.sik.member.model.vo.Member;
import org.ict.sik.roll.model.vo.Roll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;

	@RequestMapping("login.do")
	public ModelAndView loginMethod(ModelAndView mv, HttpSession session, SessionStatus status) {
		Member member = (Member)session.getAttribute("member");
		logger.info("login.do : " + member);
		Member loginMember = null;

		loginMember = (Member) memberService.selectLogin(member);
		ArrayList<Roll> rollList = memberService.selectRollList(member.getMemberId());
		if (loginMember != null) {
			if(loginMember.getAdminYn().equals("Y")) {
				session.setAttribute("loginMember", loginMember);
				status.setComplete();
			}else if(rollList.size() > 0 && loginMember.getAdminYn().equals("N")) {
				session.setAttribute("rollList", rollList);
				logger.info("roll : " + rollList);
			}
			mv.setViewName("main");
		} else {
			mv.addObject("message","로그인 실패!");
			mv.setViewName("common/error");
		}
		return mv;
	}
	
	//직원조회 페이지 보내기용
//	@RequestMapping("mlist.do")
//	public String move memberListViewMethod(
//			ModelAndView mv) {
//		
//	}
	//직급별 직원조회 페이지 보내기용
	
	//부서별 직원조회 페이지 보내기용
}
