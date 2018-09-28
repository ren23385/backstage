package com.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.model.BookSingleType;
import com.demo.model.BookToallType;
import com.demo.service.TypeService;

@Controller
public class TypeController {

	@Autowired
	private TypeService typeService;
	
	/**
	 * 
	 *	 获取所有大类型
	 */	
	@RequestMapping("/totalTypes")
	@ResponseBody
	public Map<String, Object> totalTypes(){
		
		Map<String, Object> result = new HashMap<>();
		
		List<BookToallType> totalTypes = typeService.findTotalTypes();
		
		result.put("totalTypes", totalTypes);		
		return result;
	}
	
	/*
	 *	 获取所有大类型下的小类型
	 */
	
	@RequestMapping("/singleTypes")
	@ResponseBody
	public Map<String, Object> singleTypes(@RequestParam(defaultValue="1",required=true) int totalType){
		Map<String, Object> result = new HashMap<>();
		List<BookSingleType> singleTypes = typeService.findSingleTypes(totalType);
		
		result.put("singleTypes", singleTypes);
		
		return result;
	}
	
	@RequestMapping("/allTypes")
	@ResponseBody
	public List<BookToallType> allTypes(@RequestParam(defaultValue="1",required=true) int totalType){
		Map<String, Object> result = new HashMap<>();
		List<BookToallType> types  = typeService.findAllTypes(totalType);
		System.out.println(types.toString());
		result.put("types", types);
		return types;
	}
}
