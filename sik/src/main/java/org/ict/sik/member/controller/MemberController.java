package org.ict.sik.member.controller;

import javax.servlet.http.HttpSession;

import org.ict.sik.member.model.service.MemberService;
import org.ict.sik.member.model.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	private MemberService memberService;
	@RequestMapping("login.do")
	public String loginMethod(Model model, HttpSession session, SessionStatus status) {
		Member member = (Member)session.getAttribute("member");
		logger.info("login.do : " + member);
		Member loginMember = null;

		loginMember = (Member) memberService.selectLogin(member);

		if (loginMember != null) {
			session.setAttribute("loginMember", loginMember);
			status.setComplete();
			return "main";
		} else {
			model.addAttribute("message", "로그인 실패!");
			return "common/error";
		}
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
