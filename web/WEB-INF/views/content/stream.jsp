<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
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
        <c:choose>
            <c:when test="${!empty tList}">
                <c:choose>
                    <c:when test="${!empty tSubList}">
                        <c:forEach items="${tSubList}" var="subjectVo">
                            <a href="list/mystream.do?code=${subjectVo.sucode}" class="classLink">
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
                            <a href="/수업링크?code=${subjectVo.sucode}" class="classLink">
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


<nav class="feedCenterBox">
    <p class="feedTitle"><span>알림센터</span><i class="fas fa-times feedCenterClose"></i></p>
    <div class="feedList">
        <!-- <p class="noListMsg">알림이 없습니다.</p> -->

    </div>

</nav>

<!--우하단 + 버튼, 학생-->


<!--우하단 + 버튼, 선생님-->


<!--우하단 + 버튼시 모달, 학생-->


<!--우하단 + 버튼시 모달 선생님-->


<!-- jsp 에서 해당수업의 색상을 불러와야함 -->

<style>

</style>


<div class="contentWrap">
    <div class="innerWrap">
        <div class="conTabWarp">
            <a href="" class="conTab on">스트림</a>
            <a href="" class="conTab">수업</a>
            <a href="" class="conTab">사용자</a>
        </div>

        <div class="titleBox">
            <c:choose>
                <c:when test="${!empty subList}">
                    <c:forEach items="${subList}" var="subjectVo">

                        <p class="title">${subjectVo.suname}</p>
                        <p class="school">${subjectVo.ssubname}</p>
                        <p class="teacher">${subjectVo.tid}</p>
                    </c:forEach>
                </c:when>
            </c:choose>



        </div>
        <div class="streamConBox">
            <div class="homeWorkBox">
                <p class="title">곧 마감되는 과제</p>
                <p class="noWork">기한이 곧 돌아오는 과제가 없습니다.</p>
            </div>

            <div class="streamCardWrap">
                <div class="streamCard noticeCard">
                    <div class="iconCircle">
                        <i class="fas fa-bullhorn"></i>
                    </div>
                    <p class="title">학생들에게 공지할 내용을 입력하세요.</p>

                    <div class="textAreaWrap">
                        <form action="../list/notice.do" method="post">
                        <textarea name="ncontent" >안녀하세요. 이렇게 내용을 미리 써둬봅시다...</textarea>
                        <div class="btnWrap">
                            <button class="cancleBtn">취소</button>
                            <button class="submitBtn" type="submit">등록</button>
                        </div>
                        </form>
                    </div>
                    <script>

                    </script>

                </div>

                <c:choose>
                    <c:when test="${!empty boardList}">
                        <c:forEach items="${boardList}" var="boardVo">


                <div class="streamCard">
                    <div class="iconCircle">
                        <i class="fas fa-chalkboard"></i>
                    </div>
                    <a href="" class="text">
                        <p class="title">${boardVo.tid} 님이 새 수업을 게시 : ${boardVo.btitle}</p>
                        <p class="date">${boardVo.brdate}</p>
                    </a>
                    <div class="moreBtn">
                        <i class="fas fa-ellipsis-v"></i>
                    </div>
                    <div class="moreWrap">
                        <a href="javascript:void(0)" class="saveClass" data-class="">보관</a>
                        <a href="javascript:void(0)" class="editClass" data-class="">수정</a>
                        <a href="javascript:void(0)" class="deleteClass" data-class="">삭제</a>
                    </div>
                </div>
                        </c:forEach>
                    </c:when>
                </c:choose>

            </div>
        </div>

    </div>
</div>

</body>
<script>

    //클래스카드 모어버튼
    $(document).on('click', '.streamCard .moreBtn', function(){
        $(this).siblings('.moreWrap').toggleClass('on')
    })


    // 색상랜더무요....
    function randomNum(min, max){
        var randNum = Math.floor(Math.random()*(max-min+1)) + min; return randNum;
    }

    var colors = ['#F23830','#E51056','#9114A3','#5B2AA8','#3843A9','#2088ED', '#0C9DEF', '#07B3CD','#038C7D', '#43A84D','#80BE4B','#FF8E1F','#FF4B23','#6E4B40','#56717F'];


    //색상랜덤... 삭제예정.....
    var thisColor = colors[randomNum(0, colors.length-1)];

    $('.titleBox').css({
        'background-color':thisColor
    })
    $('.streamCard .iconCircle').css({
        'background-color':thisColor
    })
    $('.textAreaWrap>textarea').css({
        'background-color':thisColor+10,
    })
    $('.submitBtn').css({
        'background-color':thisColor,
    })




    $(document).on('click', '.streamCard.noticeCard .title', function(){
        $('.streamCard.noticeCard').addClass('on');
        $('.textAreaWrap textarea').focus();
    })
    $(document).on('click','.textAreaWrap .cancleBtn', function(){
        $('.streamCard.noticeCard').removeClass('on')
    })

</script>
</html>
