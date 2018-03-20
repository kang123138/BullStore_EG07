<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理</title>
<%@ include file="/WEB-INF/base.jsp" %>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">商品管理系统</span>
			<%@ include file="/WEB-INF/product_info.jsp" %>
	</div>
	
	<div id="main">
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
				<td>康师傅红烧牛肉面</td>
				<td>3.50</td>
				<td>北京</td>
				<td>200</td>
				<td>400</td>
				<td><a href="pages/manager/product_edit.jsp">修改</a></td>
				<td><a href="#">删除</a></td>
			</tr>	
			
			<tr>
				<td>康师傅红烧牛肉面</td>
				<td>3.50</td>
				<td>北京</td>
				<td>200</td>
				<td>400</td>
				<td><a href="pages/manager/product_edit.jsp">修改</a></td>
				<td><a href="#">删除</a></td>
			</tr>	
			
			<tr>
				<td>康师傅红烧牛肉面</td>
				<td>3.50</td>
				<td>北京</td>
				<td>200</td>
				<td>400</td>
				<td><a href="pages/manager/product_edit.jsp">修改</a></td>
				<td><a href="#">删除</a></td>
			</tr>	
			
			<tr>
				<td>康师傅红烧牛肉面</td>
				<td>3.50</td>
				<td>北京</td>
				<td>200</td>
				<td>400</td>
				<td><a href="pages/manager/product_edit.jsp">修改</a></td>
				<td><a href="#">删除</a></td>
			</tr>	
			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/product_edit.jsp">添加商品</a></td>
			</tr>	
		</table>
	</div>
	
	<div id="bottom">
		<span>
			泰牛商城.Copyright &copy;2017
		</span>
	</div>
</body>
</html>