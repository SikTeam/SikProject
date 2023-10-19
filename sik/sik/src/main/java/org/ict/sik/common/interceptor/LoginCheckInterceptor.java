package org.ict.sik.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ict.sik.fc.model.vo.Fc;
import org.ict.sik.member.model.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

public class LoginCheckInterceptor implements AsyncHandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(getClass());

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object tempLoginMember = session.getAttribute("loginMember");
		logger.info("tempLoginMember : " + tempLoginMember);
		if (tempLoginMember != null) {
			if (tempLoginMember instanceof Member) {
				logger.info("로그인 한 직원 : " + ((Member)tempLoginMember).getMemberName());
			} else if (tempLoginMember instanceof Fc) {
				logger.info("로그인 한 가맹점 : " + ((Fc)tempLoginMember).getFcId());
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
