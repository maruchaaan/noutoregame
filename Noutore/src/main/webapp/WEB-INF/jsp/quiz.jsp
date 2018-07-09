<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.QuizLibrary" %>
<%@ page import="model.Quizz" %>
<%
//セッションスコープからインスタンスを取得
QuizLibrary ql = (QuizLibrary) request.getAttribute("ql");
//Quizz q = (Quizz) session.getAttribute("q");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>脳トレゲーム</title>
<style type="text/css">
body {
background-image:url(/image/813_blackboard.png);
background-position:center top;
background-size:cover;
}
</style>
</head>
<body>
<h1><%= ql.getQst() %></h1>
<form action="/QuizServlet" method="post" >
 <div style="float:left; margin:20px;">
 <INPUT TYPE="image" src="/image/<%= ql.getQleft() %>" alt="ひだり" style="border:solid 2px" name="<%= ql.getQleft()%>">
 </div>
 <div style="float:left; margin:20px;">
 <INPUT TYPE="image" src="/image/<%= ql.getQright() %>" alt="みぎ" style="border:solid 2px" name="<%= ql.getQright()%>">
 </div>
 <br clear="both"/>
 </form>
</body>
</html>