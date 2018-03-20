<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<form action="manager/ProductManagerServlet?method=addOrUpdateProduct" method = "post">
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
							<input name="id" type="hidden" value="${requestScope.product.id }"/>
							<td><input name="name" type="text" value="${requestScope.product.name }"/></td>
							<td><input name="price" type="text" value="${requestScope.product.price }"/></td>
							<td><input name="address" type="text" value="${requestScope.product.address }"/></td>
							<td><input name="sales" type="text" value="${requestScope.product.sales }"/></td>
							<td><input name="stock" type="text" value="${requestScope.product.stock }"/></td>
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