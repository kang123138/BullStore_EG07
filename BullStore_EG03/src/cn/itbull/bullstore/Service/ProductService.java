package cn.itbull.bullstore.Service;

import java.util.List;

import cn.itbull.bullstore.domain.Page;
import cn.itbull.bullstore.domain.Product;

public interface ProductService {
	/**
	 * 将商品信息保存到数据库
	 */
	int saveProduct(Product product);

	/**
	 * 删除某个商品
	 */
	int delProduct(String id);

	/**
	 * 修改某个商品
	 */
	int updateProduct(Product product);

	/**
	 * 从数据库获得某个商品，返回一个商品的对象
	 */
	Product getProduct(String id);

	/**
	 * 从数据库获得所有的商品，返回对象集合
	 */
	List<Product> getProductList();
	
	/**
	 * 处理分页的业务逻辑
	 */
	Page<Product> getPartProduct(int pageSize,String currentPage);

}
