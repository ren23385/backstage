package com.demo.mapper;

import java.util.List;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import com.demo.SQLProvider.BookSqlProvider;
import com.demo.model.Book;


@Repository("bookDao")
@Mapper
public interface BookMapper {


	@Select("select * from book where 1 = 1 order by publishDate desc limit 0,7")
	List<Book> findNewBooks();
	
	//@Select("select * from book where 1 = 1 and recommend = #{ret}")
	@SelectProvider(type=BookSqlProvider.class,method="createFindTodayBook")
	List<Book> findTodayBooks(Boolean ret,String name,int tid);
	

	@SelectProvider(type=BookSqlProvider.class,method="createFindAllBook")
	List<Book> findAllBooks(String name, int totalType, int singleType);

	@Delete("delete from book where id = #{id}")
	int delBookById(int id);

	@Insert("insert into book (bookName,author,bookConcern,publishDate,oldPrice,bookToallType_id,bookSingleType_id,descri,photo)"
			+ "values (#{bookName},#{author},#{bookConcern},#{publishDate},#{oldPrice},#{bookToallType_id},#{bookSingleType_id},#{descri},#{photo})")
	int saveBook(@Valid Book book);

	@UpdateProvider(type=BookSqlProvider.class,method="createEditBook")
	int editBook(@Valid Book book);

	@Select("select * from book where id = #{bookId}")
	Book findBookById(int bookId);

	@Update("update book set recommend = 0 where id = #{id}")
	int cancleById(int id);

	@Select("select count(*) from book where recommend = #{b}")
	int findAllTodayBooks(boolean b);

	@Update("update book set recommend = 1 where id = #{id}")
	int setToday(int id);

	//查找是否推荐过
	@Select("select * from book where id = #{id} and recommend = #{b}")
	Book findBook(int id, boolean b);
}
