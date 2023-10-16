package org.ict.sik.fc.controller;

import javax.servlet.http.HttpSession;

import org.ict.sik.fc.model.service.FcService;
import org.ict.sik.fc.model.vo.Fc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FcController {
	@Autowired
	private FcService fcService;
	
	private static final Logger logger = LoggerFactory.getLogger(FcController.class);
	
	@RequestMapping("fcLogin.do")
	public ModelAndView fcLoginMethod(ModelAndView mv, HttpSession session, SessionStatus status) {
		Fc fc = (Fc)session.getAttribute("fc");
		logger.info("fclogin : " + fc);
		mv.setViewName("franchisee/fr_main");
		return mv;
	}
}
