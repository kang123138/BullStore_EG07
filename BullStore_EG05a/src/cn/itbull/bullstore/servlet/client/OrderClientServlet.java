package cn.itbull.bullstore.servlet.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itbull.bullstore.Service.impl.OrderServiceImpl;
import cn.itbull.bullstore.domain.Cart;
import cn.itbull.bullstore.domain.Order;
import cn.itbull.bullstore.domain.OrderItem;
import cn.itbull.bullstore.domain.User;
import cn.itbull.bullstore.servlet.BaseServlet;
import cn.itbull.bullstore.utils.WEBUtils;

public class OrderClientServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * 该方法处理去结账的请求
	 */
	public void checkOut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 判断用户是否登录
		User user = (User) request.getSession().getAttribute("loginUser");

		if (user != null) {
			// 用户登录了,调用service层处理业务逻辑
			OrderServiceImpl service = new OrderServiceImpl();
			Cart cart = WEBUtils.getCart(request);
			String orderId = service.createOrder(cart, user);
			// 跳转到页面展示订单号
			request.setAttribute("orderId", orderId);
			request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request, response);
		} else {
			// 用户没登录，跳转到登录页面
			// 登录失败，在域对象中设置一个参数返回给登录页面
			request.setAttribute("msg", "您还没登录，请您登录");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}
	}

	// List<Order> getOrderListByUserId(int userId);
	/**
	 * 处理根据用户id获取订单信息的请求
	 */
	public List<Order> getOrderListByUserId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 判断用户是否登录
		User user = (User) request.getSession().getAttribute("loginUser");

		if (user != null) {
			// 用户登录了,调用service层处理业务逻辑
			OrderServiceImpl service = new OrderServiceImpl();
			List<Order> list = service.getOrderListByUserId(user.getId());

			request.setAttribute("list", list);

			// 跳转到页面展示订单列表
			request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
		} else {
			// 用户没登录，跳转到登录页面
			// 登录失败，在域对象中设置一个参数返回给登录页面
			request.setAttribute("msg", "您还没登录，请您登录");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}
		return null;
	}

	/**
	 * 处理客户端修改状态的请求
	 */
	public void takeProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取orderId参数
		String orderId = request.getParameter("orderId");

		// 调用service层处理业务逻辑
		OrderServiceImpl service = new OrderServiceImpl();

		service.takeProduct(orderId);

		// 重定向到servlet重新获取客户端订单列表
		response.sendRedirect(request.getContextPath() + "/client/OrderClientServlet?method=getOrderListByUserId");
	}

	public void getOrderDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		OrderServiceImpl service = new OrderServiceImpl();

		// 获取orderId参数
		String orderId = request.getParameter("orderId");
		List<OrderItem> orderItemList = service.getOrderItemListByOrderId(orderId);
		// System.out.println(orderItemList);
		// 将获取到的orderItemList存入request域中
		request.setAttribute("orderItemList", orderItemList);

		// 请求重定向到order_detail页面
		// response.sendRedirect(request.getContextPath() + "/pages/order/order_detail.jsp");
		// 请求转发去order_detail页面
		request.getRequestDispatcher("/pages/order/order_detail.jsp").forward(request, response);
	}

}