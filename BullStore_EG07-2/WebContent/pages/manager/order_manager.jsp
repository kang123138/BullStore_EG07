<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单管理</title>
<%@ include file="/WEB-INF/base.jsp" %>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">订单管理系统</span>
			<%@ include file="/WEB-INF/product_info.jsp" %>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>订单号</td>
				<td>日期</td>
				<td>金额</td>
				<td>数量</td>
				<td>状态</td>
				<td>详情</td>
			</tr>
			<c:forEach items="${requestScope.orderList }" var="orderList">
			<tr>
				<td>${orderList.id }</td>
				<td>${orderList.orderTime }</td>
				<td>${orderList.totalMoney }</td>
				<td>${orderList.totalCount }</td>
					<c:choose>
						<c:when test="${orderList.state == 0 }">
							<td><a href="manager/OrderManagerServlet?method=sendProduct&orderId=${orderList.id}">点击发货</a></td>
						</c:when>
						<c:when test="${orderList.state == 1 }">
							<td>已发货</td>
						</c:when>
						<c:when test="${orderList.state == 2 }">
							<td>交易完成</td>
						</c:when>
					</c:choose>
				<td><a href="manager/OrderManagerServlet?method=getOrderDetail&orderId=${orderList.id }">查看详情</a></td>
			</tr>	
			</c:forEach>		
		</table>
	</div>
	
	<div id="bottom">
		<span>
			泰牛商城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>