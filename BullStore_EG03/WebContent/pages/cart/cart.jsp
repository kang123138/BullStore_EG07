<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<%@ include file="/WEB-INF/base.jsp" %>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
			<div>
				<span>欢迎<span class="um_span">泰牛</span>光临泰牛商城</span>
				<a href="order/order.jsp">我的订单</a>
				<a href="index.jsp">注销</a>&nbsp;&nbsp;
				<a href="index.jsp">返回</a>
			</div>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>		
			<tr>
				<td>康师傅红烧牛肉面</td>
				<td>2</td>
				<td>3.50</td>
				<td>7.00</td>
				<td><a href="#">删除</a></td>
			</tr>	
			
			<tr>
				<td>海飞丝(植物净翠)</td>
				<td>1</td>
				<td>21.50</td>
				<td>21.50</td>
				<td><a href="#">删除</a></td>
			</tr>	
			
			<tr>
				<td>果粒橙(大1.25L)</td>
				<td>3</td>
				<td>8.90</td>
				<td>26.70</td>
				<td><a href="#">删除</a></td>
			</tr>		
			
		</table>
		
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">6</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">55.20</span>元</span>
			<span class="cart_span"><a href="pages/cart/checkout.jsp">去结账</a></span>
		</div>
	
	</div>
	
	<div id="bottom">
		<span>
			泰牛商城.Copyright &copy;2017
		</span>
	</div>
</body>
</html>