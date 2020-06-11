<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>出題画面</title>
</head>
<body>
<h1>出題</h1>
<h2>問題</h2>
<h3>${fn:escapeXml(quiz)}</h3>
<h2>答え</h2>
	<form:form action = "QuestionAns" modelAttribute = "questionAns" method = "post">
		<form:input path="ans"/><br>
		<form:button name = "set">回答する</form:button>
	</form:form>
	<a href = "top">TOPに戻る</a>
</body>
</html>