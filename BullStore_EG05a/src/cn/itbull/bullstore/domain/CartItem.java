package cn.itbull.bullstore.domain;

import java.math.BigDecimal;

public class CartItem {
	
	// 购物车中商品的对象
	private Product product;
	
	// 购物车中单件商品的数量
	private int count;
	
	// 购物车中单件商品的金额
	// private double money;

	public CartItem() {
		super();
		
	}

	public CartItem(Product product, int count) {
		super();
		this.product = product;
		this.count = count;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * 计算出单件商品的金额
	 */
	public double getMoney() {
//		return getProduct().getPrice() * getCount();
		// 使用BigDecimal改进
		return new BigDecimal((getProduct().getPrice()+"")).multiply(new BigDecimal(getCount()+"")).doubleValue();
	}

	@Override
	public String toString() {
		return "CartItem [product=" + product + ", count=" + count + "]";
	}
	
	
}
