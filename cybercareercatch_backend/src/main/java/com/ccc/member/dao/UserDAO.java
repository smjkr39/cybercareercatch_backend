package com.ccc.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.ccc.common.config.MyBatisConfig;
import com.ccc.member.dto.UserDTO;

public class UserDAO {
	public SqlSession sqlSession;
	
	public UserDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	public int login(UserDTO userDTO) {
		Integer userNumber = sqlSession.selectOne("user.login", userDTO);
		return userNumber == null ? -1 : userNumber;
	}
}
