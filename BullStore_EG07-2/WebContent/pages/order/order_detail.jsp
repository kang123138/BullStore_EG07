<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
<%@ include file="/WEB-INF/base.jsp"%>
<style type="text/css">
h1 {
	text-align: center;
	margin-top: 200px;
}
</style>
</head>
<body>

	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif"> <span
			class="wel_word">我的订单</span>
		<%@ include file="/WEB-INF/user_info.jsp"%>
	</div>

	<div id="main">
		<table>
			<tr>
				<td>商品的图片</td>
				<td>商品的名称</td>
				<td>商品的地址</td>
				<td>商品的价格</td>
				<td>数量</td>
				<td>金额</td>
			</tr>
			<c:forEach items="${requestScope.orderItemList }" var="orderItemList">
				<tr>
					<td><img width="50px" src = "${pageContext.request.contextPath }/static/img/default.jpg"></img></td>
					<td>${orderItemList.name }</td>
					<td>${orderItemList.address }</td>
					<td>${orderItemList.price }</td>
					<td>${orderItemList.count }</td>
					<td>${orderItemList.money }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="bottom">
		<span> 泰牛商城.Copyright &copy;2017 </span>
	</div>
</body>
</html>