<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
<%@ include file="/WEB-INF/base.jsp" %>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">我的订单</span>
			<%@ include file="/WEB-INF/user_info.jsp" %>
	</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>		
			<tr>
				<td>2017.05.20</td>
				<td>90.00</td>
				<td>未发货</td>
				<td><a href="#">查看详情</a></td>
			</tr>	
			
			<tr>
				<td>2017.03.16</td>
				<td>20.00</td>
				<td>已发货</td>
				<td><a href="#">查看详情</a></td>
			</tr>	
			
			<tr>
				<td>2016.11.11</td>
				<td>190.00</td>
				<td>已完成</td>
				<td><a href="#">查看详情</a></td>
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