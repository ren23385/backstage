package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.MenuMapper;
import com.demo.model.Attributes;
import com.demo.model.Menu;
import com.demo.service.MenuService;


@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuMapper menuMapper;

	@Override
	public List<Menu> findAll() {
		List<Menu> list = (List<Menu>) menuMapper.selAll();
		for (Menu menu : list) {
			List<Menu> listChildren = menuMapper.findByPid(menu.getId());
			for (Menu child : listChildren) {
		
				Attributes attributes = new Attributes();
				attributes.setFilename(child.getFilename());
				System.out.println("------------------------------------"+attributes.getFilename());
				child.setAttributes(attributes);
			}
			menu.setChildren(listChildren);
		}
		return list;
	}
}
