<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<br>
		<br>
		<br>
		<br>
		<br>
		<h3>まずは難易度を選ぼう！</h3>
		<p>
		<form action="/WelcomeServlet" method="get">
			<input type="submit" value="かんたん"> （時間制限なし）
		</form>
		</p>
		<p>
		<form action="/SelectServlet" method="get">
			<input type="submit" value="むずかしい"> （時間制限あり）
		</form>
		</p>
	</div>
</body>
</html>