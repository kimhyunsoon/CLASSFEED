<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../content/header.jsp" flush="true">
	<jsp:param name="title" value="스트림"/>
</jsp:include>

<div class="contentWrap">
    <div class="innerWrap">
        <div class="conTabWarp">
            <a href="../list/mystream.do?sucode=${sucode}" class="conTab on codeTransColor_color codeTransColor_border" data-sucode="${sucode}">스트림</a>
            <a href="../list/myclass.do?sucode=${sucode}" class="conTab">수업</a>
        </div>

        <div class="titleBox codeTransColor_back" data-sucode="${sucode}">
            <c:forEach items="${subList}" var="subjectVo">
                <p class="title">${subjectVo.suname}</p>
                <p class="school">${subjectVo.ssubname}</p>
                <p class="teacher">${subjectVo.tname} 선생님</p>
            </c:forEach>
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
                        <textarea name="ncontent" placeholder="공지내용을 입력해주세요."></textarea>
                        <div class="btnWrap">
                            <button class="cancleBtn" type="reset">취소</button>
                            <button class="submitBtn codeTransColor_back" data-sucode="${sucode}" type="submit">등록</button>
                        </div>
                        </form>
                    </div>
                    <script>

                    </script>

                </div>
                <c:choose>
                    <c:when test="${!empty noticeList}">
                        <c:forEach items="${noticeList}" var="noticeVo">
                            <div class="streamCard">
                                <div class="iconCircle codeTransColor_back" data-sucode="${sucode}">
                                    <i class="fas fa-bullhorn"></i>
                                </div>
                                <a href="javascript:void(0)" class="text" style="text-decoration: none; cursor: default;">
                                    <p class="title">${noticeVo.sid} </p>
                                    <p class="title">${noticeVo.tid} </p>
                                    <p class="date">${noticeVo.nrdate}</p>
                                    <pre class="content">${noticeVo.ncontent}</pre>
                                </a>
                                



                                <c:choose>
                                    <c:when test="${!empty tList}">
                                        <c:forEach items="${tList}" var="teacherVo">
                                            <c:if test="${teacherVo.tid == noticeVo.tid}">
                                                <div class="moreBtnWrap">
                                                    <button class="moreBtn">
                                                        <i class="fas fa-ellipsis-v"></i>
                                                    </button>
                                                    <div class="moreWrap">
                                                        <a href="javascript:void(0)" class="moreAnchor deleteClass" data-class="" style="top:55px">삭제</a>
                                                    </div>
                                                </div>
                                            </c:if>
                                        </c:forEach>
                                    </c:when>
                                    <c:when test="${!empty sList}">
                                        <c:forEach items="${sList}" var="studentVo">
                                            <c:if test="${studentVo.sid == noticeVo.sid}">
                                                <div class="moreBtnWrap">
                                                    <button class="moreBtn">
                                                        <i class="fas fa-ellipsis-v"></i>
                                                    </button>
                                                    <div class="moreWrap">
                                                        <a href="javascript:void(0)" class="moreAnchor deleteClass" data-class="" style="top:55px">삭제</a>
                                                    </div>
                                                </div>
                                            </c:if>
                                        </c:forEach>
                                    </c:when>
                                </c:choose>



                                
                            </div>
                        </c:forEach>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${!empty boardList}">
                        <c:forEach items="${boardList}" var="boardVo">


                <div class="streamCard">
                    <div class="iconCircle codeTransColor_back" data-sucode="${sucode}">
                        <i class="fas fa-chalkboard"></i>
                    </div>
                    <a href="" class="text">
                        <p class="title">${boardVo.tid} 님이 새 수업을 게시 : ${boardVo.btitle}</p>
                        <p class="date">${boardVo.brdate}</p>
                    </a>
                    <div class="moreBtnWrap">
                        <button class="moreBtn">
                            <i class="fas fa-ellipsis-v"></i>
                        </button>
                        <div class="moreWrap">
                            <a href="javascript:void(0)" class="moreAnchor saveClass" data-class="">보관</a>
                            <a href="javascript:void(0)" class="moreAnchor editClass" data-class="">수정</a>
                            <a href="javascript:void(0)" class="deleteClass" data-class="" style="top:55px">삭제</a>
                        </div>
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

    $(document).on('click', '.streamCard.noticeCard .title', function(){
        $('.streamCard.noticeCard').addClass('on');
        $('.textAreaWrap textarea').focus();
    })
    $(document).on('click','.textAreaWrap .cancleBtn', function(){
        $('.streamCard.noticeCard').removeClass('on')
    })

</script>
</html>
