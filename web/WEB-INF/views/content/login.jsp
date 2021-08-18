<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html;charset=utf-8" %>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>CLASSFEED | 로그인</title>
	<link rel="shortcut icon" href="../img/favicon.ico" type="image/x-icon">
	<link rel="icon" href="../img/favicon.ico" type="image/x-icon">
	<script src="https://code.jquery.com/jquery-3.6.0.slim.min.js"></script>

	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">

	<script src="https://kit.fontawesome.com/5a210d3256.js" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" href="css/sign.css">
	<script src="js/common.js"></script>
</head>
<style>

</style>
<body>
<div class="signBoxWrap" style="width: 350px;">
	<div class="signBox" style="height: auto;">
		<div class="logoWrap">
			<p class="title">로그인</p>

			<img src="img/classfeedLogo.png" class="logo">
		</div>
		<form action="member/login.do" method="post" class="loginForm">
			<div class="inpWrap">
				<input type="text" name = "id" class="inp" placeholder="아이디">
				<div class="inpBar"></div>
			</div>
			<div class="inpWrap">
				<input type="password" name = "pwd" class="inp" placeholder="비밀번호">
				<div class="inpBar"></div>
			</div>
			<button type="submit" value="로그인" class="actionBtn">로그인</button>
			<a href="member/sign_up.do" class="otherBtn">회원가입</a>
		</form>
	</div>
	<p class="copy">Copyright © 2021 CLASSFEED.</p>
</div>
</body>
</html>
