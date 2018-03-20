package cn.itbull.bullstore.serlvet.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itbull.bullstore.domain.User;
import cn.itbull.bullstore.service.UserService;
import cn.itbull.bullstore.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// 封装到User对象中
		User user = new User(null,username,password,null);
		
		// 调用service层处理业务逻辑
		UserService service = new UserServiceImpl();
		User loginUser = service.login(user);
		
		// 根据处理的结果给出不同的响应
		if(loginUser == null) {
			// 登录失败，请求转发到登录页面
			request.getRequestDispatcher("/pages/user/login.html").forward(request, response);
		}else {
			// 登录成功，请求重定向到登录成功页面
			response.sendRedirect(request.getContextPath() + "/pages/user/login_success.html");
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
