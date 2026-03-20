package com.ccc.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccc.common.Result;

/*
 * 관리자 관련 요청을 한 곳에서 받는 프론트 컨트롤러이다.
 */
public class AdminFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminFrontController() {
		super();
	}

	/*
	 * GET 방식 요청을 doProcess()로 넘긴다.
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/*
	 * POST 방식 요청을 doProcess()로 넘긴다.
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/*
	 * 실제 요청을 처리하는 메소드이다.
	 */
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* 한글 깨짐 방지 */
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		/* 사용자가 요청한 경로를 구한다. */
		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("관리자 프론트 컨트롤러 진입 : " + target);

		Result result = null;

		switch (target) {

		/* =========================
		 * 관리자 로그인 / 로그아웃 / 메인
		 * =========================
		 */
		case "/admin/login.adfc":
			result = new AdminLoginController().execute(request, response);
			break;

		case "/admin/loginOk.adfc":
			result = new AdminLoginOkController().execute(request, response);
			break;

		case "/admin/logout.adfc":
			result = new AdminLogoutController().execute(request, response);
			break;

		case "/admin/main.adfc":
			result = new AdminMainController().execute(request, response);
			break;

		/* =========================
		 * 질의문 관련
		 * =========================
		 */
		case "/admin/insertQuestion.adfc":
			result = new AdminInsertQuestionController().execute(request, response);
			break;

		case "/admin/insertQuestionOk.adfc":
			result = new AdminInsertQuestionControllerOk().execute(request, response);
			break;

		case "/admin/jobCheck.adfc":
			result = new AdminJobCheckController().execute(request, response);
			break;

		case "/admin/jobCheckDetail.adfc":
			result = new AdminJobCheckDetailController().execute(request, response);
			break;

		case "/admin/judgeJobResult.adfc":
			result = new AdminJudgeJobResultController().execute(request, response);
			break;

		/* =========================
		 * 기업 정보페이지 관련
		 * =========================
		 */
		case "/admin/companyInfoListOk.adfc":
			result = new AdminCompanyInfoListController().execute(request, response);
			break;

		case "/admin/deleteCompanyInfo.adfc":
			result = new AdminDeleteCompanyInfoController().execute(request, response);
			break;

		/* =========================
		 * 로드맵 관련
		 * =========================
		 */
		case "/admin/roadmapManagement.adfc":
			result = new AdminRoadmapManagementController().execute(request, response);
			break;

		case "/admin/updateRoadmap.adfc":
			result = new AdminUpdateRoadmapController().execute(request, response);
			break;
		}

		/*
		 * 결과 경로가 있으면
		 * redirect 또는 forward 방식으로 이동한다.
		 */
		if (result != null && result.getPath() != null) {
			if (result.isRedirect()) {
				response.sendRedirect(result.getPath());
			} else {
				request.getRequestDispatcher(result.getPath()).forward(request, response);
			}
		}
	}
}