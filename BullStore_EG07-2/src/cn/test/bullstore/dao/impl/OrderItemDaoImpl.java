package cn.itbull.bullstore.dao.impl;

import java.util.List;

import cn.itbull.bullstore.dao.OrderItemDao;
import cn.itbull.bullstore.domain.OrderItem;

public class OrderItemDaoImpl extends BaseDaoImpl<OrderItem> implements OrderItemDao {

	@Override
	public int saveOrderItem(OrderItem orderItem) {
		String sql = "insert into bs_order_item(count,money,name,price,address,image_path,order_id) values(?,?,?,?,?,?,?)";
		return this.update(sql, orderItem.getCount(),orderItem.getMoney(),orderItem.getName(),orderItem.getPrice(),orderItem.getAddress(),orderItem.getImagePath(),orderItem.getOrderId());
	}

	@Override
	public List<OrderItem> getOrderItemListByOrderId(String orderId) {
		String sql = "select id,count,money,name,price,address,image_path imagePath,order_id orderId from bs_order_item where order_id = ?";
		return this.getListBean(sql, orderId);
	}

	/**
	 * 批量插入订单项
	 */
	@Override
	public int[] saveOrderItemByBatch(Object[][] params) {
		
		String sql = "insert into bs_order_item(count,money,name,price,address,image_path,order_id) values(?,?,?,?,?,?,?)";
		return this.batch(sql,params);
	}

}
