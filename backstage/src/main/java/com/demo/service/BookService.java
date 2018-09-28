package com.demo.service;

import javax.validation.Valid;

import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Book;
import com.github.pagehelper.PageInfo;

public interface BookService {

	//展示书籍
	@Transactional(readOnly=true)
	PageInfo<Book> findAllBook(int pageNo, String name, int tid);

	//删除书籍
	@Transactional(readOnly=false)
	int delBookById(int id);

	//添加书籍
	@Transactional(readOnly=false)
	int saveBook(@Valid Book book);

	//编辑书籍
	@Transactional(readOnly=false)
	int editBook(Book book);

	//根据id 找到书籍
	@Transactional(readOnly=true)
	Book findBookById(int bookId);

	//今日推荐页面展示
	@Transactional(readOnly=true)
	PageInfo<Book> findAllRecommend(int pageNoo, boolean b,String name,int tid);

	//取消今日推荐
	@Transactional(readOnly=false)
	int cancleById(int id);

	//查找所有的近日推荐条数
	@Transactional(readOnly=true)
	int findAllToday(boolean b);

	//设置近日推荐
	@Transactional(readOnly=false)
	int setToday(int id);

	//查找是否推荐过
	@Transactional(readOnly=true)
	Book findBook(int id, boolean b);

}
