<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주제 성공</title>
</head>
<body>
주제 추가 성공

<c:forEach var="item" items ="${thinformation}">
	<tr>
		<td>
		${item}<br>
		</td>
		
	</tr>
</c:forEach>

</body>
</html>