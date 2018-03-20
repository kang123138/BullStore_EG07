<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="page_nav">
	<a href="${page.path }&currentPageNum=1">首页</a>
	<a href="${page.path }&currentPageNum=${page.currentPage-1 }">上一页</a>
	
	<c:set var = "begin" value="1" ></c:set>
	<c:set var="end" value="${page.totalPage }"></c:set>
	
	<c:choose>
		<c:when test="${page.totalPage <= 5 }">
			<c:set var="begin" value="1"></c:set>
			<c:set var="end" value="${page.totalPage }"></c:set>
		</c:when>
		
		<c:otherwise>
			<c:choose>
				<c:when test="${page.currentPage <= 3 }">
					<c:set var="begin" value="1"></c:set>
					<c:set var="end" value="5"></c:set>
				</c:when>
				
				<c:otherwise>
					<c:set var="begin" value="${page.currentPage - 2 }"></c:set>
					<c:set var="end" value="${page.currentPage + 2 }"></c:set>
					
					<c:if test="${page.currentPage+2 > page.totalPage }">
						<c:set var="begin" value="${page.totalPage - 4 }"></c:set>
						<c:set var="end" value="${page.totalPage }"></c:set>
					</c:if>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
	
	<c:forEach begin="${begin }" end="${end }" var="index">
		<c:choose> 
			<c:when test="${page.currentPage == index }">
				<span style="color:red">[<a style = "color:red "href="${page.path }&currentPageNum=${index }">${index }</a>]</span>
			</c:when>
			<c:otherwise>
				<span><a href="${page.path }&currentPageNum=${index }">${index }</a></span>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<a href="${page.path }&currentPageNum=${page.currentPage+1 }">下一页</a>
	<a href="${page.path }&currentPageNum=${page.totalPage }">末页</a>
	共${page.totalPage }页，${page.totalRecord }条记录 到第<input id = "pn_input" type = "text" value = "${page.currentPage }">页
	<input id = "btn" type="button" value="确定">
	
	<script type="text/javascript">
	$('#btn').click(function() {
		var value = $('#pn_input').val();
		// window.location = "/BullStore_EG04/manager/ProductManagerServlet?method=getPartProducts&currentPageNum=" + value;
		var url = window.location + '';
		var index = url.indexOf('&');
		if(index != -1) {
			url = url.slice(0,index);
		} 
		
		url = url + '&currentPageNum=' + value;
		window.location = url;
		
		
	});
	</script>
	</div>