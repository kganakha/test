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
<title>ID/pass変更</title>
</head>
<body>
	<c:if test="${not empty msg}">
		<p>
			<font color = "red">${msg}</font>
		</p>
	</c:if>
	<form:form action = "change" modelAttribute = "userInfo" method = "post">
		新規ID:<form:input path="userId"/><br>
		新規pass:<form:password path="pass"/><br>
		<form:button name = "set">変更する</form:button>
	</form:form>
</body>
</html>