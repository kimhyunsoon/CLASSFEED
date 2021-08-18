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
                <c:forEach items="${thlist}" var="themeVo">
                    <div class="themeLink codeTransColor_back" data-sucode="${sucode}" data-theme="1주차">
                        <p>${themeVo.thname}</p>
                    </div>
                </c:forEach>
                
            </div>

            <div class="classConCardWrap ">
                <div class="makeBtnWrap">
                    <button class="makeSomeBtn"><i class="fas fa-plus"></i>만들기</button>
                    <div class="makeSomeWrap">
                        <p class="makeBtn modalBtn" data-modal="">주제</p>
                        <p class="makeBtn modalBtn" data-modal="addSome">과제</p>
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
                            <button class="moreBtn">
                                <i class="fas fa-ellipsis-v"></i>
                            </button>
                            <div class="moreWrap">
                                <a href="" class="moreAnchor">삭제</a>
                            </div>
                        </div>
                    </div>
                </div>

                <c:forEach items="${thlist}" var="themeVo">
                <div class="themeTitle codeTransColor_border codeTransColor_back" data-sucode="${sucode}">
                    <p>${themeVo.thname}</p>
                </div>
                <c:forEach items="${blist}" var="boardVo">
                    <c:if test="${themeVo.thcode==boardVo.thcode}">
                <div class="classSomeLinkWrap codeTransColor_back" data-sucode="${sucode}">
                    <div class="classSomeLink">
                        <div class="iconCircle">
                            <i class="fas fa-chalkboard"></i>
                        </div>
                        <a href="../myboard/content.do?bseq=${boardVo.bseq }" class="title">${boardVo.btitle}</a>
                        <div class="moreBtnWrap">
                            <button class="moreBtn">
                                <i class="fas fa-ellipsis-v"></i>
                            </button>
                            <div class="moreWrap">
                                <a href="" class="moreAnchor">삭제</a>
                            </div>
                        </div>
                    </div>
                </div>
                    </c:if>
                </c:forEach>
                </c:forEach>

            </div>

        </div>
    </div>
</div>
<div class="modalWrap" data-modal="addSome">
    <div class="modalCon" style="width:500px; max-height: 1000px;">
        <p class="modalTitle">
            <span class="codeTransColor_border" data-sucode="${sucode}">과제 제출하기</span>
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
                <button type="submit" class="adMissionBtn pointBtn codeTransColor_back" data-sucode="${sucode}">등록</button>
            </div>

        </form>
    </div>
</div>

</body>
<script>


    //파일 관련
    $(document).on('click','.modalWrap .fileBtn',function(){
        $('#fileInp').trigger('click');
    })
    $(document).on('change', '#fileInp', function(){
        var fileName1   = $(this).val().split('\\');
        var fileNameLeng = fileName1.length;
        var fileName = fileName1[fileNameLeng-1];  

        if($(this).val()!=null){
            $('.modalWrap .fileBtn').hide();
            $('.modalWrap .fileSpace').css({
                display:'flex'
            });
            $('.modalWrap .fileSpace>span').text(fileName)
        }
    })

    $(document).on('click', '.modalWrap .fileSpace>i', function(){
        $(this).closest('.fileSpace').hide();
        $('.modalWrap .fileBtn').css({
            display:'flex'
        });
        $('#fileInp').val('');

    })

    //만들기 버튼
    $(document).on('click', '.makeSomeBtn', function(){
        $('.makeSomeWrap').toggleClass('on')
        
    })
    $(document).on('click', 'body', function(e){
        if(!$(e.target).hasClass('makeSomeBtn') && !$(e.target).closest('button').hasClass('makeSomeBtn')){
            $('.makeSomeWrap').removeClass('on')
        }
    })

</script>