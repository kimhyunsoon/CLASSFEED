<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${!empty fail }">
	<script type="text/javascript">
		alert("잠시후 다시시도");
		history.back();
	</script>
</c:if>

<c:if test="${!empty tinformation }">
	<h2>선생페이지</h2>
	선생id = ${tinformation.tid }
	
	<form action="subject.do" method="post" allign="center">
		<table board="1" width="200" height="300" allign="center">
		<tr>
			<td width="30%" colspan="2" align="center"><h2>과목추가</h2></td>
		</tr>
		<tr>
			<th width="30%">제목:</th>
			<td><input name = "suname" align="center" onkeydown="enterCheck(this)"></td>
		</tr>
		<tr>
			<th width="30%">부제목:</th>
			<td><input name = "ssubname" align="center" onkeydown="enterCheck(this)"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="추가" onclick="check()"/>
				<input type="reset" value="취소"/>
			</td> 
		</tr>
		</table>
		<a href="list.do">내수업리스트</a>
	</form>
	
</c:if>
<c:if test="${!empty sinformation }">
	<h2>학생페이지</h2>
	<h>id = "${sinformation.sid }"</h>
	<form action="class.do" method="post" allign="center">
		<tr>
			<td width="30%" colspan="2" align="center"><h2>수업추가</h2></td>
		</tr>
		<tr>
			<th width="30%">수업코드</th>
			<td><input name = "sucode" align="center" onkeydown="enterCheck(this)"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="추가" onclick="check()"/>
				<input type="reset" value="취소"/>
			</td> 
		</tr>
		<a href="list.do">내수업리스트</a>
	</form>
</c:if>
</body>
</html>