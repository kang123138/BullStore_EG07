package cn.itbull.bullstore.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Test;

import cn.itbull.bullstore.dao.impl.ProductDaoImpl;
import cn.itbull.bullstore.domain.Page;
import cn.itbull.bullstore.domain.Product;

public class TestProductDaoImpl {


	@Test
	public void testGetPartProductsByPrice() {
		Page<Product> page = new Page<>();
		
		page.setCurrentPage(1);
		page.setPageSize(4);
		ProductDaoImpl dao = new ProductDaoImpl();
		
		Page<Product> products = dao.getPartProductsByPrice(page, 10, 20);
		
		List<Product> datas = products.getDatas();
		
		for(Product p : datas) {
			System.out.println(p);
		}
	}

}
