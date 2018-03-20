package cn.itbull.bullstore.serlvet.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itbull.bullstore.domain.User;
import cn.itbull.bullstore.service.UserService;
import cn.itbull.bullstore.service.impl.UserServiceImpl;

public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		// 封装到User对象中
		User user = new User(null,username,password,email);
		
		// 调用UserService去做注册的业务逻辑
		UserService service = new UserServiceImpl();
		boolean isRegist = service.regist(user);
		
		// 根据返回的结果给出不同的响应
		if(isRegist) {
			// 注册成功了，请求重定向到注册成功页面
			response.sendRedirect(request.getContextPath() + "/pages/user/regist_success.html");
			
		}else {
			// 注册失败了，请求转发去注册页面
			request.getRequestDispatcher("/pages/user/regist.html").forward(request, response);
			
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
