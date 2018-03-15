package cn.itbull.bullstore.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Object user = request.getSession().getAttribute("loginUser");
		if(user == null) {
			// 用户没有登录
			request.setAttribute("msg", "此操作需要登录");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}
	
	
}
