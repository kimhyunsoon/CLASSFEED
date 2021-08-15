<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Test</h2>
<form action="sign_up.do" method="post">
	<table border="1" width="500" height="500" align="center">
		<tr>
			<td width="30%" colspan="2" align="center"><h2>입력폼</h2></td>
		</tr>
		<tr>
			<th width="30%">선생님 아이디</th>
			<td><input name="tid" align="center" size="20" align="center" onkeydown="enterCheck(this)"></td>
		</tr>
		<tr>
			<th width="30%">비밀번호</th>
			<td><input name="tpwd" align="center" size="20" align="center" onkeydown="enterCheck(this)"></td>
		</tr>
		<tr>
			<th width="30%">이름</th>
			<td><input name="tname" align="center" size="20" align="center" onkeydown="enterCheck(this)"></td>
		</tr>
		<tr>
			<th width="30%">전화번호</th>
			<td><input name="tphonenumber" align="center" size="20" align="center" onkeydown="enterCheck(this)"></td>
		</tr>
		<tr>
			<th width="30%">이메일</th>
			<td><input name="temail" align="center" size="20" align="center" onkeydown="enterCheck(this)"></td>
		</tr>
		<tr>
			<th width="30%">기관명</th>
			<td><input name="tagency" align="center" size="20" align="center" onkeydown="enterCheck(this)"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="teacher" onclick="check()" name="jobck"/>
				<input type="reset" value="취소"/>
			</td> 
		</tr>
	</table>
</form>
<form action="sign_up.do" method="post">
	<table border="1" width="500" height="500" align="center">
		<tr>
			<td width="30%" colspan="2" align="center"><h2>입력폼</h2></td>
		</tr>
		<tr>
			<th width="30%">학생 아이디</th>
			<td><input name="sid" align="center" size="20" align="center" onkeydown="enterCheck(this)"></td>
		</tr>
		<tr>
			<th width="30%">비밀번호</th>
			<td><input name="spwd" align="center" size="20" align="center" onkeydown="enterCheck(this)"></td>
		</tr>
		<tr>
			<th width="30%">이름</th>
			<td><input name="sname" align="center" size="20" align="center" onkeydown="enterCheck(this)"></td>
		</tr>
		<tr>
			<th width="30%">전화번호</th>
			<td><input name="sphonenumber" align="center" size="20" align="center" onkeydown="enterCheck(this)"></td>
		</tr>
		<tr>
			<th width="30%">이메일</th>
			<td><input name="semail" align="center" size="20" align="center" onkeydown="enterCheck(this)"></td>
		</tr>
	
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="student" onclick="check()" name="jobck"/>
				<input type="reset" value="취소"/>
			</td> 
		</tr>
	</table>
</form>
</body>
</html>