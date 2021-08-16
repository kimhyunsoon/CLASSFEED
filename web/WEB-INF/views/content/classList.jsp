<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"></jsp:include>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CLASSFEED | 클래스</title>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">

    <script src="https://kit.fontawesome.com/5a210d3256.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/sign.css">
    <script src="../js/sign.js"></script>
    <script src="../js/common.js"></script>
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
        <button class="memberSwitch">선생님모드</button>

        <button type="button" class="feedCenter clickAniBtn toolTipWrap">
            <b class="feedDot"></b>
            <img src="../img/feedCenter.svg">
            <p class="toolTipBot">알림센터</p>

        </button>

        <a href="#" class="mypageLink toolTipWrap">
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
        <a href="" class="classLink">
            <p>JAVA 기초 프로그래밍</p>
            <b>김형수 선생님</b>
        </a>
        <a href="" class="classLink">
            <p>공학수학 1단원</p>
            <b>이공학 선생님</b>
        </a>

        <a href="" class="classLink">
            <p>JAVA 기초 프로그래밍 - 클래스와 메쏘드 심화과정</p>
            <b>김형수 선생님</b>
        </a>
        <a href="" class="classLink">
            <p>공학수학 1단원</p>
            <b>이공학 선생님</b>
        </a>

        <a href="" class="classLink">
            <p>JAVA 기초 프로그래밍</p>
            <b>김형수 선생님</b>
        </a>
        <a href="" class="classLink">
            <p>공학수학 1단원</p>
            <b>이공학 선생님</b>
        </a>

        <a href="" class="classLink">
            <p>JAVA 기초 프로그래밍</p>
            <b>김형수 선생님</b>
        </a>
        <a href="" class="classLink">
            <p>공학수학 1단원</p>
            <b>이공학 선생님</b>
        </a>

        <a href="" class="classLink">
            <p>JAVA 기초 프로그래밍</p>
            <b>김형수 선생님</b>
        </a>
        <a href="" class="classLink">
            <p>공학수학 1단원</p>
            <b>이공학 선생님</b>
        </a>

        <a href="" class="classLink">
            <p>JAVA 기초 프로그래밍</p>
            <b>김형수 선생님</b>
        </a>
        <a href="" class="classLink">
            <p>공학수학 1단원</p>
            <b>이공학 선생님</b>
        </a>

        <a href="" class="classLink">
            <p>JAVA 기초 프로그래밍</p>
            <b>김형수 선생님</b>
        </a>
        <a href="" class="classLink">
            <p>공학수학 1단원</p>
            <b>이공학 선생님</b>
        </a>

        <a href="" class="classLink">
            <p>JAVA 기초 프로그래밍</p>
            <b>김형수 선생님</b>
        </a>
        <a href="" class="classLink">
            <p>공학수학 1단원</p>
            <b>이공학 선생님</b>
        </a>

        <a href="" class="classLink">
            <p>JAVA 기초 프로그래밍</p>
            <b>김형수 선생님</b>
        </a>
        <a href="" class="classLink">
            <p>공학수학 1단원</p>
            <b>이공학 선생님</b>
        </a>

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

<!--우하단 + 버튼, 학생-->
<nav class="classAddBtn toolTipWrap clickAniBtn modalBtn stuSample" data-modal="adMission">
    <i class="fas fa-plus"></i>
    <p class="toolTipTop">클래스 참여</p>
</nav>

<!--우하단 + 버튼, 선생님-->
<nav class="classAddBtn toolTipWrap clickAniBtn modalBtn teaSample" data-modal="addClass">
    <i class="fas fa-plus"></i>
    <p class="toolTipTop">새 클래스 만들기</p>
</nav>

<!--우하단 + 버튼시 모달, 학생-->
<div class="modalWrap" data-modal="adMission">
    <div class="modalCon">
        <p class="modalTitle">
            <span>클래스 참여</span>
            <i class="fas fa-times modalClose"></i>
        </p>
        <div>
            <p class="subTitle">인증코드 입력</p>
            <div class="inpWrap">
                <input type="text" class="inp">
                <div class="inpBar"></div>
            </div>
            <p class="msg">* 인증코드는 영문 혹은 숫자 조합이며, 대소문자를 구분합니다.</p>

            <div class="btnWrap">
                <button type="button" class="adMissionBtn pointBtn">참여하기</button>
            </div>

        </div>
    </div>
</div>

<!--우하단 + 버튼시 모달 선생님-->
<div class="modalWrap" data-modal="addClass">
    <div class="modalCon">
        <p class="modalTitle">
            <span>새 클래스 만들기</span>
            <i class="fas fa-times modalClose"></i>
        </p>
        <form action="" method="post">
            <p class="subTitle">제목</p>
            <div class="inpWrap">
                <input type="text" class="inp" name="suname" required>
                <div class="inpBar"></div>
            </div>

            <p class="subTitle">부제목</p>
            <div class="inpWrap">
                <input type="text" name="ssubname" class="inp">
                <divrequired class="inpBar"></divrequired>
            </div>


            <div class="btnWrap">
                <button type="submit" class="adMissionBtn pointBtn">만들기</button>
            </div>

        </ㄹ>
    </div>
</div>
<c:if test="${!empty tSubList }">
<div class="contentWrap">
    <div class="contentInnerWrap">
        <div class="classCardWrap">
            <c:forEach items="${tSubList }" var="subjectVo">
            <div class="classCard">
                <div class="cardTop">
                    <div class="titleWrap">

                        <a href="" class="title">
                            <p class="tit">${subjectVo.suname}</p>
                            <p class="sub">${subjectVo.ssubname}</p>
                        </a>
                        <button class="moreBtn">
                            <i class="fas fa-ellipsis-v"></i>
                        </button>
                        <div class="moreWrap">
                            <a href="javascript:void(0)" class="saveClass" data-class="">보관</a>
                        </div>

                    </div>
                </div>
                <c:forEach items="${tList}" var="teacherVo">
                    <div class="teacherTag">${teacherVo.tname} 선생님</div>
                </c:forEach>
                <div class="classCode toolTipWrap">
                    <div>
                        <input type="hidden" class="code" value="${subjectVo.sucode}">
                        <span>${subjectVo.sucode}</span>
                        <i class="far fa-copy"></i>
                    </div>
                    <div>
                        <span>복사됨</span>
                        <i class="fas fa-check"></i>
                    </div>
                    <p class="toolTipBot">초대코드 복사</p>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
</div>
</c:if>
</body>

<script>
    //초대코드 복사
    $(document).on('click', '.classCode', function(){
        var thisData = $(this).find('.code')
        thisData.select();
        document.execCommand("Copy");

    })
    //클래스카드 모어버튼
    $(document).on('click', '.cardTop .moreBtn', function(){
        $(this).siblings('.moreWrap').toggleClass('on')
    })

    // 색상랜더무요....
    function randomNum(min, max){
        var randNum = Math.floor(Math.random()*(max-min+1)) + min; return randNum;
    }

    var colors = ['#F23830','#E51056','#9114A3','#5B2AA8','#3843A9','#2088ED', '#0C9DEF', '#07B3CD','#038C7D', '#43A84D','#80BE4B','#FF8E1F','#FF4B23','#6E4B40','#56717F'];


    //색상랜덤... 삭제예정.....
    $(function(){
        for(i=0; i<$('.classCard').length; i++){
            var thisColor = colors[randomNum(0, colors.length-1)];

            $('.classCard').eq(i).find('.cardTop').css({
                'background-color':thisColor
            })
            $('.classCard').eq(i).find('.classCode').css({
                'background-color':thisColor
            })
        }
    })

</script>
</html>