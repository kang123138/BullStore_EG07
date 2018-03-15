package cn.itbull.bullstore.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单类
 */
public class Order implements Serializable {
	// 订单号
	private String id;

	// 下单时间
	private Date orderTime;

	// 订单的总金额
	private double totalMoney;

	// 订单的商品总数量
	private int totalCount;

	// 订单中商品的状态
	private int state;

	// 引用User表中的id，用户的id
	private int userId;

	public Order() {
		super();

	}

	public Order(String id, Date orderTime, double totalMoney, int totalCount, int state, int userId) {
		super();
		this.id = id;
		this.orderTime = orderTime;
		this.totalMoney = totalMoney;
		this.totalCount = totalCount;
		this.state = state;
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderTime=" + orderTime + ", totalMoney=" + totalMoney + ", totalCount="
				+ totalCount + ", state=" + state + ", userId=" + userId + "]";
	}
}
