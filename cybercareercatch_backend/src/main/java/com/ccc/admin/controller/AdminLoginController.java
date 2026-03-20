package com.ccc.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccc.common.Execute;
import com.ccc.common.Result;

/*
 * 관리자 로그인 페이지로 이동시키는 컨트롤러이다.
 */
public class AdminLoginController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Result result = new Result();

		/* 기존 세션만 확인한다. */
		HttpSession session = request.getSession(false);

		/*
		 * 이미 로그인되어 있으면
		 * 관리자 메인 대시보드로 보낸다.
		 */
		if (session != null && session.getAttribute("adminNumber") != null) {
			result.setPath(request.getContextPath() + "/admin/main.adfc");
			result.setRedirect(true);
			return result;
		}

		/*
		 * 아이디 저장 쿠키가 있으면
		 * 로그인 페이지에 미리 넣어준다.
		 */
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("adminId".equals(cookie.getName())) {
					request.setAttribute("adminId", cookie.getValue());
				}
			}
		}

		result.setPath("/app/admin/admin-login.jsp");
		result.setRedirect(false);

		return result;
	}
}