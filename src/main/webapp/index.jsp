<%@page import="dog_shopingmall_proj.ds.JndiDS"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=JndiDS.getConnection() %>
Hi~~~!!!
<hr>
<a href="dogList.do">개 목록보기</a>
</body>
</html>