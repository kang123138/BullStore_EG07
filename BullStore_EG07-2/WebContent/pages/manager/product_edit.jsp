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
	${requestScope.pro }
	<h1>这是页面</h1>
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
						<input type = "hidden" name = "referer" value = "${header['referer'] }"> 
						<input type = "hidden" name = "id" value="${pro.id }">
						<td><input name="name" type="text" value="${pro.name }"/></td>
						<td><input name="price" type="text" value="${pro.price }"/></td>
						<td><input name="address" type="text" value="${pro.address }"/></td>
						<td><input name="sales" type="text" value="${pro.sales }"/></td>
						<td><input name="stock" type="text" value="${pro.stock }"/></td>
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