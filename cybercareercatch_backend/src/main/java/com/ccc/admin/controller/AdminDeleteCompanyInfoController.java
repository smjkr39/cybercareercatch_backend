package com.ccc.admin.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccc.common.Execute;
import com.ccc.common.Result;
import com.ccc.company.dao.CompanyDAO;

/*
 * 관리자 기업 정보페이지 삭제를 처리하는 컨트롤러이다.
 * 목록에서 체크한 기업 정보페이지를 바로 삭제한다.
 */
public class AdminDeleteCompanyInfoController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CompanyDAO companyDAO = new CompanyDAO();
		Result result = new Result();

		String[] companyNumbers = request.getParameterValues("companyNumber");
		String keyword = request.getParameter("keyword");
		String page = request.getParameter("page");

		/*
		 * 선택된 기업 번호가 있으면
		 * 파일 먼저 삭제 후 기업 정보페이지를 삭제한다.
		 */
		if (companyNumbers != null) {
			for (String companyNumber : companyNumbers) {
				int number = Integer.parseInt(companyNumber);
				companyDAO.deleteFileByCompanyNumber(number);
				companyDAO.deleteCompInfoByCompanyNumber(number);
			}
		}

		if (keyword == null) {
			keyword = "";
		}

		if (page == null || page.trim().equals("")) {
			page = "1";
		}

		/* 삭제 후 다시 목록 페이지로 이동 */
		result.setPath(
			request.getContextPath()
			+ "/admin/companyInfoListOk.adfc?page=" + page
			+ "&keyword=" + URLEncoder.encode(keyword, "UTF-8")
		);
		result.setRedirect(true);

		return result;
	}
}