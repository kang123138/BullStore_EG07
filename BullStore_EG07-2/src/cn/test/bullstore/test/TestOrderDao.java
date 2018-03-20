package cn.itbull.bullstore.test;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.itbull.bullstore.dao.impl.OrderDaoImpl;
import cn.itbull.bullstore.domain.Order;

public class TestOrderDao {

	private OrderDaoImpl dao = new OrderDaoImpl();

	@Test
	public void testSaveOrder() {
		// 生成一个订单号
		String OrderId = System.currentTimeMillis() + "" + 2;
		Order order = new Order(OrderId, new Date(), 1400, 1440, 0, 2);
		int count = dao.saveOrder(order);
		System.out.println(count);

	}

	@Test
	public void testGetOrderList() {
		
		List<Order> orderList = dao.getOrderList();
		// 遍历集合
		for(Order or : orderList) {
			System.out.println(or);
		}
	}

	@Test
	public void testGetOrderListByUserId() {
		
		List<Order> list = dao.getOrderListByUserId(1);
		
		// 遍历list
		for(Order or1 : list) {
			System.out.println(or1);
		}
	}

	@Test
	public void testUpdateState() {
		
		int count = dao.updateState("15135147158831", 1);
		System.out.println(count);
	}

}
