package com.ccc.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccc.common.Execute;
import com.ccc.common.Result;
import com.ccc.member.dao.MemberDAO;
import com.ccc.member.dto.MemberJoinDTO;

public class MemberJoinOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MemberDAO memberDAO = new MemberDAO();
		MemberJoinDTO memberJoinDTO = new MemberJoinDTO();
		Result result = new Result();
		
		request.setCharacterEncoding("UTF-8");
		
		memberJoinDTO.setUserId(request.getParameter("userId"));
		memberJoinDTO.setUserPw(request.getParameter("userPw"));
		memberJoinDTO.setUserPwConfirm(request.getParameter("userPwConfirm"));
		memberJoinDTO.setUserName(request.getParameter("userName"));
		memberJoinDTO.setUserPhone(request.getParameter("userPhone"));
		memberJoinDTO.setMemberDob(request.getParameter("memberDob"));
		memberJoinDTO.setMemberGender(request.getParameter("memberGender"));
		memberJoinDTO.setAuthCode(request.getParameter("authCode"));
		
		memberDAO.join(memberJoinDTO);
		
		result.setPath(request.getContextPath() + "/member/login.mefc");
		result.setRedirect(true);
		
		return result;
	}

}
