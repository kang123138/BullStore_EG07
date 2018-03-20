package cn.itbull.bullstore.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import cn.itbull.bullstore.domain.User;

public class WEBUtils {

	public  static <T>  T param2Bean(HttpServletRequest request, T t) throws Exception {
		Map<String, String[]> map = request.getParameterMap();
			BeanUtils.populate(t, map);
			return t;
	}

}
