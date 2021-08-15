<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body style="text-align:center">
		<center>
			<h1>
				주제 리스트
			</h1>
			<table border='1' cellpadding='7' cellspacing='2' width='50%'>
			<tr>
			<th>주제코드</th>
			<th>선생님아이디</th>
			<th>과목코드</th>
			<th>주제이름</th>
			<th>작성날짜</th>
			</tr>
			
			<c:if test="${empty list }">
				<tr>
				<td align="center" colspan="5">데이터가 하나도 없음</td>
				</tr>
			</c:if>
			
			<c:forEach items="${list }" var="ThemeVo">
				<tr>
				<td align="center">${ThemeVo.thcode }</td>
				 
				<td>${ThemeVo.tid }</td>
				<td>${ThemeVo.sucode }</td>
				<td>${ThemeVo.thname }</td>
				<td>${ThemeVo.trdate }</td>
				<td align='center'><a href='mysubject.do?sucode=${ThemeVo.sucode }'>이동</a></td>
				</tr>
			</c:forEach>
			<a href="logout.do">로그아웃</a>
			</table>
		</center>
	</body>
</html>