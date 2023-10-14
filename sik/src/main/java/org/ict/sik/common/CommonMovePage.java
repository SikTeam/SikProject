package org.ict.sik.common;

import javax.servlet.http.HttpSession;

import org.ict.sik.fc.model.vo.Fc;
import org.ict.sik.member.model.vo.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonMovePage {
	@RequestMapping("main.do")
	public String moveMainMethod() {
		return "main";
	}
	
	@RequestMapping(value = "loginMain.do", method= {RequestMethod.GET,RequestMethod.POST})
	public String moveLoginPageMethod() {
		return "login";
	}
	
	@RequestMapping(value="loginCheck.do",method=RequestMethod.POST)
	public ModelAndView loginCheckMethod(Member member, @RequestParam("logincheck") String logincheck,
			ModelAndView mv,HttpSession session) {
		if(logincheck.equals("login")) {
			session.setAttribute("member", member);
			mv.setViewName("redirect:login.do");
		}else if(logincheck.equals("fcLogin")) {
			session.setAttribute("fc", new Fc(member.getMemberId(),member.getPw()));
			mv.setViewName("redirect:fcLogin.do");
		}
		return mv;
	}
}
