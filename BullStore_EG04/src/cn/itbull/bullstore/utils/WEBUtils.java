package cn.itbull.bullstore.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

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

}
