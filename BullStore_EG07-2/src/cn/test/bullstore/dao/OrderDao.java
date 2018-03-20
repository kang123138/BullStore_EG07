package cn.itbull.bullstore.dao;

import java.util.List;

import cn.itbull.bullstore.domain.Order;

/**
 * 订单接口
 */

public interface OrderDao {

	// 向订单表中插入一条订单记录
	int saveOrder(Order order);

	// 获取所有的订单列表,给管理员用的
	List<Order> getOrderList();

	// 根据用户的id获取该用户的所有的订单，给用户用的
	List<Order> getOrderListByUserId(int userId);

	// 更新某个订单的状态
	int updateState(String orderId, int state);
}
