package com.ccc.post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccc.common.Execute;
import com.ccc.common.Result;

public class PostWriteController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("자유게시판 글쓰기 페이지 컨트롤러 이동 완료");

		Result result = new Result();

		// 기존 세션만 가져오기
		HttpSession session = request.getSession(false);

		// 비로그인 차단
		if (session == null || session.getAttribute("userNumber") == null) {
			System.out.println("글쓰기 페이지 접근 실패 : 로그인 필요");
			result.setPath(request.getContextPath() + "/member/login.mefc");
			result.setRedirect(true);
			return result;
		}

		// 회원 유형 확인
		String userType = (String) session.getAttribute("userType");
		System.out.println("글쓰기 페이지 접근 회원 유형 : " + userType);

		// 일반회원만 자유게시판 글쓰기 가능
		if (!"일반회원".equals(userType)) {
			System.out.println("글쓰기 페이지 접근 실패 : 일반회원만 접근 가능");
			result.setPath(request.getContextPath() + "/post/list.pfc");
			result.setRedirect(true);
			return result;
		}

		// 일반회원만 글쓰기 페이지로 이동
		result.setPath("/app/main/community/add-post.jsp");
		result.setRedirect(false);

		return result;
	}
}