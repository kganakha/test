<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
<h1>単語帳</h1>
<h2>ログイン</h2>
	<c:if test="${not empty msg}">
		<p>
			<font color = "red">${msg}</font>
		</p>
	</c:if>
	<form:form action = "login" modelAttribute = "userInfo" method = "post">
		ID:<form:input path="userId"/><br>
		pass:<form:password path="pass"/><br>
		<form:button name = "set">ログインする</form:button>
	</form:form>
	<br>
</body>
</html>