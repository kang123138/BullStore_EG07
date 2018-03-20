<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<c:forEach items="${requestScope.page.datas }" var="page">
				<tr>
					<td>${page.name }</td>
					<td>${page.price }</td>
					<td>${page.address }</td>
					<td>${page.sales }</td>
					<td>${page.stock }</td>
					<td><a href="manager/ProductManagerServlet?method=getProduct&id=${page.id }">修改</a></td>
					<td><a href="manager/ProductManagerServlet?method=delProduct&id=${page.id }">删除</a></td>
			</tr>	
			</c:forEach>
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
		<div id="page_nav">
			<a href="manager/ProductManagerServlet?method=getPartProducts&currentPage=1">首页</a>
			<a href="#">上一页</a>
			<a href="#">下一页</a>
			<a href="manager/ProductManagerServlet?method=getPartProducts&currentPage=${requestScope.page.totalPage }">末页</a>
			共页，条记录 到第<input id = "pn_input" type = "text" value = "#">页
			<input id = "btn" type="button" value="确定">
		</div>
	<div id="bottom">
		<span>
			泰牛商城.Copyright &copy;2017
		</span>
	</div>
</body>
</html>