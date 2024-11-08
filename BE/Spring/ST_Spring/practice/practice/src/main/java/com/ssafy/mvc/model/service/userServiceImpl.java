package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.UserDao;
import com.ssafy.mvc.model.dto.User;

@Service
public class userServiceImpl implements userService {

	private final UserDao dao;
	public userServiceImpl(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public void signup(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User login(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
