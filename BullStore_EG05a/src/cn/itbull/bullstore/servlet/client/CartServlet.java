package cn.itbull.bullstore.servlet.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itbull.bullstore.Service.impl.ProductServiceImpl;
import cn.itbull.bullstore.domain.Cart;
import cn.itbull.bullstore.domain.Product;
import cn.itbull.bullstore.servlet.BaseServlet;
import cn.itbull.bullstore.utils.WEBUtils;

public class CartServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * 处理添加购物车请求
	 */
	public void addProduct2Cart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取商品的id
		String productId = request.getParameter("ProductId");

		
		// 调用service层获取商品对象
		ProductServiceImpl service = new ProductServiceImpl();
		Product product = service.getProduct(productId);

		// 设置添加的商品的名称
		request.setAttribute("productName", product.getName());
		Cart cart = WEBUtils.getCart(request);
		// 调用购物车对象中的addProduct2Cart方法
		cart.addProduct2Cart(product);
		// 回到首页
		// response.sendRedirect(request.getContextPath() + "/index.jsp");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * 该方法处理清空购物车功能
	 */
	public void clearCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取购物车对象
		Cart cart = WEBUtils.getCart(request);

		// 调用cart清空购物车的方法
		cart.clearCart();

		// 请求重定向到首页让用户购买
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}
	
	/**
	 * 删除某项商品的方法
	 */
	public void delCartItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 获取购物车对象
		Cart cart = WEBUtils.getCart(request);
		
		String productId = request.getParameter("productId");
		
		// 调用cart中的方法
		cart.delCartItem(productId);
		
		// 重定向到cart.jsp中
		response.sendRedirect(request.getContextPath() + "/pages/cart/cart.jsp");
	}
	
	/**
	 * 更新商品的数量
	 */
	public void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 获取商品的id
		String id = request.getParameter("productId");
		// 获取需要商品的数量
		String count = request.getParameter("count");
		
		// 获取购物车对象
		Cart cart = WEBUtils.getCart(request);
		
		// 调用cart中的updateCount方法
		cart.updateCount(id, count);
		
		response.sendRedirect(request.getContextPath() + "/pages/cart/cart.jsp");
		
		
		
	}
}