<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
	Date nowTime = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhmmss");
    String test = "test";
%>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>CLASSFEED | ${param}</title>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">

	<script src="https://kit.fontawesome.com/5a210d3256.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../css/common.css?v=<%= sf.format(nowTime) %>">
    <link rel="stylesheet" href="../css/sign.css?v=<%= sf.format(nowTime) %>">
    <script src="../js/common.js?v=<%= sf.format(nowTime) %>"></script>
</head>
<body>

<header id="header" class="outerWrap">

	<button type="button" class="sideMenuBtn clickAniBtn toolTipWrap">
		<img src="../img/sideMenuBtn.svg">
		<p class="toolTipBot">사이드메뉴</p>

	</button>
	<a href="" class="homeLink">
		<img src="../img/classfeedLogo.png">
	</a>

	<div class="rightBtnWrap">


		<button type="button" class="feedCenter clickAniBtn toolTipWrap">
			<b class="feedDot"></b>
			<img src="../img/feedCenter.svg">
			<p class="toolTipBot">알림센터</p>

		</button>

		<a href="../member/logout.do" class="mypageLink toolTipWrap">
			<img src="../img/defaltProfile.png">
			<p class="toolTipBot toolTipBot2">마이페이지</p>
		</a>
	</div>

	<!-- <div class="innerWrap">

    </div> -->

</header>
<nav class="sideNav">
	<a href="" class="sideNavLink toolTipWrap on">
		<i class="fas fa-chalkboard-teacher"></i>
		<p class="toolTipBot">클래스</p>
	</a>

	<a href="" class="sideNavLink toolTipWrap">
		<i class="fas fa-archive"></i>
		<p class="toolTipBot">수업보관함</p>
	</a>
</nav>


<div class="sideMenuWrap"></div>

<nav class="sideMenu">
	<div class="welcomeMsg">
		<c:choose>
			<c:when test="${!empty tList}">
				<c:forEach items="${tList}" var="teacherVo">
					<p>${teacherVo.tname} 선생님, 반갑습니다!</p>
				</c:forEach>
			</c:when>
			<c:when test="${!empty sList}">
				<c:forEach items="${sList}" var="studentVo">
					<p>${studentVo.sname} 님, 반갑습니다!</p>
				</c:forEach>
			</c:when>
		</c:choose>

	</div>
	<a href="" class="mainLink on">
		<i class="fas fa-chalkboard-teacher"></i>
		<p>클래스</p>
	</a>
	<a href="" class="mainLink">
		<i class="fas fa-archive"></i>
		<p>수업보관함</p>
	</a>
	<div class="classList">
		<p class="classListTitle">나의 수업</p>
		<c:choose>
			<c:when test="${!empty tList}">
				<c:choose>
					<c:when test="${!empty tSubList}">
						<c:forEach items="${tSubList}" var="subjectVo">
							<a href="../list/mystream.do?sucode=${subjectVo.sucode}" class="classLink">
								<p>${subjectVo.suname}</p>
								<c:forEach items="${tList}" var="teacherVo">
									<p>${teacherVo.tname} 선생님</p>
								</c:forEach>
							</a>
						</c:forEach>
					</c:when>
					<c:when test="${empty tSubList}">
						<p class="noClassText classLink">
							등록된 수업이 없습니다.
						</p>
					</c:when>
				</c:choose>
			</c:when>
			<c:when test="${!empty sList}">
				<c:choose>
					<c:when test="${!empty sSubList}">
						<c:forEach items="${sSubList}" var="subjectVo">
							<a href="../list/mystream.do?sucode=${subjectVo.sucode}" class="classLink">
								<p>${subjectVo.suname}</p>

								<p>
								<c:forEach items="${tName}" var="TeacherVo">
									${TeacherVo.tname} 선생님
								</c:forEach></p>

							</a>
						</c:forEach>
					</c:when>
					<c:when test="${empty sSubList}">
						<p class="noClassText classLink">
							등록된 수업이 없습니다.
						</p>
					</c:when>
				</c:choose>
			</c:when>
		</c:choose>

	</div>

</nav>




<c:choose>
	<c:when test="${!empty tList}">
		<!--우하단 + 버튼, 선생님-->
		<nav class="classAddBtn toolTipWrap clickAniBtn modalBtn teaSample" data-modal="addClass">
			<i class="fas fa-plus"></i>
			<p class="toolTipTop">새 클래스 만들기</p>
		</nav>

		<!--우하단 + 버튼시 모달 선생님-->
		<div class="modalWrap" data-modal="addClass">
			<div class="modalCon">
				<p class="modalTitle">
					<span>새 클래스 만들기</span>
					<i class="fas fa-times modalClose"></i>
				</p>
				<form action="../subject/subject.do" method="post">
					<c:forEach items="${tList}" var="teacherVo">
						<input type="hidden" name="tid" value="${teacherVo.tid}">
					</c:forEach>

					<p class="subTitle">제목</p>
					<div class="inpWrap">
						<input type="text" class="inp" name="suname" required>
						<div class="inpBar"></div>
					</div>

					<p class="subTitle">부제목</p>
					<div class="inpWrap">
						<input type="text" name="ssubname" class="inp" required>
						<div class="inpBar"></div>
					</div>
					<div class="btnWrap">
						<button type="submit" class="adMissionBtn pointBtn">만들기</button>
					</div>

				</form>
			</div>
		</div>
	</c:when>
	<c:when test="${!empty sList}">
		<!--우하단 + 버튼, 학생-->
		<nav class="classAddBtn toolTipWrap clickAniBtn modalBtn stuSample" data-modal="adMission">
			<i class="fas fa-plus"></i>
			<p class="toolTipTop">클래스 참여</p>
		</nav>
		<!--우하단 + 버튼시 모달, 학생-->
		<div class="modalWrap" data-modal="adMission">
			<div class="modalCon">
				<p class="modalTitle">
					<span>클래스 참여</span>
					<i class="fas fa-times modalClose"></i>
				</p>
				<form action="../subject/class.do" method="post">
					<c:forEach items="${sList}" var="studentVo">
						<input type="hidden" name="sid" value="${studentVo.sid}">
					</c:forEach>
					<p class="subTitle">인증코드 입력</p>
					<div class="inpWrap">
						<input type="text" name="sucode" class="inp" required>
						<div class="inpBar"></div>
					</div>
					<p class="msg">* 인증코드는 영문 혹은 숫자 조합이며, 대소문자를 구분합니다.</p>

					<div class="btnWrap">
						<button type="submit" class="adMissionBtn pointBtn">참여하기</button>
					</div>

				</form>
			</div>
		</div>
	</c:when>
</c:choose>

<script>
    function codeTransColor(val){
		var num1 = Number(numTrans(val)[0]);
		var num2 = Number(numTrans(val)[1]);
		var num3 = Number(numTrans(val)[2]);

		var st = 0;
		var ed = 0;
		var index = 0;
		if(num2 % 2 == 0){
			st = 0;
			ed = 3;
		} else {
			st = 4;
			ed = 7;
		}
		if(num3 % 2 == 0){
			st = st;
			ed = ed-2;
		} else {
			st = st+2;
			ed = ed;
		}
		if(num1 % 2 == 0){
			index = st;
		} else {
			index = ed;
		}
		return colors[index];
	}


	function numTrans(val) {
		var val = val.toUpperCase()
		var base = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', i, j, result = 0;
		for (i = 0, j = val.length - 1; i < val.length; i += 1, j -= 1) {
			result += Math.pow(base.length, j) * (base.indexOf(val[i]) + 1);
		}
		var sliceRe = String(result).replace(/0/gi,'').slice(-3,result.length)
		return sliceRe;
	};

    var colors = [
		'#F23831',
		'#E51057',
		'#9114A3',
		'#5C2BAA',
		'#3843A9',
		'#2088ED',
		'#0C9DEF',
		'#07B3CD',
		'#038C7D',
		'#43A84D',
		'#80BE4B',
		'#FFBB29',
		'#FF8E1F',
		'#FF4B23',
		'#6E4B40',
		'#56717F',
	];

	$(function(){
		for(i=0; i<$('.codeTransColor_back').length; i++){
			var thisColor = codeTransColor($('.codeTransColor_back').eq(i).data('sucode'));

			$('.codeTransColor_back').eq(i).css({
				'background-color':thisColor
			})
		}
        for(i=0; i<$('.codeTransColor_border').length; i++){
			var thisColor = codeTransColor($('.codeTransColor_border').eq(i).data('sucode'));

            $('.codeTransColor_border').eq(i).css({
				'border-color':thisColor
			})
	
		}
        for(i=0; i<$('.codeTransColor_color').length; i++){
			var thisColor = codeTransColor($('.codeTransColor_color').eq(i).data('sucode'));

			$('.codeTransColor_color').eq(i).css({
				'border-color':thisColor
			})
		}
	})
</script>