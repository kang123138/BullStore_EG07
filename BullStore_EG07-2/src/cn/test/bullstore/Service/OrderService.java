package cn.itbull.bullstore.Service;

import java.util.List;

import cn.itbull.bullstore.domain.Cart;
import cn.itbull.bullstore.domain.Order;
import cn.itbull.bullstore.domain.OrderItem;
import cn.itbull.bullstore.domain.User;

/**
 * 处理订单相关的业务逻辑
 */
public interface OrderService {
	// 获取订单号的业务逻辑
	String createOrder(Cart cart, User user);
	// 根据用户id获取订单列表的业务逻辑
	List<Order> getOrderListByUserId(int userId);
	
	// 管理员获取订单列表
	List<Order> getOrderlist();
	
	// sendProduct(String orderId)
	// 管理员发货
	void sendProduct(String orderId);
	
	// 修改客户端订单状态
	void takeProduct(String orderId);
	
	// 根据订单号获取某个订单项的业务逻辑
	List<OrderItem> getOrderItemListByOrderId(String orderId);
}
