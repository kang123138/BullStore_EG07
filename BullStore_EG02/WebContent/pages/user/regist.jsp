<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/base.jsp" %>
<title>泰牛会员注册页面</title>
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		
		//正则表达式，用来检查字符串是否符合规则
		/* var reg = /a/;
		var flag = reg.test("cbbc");
		alert(flag); */
		
		
		//为提交按钮绑定单击响应函数
		$("#sub_btn").click(function(){
			
			//获取用户输入的用户名、密码、确认密码、电子邮件、验证码
			var name = $("[name=username]").val();
			var password = $("[name=password]").val();
			var repwd = $("[name=repwd]").val();
			var email = $("[name=email]").val();
			var code = $("[name=code]").val();
			
			//检查用户名、密码等信息是否符合规则
			//验证用户名
			var nameReg = /^[a-zA-Z0-9_-]{3,16}$/;
			if(!nameReg.test(name)){
				//用户名格式不正确
				alert("请输入包含字母、数字、-、_且3-16位的用户名！");
				//取消默认行为
				return false;
			}
			
			//验证密码
			var pwdReg = /^[a-zA-Z0-9_-]{6,18}$/;
			if(!pwdReg.test(password)){
				//密码格式不正确
				alert("请输入包含字母、数字、-、_且6-18位的密码！");
				//取消默认行为
				return false;
			}
			
			//验证确认密码
			if(repwd != password){
				//两次输入的密码不一致
				alert("两次输入的密码不一致！");
				return false;
			}
			
			//检查邮箱格式
			var emailReg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(!emailReg.test(email)){
				alert("请输入正确的邮箱地址！");
				return false;
			}
			
			//检查验证码是否为空
			if(code == ""){
				alert("请输入验证码！");
				return false;
			}

		});
		
	});

</script>



<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册泰牛会员</h1>
								<span class="errorMsg"><!-- 获取域对象中的参数 -->
									${empty msg ? "请注册" : msg }
								</span>
							</div>
							<div class="form">
								<form action="client/UserServlet?method=register" method="post">
									<label>用户名称：</label>
									<input class="itxt" value = "${param.username }" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" value = "${param.email }" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" name="code"/>
									<img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">									
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
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