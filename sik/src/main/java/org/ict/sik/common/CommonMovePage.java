package org.ict.sik.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ict.sik.fc.model.vo.Fc;
import org.ict.sik.member.model.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonMovePage {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("main.do")
	public String moveMainMethod() {
		return "main";
	}
	@RequestMapping("loginMain.do")
	public String moveLoginPageMethod(HttpServletRequest request) {
		return "login";
	}

	@RequestMapping(value="loginCheck.do",method=RequestMethod.POST)
	public ModelAndView loginCheckMethod(Member member, @RequestParam("logincheck") String logincheck,
			ModelAndView mv,HttpSession session) {
		logger.info("member : " + member);
		if(logincheck.equals("login")) {
			session.setAttribute("loginMember", member);
			mv.setViewName("redirect:login.do");
		}
		if(logincheck.equals("fcLogin")) {
			Fc fc = new Fc(member.getMemberId(),member.getPw());
			logger.info("fc : " + fc);
			session.setAttribute("loginMember", fc);
			logger.info("fc session : " + session.getAttribute("fc"));
			mv.setViewName("redirect:fcLogin.do");
		}
		return mv;
	}
}
