package cn.itbull.bullstore.Service.impl;

import java.util.List;

import cn.itbull.bullstore.Service.ProductService;
import cn.itbull.bullstore.dao.impl.ProductDaoImpl;
import cn.itbull.bullstore.domain.Page;
import cn.itbull.bullstore.domain.Product;

public class ProductServiceImpl implements ProductService {

	ProductDaoImpl dao = new ProductDaoImpl();

	/**
	 * 保存商品
	 */
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
		int currentPage1 = 1;
		try {
			currentPage1 = Integer.parseInt(currentPage);
		} catch (Exception e) {
		}

		page.setCurrentPage(currentPage1);
		dao.getPartProduct(page);

		return page;
	}

}
