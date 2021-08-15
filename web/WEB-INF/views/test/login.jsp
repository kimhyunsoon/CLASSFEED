<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="login.do" method="post">
	<table board="1" width="100" height="200" allign="center">
		<tr>
			<td width="30%" colspan="2" align="center"><h2>로그은</h2></td>
		</tr>
		<tr>
			<th width="30%">id</th>
			<td><input name = "id" align="center" onkeydown="enterCheck(this)"></td>
		</tr>
		<tr>
			<th width="30%">pwd</th>
			<td><input name = "pwd" align="center" onkeydown="enterCheck(this)"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="로그인" onclick="check()"/>
				<input type="reset" value="취소"/>
			</td> 
		</tr>
		</table>
		
</form>
</body>
</html>