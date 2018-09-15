<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div style="text-align:center">
<br><br><br><br>
<br>
<br>
<h2>正解だと思う方の画像をクリックしてね。</h2>
<p>問題は全部で10問！全問正解できるかな？</p>
<p>レベル：むずかしい☆制限時間は１問10秒だよ！☆</p>
<form action="/QuizServlet2" method="get">
 <input type="submit" value="START!!">
</form>
</div>
</body>
</html>