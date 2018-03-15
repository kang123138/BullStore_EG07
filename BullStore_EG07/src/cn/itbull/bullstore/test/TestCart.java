package cn.itbull.bullstore.test;

import org.junit.Test;

import cn.itbull.bullstore.Service.impl.ProductServiceImpl;
import cn.itbull.bullstore.domain.Cart;
import cn.itbull.bullstore.domain.Product;

public class TestCart {


	@Test
	public void testGetTotalCount() {
		
		Cart cart = new Cart();
		ProductServiceImpl service = new ProductServiceImpl();
		Product product = service.getProduct("1");
		Product product2 = service.getProduct("2");
		cart.addProduct2Cart(product2);
		cart.addProduct2Cart(product2);
		
		System.out.println(cart.getTotalCount());
		
		
		// 获取总金额
		// System.out.println(cart.getTotalCount());

		
		
	}


}
