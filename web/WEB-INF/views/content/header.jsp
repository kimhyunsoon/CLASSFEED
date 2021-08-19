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
	<link rel="shortcut icon" href="../img/favicon.ico" type="image/x-icon">
	<link rel="icon" href="../img/favicon.ico" type="image/x-icon">
	<title>CLASSFEED | ${param.title}</title>

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
	<a href="/" class="homeLink">
		<img src="../img/classfeedLogo.png">
	</a>

	<div class="rightBtnWrap">


		<button type="button" class="feedCenter clickAniBtn toolTipWrap">
			<b class="feedDot"></b>
			<img src="../img/feedCenter.svg">
			<p class="toolTipBot">알림센터</p>
		</button>

		<a href="javascript:void(0)" class="mypageLink toolTipWrap">
			<img src="../img/defaltProfile.png">
			<p class="toolTipBot toolTipBot2">마이페이지</p>
		</a>
	</div>

	<!-- <div class="innerWrap">

    </div> -->

</header>
<nav class="sideNav">
	<c:choose>
		<c:when test="${param.title == '클래스'}">
			<a href="/" class="sideNavLink toolTipWrap on">
				<i class="fas fa-chalkboard-teacher"></i>
				<p class="toolTipBot">클래스</p>
			</a>
		
			<a href="/main/keepList.do" class="sideNavLink toolTipWrap">
				<i class="fas fa-archive"></i>
				<p class="toolTipBot">수업보관함</p>
			</a>
		</c:when>
		<c:when test="${param.title == '수업보관함'}">
			<a href="/" class="sideNavLink toolTipWrap">
				<i class="fas fa-chalkboard-teacher"></i>
				<p class="toolTipBot">클래스</p>
			</a>
		
			<a href="/main/keepList.do" class="sideNavLink toolTipWrap on">
				<i class="fas fa-archive"></i>
				<p class="toolTipBot">수업보관함</p>
			</a>
		</c:when>
		<c:when test="${param.title != '클래스' && param.title != '수업보관함'}">
			<a href="/" class="sideNavLink toolTipWrap">
				<i class="fas fa-chalkboard-teacher"></i>
				<p class="toolTipBot">클래스</p>
			</a>
		
			<a href="/main/keepList.do" class="sideNavLink toolTipWrap">
				<i class="fas fa-archive"></i>
				<p class="toolTipBot">수업보관함</p>
			</a>
		</c:when>
	</c:choose>
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
	

	<c:choose>
		<c:when test="${param.title == '클래스'}">
			<a href="/" class="mainLink on">
				<i class="fas fa-chalkboard-teacher"></i>
				<p>클래스</p>
			</a>
			<a href="/main/keepList.do" class="mainLink">
				<i class="fas fa-archive"></i>
				<p>수업보관함</p>
			</a>
		</c:when>
		<c:when test="${param.title == '수업보관함'}">
			<a href="/" class="mainLink">
				<i class="fas fa-chalkboard-teacher"></i>
				<p>클래스</p>
			</a>
			<a href="/main/keepList.do" class="mainLink on">
				<i class="fas fa-archive"></i>
				<p>수업보관함</p>
			</a>
		</c:when>
		<c:when test="${param.title != '클래스' && param.title != '수업보관함'}">
			<a href="/" class="mainLink on">
				<i class="fas fa-chalkboard-teacher"></i>
				<p>클래스</p>
			</a>
			<a href="/main/keepList.do" class="mainLink">
				<i class="fas fa-archive"></i>
				<p>수업보관함</p>
			</a>
		</c:when>
	</c:choose>

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

								<p>${subjectVo.tname} 선생님
</p>

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
<nav class="feedCenterBox">
	<p class="feedTitle"><span>알림센터</span><i class="fas fa-times feedCenterClose"></i></p>
	<div class="feedList">
		<!-- <p class="noListMsg">알림이 없습니다.</p> -->
		<a href="" class="feedMsg">
			<p>새로운 과제가 등록되었습니다.</p>
			<div><span>JAVA 기초 프로그래밍 클래스와 메쏘드 심화과정</span><p>김형수 선생님</p></div>
		</a>
		<a href="" class="feedMsg">
			<p>새로운 과제가 등록되었습니다.</p>
			<div><span>JAVA 기초 프로그래밍 클래스와 메쏘드 심화과정</span><p>김형수 선생님</p></div>
		</a>
		<a href="" class="feedMsg">
			<p>새로운 과제가 등록되었습니다.</p>
			<div><span>JAVA 기초 프로그래밍 클래스와 메쏘드 심화과정</span><p>김형수 선생님</p></div>
		</a>
		<a href="" class="feedMsg">
			<p>새로운 과제가 등록되었습니다.</p>
			<div><span>JAVA 기초 프로그래밍 클래스와 메쏘드 심화과정</span><p>김형수 선생님</p></div>
		</a>
		<a href="" class="feedMsg">
			<p>새로운 과제가 등록되었습니다.</p>
			<div><span>JAVA 기초 프로그래밍 클래스와 메쏘드 심화과정</span><p>김형수 선생님</p></div>
		</a>
		<a href="" class="feedMsg">
			<p>새로운 과제가 등록되었습니다.</p>
			<div><span>JAVA 기초 프로그래밍 클래스와 메쏘드 심화과정</span><p>김형수 선생님</p></div>
		</a>
		<a href="" class="feedMsg">
			<p>새로운 과제가 등록되었습니다.</p>
			<div><span>JAVA 기초 프로그래밍 클래스와 메쏘드 심화과정</span><p>김형수 선생님</p></div>
		</a>
		<a href="" class="feedMsg">
			<p>새로운 과제가 등록되었습니다.</p>
			<div><span>JAVA 기초 프로그래밍 클래스와 메쏘드 심화과정</span><p>김형수 선생님</p></div>
		</a>
		<a href="" class="feedMsg">
			<p>새로운 과제가 등록되었습니다.</p>
			<div><span>JAVA 기초 프로그래밍 클래스와 메쏘드 심화과정</span><p>김형수 선생님</p></div>
		</a>
	</div>

</nav>
<nav class="myPageBox">
	<a href="javascript:void(0)" onClick="alert('기능 준비 중입니다. 😂')">내 계정 관리</a>
	<a href="javascript:void(0)" class="logoutBtn">로그아웃</a>
</nav>





<script>

	$(document).on('click', '.logoutBtn', function(){
		if(confirm('정말 로그아웃 하시겠습니까?')){
			location.href ='../member/logout.do'
		}
	})
    function codeTransColor(val){
		var num1 = Number(numTrans(val)[0]);
		var num2 = Number(numTrans(val)[1]);
		var num3 = Number(numTrans(val)[2]);
		var num4 = Number(numTrans(val)[3]);

		// console.log(numTrans(val))
		var st = 0;
		var ed = 0;
		var index = 0;

		// console.log('전체 : '+numTrans(val))

		if(num4 % 2 == 0){
			st = 0;
			ed = 7;
		} else {
			st = 8;
			ed = 15;
		}
		// console.log('1단계 범위: '+st+' ~ '+ed)

		if(num2 % 2 == 0){
			st = st;
			ed = ed-4;
		} else {
			st = st+4;
			ed = ed;
		}
		// console.log('2단계 범위: '+st+' ~ '+ed)

		if(num1 % 2 == 0){
			st = st;
			ed = ed-2;
		} else {
			st = st+2;
			ed = ed;
		}
		// console.log('3단계 범위: '+st+' or '+ed)

		if(num3 % 2 == 0){
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


		var sliceRe = String(result).replace(/0/gi,'').slice(-4,result.length)   
		return sliceRe;
	};

    var colors = [
		'#F23831',
		'#3843A9',
		'#6E4B40',
		'#43A84D',
		'#56717F',
		'#2088ED',
		'#E51057',
		'#FF8E1F',
		'#07B3CD',
		'#038C7D',
		'#FF4B23',
		'#0C9DEF',
		'#5C2BAA',
		'#FFBB29',
		'#80BE4B',
		'#9114A3',

	];

	$(function(){
		for(i=0; i<$('.codeTransColor_back').length; i++){
			var thisColor = codeTransColor($('.codeTransColor_back').eq(i).data('sucode'));

			$('.codeTransColor_back').eq(i).css({
				'background-color':thisColor
			})
		}
        for(j=0; j<$('.codeTransColor_border').length; j++){
			var thisColor = codeTransColor($('.codeTransColor_border').eq(j).data('sucode'));

            $('.codeTransColor_border').eq(j).css({
				'border-color':thisColor
			})
	
		}
        for(m=0; m<$('.codeTransColor_color').length; m++){
			var thisColor = codeTransColor($('.codeTransColor_color').eq(m).data('sucode'));

			$('.codeTransColor_color').eq(m).css({
				'color':thisColor
			})
		}
	})
	// 모어버튼
    $(document).on('click', '.moreBtn', function(){
        $('.moreWrap').not($(this).siblings('.moreWrap')).removeClass('on')
		if($(this).siblings('.moreWrap').hasClass('on')){
			$(this).siblings('.moreWrap').removeClass('on')
		}else {
			$(this).siblings('.moreWrap').addClass('on')
		}
    })

	//바깥클릭 모어랩 닫기
	$(document).on('click', 'body', function(e){
		if(!$(e.target).hasClass('moreBtn') && !$(e.target).parents('button').hasClass('moreBtn')){
			$('.moreWrap').removeClass('on')
		}
	})

	//바깥클릭 알림센터 닫기
	$(document).on('click', 'body', function(e){
		if(!$(e.target).hasClass('feedCenter') && !$(e.target).parents('button').hasClass('feedCenter') && !$(e.target).parents('nav').hasClass('feedCenterBox')){
			$('.feedCenterBox').removeClass('on')
		}
	})

	//바깥클릭 계정관리 닫기
	$(document).on('click', 'body', function(e){
		if(!$(e.target).hasClass('mypageLink') && !$(e.target).parents('a').hasClass('mypageLink') && !$(e.target).parents('nav').hasClass('myPageBox')){
			$('.myPageBox').removeClass('on')
		}
	})

	//계정관리 열기
	$(document).on('click', '.mypageLink' ,function(){
		$('.myPageBox').toggleClass('on');
	})
</script>