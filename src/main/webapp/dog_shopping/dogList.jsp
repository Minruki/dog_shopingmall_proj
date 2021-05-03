<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>목록</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/list.css">
</head>

<body>
<%-- ${dogList}
<hr>
${todayImageList }
<hr>  --%>
	<section id = "listForm">
		<c:if test="${dogList != null}">
			<h2>개 분양 목록  </h2>
			<div id="regDog"><a href="dogRegistForm.do">개상품등록</a></div>
			<table>
				<tr>
				<c:forEach var="dog" items="${dogList }" varStatus="status">
					<td>
						<a href="dogView.do?id=${dog.id}">
							<img src="images/${dog.image}" id="productImage"/>
						</a>
						
						<span id="dogcontent">분양하는 견종 : ${dog.kind}</span>
						<span id="dogcontent">가격 : <fmt:formatNumber value="${dog.price}" pattern="#,##0원"/></span>
					</td>
					<c:if test="${ ((status.index+1) mod 4) == 0 }">
						</tr>
						<tr>
					</c:if>
				</c:forEach>
				</tr>
			</table>
		</c:if>
		<c:if test="${dogList==null }">
			<div class="div_empty">	강아지 분양이 없습니다. 분양불가 </div>
		</c:if>
		<c:if test="${todayImageList !=null }">
			<div id ="todayImageList">
				<h2>오늘 본 개 상품 목록</h2>
				<table>
					<tr>
						<c:forEach var="todayImage" items="${todayImageList}" varStatus="status">
							<td>
								<img src="images/${todayImage}" id="todayImage"/>
							</td>
							<c:if test="${((status.index+1) mod 4)==0 }">
								</tr>
								<tr>
							</c:if>
						</c:forEach>
					</tr>
				</table>
			</div>
		</c:if>
	</section>
</body>
</html>