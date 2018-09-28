package com.demo.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Order;
import com.demo.model.OrderItem;
import com.github.pagehelper.PageInfo;

public interface OrderService {
	
	@Transactional(readOnly=true)
	List<OrderItem> findAllOrderItem();
	
	@Transactional(readOnly=false)
	void updateOrder(String status,String id,String orderAddress);

	@Transactional(readOnly=true)
	PageInfo<Order> findShippedOrder(int pageNo, String id);

	@Transactional(readOnly=true)
	PageInfo<Order> findNotOrder(int pageNo, String id);

	@Transactional(readOnly=true)
	PageInfo<Order> findBackOrder(int pageNo, String id);

	@Transactional(readOnly=true)
	PageInfo<Order> findAlredyOrder(int pageNo, String id);

}
