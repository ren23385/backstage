package com.demo.service;

import org.springframework.transaction.annotation.Transactional;

import com.demo.model.User;

public interface LoginService {

	@Transactional(readOnly=true)
	User findByName(String name);
}
