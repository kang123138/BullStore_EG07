package cn.itbull.bullstore.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itbull.bullstore.Service.impl.ProductServiceImpl;
import cn.itbull.bullstore.domain.Page;
import cn.itbull.bullstore.domain.Product;
import cn.itbull.bullstore.servlet.BaseServlet;
import cn.itbull.bullstore.utils.WEBUtils;
import sun.net.www.content.text.plain;


public class ProductManagerServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public void addOrUpdateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 调用service层
		ProductServiceImpl service = new ProductServiceImpl();
		Product product = WEBUtils.getParameterBean(request, new Product());
		int count = 0;
		if(product.getId() != 0) {
			// 修改
			count = service.updateProduct(product);
		} else {
			// 添加
			count = service.saveProduct(product);
		}
		
		if(count > 0) {
			// 修改成功
			response.sendRedirect(request.getContextPath() + "/manager/ProductManagerServlet?method=getPartProducts");
		} else {
			// 修改失败
		}
	}
	
	public void getProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 调用service层
		ProductServiceImpl service = new ProductServiceImpl();
		String id = request.getParameter("id");
		Product product = service.getProduct(id);
		request.setAttribute("product", product);
		request.getRequestDispatcher("/pages/manager/product_edit.jsp").forward(request, response);
	
	}
	
	public void getProductList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 调用service层
		ProductServiceImpl service = new ProductServiceImpl();
		
		List<Product> productList = service.getProductList();
		
		// 存入域中
		request.setAttribute("productList", productList);
		
		// 转发去product_manager
		request.getRequestDispatcher("/pages/manager/product_manager.jsp").forward(request, response);
	}

	public void delProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 调用service层
		ProductServiceImpl service = new ProductServiceImpl();
		String id = request.getParameter("id");
		int count = service.delProduct(id);
		if(count > 0) {
			// 成功
			response.sendRedirect(request.getContextPath() + "/manager/ProductManagerServlet?method=getPartProducts");
		}
	}
	
	/**
	 * 处理分页查询数据的请求
	 */
	public void getPartProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageSize = 4;
		String currentPage = request.getParameter("currentPage");
		
		ProductServiceImpl service  = new ProductServiceImpl();
		Page<Product> page = service.getPartProduct(pageSize, currentPage);
		
		request.setAttribute("page", page);
		request.getRequestDispatcher("/pages/manager/product_manager.jsp").forward(request, response);
	}
}