<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商城首页</title>
<%@ include file="/WEB-INF/base.jsp"%>


</head>
<body>
	<div id="header">
		<img class="logo_img" alt="" src="static/img/logo.gif"> <span
			class="wel_word">泰牛商城</span>
		<%@ include file="/WEB-INF/user_info.jsp"%>
	</div>

	<div id="main">
		<div id="product">
			<div class="product_cond">
				<form action="client/ProductClientServlet" method = "get">
				<input type="hidden" name = "method" value = "getPartProductsByPrice" />
					价格：<input type="text" name="min" value = "${param.min }"> 元 - <input type="text"
						name="max" value = "${param.max }"> 元 <input type="submit" value="提交">
				</form>
			</div>
			<div style="text-align: center">
				<c:choose>
					<c:when test="${empty sessionScope.cart.totalCount }">
						<span>您还没商品，快去购买</span>
					</c:when>
					<c:otherwise>
						<span>您的购物车中有${sessionScope.cart.totalCount }件商品</span>
					</c:otherwise>
				</c:choose>
				
				<div>
					您刚刚将<span style="color: red">${requestScope.productName }</span>加入到了购物车中
				</div>
			</div>
			<c:forEach items="${page.datas }" var="product">
				<div class="b_list">
					<div class="img_div">
						<img class="product_img" alt="" src="static/img/default.jpg" />
					</div>
					<div class="product_info">
						<div class="product_name">
							<span class="sp1">商品:</span> <span class="sp2">${product.name }</span>
						</div>
						<div class="product_address">
							<span class="sp1">地区:</span> <span class="sp2">${product.address }</span>
						</div>
						<div class="product_price">
							<span class="sp1">价格:</span> <span class="sp2">￥${product.price }</span>
						</div>
						<div class="product_sales">
							<span class="sp1">销量:</span> <span class="sp2">${product.sales }</span>
						</div>
						<div class="product_amount">
							<span class="sp1">库存:</span> <span class="sp2">${product.stock }</span>
						</div>
						<div class="product_add">
							<a href = "client/CartServlet?method=addProduct2Cart&ProductId=${product.id }">加入购物车</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

		<%@ include file="/WEB-INF/page.jsp"%>

	</div>

	<div id="bottom">
		<span> 泰牛商城.Copyright &copy;2017 </span>
	</div>
</body>
</html>