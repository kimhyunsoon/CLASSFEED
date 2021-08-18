
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../content/header.jsp" flush="true">
	<jsp:param name="title" value="과제"/>
</jsp:include>

<div class="contentWrap">
    <div class="innerWrap">
        <c:forEach items="${subList}" var="subjectVo">
        <a href="" class="smallTitle codeTransColor_back" data-sucode="${sucode}">
            <p>${subjectVo.suname} - ${subjectVo.ssubname} <i class="codeTransColor_color fas fa-chevron-right" data-sucode="${sucode}"></i></p>
        </a>
        </c:forEach>

        
        <div class="boradConBox">
        <c:forEach items="${blist}" var="boardVo">
            <div class="boradConTitle codeTransColor_border" data-sucode="${sucode}">
                <div class="tit">
                    <p class="main">${boardVo.btitle}</p>
                    <p class="sub">이가은 선생님 ・ 2021-10-11</p>

                </div>
                <!-- 선생님만 나옴 -->
                <div class="moreBtnWrap">
                    <button class="moreBtn">
                        <i class="fas fa-ellipsis-v codeTransColor_color" data-sucode="${sucode}"></i>
                    </button>
                    <div class="moreWrap">
                        <a href="" class="moreAnchor">삭제</a>
                    </div>
                </div>
                <!-- 선생님만 나옴 끝-->
            </div>
            <pre class="boradContent">유닉스 실무 OT 내용입니다.
교안은 https://prezi.com/view/eyOMNnjXOI7DXWMFqE6S/ 요기를 참고 하세요

효과적인 소통을 위해 밴드 운영합니다.
밴드 주소는 https://band.us/n/a3ab46C3xeK1m</pre>
            <a href="" class="boradFile toolTipWrap" download>
                <i class="far fa-file-alt"></i>
                <span>파일명.jpg</span>
                <p class="toolTipBot">다운로드</p>
            </a>

        </div>
    </c:forEach>

        <!-- 선생님 -->
        <p class="boradWorkTitle">제출된 과제</p>

        <div class="streamCard">
            <div class="iconCircle codeTransColor_back" data-sucode="${sucode}">
                <i class="far fa-file-alt"></i>
            </div>
            <a href="" class="text" download>
                <p class="title">김현순 님이 제출한 과제 : 파일명파일명.jpg</p>
                <p class="date">2021.08.16.</p>
            </a>
        </div>

        <!-- 선생님 끝 -->

        <!-- 학생_제출한게 있으면 -->
        <p class="boradWorkTitle">내가 제출한 과제</p>
        <div class="streamCard">
            <div class="iconCircle codeTransColor_back" data-sucode="${sucode}">
                <i class="far fa-file-alt"></i>
            </div>
            <a href="" class="text" download>
                <p class="title">김현순 님이 제출한 과제 : 파일명파일명.jpg</p>
                <p class="date">2021.08.16.</p>
            </a>
            <div class="moreBtnWrap">
                <button class="moreBtn">
                    <i class="fas fa-ellipsis-v" aria-hidden="true"></i>
                </button>
                <div class="moreWrap">
                    <a href="javascript:void(0)" class="moreAnchor deleteClass" data-class="">삭제</a>
                </div>
            </div>
        </div>
        <!-- 학생_제출한게 있으면 끝-->


        <!-- 학생_제출한게 없으면-->
        <div class="workSubmitWrap">
            <button class="modalBtn codeTransColor_back" data-modal="workSubmit" data-sucode="${sucode}">과제 제출하기</button>
        </div>

        <div class="modalWrap" data-modal="workSubmit">
            <div class="modalCon" style="width:500px; max-height: 1000px;">
                <p class="modalTitle">
                    <span class="codeTransColor_border" data-sucode="${sucode}">과제 제출하기</span>
                    <i class="fas fa-times modalClose"></i>
                </p>
                <form action="" method="post">
                    <div class="fileBtn">
                        <i class="far fa-folder-open"></i>
                        <p>파일 첨부하기</p>
                    </div>
                    <div class="fileSpace">
                        <span>파일명파일명 파일명.jpg</span><i class="fas fa-times"></i>
                    </div>
                    <input type="file" name="file" id="fileInp" style="display: none;">
                    <div class="btnWrap" style="margin-top:20px">
                        <button type="submit" class="codeTransColor_back adMissionBtn pointBtn" data-sucode="${sucode}">제출</button>
                    </div>
    
                </form>
            </div>
        </div>
        <!-- 학생_제출한게 없으면 끝-->


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

</script>
</html>