package com.ccc.mainpage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ccc.common.Execute;
import com.ccc.common.Result;
import com.ccc.company.dto.CompanyCardDTO;
import com.ccc.expo.dto.ExpoListDTO;
import com.ccc.job.dto.JobGroupDTO;
import com.ccc.job.dto.JobRecommendQuestionDTO;
import com.ccc.mainpage.dao.MainpageDAO;
import com.ccc.post.dto.PostListDTO;
import com.ccc.qna.dto.QnaListDTO;

public class MainpageController implements Execute {

	private static final int DEFAULT_QUESTION_NUMBER = 1;
	private static final int MAX_QUESTION_COUNT = 10;

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MainpageDAO mainpageDAO = new MainpageDAO();
		Result result = new Result();
		HttpSession session = request.getSession();

		boolean isResume = "true".equals(request.getParameter("resume"));
		boolean isComplete = "true".equals(request.getParameter("complete"));

		// resume=true가 아니면 새로 진입한 것으로 보고 진행중 데이터 삭제
		if (!isResume) {
			deleteInProgressMainTest(session, mainpageDAO);
		}

		int questionCount = getQuestionCount(mainpageDAO);

		Integer currentQuestionNumber = (Integer) session.getAttribute("mainCurrentQuestionNumber");
		if (currentQuestionNumber == null || currentQuestionNumber < 1 || currentQuestionNumber > questionCount) {
			currentQuestionNumber = DEFAULT_QUESTION_NUMBER;
		}

		JobRecommendQuestionDTO mainQuestion = mainpageDAO.selectMainQuestion(currentQuestionNumber);
		if (mainQuestion == null) {
			currentQuestionNumber = DEFAULT_QUESTION_NUMBER;
			mainQuestion = mainpageDAO.selectMainQuestion(currentQuestionNumber);
		}

		List<JobGroupDTO> mainJobGroupList = mainpageDAO.selectMainJobGroupList();
		List<CompanyCardDTO> mainCompanyList = mainpageDAO.selectMainCompanyList();
		List<PostListDTO> mainFreePostList = mainpageDAO.selectMainFreePostList();
		List<QnaListDTO> mainQnaList = mainpageDAO.selectMainQnaList();
		List<ExpoListDTO> mainExpoList = mainpageDAO.selectMainExpoList();

		request.setAttribute("mainQuestion", mainQuestion);
		request.setAttribute("mainJobGroupList", mainJobGroupList);
		request.setAttribute("mainCompanyList", mainCompanyList);
		request.setAttribute("mainFreePostList", mainFreePostList);
		request.setAttribute("mainQnaList", mainQnaList);
		request.setAttribute("mainExpoList", mainExpoList);

		request.setAttribute("mainCurrentQuestionNumber", currentQuestionNumber);
		request.setAttribute("mainQuestionCount", questionCount);
		request.setAttribute("mainIsTestInProgress", session.getAttribute("mainJobResultNumber") != null);

		if (isComplete) {
			request.setAttribute("mainAlertMessage",
					"답변이 완료 되었습니다. 결과는 3일~5일정도 소요됩니다. 마이페이지에서 확인하실 수 있습니다");
		} else if ("true".equals(request.getParameter("emptyAnswer"))) {
			request.setAttribute("mainAlertMessage", "답변을 입력해주세요.");
		} else if ("true".equals(request.getParameter("loginRequired"))) {
			request.setAttribute("mainAlertMessage", "로그인 후 이용할 수 있습니다.");
		} else if ("true".equals(request.getParameter("memberOnly"))) {
			request.setAttribute("mainAlertMessage", "직군 검사는 일반회원만 제출할 수 있습니다.");
		}

		result.setPath("/app/main/mainpage/mainpage-login.jsp");
		result.setRedirect(false);

		return result;
	}

	private int getQuestionCount(MainpageDAO mainpageDAO) {
		int questionCount = mainpageDAO.selectMainQuestionCount();

		if (questionCount <= 0) {
			return MAX_QUESTION_COUNT;
		}

		return Math.min(questionCount, MAX_QUESTION_COUNT);
	}

	private void deleteInProgressMainTest(HttpSession session, MainpageDAO mainpageDAO) {
		Integer jobResultNumber = (Integer) session.getAttribute("mainJobResultNumber");

		if (jobResultNumber != null) {
			mainpageDAO.deleteMainJobResultAnswers(jobResultNumber);
			mainpageDAO.deleteMainJobResult(jobResultNumber);
		}

		clearMainTestSessionOnlySession(session);
	}

	private void clearMainTestSessionOnlySession(HttpSession session) {
		session.removeAttribute("mainJobResultNumber");
		session.removeAttribute("mainCurrentQuestionNumber");
	}
}