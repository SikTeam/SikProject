package org.ict.sik.member.controller;

import javax.servlet.http.HttpSession;

import org.ict.sik.fc.model.service.FcService;
import org.ict.sik.fc.model.service.FcServiceImpl;
import org.ict.sik.fc.model.vo.Fc;
import org.ict.sik.member.model.service.MemberService;
import org.ict.sik.member.model.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String loginMethod(Member member, Model model, HttpSession session, SessionStatus status) {
		logger.info("login.do : " + member);
		FcService fcService = new FcServiceImpl();
		Member loginMember = memberService.selectLogin(member);
		Fc fcLogin = new Fc();
		fcLogin.setFcId(loginMember.getMemberId());
		fcLogin.setFcPw(loginMember.getPw());
		if(loginMember != null && memberService.selectMemberCheck(member) > 0) {
			session.setAttribute("loginMember", loginMember);
			status.setComplete();
			return "main";
		}else if(loginMember != null && fcService.selectFcCheck(fcLogin) > 0){
			session.setAttribute("loginMember", fcLogin);
			status.setComplete();
			return "";
		}else {
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
