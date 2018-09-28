package com.demo.SQLProvider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import com.demo.model.Book;

public class BookSqlProvider {

	public String createFindAllBook(final String name,
									int totalType,
									 int singleType) {
		
		return new SQL() {
			{
				
				SELECT("*");
				FROM("book");
				if(name != null && !name.equals("")) {
					WHERE("bookName like concat('%',#{name},'%')");
				}
				if(totalType != -1) {
					WHERE("bookToallType_id = #{totalType}");
				}
				if(singleType != -1) {
					WHERE("bookSingleType_id = #{singleType}");
				}
			}
		}.toString();
	}
	
	
public String createEditBook(@Param(value = "book") final Book book) {
		
		return new SQL() {
			{
				
				UPDATE("book");
				SET("bookName = #{bookName},author = #{author},descri = #{descri},"
						+ "bookConcern = #{bookConcern},publishDate = #{publishDate},"
						+ "oldPrice = #{oldPrice},bookToallType_id = #{bookToallType_id},"
						+ "bookSingleType_id = #{bookSingleType_id}");
				if (book.getPhoto() != null) {
					SET("photo = #{photo}");
				}
				WHERE("id = #{id}");
			}
		}.toString();
	}
	

	public String createFindTodayBook(Boolean ret,String name,int tid) {

		return new SQL() {
			{

				SELECT("*");
				FROM("book");
				if (name != null && !name.equals("")) {
					WHERE("bookName like concat('%',#{name},'%')");
				}
				if (tid != -1) {
					WHERE("bookToallType_id = #{tid}");
				}
				WHERE("recommend = #{ret}");
			}
		}.toString();
	}

}
