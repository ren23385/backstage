package com.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.model.User;
import com.demo.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/login")
	@ResponseBody
	public Map<String, Object> login(@RequestParam String name,@RequestParam String password, HttpSession session) {
		
		User user = loginService.findByName(name);
		session.setAttribute(name, name);
		if(user == null) {
			Map<String , Object> result = new HashMap<>();
			result.put("error", true);
			result.put("msg", "该用户不存在");
			
			return  result;
		}
		
		if(user.getPassword().equals(password)) {
			session.setAttribute("admin", user);
			Map<String , Object> result = new HashMap<>();
			result.put("error", false);
			result.put("url", "toAdmin");
	
			return  result;
		}else {
			
			Map<String , Object> result = new HashMap<>();
			result.put("error", true);
			result.put("msg", "用户名或密码错误");
			
			return  result;
		}
		
		
	}
	
	
}
