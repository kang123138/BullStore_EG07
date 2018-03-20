package cn.itbull.bullstore.dao.impl;

import java.util.List;

import cn.itbull.bullstore.dao.ProductDao;
import cn.itbull.bullstore.domain.Page;
import cn.itbull.bullstore.domain.Product;

public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {

	@Override
	public int saveProduct(Product product) {
		String sql = "insert into user_product(name,address,price,sales,stock,img_path) values(?,?,?,?,?,?)";
		return this.update(sql, product.getName(), product.getAddress(), product.getPrice(), product.getSales(),
				product.getStock(), product.getImgPath());
	}

	@Override
	public int delProduct(String id) {
		String sql = "delete from user_product where id = ?";
		return this.update(sql, id);
	}

	@Override
	public int updateProduct(Product product) {
		String sql = "update user_product set name=?,address=?,price=?,sales=?,stock=?,img_path=? where id = ?";
		return this.update(sql, product.getName(), product.getAddress(), product.getPrice(), product.getSales(),
				product.getStock(), product.getImgPath(), product.getId());
	}

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
	public Page<Product> getPartProducts(Page page) {

		String sql = "select count(*) from user_product";
		// 获取总记录数
		Long count = (Long) this.getSingleData(sql);
		int totalRecord = (int) count.longValue();

		page.setTotalRecord(totalRecord);

		String sql1 = "select * from user_product limit ?,?";
		// 获取每页的数据列表
		List<Product> list = this.getListBean(sql1, page.getIndex(), page.getPageSize());

		page.setDatas(list);

		return page;
	}

	/**
	 * 
	 */
	@Override
	public Page<Product> getPartProductsByPrice(Page<Product> page, double min, double max) {

		// 获取总记录数
		Long count = (Long) this.getSingleData("select count(*) from user_product where price > ? and price < ?", min,
				max);
		// 给page对象设置满足条件的总记录数
		page.setTotalRecord((int) count.longValue());

		// 获取商品列表，根据价格
		List<Product> list = this.getListBean("select * from user_product where price > ? and price < ? limit ?,?", min,
				max, page.getIndex(), page.getPageSize());
		// 给page对象设置商品的list集合数据
		page.setDatas(list);

		return page;
	}

}
