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
<title>結果発表</title>
</head>
<body>
	<h1>結果</h1>
		<h1>
		<c:if test="${not empty msg}">
			<p>
				<font color = "red">${msg}</font>
			</p>
		</c:if>
	</h1>
	<h2>問題</h2>
		<h3>${fn:escapeXml(quest)}</h3>
	<h2>答え</h2>
	<h3>
		<c:if test="${not empty ans}">
			<p>
				${ans}
			</p>
		</c:if>
	</h3>
	<h2>
		<c:if test="${not empty ansR}">
			<p>
				<font color = "red">${ansR}</font>
			</p>
		</c:if>
	</h2>

	<a href = "question">もう一回やる</a><br>
	<a href = "top">トップに戻る</a>
</body>
</html>