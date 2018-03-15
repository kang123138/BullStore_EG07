package cn.itbull.bullstore.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
	// 购物车商品总数量
	// private int totalCount;

	// 购物车商品总金额
	// private double totalMoney;

	// 保存购物车中的购物项
	private Map<String, CartItem> map = new HashMap<String, CartItem>();

	// 购物车中购物项的List集合
	// private List<CartItem> cartItems;

	public Cart() {
		super();

	}

	public Cart(Map<String, CartItem> map) {
		super();
		this.map = map;
	}

	/**
	 * 通过遍历List集合得到每一个购物项，然后获取每个数量相加
	 */
	public int getTotalCount() {
		List<CartItem> cartItems = getCartItems();
		int totalCount = 0;
		// 遍历
		for (CartItem c : cartItems) {
			totalCount += c.getCount();
		}
		return totalCount;
	}

	/**
	 * 通过遍历List集合得到每一个购物项，然后获取每个价格
	 */
	public double getTotalMoney() {
		List<CartItem> cartItems = getCartItems();

		/*
		 * double totalMoney = 0; // 遍历 for(CartItem c : cartItems) { totalMoney
		 * += c.getMoney(); }
		 */

		// double 类型的使用BigDecimal精确
		BigDecimal totalMoney = new BigDecimal("0");

		for (CartItem c : cartItems) {
			totalMoney = totalMoney.add(new BigDecimal(c.getMoney() + ""));
		}
		return totalMoney.doubleValue();
	}

	public Map<String, CartItem> getMap() {
		return map;
	}

	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}

	/**
	 * 通过获取Map集合中所有的值的方式获取所有购物项的List集合
	 */
	public List<CartItem> getCartItems() {
		Collection<CartItem> values = getMap().values();
		ArrayList<CartItem> cartItems = new ArrayList<>(values);
		return cartItems;
	}

	@Override
	public String toString() {
		return "Cart []";
	}
	// 将商品添加到购物车
	public void addProduct2Cart(Product product) {
		// 到Map集合中，看有没有该这个购物项
		Map<String, CartItem> map = getMap();
		if (map.containsKey(product.getId().toString())) {
			// 包含这个购物项，已经有这个商品了
			// 获取该商品的数量，然后加1
			CartItem cartItem = map.get(product.getId().toString());
			cartItem.setCount(cartItem.getCount()+1);
			// System.out.println(cartItem.getCount());
		} else {
			// 没有这购物项
			// 创建该商品
			CartItem cartItem = new CartItem(product, 1);
			map.put(product.getId().toString(), cartItem);
		}
	}

	// 根据商品的id 删除指定的商品
	public void delCartItem(String productId) {
		getMap().remove(productId);
	}

	// 清空购物车
	public void clearCart() {
		getMap().clear();
	}

	// 修改购物车中的商品数量
	public void updateCount(String productId, String countStr) {
		int count = 1;
		try{
			count = Integer.parseInt(countStr);
		} catch(Exception e){
		}
		getMap().get(productId).setCount(count);
	}

}
