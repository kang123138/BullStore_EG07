package cn.itbull.bullstore.dao;

import java.util.List;

import cn.itbull.bullstore.domain.OrderItem;

/**
 * 订单项接口
 */
public interface OrderItemDao {
	// 向订单项表中插入一条订单项纪录
	int saveOrderItem(OrderItem orderItem);

	// 根据订单号获取该订单的所有的订单项，即订单详情
	List<OrderItem> getOrderItemListByOrderId(String orderId);
	
	// 批量插入订单项
	int[] saveOrderItemByBatch(Object[][] params);
}
