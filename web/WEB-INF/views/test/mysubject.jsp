<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:if test="${!empty tsucode }">
	<body>
	>>>>>>>>>
		<%
			session = request.getSession();
			
		%>
		아이디 = <%= session.getAttribute("tid") %>
		코드 = <%= session.getAttribute("sucode") %>
		<form action="theme.do" method="post" allign="center">
		<table board="1" width="200" height="300" allign="center">
	
		<tr>
			<th width="30%">주제 이름:</th>
			<td><input name = "Thname" align="center" onkeydown="enterCheck(this)"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="추가" onclick="check()"/>
			</td> 
		</tr>
		</table>
		
	</form>
	<a href="themelist.do">주제목록</a>
	</body>
</c:if>
<c:if test="${!empty ssucode }">
	<body>
		<%
			session = request.getSession();
			
		%>
		아이디 = <%= session.getAttribute("sid") %>
		코드 = <%= session.getAttribute("sucode") %>
	</body>
</c:if>

</html>