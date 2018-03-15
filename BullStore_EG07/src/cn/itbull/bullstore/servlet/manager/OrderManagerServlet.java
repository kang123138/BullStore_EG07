package cn.itbull.bullstore.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itbull.bullstore.Service.impl.OrderServiceImpl;
import cn.itbull.bullstore.domain.Order;
import cn.itbull.bullstore.domain.OrderItem;
import cn.itbull.bullstore.servlet.BaseServlet;

public class OrderManagerServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * 处理管理员获取订单列表的请求
	 */
	public void getOrderList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		OrderServiceImpl service = new OrderServiceImpl();

		List<Order> orderList = service.getOrderlist();
		// 放入request域中
		request.setAttribute("orderList", orderList);

		// 转发去页面order_manager.jsp
		request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);
	}
 
	/**
	 * 处理管理员修改订单状态（即发货） 的请求
	 */
	public void sendProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       
		OrderServiceImpl service = new OrderServiceImpl();
      
	//	String orderId = (String) request.getAttribute("orderId");
		String orderId = request.getParameter("orderId");
		service.sendProduct(orderId);
 
		// 修改完后再到servlet获取订单列表
		 response.sendRedirect(request.getContextPath() + "/manager/OrderManagerServlet?method=getOrderList");
		// request.getRequestDispatcher("/manager/OrderManagerServlet?method=getOrderList").forward(request, response);
	}
	
	/**
	 * 处理管理员查看某个订单的订单项的请求
	 */
	public void getOrderDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OrderServiceImpl service = new OrderServiceImpl();
		
		String orderId = request.getParameter("orderId");
		List<OrderItem> orderItemList = service.getOrderItemListByOrderId(orderId);
		// 把得到的list集合存入request域中
		request.setAttribute("orderItemList", orderItemList);
		
		// 请求转发去order_detail.jsp页面
		request.getRequestDispatcher("/pages/order/order_detail.jsp").forward(request, response);
	}
	
}