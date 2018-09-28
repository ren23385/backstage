package com.demo.SQLProvider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class OrderSqlProvider {

	/**
	 *	查询已发货的订单
	 */
	public String createFindShippedOrder(@Param(value="id")String id) {
		return new SQL() {
			{
				
				SELECT("*");
				FROM("order_from");
				
				if(!id.isEmpty()) {
					WHERE("id = #{id}");
				}
				
				WHERE("orderStatus = '已发货'");
				
				
			}
		}.toString();
	}
	
	/**
	 *	查询未处理的订单
	 */
	public String createFindNotOrder(@Param(value="id")String id) {
		return new SQL() {
			{
				
				SELECT("*");
				FROM("order_from");
				
				if(!id.isEmpty()) {
					WHERE("id = #{id}");
				}
				WHERE("orderStatus is null");
				
				
			}
		}.toString();
	}
	
	/**
	 *	查询已完成的订单
	 */
	public String createFindAlready(@Param(value="id")String id) {
		return new SQL() {
			{
				
				SELECT("*");
				FROM("order_from");
				
				if(!id.isEmpty()) {
					WHERE("id = #{id}");
				}
				WHERE("orderStatus = '已完成'");
				
				
			}
		}.toString();
	}
	
	/**
	 *	查询退货中的订单
	 */
	public String createFindBackOrder(@Param(value="id")String id) {
		return new SQL() {
			{
				
				SELECT("*");
				FROM("order_from");
				
				if(!id.isEmpty()) {
					WHERE("id = #{id}");
				}
				WHERE("orderStatus = '退货中'");
				
				
			}
		}.toString();
	}
	
	/**
	 *	更新未处理的订单状态 录入快递编号
	 */
	public String updateNotOrder(@Param(value="id")String id,@Param(value="orderStatus")String orderStatus,
				@Param(value="orderAddress") String orderAddress) {
		return new SQL() {
			{
				
				UPDATE("order_from");
				
				if(!orderAddress.isEmpty() || orderAddress != null) {
					SET("orderAddress = #{orderAddress}");
				}
				SET("orderStatus = #{orderStatus}");
				WHERE("id = #{id}");
				
				
			}
		}.toString();
	}
	
}
