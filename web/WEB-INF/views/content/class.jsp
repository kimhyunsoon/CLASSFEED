<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../content/header.jsp" flush="true">
	<jsp:param name="title" value="수업"/>
</jsp:include>

<div class="contentWrap">
    <div class="innerWrap">
        <div class="conTabWarp">
            <a href="../list/mystream.do?sucode=${sucode}" class="conTab">스트림</a>
            <a href="../list/myclass.do?sucode=${sucode}" class="conTab on codeTransColor_color codeTransColor_border" data-sucode="${sucode}">수업</a>
        </div>

        
        <div class="titleBox codeTransColor_back" data-sucode="${sucode}">
            <c:forEach items="${subList}" var="subjectVo">
                <p class="title">${subjectVo.suname}</p>
                <p class="school">${subjectVo.ssubname}</p>
                <p class="teacher">${subjectVo.tname} 선생님</p>
            </c:forEach>
        </div>

        <div class="classConBox">
            <div class="classConLeft">
                <div class="themeLink on codeTransColor_back" data-sucode="${sucode}">
                    <p>모든 주제</p>
                </div>
                <div class="themeLink codeTransColor_back" data-sucode="${sucode}" data-theme="1주차">
                    <p>1주차</p>
                </div>
                <div class="themeLink codeTransColor_back" data-sucode="${sucode}" data-theme="2주차">
                    <p>2주차</p>
                </div>
                <div class="themeLink codeTransColor_back" data-sucode="${sucode}" data-theme="3주차">
                    <p>3주차</p>
                </div>
                
            </div>

            <div class="classConCardWrap ">
                <div class="makeBtnWrap">
                    <button class="makeSomeBtn"><i class="fas fa-plus"></i>만들기</button>
                    <div class="makeSomeWrap">
                        <p class="makeBtn modalBtn" data-modal="">주제</p>
                        <p class="makeBtn modalBtn" data-modal="addSome">수업/과제</p>
                        <p class="makeBtn modalBtn" data-modal="addSome">자료</p>
                    </div>
                </div>




                <div class="themeTitle codeTransColor_back" data-sucode="${sucode}">
                    <p>모든주제</p>
                </div>
                <div class="classSomeLinkWrap codeTransColor_back" data-sucode="${sucode}">
                    <div class="classSomeLink">
                        <div class="iconCircle">
                            <i class="fas fa-chalkboard"></i>
                        </div>
                        <a href="" class="title">0주차 유닉스 (수업)</a>
                        <div class="moreBtnWrap">
                            <div class="moreBtn">
                                <i class="fas fa-ellipsis-v"></i>
                            </div>
                            <div class="moreWrap">
                                <a href="">보관</a>
                                <a href="">수정</a>
                                <a href="">삭제</a>
                            </div>
                        </div>
                    </div>
                </div>
                

                <div class="themeTitle codeTransColor_border codeTransColor_back" data-sucode="${sucode}">
                    <p>1주차</p>
                </div>
                <div class="classSomeLinkWrap codeTransColor_back" data-sucode="${sucode}">
                    <div class="classSomeLink">
                        <div class="iconCircle">
                            <i class="fas fa-chalkboard"></i>
                        </div>
                        <a href="" class="title">0주차 유닉스 (수업)</a>
                        <div class="moreBtnWrap">
                            <div class="moreBtn">
                                <i class="fas fa-ellipsis-v"></i>
                            </div>
                            <div class="moreWrap">
                                <a href="">보관</a>
                                <a href="">수정</a>
                                <a href="">삭제</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="classSomeLinkWrap codeTransColor_back" data-sucode="${sucode}">
                    <div class="classSomeLink">
                        <div class="iconCircle">
                            <i class="fas fa-chalkboard"></i>
                        </div>
                        <a href="" class="title">0주차 유닉스 (수업)</a>
                        <div class="moreBtnWrap">
                            <div class="moreBtn">
                                <i class="fas fa-ellipsis-v"></i>
                            </div>
                            <div class="moreWrap">
                                <a href="">보관</a>
                                <a href="">수정</a>
                                <a href="">삭제</a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>
    </div>
</div>
<div class="modalWrap" data-modal="addSome">
    <div class="modalCon" style="width:500px; max-height: 1000px;">
        <p class="modalTitle">
            <span>수업/과제 등록</span>
            <i class="fas fa-times modalClose"></i>
        </p>
        <form action="" method="post">
            <p class="subTitle">제목</p>
            <div class="inpWrap">
                <input type="text" name="title" class="inp" required>
                <div class="inpBar"></div>
            </div>

            <p class="subTitle">내용</p>
            <div class="inpWrap" style="height: 170px;">
                <textarea name="content" class="inp" style="resize: none; padding:8px"></textarea>
                <div class="inpBar"></div>
            </div>

            <div class="doubleRow">
                <p class="subTitle">기한</p>
                <p class="subTitle">주제</p>
            </div>
            <div class="doubleRow">
                <select name="endDate" class="selectWrap">
                    <option value="0" selected>기한 없음</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>
                <select name="subject" class="selectWrap">
                    <option value="0" selected>주제 없음</option>
                    <option value="주제1">주제1</option>
                    <option value="주제2">주제2</option>
                    <option value="주제3">주제3</option>
                </select>
            </div>

            <div class="fileBtn">
                <i class="far fa-folder-open"></i>
                <p>파일 첨부하기</p>
            </div>
            <div class="fileSpace">
                <span>파일명파일명 파일명.jpg</span><i class="fas fa-times"></i>
            </div>
            <input type="file" name="file" id="fileInp" style="display: none;">


            <div class="btnWrap">
                <button type="submit" class="adMissionBtn pointBtn">등록</button>
            </div>

        </form>
    </div>
</div>

</body>
<script>

//클래스카드 모어버튼
$(document).on('click', '.classSomeLink .moreBtn', function(){
    $(this).siblings('.moreWrap').toggleClass('on')
})

//만들기 버튼
$(document).on('click', '.makeSomeBtn', function(){
    $('.makeSomeWrap').toggleClass('on')
})

</script>