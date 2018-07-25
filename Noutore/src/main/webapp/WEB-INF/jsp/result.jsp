<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Quizz"%>
<%@ page import="model.count"%>
<%
	count c = (count) session.getAttribute("c");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>脳トレゲーム</title>
<style type="text/css">
body {
	background-image: url(/image/813_blackboard.png);
	background-position: center top;
	background-size: cover;
}
</style>
</head>
<body>
	<div style="text-align: center">
	<br><br><br>
		<h2>～あなたの結果～</h2>
		10問中、<%=c.getCorrCount()%>問正解！！ あなたのレベルは....
		<% if(c.getCorrCount() < 3) { %>
		<h1>脳ちゃんと働いてる？</h1>
		<h1>生まれたての赤ちゃんレベル</h1>
		<p><img src="/image/baby.png" alt="baby" width="130" height="130"></p>
		<% } %>
	    <% if(3 <= c.getCorrCount() && c.getCorrCount() < 7) {%>
	    <h1>ダラダラするな！！休日のお父さんレベル</h1>
	    <p><img src="/image/chuunen.png" alt="chuunen" width="130" height="130"></p>
		<% } %>
		<% if(7 <= c.getCorrCount() && c.getCorrCount() < 10) {%>
		<h1>あともうちょっと？ハンプティダンプティレベル</h1>
		<p><img src="/image/humpty_dumpty.png" alt="humpty_dumpty" width="130" height="130"></p>
		<% } %>
		<% if(c.getCorrCount()==10) { %>
		<h1>もはや天才、仙人レベル</h1>
		<p><img src="/image/sennin.png" alt="sennnin" width="130" height="130"></p>
		<% } %>
		<form action="/WelcomeServlet" method="post">
			<input type="submit" value="もう一度挑戦する">
		</form>
	</div>
</body>
</html>