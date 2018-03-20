package cn.itbull.bullstore.test;

import static org.junit.Assert.fail;

import org.junit.Test;

import cn.itbull.bullstore.domain.Page;
import cn.itbull.bullstore.domain.Product;

public class TestPage {

	@Test
	public void testGetTotalPage() {
		Page<Product> page = new Page<>();
		page.setTotalRecord(40);
		page.setPageSize(6);
		int totalPage = page.getTotalPage();
		System.out.println(totalPage);
	}

	@Test
	public void testGetIndex() {
		fail("Not yet implemented");
	}

}
