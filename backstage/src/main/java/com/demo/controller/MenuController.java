package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.model.Menu;
import com.demo.service.MenuService;


@Controller
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/")
	public String toLogin() {
		
		return "login";
	}
	
	@RequestMapping("/toAdmin")
	public String toAdmin() {
		
		return "backstage/index";
	}
	
	@RequestMapping("showMenu")
	@ResponseBody
	public List<Menu> showMenu(){
		return menuService.findAll();
	}
	
	//后台首页
	@RequestMapping("/info")
	public String role() {
		return "backstage/info";
	}
	
	//修改密码
	@RequestMapping("/pass")
	public String pass() {
		return "backstage/pass";
	}
	
	
	//书籍管理
	@RequestMapping("/add")
	public String add() {
		return "backstage/book/addForm";
	}
}
