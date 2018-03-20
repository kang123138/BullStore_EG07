package cn.itbull.bullstore.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.apache.jasper.runtime.PageContextImpl;

import cn.itbull.bullstore.Service.impl.ProductServiceImpl;
import cn.itbull.bullstore.domain.Page;
import cn.itbull.bullstore.domain.Product;
import cn.itbull.bullstore.servlet.BaseServlet;
import cn.itbull.bullstore.utils.WEBUtils;

public class ProductManagerServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public void getPartProducts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = WEBUtils.getPath(request);
		// 获取请求参数
		String currentPage = request.getParameter("currentPageNum");
		// 定义每页的记录数
		int pageSize = 4;
		// 调用service层处理业务逻辑
		ProductServiceImpl service = new ProductServiceImpl();

		Page<Product> page = service.getPartProduct(pageSize, currentPage);

		// 存入page对象中
		page.setPath(path);
		// 存入域中
		request.setAttribute("page", page);
		// 请求转发去product_manager.jsp
		request.getRequestDispatcher("/pages/manager/product_manager.jsp").forward(request, response);
	}

	/**
	 * 根据商品的id获取商品的信息
	 */
	public void getProductById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取商品的id
		String Product_id = request.getParameter("id");

		// System.out.println(Product_id);

		// 调用service层
		ProductServiceImpl service = new ProductServiceImpl();

		// 调用Service层的方法获取商品
		Product product = service.getProduct(Product_id);

		// System.out.println(product);
		// 获取修改的对象
		// 存储到域中
		request.setAttribute("pro", product);

		// 请求转发去Product_edit页面
		request.getRequestDispatcher("/pages/manager/product_edit.jsp").forward(request, response);
	}

	public void addOrUpdateProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取请求参数
		Product product = WEBUtils.getParameterBean(request, new Product());
		// 从edit.jsp中获取隐藏表单值
		String referer = request.getParameter("referer");
		ProductServiceImpl service = new ProductServiceImpl();
		int count = 0;
		// 判断
		if (product.getId() != 0) {
			// 修改商品
			count = service.updateProduct(product);
			if (count > 0) {
				// 修改成功，请求转发到product_edit.jsp
				response.sendRedirect(referer);
				// 请求重定向去
			}
		} else {
			// 添加商品
			// 调用service层处理业务逻辑
			count = service.saveProduct(product);

			// 添加成功
			if (count > 0) {
				response.sendRedirect(referer);
				// 请求重定向去
			}
		}

	}

	/**
	 * 获取商品list集合
	 */
	public void getProductList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 调用service层
		ProductServiceImpl service = new ProductServiceImpl();

		List<Product> products = service.getProductList();

		// 存储到域中
		request.setAttribute("list", products);

		// 转发去
		request.getRequestDispatcher("/pages/manager/product_manager.jsp").forward(request, response);
	}

	/**
	 * 删除某条商品
	 */
	public void delProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Service层对象
		ProductServiceImpl service = new ProductServiceImpl();

		String ProId = request.getParameter("id");
		int count = service.delProduct(ProId);
		// 获取请求从哪儿来
		String referer = request.getHeader("referer");
		// System.out.println(referer);
		//
		if (count > 0) {
			// 删除成功,请求转发去
			// request.getRequestDispatcher(referer).forward(request, response);
			// 请求重定向去
			response.sendRedirect(referer);

		}
	}

}