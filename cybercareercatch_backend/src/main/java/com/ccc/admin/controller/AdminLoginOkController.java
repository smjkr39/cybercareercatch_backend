package com.ccc.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccc.admin.dao.AdminDAO;
import com.ccc.admin.dto.AdminDTO;
import com.ccc.common.Execute;
import com.ccc.common.Result;

/*
 * 관리자 로그인 처리를 담당하는 컨트롤러이다.
 */
public class AdminLoginOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AdminDAO adminDAO = new AdminDAO();
		AdminDTO adminDTO = new AdminDTO();
		Result result = new Result();

		String adminId = request.getParameter("adminId");
		String adminPw = request.getParameter("adminPw");
		String remember = request.getParameter("remember");

		adminDTO.setAdminId(adminId);
		adminDTO.setAdminPw(adminPw);

		/* DB에서 관리자 계정 조회 */
		AdminDTO loginAdmin = adminDAO.login(adminDTO);

		if (loginAdmin != null) {
			HttpSession session = request.getSession();
			session.setAttribute("adminNumber", loginAdmin.getAdminNumber());
			session.setAttribute("loginAdmin", loginAdmin);

			if (remember != null) {
				Cookie cookie = new Cookie("adminId", adminId);
				cookie.setMaxAge(60 * 60 * 24 * 30);
				cookie.setPath(request.getContextPath().isEmpty() ? "/" : request.getContextPath());
				response.addCookie(cookie);
			} else {
				Cookie cookie = new Cookie("adminId", "");
				cookie.setMaxAge(0);
				cookie.setPath(request.getContextPath().isEmpty() ? "/" : request.getContextPath());
				response.addCookie(cookie);
			}

			result.setPath(request.getContextPath() + "/admin/main.adfc");
			result.setRedirect(true);
			return result;
		}

		/* 로그인 실패 시 로그인창 유지 */
		result.setPath(request.getContextPath() + "/admin/login.adfc?login=fail");
		result.setRedirect(true);

		return result;
	}
}