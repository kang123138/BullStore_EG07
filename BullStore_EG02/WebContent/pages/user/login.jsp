<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>泰牛会员登录页面</title>
<%@ include file="/WEB-INF/base.jsp" %>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎登录</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>泰牛会员</h1>
								<a href="pages/user/regist.jsp">立即注册</a>
							</div>
							<div class="msg_cont">
								<b></b>
								<!-- <span class="errorMsg">请输入用户名和密码</span> -->
								<!-- 获取域对象中的参数 --><!-- ${msg} -->
								<span class="errorMsg">${empty msg ?  "请输入用户名和密码" : msg}</span>
							</div>
							
							<div class="form">
								<form action="client/UserServlet?method=login"  method="get">
									<label>用户名称：</label>
									<input type = "hidden" value="login" name = "method">
									<input class="itxt" value ="${param.username }" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt"  type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<div id="bottom">
			<span>
				泰牛商城.Copyright &copy;2017
			</span>
		</div>
</body>
</html>