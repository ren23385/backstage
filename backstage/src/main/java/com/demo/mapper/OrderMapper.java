package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import com.demo.SQLProvider.OrderSqlProvider;
import com.demo.model.Order;
import com.demo.model.OrderItem;

@Mapper
public interface OrderMapper {
	@Select("select * from order_from where orderStatus is null limit #{pageStart},#{pageSize}")
	List<Order> findAllNotOrder(int pageStart,int pageSize);
	
	@Select("select count(*) from order_from")
	int orderCount();
	
	@Select("select * from orderitem")
	List<OrderItem> findAllOrderItem();
	
	//更新未处理的订单状态和快递编号
	@SelectProvider(type=OrderSqlProvider.class,method="updateNotOrder")
	void updateOrder(@Param(value="orderStatus")String orderStatus,@Param(value="id")String id,@Param(value="orderAddress")String orderAddress);

	//查找所有已发货的订单
	@SelectProvider(type=OrderSqlProvider.class,method="createFindShippedOrder")
	List<Order> findShippedOrder(@Param(value="id")String id);

	//查找所有未处理的订单
	@SelectProvider(type=OrderSqlProvider.class,method="createFindNotOrder")
	List<Order> findNotOrder(@Param(value="id")String id);
	
	//查找所有已完成的订单
	@SelectProvider(type=OrderSqlProvider.class,method="createFindAlready")
	List<Order> findAlreadyOrder(@Param(value="id")String id);
	
	//查找退货中的订单
	@SelectProvider(type=OrderSqlProvider.class,method="createFindBackOrder")
	List<Order> findBackOrder(@Param(value="id")String id);
}
