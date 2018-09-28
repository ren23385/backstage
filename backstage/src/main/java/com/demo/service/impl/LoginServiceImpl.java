package com.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.LoginMapper;
import com.demo.model.User;
import com.demo.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper;
	
	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return loginMapper.findByName(name);
	}

}
