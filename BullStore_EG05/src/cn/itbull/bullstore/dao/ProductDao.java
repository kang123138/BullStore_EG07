package cn.itbull.bullstore.dao;

import java.util.List;

import cn.itbull.bullstore.domain.Page;
import cn.itbull.bullstore.domain.Product;

/**
 * 操作商品信息的
 */
public interface ProductDao {
	/**
	 * 增加商品
	 */
	int saveProduct(Product product);
	
	/**
	 * 删除商品
	 */
	int delProduct(String id);
	
	/**
	 * 修改商品信息
	 */
	int updateProduct(Product product);
	
	/**
	 * 查询一条商品信息
	 */
	Product getProduct(String id);
	
	/**
	 * 查询多条商品
	 */
	
	List<Product> getProductList();
	
	/**
	 * 获取总记录数和每页商品列表
	 */
	Page<Product> getPartProducts(Page page);
	
	/**
	 * 获取根据价格得到的总记录数和每页的商品列表
	 */
	Page<Product> getPartProductsByPrice(Page<Product> page,double min, double max);
	
}
