package com.ccc.qna.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import com.ccc.common.Execute;
import com.ccc.common.Result;
import com.ccc.company.dto.CompanyDTO;
import com.ccc.qna.dao.QnaDAO;

public class QnaWriteFormController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		QnaDAO qnaDAO = new QnaDAO();
		Result result = new Result();

		HttpSession session = request.getSession(false);

		// 비회원 접근 불가
		if (session == null || session.getAttribute("userNumber") == null) {
			result.setPath(request.getContextPath() + "/member/login.mefc");
			result.setRedirect(true);
			return result;
		}

		int userNumber = (Integer) session.getAttribute("userNumber");
		String userType = (String) session.getAttribute("userType");

		if (!"일반회원".equals(userType)) {
			result.setPath(request.getContextPath() + "/qna/list.qfc");
			result.setRedirect(true);
			return result;
		}

		List<CompanyDTO> companyList = qnaDAO.selectCompanyList();

		request.setAttribute("companyList", companyList);
		request.setAttribute("userNumber", userNumber);
		request.setAttribute("userType", userType);

		// 핵심 수정
		// add-qna.jsp 말고 qna-write.jsp로 통일
		result.setPath("/app/main/qna/qna-write.jsp");
		result.setRedirect(false);

		return result;
	}
}