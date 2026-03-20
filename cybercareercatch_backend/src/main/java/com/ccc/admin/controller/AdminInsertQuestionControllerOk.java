package com.ccc.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccc.common.Execute;
import com.ccc.common.Result;
import com.ccc.job.dao.JobDAO;
import com.ccc.job.dto.JobRecommendQuestionDTO;

public class AdminInsertQuestionControllerOk implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 질의문 관련 DB 작업을 처리할 DAO 객체이다.
		JobDAO jobDAO = new JobDAO();

		// 이동 정보를 담을 객체이다.
		Result result = new Result();

		// 질문 1번부터 10번까지 반복하면서 저장한다.
		for (int i = 1; i <= 10; i++) {

			// 질문 번호 파라미터를 가져온다.
			String questionNumber = request.getParameter("jobQuestionNumber" + i);

			// 질문 내용 파라미터를 가져온다.
			String questionContent = request.getParameter("jobQuestionContent" + i);

			// 번호가 없거나 내용이 비어 있으면 해당 질문은 처리하지 않는다.
			if (questionNumber == null || questionContent == null || questionContent.trim().equals("")) {
				continue;
			}

			// DTO 객체를 생성한다.
			JobRecommendQuestionDTO questionDTO = new JobRecommendQuestionDTO();

			// DTO에 질문 번호와 질문 내용을 저장한다.
			questionDTO.setJobQuestionNumber(Integer.parseInt(questionNumber));
			questionDTO.setJobQuestionContent(questionContent);

			// 기존에 해당 질문 번호가 존재하는지 확인한다.
			JobRecommendQuestionDTO foundQuestion = jobDAO.selectQuestion(questionDTO.getJobQuestionNumber());

			// 기존 질문이 있으면 수정한다.
			if (foundQuestion != null) {
				jobDAO.updateQuestion(questionDTO);
			} else {
				// 기존 질문이 없으면 새로 등록한다.
				jobDAO.insertQuestion(questionDTO);
			}
		}

		// 저장 후 다시 질의문 관리 페이지로 이동한다.
		result.setPath(request.getContextPath() + "/admin/insertQuestion.adfc");
		result.setRedirect(true);

		return result;
	}
}