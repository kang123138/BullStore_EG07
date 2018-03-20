package cn.itbull.bullstore.servlet.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itbull.bullstore.Service.impl.ProductServiceImpl;
import cn.itbull.bullstore.domain.Page;
import cn.itbull.bullstore.domain.Product;
import cn.itbull.bullstore.servlet.BaseServlet;
import cn.itbull.bullstore.utils.WEBUtils;

public class ProductClientServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * 处理前台客户端商品信息的请求
	 */
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
		request.getRequestDispatcher("/pages/product/product_list.jsp").forward(request, response);
	}
	
	public void getPartProductsByPrice(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String min = request.getParameter("min");
		String max = request.getParameter("max");
		    
		String path = WEBUtils.getPath(request);
		
		// path = path + "&min=" + min + "&max=" + max;
		// 获取当前的页码
		String currentPageNum = request.getParameter("currentPageNum");
		   
		int pageSize = 4;
		        
		ProductServiceImpl service = new ProductServiceImpl();
		Page<Product> page = service.getPartProductsByPrice(pageSize, currentPageNum, min, max);
		
		page.setPath(path);
		
		request.setAttribute("page", page);
		
		request.getRequestDispatcher("/pages/product/product_list.jsp").forward(request, response);
		
	}

}