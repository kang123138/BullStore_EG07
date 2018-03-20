<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
<%@ include file="/WEB-INF/base.jsp" %>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">编辑商品</span>
			<%@ include file="/WEB-INF/product_info.jsp" %>
		</div>
		<div id="main">
			<form action="pages/manager/product_manager.jsp">
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>地区</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<td><input name="product_name" type="text" value="康师傅红烧牛肉面"/></td>
						<td><input name="product_price" type="text" value="3.50"/></td>
						<td><input name="product_address" type="text" value="北京"/></td>
						<td><input name="product_sales" type="text" value="200"/></td>
						<td><input name="product_amount" type="text" value="300"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>
		
		<div id="bottom">
			<span>
				泰牛商城.Copyright &copy;2015
			</span>
		</div>
</body>
</html>