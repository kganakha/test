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
<title>トップ画面</title>
</head>
<body>
<h1>トップ画面</h1>
	<a href = "insert">登録</a>
	<a href = "search">確認</a>
	<a href = "questionTop">出題</a><br>
	<a href = "idChange">ID/passを変更する</a><br>
	<a href  = "logout">ログアウト</a>
</body>
</html>