<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Title</title>
		<style>
			table, th, td {
			   border: 1px solid black;
			   border-collapse: collapse;
			}
			th, td {
			   padding: 5px;
			}
			a { text-decoration:none }
		</style>
	</head>
<c:if test="${!empty tlist }">
선생님 리스트
<body style="text-align:center">
		<center>
			<h1>
				선생(teacher) 수업 리스트
			</h1>
			<table border='1' cellpadding='7' cellspacing='2' width='50%'>
			<tr>
			<th>과목코드</th>
			<th>선생님아이디</th>
			<th>과목명</th>
			<th>부제목</th>
			</tr>
			
			<c:if test="${empty tlist }">
				<tr>
				<td align="center" colspan="5">데이터가 하나도 없음</td>
				</tr>
			</c:if>
			
			<c:forEach items="${tlist }" var="subjectVo">
				<tr>
				<td align="center">${subjectVo.sucode }</td>
				 
				<td>${subjectVo.tid }</td>
				<td>${subjectVo.suname }</td>
				<td>${subjectVo.ssubname }</td>
				<td align='center'><a href='mysubject.do?sucode=${subjectVo.sucode }'>이동</a></td>
				</tr>
			</c:forEach>
			<a href="logout.do">로그아웃</a>
			</table>
		</center>
	</body>
</c:if>
<c:if test="${!empty slist }">
	<body style="text-align:center">
		<center>
			<h1>
				학생(my) 수업 리스트
			</h1>
			<table border='1' cellpadding='7' cellspacing='2' width='50%'>
			<tr>
			<th>과목코드</th>
			<th>선생님아이디</th>
			<th>과목명</th>
			<th>부제목</th>
			</tr>
			
			<c:if test="${empty slist }">
				<tr>
				<td align="center" colspan="5">데이터가 하나도 없음</td>
				</tr>
			</c:if>
			
			<c:forEach items="${slist }" var="subjectVo">
				<tr>
				<td align="center">${subjectVo.sucode }</td>
				 
				<td>${subjectVo.tid }</td>
				<td>${subjectVo.suname }</td>
				<td>${subjectVo.ssubname }</td>
				<td align='center'><a href='mysubject.do?sucode=${subjectVo.sucode }'>이동</a></td>
				</tr>
			</c:forEach>
			<a href="logout.do">로그아웃</a>
			</table>
		</center>
	</body>
</c:if>

</html>