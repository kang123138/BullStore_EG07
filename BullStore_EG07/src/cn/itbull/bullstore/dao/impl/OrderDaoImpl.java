package cn.itbull.bullstore.dao.impl;

import java.util.List;

import cn.itbull.bullstore.dao.OrderDao;
import cn.itbull.bullstore.domain.Order;

public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao {

	@Override
	public int saveOrder(Order order) {
		String sql = "insert into bs_order values(?,?,?,?,?,?)";
		return this.update(sql, order.getId(), order.getOrderTime(), order.getTotalCount(), order.getTotalMoney(),
				order.getState(), order.getUserId());
	}

	@Override
	public List<Order> getOrderList() {
		String sql = "select id, order_time orderTime, total_count totalCount, total_money totalMoney,state,user_id userId from bs_order";
		return this.getListBean(sql);
	}

	@Override
	public List<Order> getOrderListByUserId(int userId) {

		String sql = "select id, order_time orderTime, total_count totalCount, total_money totalMoney,state,user_id userId from bs_order where user_id = ?";
		return this.getListBean(sql, userId);
	}

	@Override
	public int updateState(String orderId, int state) {
		String sql = "update bs_order set state = ? where id = ?";
		return this.update(sql, state, orderId);
	}

}
