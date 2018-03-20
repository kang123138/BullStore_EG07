package cn.itbull.bullstore.servlet.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itbull.bullstore.Service.impl.UserServiceImpl;
import cn.itbull.bullstore.domain.User;
import cn.itbull.bullstore.servlet.BaseServlet;
import cn.itbull.bullstore.utils.WEBUtils;

public class UserServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取请求参数
		User user = WEBUtils.getParameterBean(request, new User());

		// 调用service层进行登录逻辑操作
		UserServiceImpl service = new UserServiceImpl();
		User login = service.login(user);
		if (login != null) {
			// 登录成功,请求重定向到登录成功页面
			response.sendRedirect(request.getContextPath() + "/pages/user/login_success.jsp");
		} else {
			// 登录失败，在域对象中设置一个参数返回给登录页面
			request.setAttribute("msg", "用户名或密码错误！请重新登录");
			// 登录失败，请求转发到登录页面
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}
	}

	public void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取请求参数
		User user = WEBUtils.getParameterBean(request, new User());

		// 调用service层处理注册逻辑
		UserServiceImpl service = new UserServiceImpl();

		boolean register = service.register(user);

		if (register == true) {
			// 成功了，请求重定向到注册成功页面
			response.sendRedirect(request.getContextPath() + "/pages/user/regist_success.jsp");
		} else {
			// 注册失败，在域对象中设置错误信息给注册页面
			request.setAttribute("msg", "注册失败!请您重新注册");
			// 请求转发到注册页面
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);;
		}

	}
}