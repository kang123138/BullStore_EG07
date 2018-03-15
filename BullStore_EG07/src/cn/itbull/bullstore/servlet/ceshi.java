package cn.itbull.bullstore.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itbull.bullstore.domain.User;

public class ceshi extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public void ceshia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> li = new ArrayList<User>();
		li.add(new User(null, "3", "d", "adf"));
		li.add(new User(null, "6", "e", "afgh"));
		li.add(new User(null, "9", "f", "hjh"));
		request.setAttribute("list", li);
		request.getRequestDispatcher(request.getContextPath() + "/pages/manager/a.jsp").forward(request, response);
	}


}