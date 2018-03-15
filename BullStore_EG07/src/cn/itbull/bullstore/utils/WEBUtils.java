package cn.itbull.bullstore.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import cn.itbull.bullstore.domain.Cart;
import cn.itbull.bullstore.domain.User;

public class WEBUtils {

	public static <T> T getParameterBean(HttpServletRequest request, T t) {

		// 获取请求参数的map 集合
		Map<String, String[]> map = request.getParameterMap();
		try {
			BeanUtils.populate(t, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return t;
	}

	public static String getPath(HttpServletRequest request) {
		// 获取请求地址
		String path = request.getRequestURI();
		// 获取查询参数
		String queryString = request.getQueryString();
		path = path + "?" + queryString;
		if (path.indexOf("&currentPageNum") != -1) {
			path = path.substring(0, path.indexOf("&currentPageNum"));
		}
		return path;
	}

	public static Cart getCart(HttpServletRequest request) {
		// 获取购物车对象
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null) {
			// 没有cart对象
			cart = new Cart();
			// 将购物车对象添加到session域中
			request.getSession().setAttribute("cart", cart);
		}
		return cart;
	}

}
