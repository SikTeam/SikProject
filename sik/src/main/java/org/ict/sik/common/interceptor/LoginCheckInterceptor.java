package org.ict.sik.common.interceptor;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ict.sik.fc.model.vo.Fc;
import org.ict.sik.member.model.service.MemberService;
import org.ict.sik.member.model.service.MemberServiceImpl;
import org.ict.sik.member.model.vo.Member;
import org.ict.sik.roll.model.vo.Roll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

public class LoginCheckInterceptor implements AsyncHandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(getClass());

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object tempLoginMember = session.getAttribute("loginMember");
		if (tempLoginMember != null) {
			if (((Member) tempLoginMember).isMember(tempLoginMember)) {
				logger.info("로그인 한 직원 : " + ((Member) tempLoginMember).getMemberName());
//				if (request.getParameter("board") == null) {
//					MemberService memberService = new MemberServiceImpl();
//					ArrayList<Roll> rollList = memberService.selectRollList(((Member) tempLoginMember).getMemberId());
//					ArrayList<String> boardList = new ArrayList<String>();
//					ArrayList<String> numRollList = new ArrayList<String>();
//					
//					for(int i = 0; i < rollList.size(); i++) {
//						String roll = new Roll(rollList.get(i)).getRoll();
//						String board = roll.substring(0, roll.length()-4);
//						String numRoll = roll.substring(roll.length()-4,roll.length());
//						boardList.add(board);
//						numRollList.add(numRoll);
//					}
//					request.setAttribute("board", boardList);
//					request.setAttribute("numRoll", numRollList);
//					logger.info("권한!");
//				}

			} else if (((Fc) tempLoginMember).isFc(tempLoginMember)) {
				logger.info("로그인 한 가맹점 : " + ((Fc) tempLoginMember).getFcName());
			}
		} else {
			String origin = request.getHeader("Origin");
			String uri = request.getRequestURI().toString();
			String referer = request.getHeader("Referer");
			if (origin == null) {
				origin = uri.replace(uri, "");
			}

			String location = referer.replace(origin + request.getContextPath(), "");
			request.setAttribute("loc", location);
			request.setAttribute("message", "로그인해야 이용할 수 있는 서비스입니다.");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			return false;
		}
		return true;
	}
}
