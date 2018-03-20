package cn.itbull.bullstore.Service.impl;

import java.util.List;

import cn.itbull.bullstore.Service.ProductService;
import cn.itbull.bullstore.dao.impl.ProductDaoImpl;
import cn.itbull.bullstore.domain.Page;
import cn.itbull.bullstore.domain.Product;

public class ProductServiceImpl implements ProductService {

	private ProductDaoImpl dao = new ProductDaoImpl();

	@Override
	public int saveProduct(Product product) {
		return dao.saveProduct(product);
	}

	@Override
	public int delProduct(String id) {
		return dao.delProduct(id);
	}

	@Override
	public int updateProduct(Product product) {
		return dao.updateProduct(product);
	}

	@Override
	public Product getProduct(String id) {
		return dao.getProduct(id);
	}

	@Override
	public List<Product> getProductList() {
		return dao.getProductList();
	}

	@Override
	public Page<Product> getPartProduct(int pageSize, String currentPage) {

		Page<Product> page = new Page<>();

		page.setPageSize(pageSize);
		int cpn = 1;
		try {
			cpn = Integer.parseInt(currentPage);
		} catch (Exception e) {

		}
		page.setCurrentPage(cpn);

		// 调用dao层
		page = dao.getPartProducts(page);
		return page;
	}

	@Override
	public Page<Product> getPartProductsByPrice(int pageSize, String currentPage, String min, String max) {

		Page<Product> page = new Page<>();

		page.setPageSize(pageSize);

		int cp = 1;
		try {
			cp = Integer.parseInt(currentPage);
		} catch (Exception e) {
		}
		
		double minPrice = 0;
		double maxPrice = Double.MAX_VALUE;
		try{
			 minPrice = Double.parseDouble(min);
		} catch(Exception e){}
		
		try{
			 maxPrice = Double.parseDouble(max);
		}catch(Exception e){}
		page.setCurrentPage(cp);

		// 调用dao
		ProductDaoImpl dao = new ProductDaoImpl();
		page = dao.getPartProductsByPrice(page, minPrice, maxPrice);

 		return page;
	}

}
