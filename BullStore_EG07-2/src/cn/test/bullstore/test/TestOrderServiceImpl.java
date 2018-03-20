package cn.itbull.bullstore.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.itbull.bullstore.Service.impl.OrderServiceImpl;
import cn.itbull.bullstore.domain.OrderItem;

public class TestOrderServiceImpl {

	@Test
	public void testGetOrderItemListByOrderId() {

		OrderServiceImpl service = new OrderServiceImpl();
		String orderId = "15135673221011";
		List<OrderItem> list = service.getOrderItemListByOrderId(orderId);
		
		for(OrderItem or : list) {
			System.out.println(or);
		}
		
	}

}
