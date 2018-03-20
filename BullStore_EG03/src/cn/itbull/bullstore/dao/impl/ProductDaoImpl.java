package cn.itbull.bullstore.dao.impl;

import java.util.List;

import javax.lang.model.type.PrimitiveType;

import cn.itbull.bullstore.dao.ProductDao;
import cn.itbull.bullstore.domain.Page;
import cn.itbull.bullstore.domain.Product;

public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {

	/**
	 * 向数据库保存商品
	 */
	@Override
	public int saveProduct(Product product) {
		
		String sql = "insert into user_product(name,address,price,sales,stock,img_path) values(?,?,?,?,?,?)";
		return this.update(sql, product.getName(),product.getAddress(),product.getPrice(),product.getSales(),product.getStock(),product.getImgPath());
	}

	/**
	 * 根据商品id删除商品
	 */
	@Override
	public int delProduct(String  id) {
		
		String sql = "delete from user_product where id = ?";
		return this.update(sql, id);
	}

	/**
	 * 更新商品
	 */
	@Override
	public int updateProduct(Product product) {
		String sql = "update user_product set name=?,address=?,price=?,sales=?,stock=?,img_path=? where id = ?";
		return this.update(sql, product.getName(), product.getAddress(), product.getPrice(), product.getSales(),
				product.getStock(), product.getImgPath(), product.getId());
	}

	/**
	 * 根据商品id获取商品
	 */
	@Override
	public Product getProduct(String id) {
		String sql = "select * from user_product where id = ?";
		return this.getBean(sql, id);
	}

	@Override
	public List<Product> getProductList() {
		String sql = "select * from user_product";
		return this.getListBean(sql);
	}

	@Override
	public Page<Product> getPartProduct(Page<Product> page) {
		String sql = "select * from user_product limit ?,?";
		List<Product> datas = this.getListBean(sql, page.getIndex(),page.getPageSize());
		// 添加到page中
		page.setDatas(datas);
		
		// 获取总记录数
		String sql1 = "select count(*) from user_product";
		Long count = (Long)this.getSingleValue(sql1);
		int totalRecord = (int)count.longValue();
		page.setTotalRecord(totalRecord);
		return page;
	}

}
