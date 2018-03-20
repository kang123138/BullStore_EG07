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
	
	<script type="text/javascript">
		/* 清空购物车 */
		$(function() {
			$("#cart_span1").click(function() {
			if(!confirm("您确定要清除购物车吗？")){
				return false;
			}
			});
			
			/* 删除某个购物项 */
			$(".del").click(function() {
				var oTr = $(this).parents("tr").find("td:eq(0)");
				var name = oTr.html();
				if(!confirm("您确定要删除<"+name+">这件商品吗？")){
					return false;
				} 
			});
			
			/* 给数量输入框添加事件改变 */
			$(".c_change").change(function() {
				// 获取修改的商品的数量
				var count = $(this).val();
				// 对数量进行检验
				var regex = /^\+?[1-9][0-9]*$/;
				
				if(!regex.test(count)) {
					// 非法字符，给count一个默认的值
					count = this.defaultValue;
					alert("请输入合法数量");
					this.value = this.defaultValue;
				} else {
					// 获取当前商品的id
					var id = this.id;
					window.location = "${pageContext.request.contextPath }/client/CartServlet?method=updateCount&productId=" + id + "&count=" + count;
				}
				
			});
			
		});
	

	</script>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
			<%@ include file="/WEB-INF/user_info.jsp" %>
	</div>
	
	<div id="main">
	
		
			
			<c:choose>
				<c:when test="${empty sessionScope.cart }">
					<h1>您还没有商品，快去购买</h1>
				</c:when>
				
				<c:otherwise>
					<table>
						<tr>
							<td>商品名称</td>
							<td>数量</td>
							<td>单价</td>
							<td>金额</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${sessionScope.cart.cartItems}" var="cartItem">
							<tr>
								<td>${cartItem.product.name }</td>
								<td><input id = "${cartItem.product.id}" class = "c_change" style="width: 20px;text-align: center" type="text" name = "amount" value = "${cartItem.count }"></td>
								<td>${cartItem.product.price }</td>
								<td>${cartItem.money }</td>
								<td><a class = "del" href="client/CartServlet?method=delCartItem&productId=${cartItem.product.id}">删除</a></td>
							</tr>
						</c:forEach>	
					</table>
				</c:otherwise>
			</c:choose>
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalMoney}</span>元</span>
			<span class="cart_span"><a href="pages/cart/checkout.jsp">去结账</a></span>
			<span class="cart_span"><a id = "cart_span1" href="client/CartServlet?method=clearCart">清空购物车</a></span>
		</div>
	
	</div>
	
	<div id="bottom">
		<span>
			泰牛商城.Copyright &copy;2017
		</span>
	</div>
</body>
</html>