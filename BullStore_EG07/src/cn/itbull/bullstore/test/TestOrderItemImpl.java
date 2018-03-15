package cn.itbull.bullstore.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.itbull.bullstore.dao.impl.OrderItemDaoImpl;
import cn.itbull.bullstore.domain.OrderItem;

public class TestOrderItemImpl {

	private OrderItemDaoImpl dao = new OrderItemDaoImpl();
	@Test
	public void testSaveOrderItem() {
		
		OrderItem orderItem = new OrderItem(1, "泡面2", 2, 4, 8, "北京", "/static/img/default.jpg", "15135146312472");
		int count = dao.saveOrderItem(orderItem);
		System.out.println(count);
		
		
	}

	@Test
	public void testGetOrderItemListByOrderId() {
		
		List<OrderItem> list = dao.getOrderItemListByOrderId("15135146312472");
		
		// 遍历
		for(OrderItem or : list) {
			System.out.println(or);
		}
	}

}
