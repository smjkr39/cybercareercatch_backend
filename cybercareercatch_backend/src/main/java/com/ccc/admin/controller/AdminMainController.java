package com.ccc.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccc.common.Execute;
import com.ccc.common.Result;

/*
 * 관리자 메인 대시보드 페이지로 이동시키는 컨트롤러이다.
 */
public class AdminMainController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Result result = new Result();

		/*
		 * 로그인하지 않은 상태면 로그인 페이지로 이동
		 */
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("adminNumber") == null) {
			result.setPath(request.getContextPath() + "/admin/login.adfc");
			result.setRedirect(true);
			return result;
		}

		result.setPath("/app/admin/admin-main.jsp");
		result.setRedirect(false);

		return result;
	}
}