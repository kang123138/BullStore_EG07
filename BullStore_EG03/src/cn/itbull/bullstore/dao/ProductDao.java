package cn.itbull.bullstore.dao;

import java.util.List;

import cn.itbull.bullstore.domain.Page;
import cn.itbull.bullstore.domain.Product;

public interface ProductDao {
	
	int saveProduct(Product product);		//将商品的信息保存到数据库
	int delProduct(String id);				//根据商品的id删除一件商品
	int updateProduct(Product product); // 修改商品的信息
	Product getProduct(String id);			//根据商品的id获取商品对象
	List<Product> getProductList();		//获取所有的商品信息的集合
	Page<Product> getPartProduct(Page<Product> page);  // 获取分页的商品信息
}
