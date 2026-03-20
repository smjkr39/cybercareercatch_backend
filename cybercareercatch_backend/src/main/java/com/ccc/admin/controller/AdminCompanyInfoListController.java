package com.ccc.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccc.common.Execute;
import com.ccc.common.Result;
import com.ccc.company.dao.CompanyDAO;
import com.ccc.company.dto.CompanyCardDTO;

/*
 * 관리자 기업 정보페이지 목록으로 이동시키는 컨트롤러이다.
 * 기업명 검색, 페이징 처리, 목록 출력을 담당한다.
 */
public class AdminCompanyInfoListController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CompanyDAO companyDAO = new CompanyDAO();
		Result result = new Result();

		String temp = request.getParameter("page");
		String keyword = request.getParameter("keyword");

		int page = 1;
		int rowCount = 10;
		int pageCount = 5;

		if (keyword == null) {
			keyword = "";
		} else {
			keyword = keyword.trim();
		}

		if (temp != null && !temp.trim().equals("")) {
			page = Integer.parseInt(temp);
		}

		/* 전체 개수 조회 */
		int total = companyDAO.getCompanyTotal(keyword);

		/* 실제 마지막 페이지 */
		int realEndPage = (int) Math.ceil(total / (double) rowCount);

		if (realEndPage == 0) {
			realEndPage = 1;
		}

		if (page > realEndPage) {
			page = realEndPage;
		}

		if (page < 1) {
			page = 1;
		}

		/* Oracle ROWNUM용 시작/끝 행 */
		int startRow = (page - 1) * rowCount + 1;
		int endRow = page * rowCount;

		Map<String, Object> pageMap = new HashMap<String, Object>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		pageMap.put("keyword", keyword);

		/* 현재 페이지 목록 조회 */
		List<CompanyCardDTO> companyList = companyDAO.selectCompanyList(pageMap);

		/* 페이지네이션 시작/끝 번호 */
		int startPage = ((page - 1) / pageCount) * pageCount + 1;
		int endPage = startPage + pageCount - 1;

		if (endPage > realEndPage) {
			endPage = realEndPage;
		}

		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;

		request.setAttribute("companyList", companyList);
		request.setAttribute("total", total);
		request.setAttribute("page", page);
		request.setAttribute("keyword", keyword);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);

		result.setPath("/app/admin/main-management/company-info.jsp");
		result.setRedirect(false);

		return result;
	}
}