<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理</title>
<%@ include file="/WEB-INF/base.jsp"%>
</head>
<body>
	${requestScope.page }
	<script type="text/javascript">
	$(function() {
		
		$('.Adiv').click(function() {
			var name = $(this).parents("tr").find("td:eq(0)").html();
			if( !confirm('确定删除'+ name +'吗？')) {
				//取消
				return false;
			} 
		}); 
	});
	
	</script>
	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif"> <span
			class="wel_word">商品管理系统</span>
		<%@ include file="/WEB-INF/product_info.jsp"%>
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
		<c:forEach items="${page.datas }" var="scope">
			<tr>
				<td>${scope.name }</td>
				<td>${scope.price }</td>
				<td>${scope.address }</td>
				<td>${scope.sales }</td>
				<td>${scope.stock }</td>
				<td><a href="manager/ProductManagerServlet?method=getProductById&id=${scope.id }">修改</a></td>
				<td><a class = "Adiv"  href="manager/ProductManagerServlet?method=delProduct&id=${scope.id }">删除</a></td>
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
	<%@ include file="/WEB-INF/page.jsp" %>
	<div id="bottom">
		<span> 泰牛商城.Copyright &copy;2017 </span>
	</div>
</body>
</html>