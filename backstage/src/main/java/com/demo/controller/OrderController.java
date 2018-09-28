package com.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.model.Order;
import com.demo.service.OrderService;
import com.github.pagehelper.PageInfo;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	/**
	 * 未处理
	 */
	@RequestMapping(path="not")
	public String showOrder() {
		return "backstage/order/not";
	}
	@RequestMapping(value="backstage/findAllNotOrder")
	@ResponseBody
	public Map<String, Object> showNotdOrder(Model model, @RequestParam(defaultValue = "1", required = false) int pageNo,
			@RequestParam(defaultValue = "", required = false) String id) {

	
		Map<String, Object> result = new HashMap<>();

		PageInfo<Order> pageInfo = orderService.findNotOrder(pageNo, id);
		
		for (Order order : pageInfo.getList()) {
			System.out.println(order+"++++++++++++++++++++++++++++++++++++");
			order.setOrderStatus("未处理");
		}

		result.put("pageInfo", pageInfo);
		return result;
	}
	
	/**
	 * 	已发货
	 */
	@RequestMapping(path="shipped")
	public String shipped() {
		return "backstage/order/shipped";
	}
	
	@RequestMapping(value="backstage/shipped")
	@ResponseBody
	public Map<String, Object> showShippedOrder(Model model, @RequestParam(defaultValue = "1", required = false) int pageNo,
			@RequestParam(defaultValue = "", required = false) String id) {

		
		Map<String, Object> result = new HashMap<>();

		PageInfo<Order> pageInfo = orderService.findShippedOrder(pageNo, id);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(pageInfo);
		System.out.println("=========================================================");
		result.put("pageInfo", pageInfo);

		return result;
	}
	
	@RequestMapping(path="test")
	public String test() {
		return "backstage/style";
	}
	
	/**
	 * 	已完成
	 */
	@RequestMapping(path="already")
	public String already() {
		return "backstage/order/already";
	}
	
	@RequestMapping(value="backstage/already")
	@ResponseBody
	public Map<String, Object> showAlradyOrder(Model model, @RequestParam(defaultValue = "1", required = false) int pageNo,
			@RequestParam(defaultValue = "", required = false) String id) {

		Map<String, Object> result = new HashMap<>();

		PageInfo<Order> pageInfo = orderService.findAlredyOrder(pageNo, id);

		result.put("pageInfo", pageInfo);
		
		return result;
	}
	
	
	/**
	 * 	退货中
	 */
	@RequestMapping(path="backOrder")
	public String back() {
		return "backstage/order/back";
	}
	
	@RequestMapping(value="backstage/back")
	@ResponseBody
	public Map<String, Object> showBackOrder(Model model, @RequestParam(defaultValue = "1", required = false) int pageNo,
			@RequestParam(defaultValue = "", required = false) String id) {

		Map<String, Object> result = new HashMap<>();

		PageInfo<Order> pageInfo = orderService.findBackOrder(pageNo, id);

		result.put("pageInfo", pageInfo);
		
		return result;
	}
	
	
	/**
	 * 
	 *	更新订单状态
	 */
	@RequestMapping(value="/updateNotOrder")
	public String UpdateOrder(@RequestParam(defaultValue="" ,required=true)String id,@RequestParam(defaultValue="",required = true)String orderAddress){
		System.out.println(id+"asdadasd1231+++++++++++++++++"+orderAddress);
		orderService.updateOrder("已发货", id,orderAddress);
		
		return "redirect:not";
	}
	
}
