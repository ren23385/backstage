package com.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.demo.model.User;

@Mapper
public interface LoginMapper {

	@Select("select * from admin where name = #{name}")
	User findByName(String name);
}
