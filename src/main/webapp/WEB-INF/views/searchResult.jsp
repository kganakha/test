<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
</head>
<body>
<h1>検索結果</h1>
<table border="1">
    <tr>
    <th width="80">番号</th>
      <th width="160">問題</th>
      <th width="80">答え</th>

    </tr>
    <c:forEach var="question" items="${result}">
      <tr>
      	<td>${fn:escapeXml(question.questId)}</td>
        <td>${fn:escapeXml(question.quest)}</td>
        <td>${fn:escapeXml(question.ans)}</td>
        <td>
        	<button  value = question.questId onclick = "location.href='deleteResult'">削除</button>
        </td>
      </tr>
    </c:forEach>
  </table>

<a href = "top">トップに戻る</a>
</body>
</html>