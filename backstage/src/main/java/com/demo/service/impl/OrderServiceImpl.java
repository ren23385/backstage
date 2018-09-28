package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.OrderMapper;
import com.demo.model.Order;
import com.demo.model.OrderItem;
import com.demo.service.OrderService;
import com.demo.util.PageConstent;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;

	@Override
	public List<OrderItem> findAllOrderItem() {
		// TODO Auto-generated method stub
		return orderMapper.findAllOrderItem();
	}

	@Override
	public void updateOrder(String status,String id,String orderAddress) {
		// TODO Auto-generated method stub
		orderMapper.updateOrder(status, id,orderAddress);
	}

	
	/**
	 * 	查找已发货的订单
	 */

	@Override
	public PageInfo<Order> findShippedOrder(int pageNo, String id) {
		PageHelper.offsetPage((pageNo - 1)*PageConstent.PAGE_SIZE+1-1,PageConstent.PAGE_SIZE,true);
		List<Order> ls  = orderMapper.findShippedOrder(id);
		
		PageInfo<Order> pageInfo = new PageInfo<>(ls);
		
		
		return pageInfo;
	}
	
	/**
	 * 	查找未处理的订单
	 */

	@Override
	public PageInfo<Order> findNotOrder(int pageNo, String id) {
		PageHelper.offsetPage((pageNo - 1)*PageConstent.PAGE_SIZE+1-1,PageConstent.PAGE_SIZE,true);
		List<Order> ls  = orderMapper.findNotOrder(id);
		PageInfo<Order> pageInfo = new PageInfo<>(ls);
		
		System.err.println(ls.size()+"=============1231313===============================");
		System.out.println(pageInfo);
		
		return pageInfo;
	}

	/**
	 * 	查找退货中的订单
	 */
	@Override
	public PageInfo<Order> findBackOrder(int pageNo, String id) {
		PageHelper.offsetPage((pageNo - 1)*PageConstent.PAGE_SIZE+1-1,PageConstent.PAGE_SIZE,true);
		List<Order> ls  = orderMapper.findBackOrder(id);
		PageInfo<Order> pageInfo = new PageInfo<>(ls);
		
		System.out.println(pageInfo);
		
		return pageInfo;
	}

	/**
	 * 	查找已完成的订单
	 */
	@Override
	public PageInfo<Order> findAlredyOrder(int pageNo, String id) {
		PageHelper.offsetPage((pageNo - 1)*PageConstent.PAGE_SIZE+1-1,PageConstent.PAGE_SIZE,true);
		List<Order> ls  = orderMapper.findAlreadyOrder(id);
		PageInfo<Order> pageInfo = new PageInfo<>(ls);
		
		System.out.println(pageInfo);
		
		return pageInfo;
	}

}
