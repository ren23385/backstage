package com.demo.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.BookMapper;
import com.demo.model.Book;
import com.demo.service.BookService;
import com.demo.util.PageConstent;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookMapper bookMapper;

	@Override
	public PageInfo<Book> findAllBook(int pageNo, String name, int tid) {
		PageHelper.offsetPage((pageNo - 1)*PageConstent.PAGE_SIZE+1-1,PageConstent.PAGE_SIZE,true);
		List<Book> ls  = bookMapper.findAllBooks(name, tid, -1);
		PageInfo<Book> pageInfo = new PageInfo<>(ls);
		
		System.out.println(pageInfo);
		
		return pageInfo;
	}

	@Override
	public int delBookById(int id) {
		// TODO Auto-generated method stub
		return bookMapper.delBookById(id);
	}

	@Override
	public int saveBook(@Valid Book book) {
		// TODO Auto-generated method stub
		return bookMapper.saveBook(book);
	}

	@Override
	public int editBook(Book book) {
		// TODO Auto-generated method stub
		return bookMapper.editBook(book);
	}

	@Override
	public Book findBookById(int bookId) {
		// TODO Auto-generated method stub
		return bookMapper.findBookById(bookId);
	}

	@Override
	public PageInfo<Book> findAllRecommend(int pageNoo, boolean b,String name,int tid) {
		PageHelper.offsetPage((pageNoo - 1)*PageConstent.PAGE_SIZE+1-1,PageConstent.PAGE_SIZE,true);
		List<Book> ls  = bookMapper.findTodayBooks(true,name,tid);
		PageInfo<Book> pageInfo = new PageInfo<>(ls);
		
		System.out.println(pageInfo);
		
		return pageInfo;
	}

	
	//取消推荐
	@Override
	public int cancleById(int id) {
		
		return bookMapper.cancleById(id);
	}

	//查找今日推荐条数
	@Override
	public int findAllToday(boolean b) {
		return bookMapper.findAllTodayBooks(b);
	}

	//设置今日推荐
	@Override
	public int setToday(int id) {
		// TODO Auto-generated method stub
		return bookMapper.setToday(id);
	}

	//查找是否推荐过
	@Override
	public Book findBook(int id, boolean b) {
		// TODO Auto-generated method stub
		return bookMapper.findBook(id,b);
	}

}
