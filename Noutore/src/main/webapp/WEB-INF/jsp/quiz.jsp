<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.QuizLibrary" %>
<%@ page import="model.Quizz" %>
<%
//セッションスコープからインスタンスを取得
//QuizLibrary ql = (QuizLibrary) request.getAttribute("ql");
Quizz q = (Quizz) session.getAttribute("q");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>脳トレゲーム</title>
</head>
<body>
<h1><%= q.getQst() %></h1>
<form action="/QuizServlet" method="post" >
 <div style="float:left; margin:20px;">
 <INPUT TYPE="image" src="/image/<%= q.getQLeft() %>" alt="ひだり" style="border:solid 2px" name="left">
 </div>
 <div style="float:left; margin:20px;">
 <INPUT TYPE="image" src="/image/<%= q.getQRight() %>" alt="みぎ" style="border:solid 2px" name="right">
 </div>
 <br clear="both"/>
 </form>
</body>
</html>