package com.ccc.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccc.common.Execute;
import com.ccc.common.Result;
import com.ccc.job.dao.JobDAO;
import com.ccc.job.dto.JobRecommendQuestionDTO;

public class AdminInsertQuestionController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 질의문 관련 DB 작업을 처리할 DAO 객체이다.
		JobDAO jobDAO = new JobDAO();

		// 질의문 목록을 담을 리스트이다.
		List<JobRecommendQuestionDTO> questionList = jobDAO.selectQuestionList();

		// 이동 정보를 담을 객체이다.
		Result result = new Result();

		// JSP에서 사용할 수 있도록 request 영역에 저장한다.
		request.setAttribute("questionList", questionList);

		// 질의문 관리 JSP로 이동한다.
		result.setPath("/app/admin/main-management/qna-management.jsp");
		result.setRedirect(false);

		return result;
	}
}