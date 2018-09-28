package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.mapping.FetchType;
import com.demo.model.BookSingleType;
import com.demo.model.BookToallType;

@Mapper
public interface TypeMapper {

	@Select("select * from booktoalltype")
	List<BookToallType> findTotalTypes();
	
	@Select("select * from booksingletype where bookToallType_id = #{id}")
	List<BookSingleType> findSingleTypes(int id);
	
	@Results(value= {
			@Result(id=true,column="id",property="id"),
			@Result(
			many=@Many(select="com.demo.mapper.TypeMapper.findSingleTypes"
			,fetchType=FetchType.EAGER)
			,property="singleTypes",
			column="id"
			)
			})
	@Select("select * from booktoalltype")
	List<BookToallType> findAllTypes(int id);
}
