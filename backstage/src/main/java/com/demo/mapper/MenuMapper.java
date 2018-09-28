package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.demo.model.Menu;

@Mapper
public interface MenuMapper{
	
	@Select("select * from menu where pid = #{pid}")
	List<Menu> findByPid(int pid);
	
	@Select("select * from menu where pid = 0")
	List<Menu> selAll();

}
