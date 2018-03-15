package cn.itbull.bullstore.Service.impl;

import java.util.Date;
import java.util.List;

import cn.itbull.bullstore.Service.OrderService;
import cn.itbull.bullstore.dao.impl.OrderDaoImpl;
import cn.itbull.bullstore.dao.impl.OrderItemDaoImpl;
import cn.itbull.bullstore.dao.impl.ProductDaoImpl;
import cn.itbull.bullstore.domain.Cart;
import cn.itbull.bullstore.domain.CartItem;
import cn.itbull.bullstore.domain.Order;
import cn.itbull.bullstore.domain.OrderItem;
import cn.itbull.bullstore.domain.Product;
import cn.itbull.bullstore.domain.User;
import cn.itbull.bullstore.utils.WEBUtils;

public class OrderServiceImpl implements OrderService {
	private OrderDaoImpl dao = new OrderDaoImpl();

	/**
	 * 处理生成一个订单的业务逻辑
	 */
	@Override
	public String createOrder(Cart cart, User user) {
		// 生成一个订单号
		String orderId = System.currentTimeMillis() + "" + user.getId();
		// 创建一个order订单
		Order order = new Order(orderId, new Date(), cart.getTotalMoney(), cart.getTotalCount(), 0, user.getId());
		// 将购物车中信息转换成订单信息插入数据库中
		dao.saveOrder(order);

		// 创建订单项对象
		OrderItemDaoImpl orderItem2 = new OrderItemDaoImpl();
		
		// 调用商品dao把修改后的库存和销量的product对象存入数据库
		 ProductDaoImpl dao1 = new ProductDaoImpl();
		// 购物项转换成订单项
		List<CartItem> cartItems = cart.getCartItems();
		// 遍历购物项,第一次用的遍历	
		/*for (CartItem c : cartItems) {

			Product product = c.getProduct();
			// 获取每一个购物项，转换成订单项
			OrderItem orderItem = new OrderItem(null, product.getName(), product.getPrice(), c.getCount(), c.getMoney(),
					product.getAddress(), product.getImgPath(), orderId);

			orderItem2.saveOrderItem(orderItem);

			// 修改Product的销量和库存
			product.setSales(product.getSales() + c.getCount());

			product.setStock(product.getStock() - c.getCount());
			// 修改销量和库存
			dao1.updateProduct(product);
		}*/
		
		// 创建批量操作的参数
		Object[][] productParams = new Object[cartItems.size()][];
		Object[][] orderItemParams = new Object[cartItems.size()][];
		
		/**
		 * int[] arr = {};
		 * arr[0]
		 * 
		 * int[][] arr = {};
		 * arr[0]
		 */
		// 遍历二维数组，给每一个一维数组赋值
		for(int i = 0; i < cartItems.size(); i++) {
			
			// 得到每一个购物项
			CartItem cartItem = cartItems.get(i);
			// 获取商品
			Product product = cartItem.getProduct();
			// 批量插入
			orderItemParams[i] = new Object[]{cartItem.getCount(),cartItem.getMoney(),product.getName(),product.getPrice(),product.getAddress(),product.getImgPath(),orderId};
			
			// 改变后的商品库存和销量
			int stock = product.getStock() + cartItem.getCount();
			int sales = product.getSales() - cartItem.getCount();
			// name=?,address=?,price=?,sales=?,stock=?,img_path=? where id = ?
			// 批量修改商品信息
			productParams[i] = new Object[]{product.getName(),product.getAddress(),product.getPrice(),sales,stock,product.getImgPath(),product.getId()};
			
		}
		
		// 批量修改商品的销量和库存
		dao1.updateProductByBatch(productParams);
		// 批量插入订单项
		orderItem2.saveOrderItemByBatch(orderItemParams);
		// 清空购物车
		cart.clearCart();

		// 返回订单号
		return orderId;
	}

	/**
	 * 处理用户获取订单列表的业务逻辑
	 */
	@Override
	public List<Order> getOrderListByUserId(int userId) {

		List<Order> list = dao.getOrderListByUserId(userId);
		return list;
	}

	/**
	 * 处理管理员获取订单列表的业务逻辑
	 */
	@Override
	public List<Order> getOrderlist() {

		List<Order> orderList = dao.getOrderList();

		return orderList;
	}

	/**
	 * 处理管理员发货的业务逻辑
	 */
	@Override
	public void sendProduct(String orderId) {
		dao.updateState(orderId, 1);
	}

	/**
	 * 处理客户端订单状态修改的业务逻辑
	 */
	@Override
	public void takeProduct(String orderId) {
		dao.updateState(orderId, 2);
	}

	/**
	 * 处理根据订单号获取指定订单项的信息列表的业务逻辑
	 */
	@Override
	public List<OrderItem> getOrderItemListByOrderId(String orderId) {
		OrderItemDaoImpl dao1 = new OrderItemDaoImpl();
		return dao1.getOrderItemListByOrderId(orderId);
	}

}
