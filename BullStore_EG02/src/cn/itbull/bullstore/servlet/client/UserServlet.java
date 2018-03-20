package cn.itbull.bullstore.servlet.client;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.itbull.bullstore.domain.User;
import cn.itbull.bullstore.service.UserService;
import cn.itbull.bullstore.service.impl.UserServiceImpl;
import cn.itbull.bullstore.utils.WEBUtils;

public class UserServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		// 获取请求参数
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//
//		// 封装到对象中
//		User user = new User(null, username, password, null);
		
		User user = null;
		try {
			user = WEBUtils.param2Bean(request,new User());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 调用Serviece层处理业务逻辑
		UserServiceImpl service = new UserServiceImpl();

		User loginUser = service.login(user);

		if (loginUser != null) {
			// 登录成功，请求重定向到成功页面(跟浏览器相关的，需要用绝对路径)
			response.sendRedirect(request.getContextPath() + "/pages/user/login_success.jsp");
		} else {
			// 登录失败，请求转发到登录页面
			// 向域对象中添加一个属性
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}
	}

	public void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 封装到对象中
		User user = new User(null, username, password, null);

		// 调用service层处理业务逻辑
		UserService service = new UserServiceImpl();

		boolean isRegister = service.register(user);

		// 根据结果不同给出不同的响应
		if (isRegister == true) {
			// 注册成功，请求重定向到注册成功页面（跟服务器相关，所以用绝对路径）
			response.sendRedirect(request.getContextPath() + "/pages/user/regist_success.jsp");
		} else {
			// 注册失败，请求转发到注册页面
			// 向域对象中添加一个元素
			request.setAttribute("msg", "注册失败");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);;
		}

	}

}