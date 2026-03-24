package com.ccc.admin.controller;

/*
 * [추가된 파일]
 * 1. 관리자 기업 QnA 목록에서 제목 클릭 시 들어오는 관리자 전용 상세 컨트롤러이다.
 * 2. 기존 사용자 상세(/qna/detail.qfc)로 보내던 구조를
 *    관리자 상세(/admin/companyQnaDetail.adfc)로 분리하기 위해 추가했다.
 * 3. 게시글 상세 정보와 댓글 목록을 조회해서 관리자 상세 JSP로 전달한다.
 * 4. 관리자는 관리자 페이지 내부에서만 움직여야 하므로
 *    사용자 권한 체크 로직 없이 관리자 세션만 확인한다.
 */

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccc.common.Execute;
import com.ccc.common.Result;
import com.ccc.qna.dao.QnaDAO;
import com.ccc.qna.dto.QnaCommentDTO;
import com.ccc.qna.dto.QnaDetailDTO;

public class AdminCompanyQnaDetailController implements Execute {

   @Override
   public Result execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

      QnaDAO qnaDAO = new QnaDAO();
      Result result = new Result();

      Object adminNumber = request.getSession().getAttribute("adminNumber");
      String postNumberStr = request.getParameter("postNumber");

      // 관리자 로그인 안 되어 있으면 로그인 페이지로 보냄
      if (adminNumber == null) {
         result.setPath(request.getContextPath() + "/admin/login.adfc");
         result.setRedirect(true);
         return result;
      }

      // postNumber 없으면 목록으로 보냄
      if (postNumberStr == null || postNumberStr.trim().equals("")) {
         result.setPath(request.getContextPath() + "/admin/companyQnaManagement.adfc");
         result.setRedirect(true);
         return result;
      }

      long postNumber = 0;

      try {
         postNumber = Long.parseLong(postNumberStr);
      } catch (NumberFormatException e) {
         result.setPath(request.getContextPath() + "/admin/companyQnaManagement.adfc");
         result.setRedirect(true);
         return result;
      }

      // 게시글 상세 조회
      QnaDetailDTO qnaDetail = qnaDAO.selectQnaDetail(postNumber);

      // 게시글이 없으면 목록으로
      if (qnaDetail == null) {
         result.setPath(request.getContextPath() + "/admin/companyQnaManagement.adfc");
         result.setRedirect(true);
         return result;
      }

      // 댓글 목록 조회
      List<QnaCommentDTO> commentList = qnaDAO.selectCommentListByPostNumber(postNumber);

      request.setAttribute("qnaDetail", qnaDetail);
      request.setAttribute("commentList", commentList);

      result.setPath("/app/admin/community-management/company-qna-detail.jsp");
      result.setRedirect(false);

      return result;
   }
}