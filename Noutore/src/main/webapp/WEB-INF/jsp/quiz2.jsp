<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.QuizLibrary" %>
<%@ page import="model.Quizz" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Timer"%>
<%@ page import="java.util.TimerTask" %>
<%
//セッションスコープ
Quizz q = (Quizz) session.getAttribute("q");
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
<br><br><br>
<div style="text-align:center">
<h1><%= q.getqst() %></h1>
<form action="/QuizServlet2" method="post" >
 <div style="float:left; margin:50px 110px; text-align:center">
 <button type="submit" name="name" value="<%= q.getqLeft() %>">
 <img src="/image/<%= q.getqLeft() %>" alt="ひだり" width="200" height="200" style="border:solid 2px" >
 </button>
 </div>
 <div style="float:left; margin:50px 20px;">
 <button type="submit" name="name" value="<%= q.getqRight() %>">
 <img src="/image/<%= q.getqRight() %>" alt="みぎ" width="200" height="200" style="border:solid 2px" >
 </button>
 </div>
 <br clear="both"/>
 </form>
 </div>
 <%
 //boolean flag = true;
 //Date jikan= new Date();
 //long start = jikan.getTime();
 //while(flag){
//	 long end = jikan.getTime();
//	 if((end-start)>100000){ //10秒たったらループを抜ける
//		 flag = false;
//	 }
// }
 %>
 <%-- 
 <form action="/QuizServlet2" method="post" >
<input type="hidden" name="name" value="no" >
 </form>
 --%>
</body>
</html>