package com.ccc.post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccc.common.Execute;
import com.ccc.common.Result;
import com.ccc.post.dao.PostDAO;
import com.ccc.post.dto.NoticeDTO;

public class NoticeDetailController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("공지사항 상세 컨트롤러 실행");

		PostDAO postDAO = new PostDAO();
		Result result = new Result();

		String temp = request.getParameter("postNumber");
		int postNumber = 0;

		try {
			postNumber = Integer.parseInt(temp);
		} catch (Exception e) {
			System.out.println("공지사항 번호 파라미터 오류");
			result.setPath(request.getContextPath() + "/post/list.pfc");
			result.setRedirect(true);
			return result;
		}

		NoticeDTO notice = postDAO.selectFreeNoticeDetail(postNumber);

		request.setAttribute("notice", notice);

		result.setPath("/app/main/community/post-notification.jsp");
		result.setRedirect(false);

		System.out.println("공지사항 상세 컨트롤러 종료");
		return result;
	}
}