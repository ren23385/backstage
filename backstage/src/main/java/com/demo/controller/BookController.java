package com.demo.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.demo.model.Book;
import com.demo.model.BookToallType;
import com.demo.service.BookService;
import com.demo.service.TypeService;
import com.github.pagehelper.PageInfo;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private TypeService typeService;
	
	int pageNoo = 1;
	int bookId = 1;
	
	
	//书籍管理
	@RequestMapping("/list")
	public String list(@RequestParam(defaultValue="1",required=false)int pageNo) {
		
		if(pageNo >1) {
			pageNoo = pageNo;
		}else {
			pageNoo = 1;
		}
		return "backstage/book/bookList";
	}
	
	//查找所有book
	@RequestMapping("/backstage/bookList")
	@ResponseBody
	public Map<String, Object> showBook(Model model, @RequestParam(defaultValue = "1", required = false) int pageNo,
			@RequestParam(defaultValue = "", required = false) String name,
			@RequestParam(defaultValue = "-1", required = false) int tid) {

		Map<String, Object> result = new HashMap<>();
		List<BookToallType> types = typeService.findTotalTypes();

		result.put("types", types);

		PageInfo<Book> pageInfo = bookService.findAllBook(pageNoo, name, tid);

		result.put("pageInfo", pageInfo);
		
		return result;
	}
	
	@RequestMapping("/bookDel")
	public String delBook(@RequestParam int id) {

		@SuppressWarnings("unused")
		int ret = bookService.delBookById(id);
		return "redirect:list";
	}
	
	@RequestMapping(value = "/saveBook")
	@ResponseBody
	public Map<String, Object> saveBook(@Valid @ModelAttribute Book book, BindingResult result,
			@RequestParam(value = "file",required=false) MultipartFile file, HttpServletRequest request, Model model)
			throws IOException, ParseException {

		Map<String, Object> map = new HashMap<>();
		
		if (result.hasErrors()) {
			map.put("success", false);
			map.put("msg", "添加失败");
			map.put("errors", result.getFieldErrors());
			
			return map;
		}

		String fileName = file.getOriginalFilename();
		// 解决IE下路径问题
		fileName = fileName.lastIndexOf("\\") == -1 ? fileName : fileName.substring(fileName.lastIndexOf("\\") + 1);

		// 解决名字重复问题
		String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

		String newFileName = UUID.randomUUID() + "." + ext;

		OutputStream output = new FileOutputStream(
				request.getServletContext().getRealPath("/WEB-INF/upload/" + newFileName));
		IOUtils.copy(file.getInputStream(), output);
		output.close();

		book.setPhoto(newFileName);

		int ret = bookService.saveBook(book);

		if (ret > 0) {
			map.put("success", true);
			map.put("msg", "添加成功");
			map.put("url", "add");
			
			return  map;
		} else {
			map.put("success", false);
			map.put("msg", "添加失败");
			return map;
		}
	}
	
	//编辑书籍
	@RequestMapping(value="/toEdit")
	public String toEdit(@RequestParam(required=false) int id) {
		if(id>1) {
			bookId = id;
		}else {
			bookId = 1;
		}
		return "backstage/book/editForm";
	}
	
	@RequestMapping(value="/editData")
	@ResponseBody
	public Book getData() {
		Book book = new Book();
		book = bookService.findBookById(bookId);
		
		return book;
	}
	
	@RequestMapping("/editBook")
	public Map<String, Object> bookEdit(@Valid @ModelAttribute Book book, BindingResult result,
			@RequestParam(value = "file",required=false) MultipartFile file, HttpServletRequest request, Model model,HttpSession session) throws IOException, ParseException {
		
		/*String serverVcode = (String) session.getAttribute(ValidateController.serverVCodeName);
		if(!serverVcode.equalsIgnoreCase(book.getVcode())) {
			result.rejectValue("vcode","book.vcode", "验证码错误");
		}
		*/
		Map<String, Object> map = new HashMap<>();
		if(!file.isEmpty()) {
			
			String fileName = file.getOriginalFilename();
			// 解决IE下路径问题
			fileName = fileName.lastIndexOf("\\") == -1 ? fileName : fileName.substring(fileName.lastIndexOf("\\") + 1);

			// 解决名字重复问题
			String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

			String newFileName = UUID.randomUUID() + "." + ext;

			OutputStream output = new FileOutputStream(
					request.getServletContext().getRealPath("/WEB-INF/upload/" + newFileName));
			IOUtils.copy(file.getInputStream(), output);
			output.close();

			book.setPhoto(newFileName);
		}

		int ret = bookService.editBook(book);

		if (ret > 0) {
			map.put("success", true);
			map.put("msg", "添加成功");
			map.put("url", "list");
			return map;
		} else {
			map.put("success", false);
			map.put("msg", "添加失败");
			return map;
		}
		
	}
	
	
	/**
	 * 	今日推荐（先判断数据库有多少条，满8条不能添）
	 */
	
	int toDayPage = 1;
	
	@RequestMapping(value="/today")
	public String toSetShou(@RequestParam(defaultValue = "1", required = false) int pageNo) {
		
		if(pageNo > 1) {
			toDayPage = pageNo;
		}else {
			toDayPage = 1;
		}
		
		return "backstage/book/recommend";
	}
	
	@RequestMapping(value="/set")
	@ResponseBody
	public Map<String, Object> setShou(@RequestParam int id) {
		
		Map<String, Object> result = new HashMap<>();
		
		int ret = bookService.findAllToday(true);
		
		Book book = bookService.findBook(id,true);
		
		if(book != null) {
			result.put("error", true);
			result.put("msg","本书已经被推荐，请勿重复点击");
			return result;
		}
		
		if(ret >= 10) {
			result.put("error", true);
			result.put("msg","今日推荐已满，请删除推荐后再来推荐");
			return result;
		}else {
			
			int ret2 = bookService.setToday(id);
			
			if(ret2 != 0) {
				result.put("error", false);
				result.put("msg","推荐成功");
				return result;
			}else {
				result.put("error", true);
				result.put("msg","推荐失败");
				return result;
				
			}
			
		}
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value="/cancleById")
	public String cancleById(@RequestParam int id) {
		
		int ret = bookService.cancleById(id);
		
		return "redirect:today";
	}
	
	@RequestMapping(value="/showList")
	@ResponseBody
	public Map<String, Object> showList(@RequestParam(defaultValue = "1", required = false) int pageNo,
			@RequestParam(defaultValue = "", required = false) String name,
			@RequestParam(defaultValue = "-1", required = false) int tid){
		PageInfo<Book> pageInfo = bookService.findAllRecommend(toDayPage,true,name,tid);
		
		Map<String, Object> result = new HashMap<>();
		List<BookToallType> types = typeService.findTotalTypes();

		result.put("types", types);
		
		result.put("pageInfo", pageInfo);
		return result;
	}
}
