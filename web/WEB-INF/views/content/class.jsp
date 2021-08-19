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
                <div class="themeLink on codeTransColor_back thCodeTab" data-sucode="${sucode}" data-thcode="">
                    <p>모든 주제</p>
                </div>
                <c:forEach items="${thlist}" var="themeVo">
                    <div class="themeLink codeTransColor_back thCodeTab" data-sucode="${sucode}" data-thcode="${themeVo.thcode}">
                        <p>${themeVo.thname}</p>
                    </div>
                </c:forEach>
                
            </div>

            
            <div class="classConCardWrap ">

                <!-- 선생님만-->
                <c:if test="${!empty tList}">
                    <div class="makeBtnWrap">
                        <button class="makeSomeBtn"><i class="fas fa-plus"></i>만들기</button>
                        <div class="makeSomeWrap">
                            <p class="makeBtn modalBtn" data-modal="addTheme">주제</p>
                            <p class="makeBtn modalBtn" data-modal="addAssignment">과제</p>
                            <p class="makeBtn modalBtn" data-modal="addStudyFile">자료</p>
                        </div>
                    </div>
                </c:if>

                <c:forEach items="${blist}" var="boardVo">
                    <c:if test="${empty boardVo.thcode}">
                        <div class="classSomeLinkWrap codeTransColor_back thCodeBlock" data-thcode="" data-sucode="${sucode}">
                            <div class="classSomeLink">
                                <div class="iconCircle codeTransColor_back" data-sucode="${sucode}">
                                    <c:choose>
                                        <c:when test="${empty boardVo.bdeadline}">
                                            <i class="far fa-file-alt" aria-hidden="true"></i>
                                        </c:when>
                                        <c:when test="${!empty boardVo.bdeadline}">
                                            <i class="fas fa-pencil-alt"></i>
                                        </c:when>
                                    </c:choose>
                                </div>
                                <a href="../myboard/content.do?bseq=${boardVo.bseq }" class="title">${boardVo.btitle}</a>
                                
                                <c:if test="${!empty tList}">
                                    <div class="moreBtnWrap">
                                        <button class="moreBtn">
                                            <i class="fas fa-ellipsis-v"></i>
                                        </button>
                                        <div class="moreWrap">
                                            <a href="" class="moreAnchor">삭제</a>
                                        </div>
                                    </div>
                                </c:if>

                            </div>
                        </div>
                    </c:if>
                </c:forEach>
    

                <c:forEach items="${thlist}" var="themeVo">
                <div class="themeTitle codeTransColor_border codeTransColor_back thCodeBlock thCodeTitle" data-thcode="${themeVo.thcode}" data-sucode="${sucode}">
                    <p>${themeVo.thname}</p>
                </div>
                <c:forEach items="${blist}" var="boardVo">
                    <c:if test="${themeVo.thcode==boardVo.thcode}">
                        <div class="classSomeLinkWrap codeTransColor_back thCodeBlock" data-thcode="${themeVo.thcode}"" data-sucode="${sucode}">
                            <div class="classSomeLink">
                                <div class="iconCircle codeTransColor_back" data-sucode="${sucode}">
                                    <c:choose>
                                        <c:when test="${empty boardVo.bdeadline}">
                                            <i class="far fa-file-alt" aria-hidden="true"></i>
                                        </c:when>
                                        <c:when test="${!empty boardVo.bdeadline}">
                                            <i class="fas fa-pencil-alt"></i>
                                        </c:when>
                                    </c:choose>
                                </div>
                                <a href="../myboard/content.do?bseq=${boardVo.bseq }" class="title">${boardVo.btitle}</a>
                                <c:if test="${!empty tList}">
                                    <div class="moreBtnWrap">
                                        <button class="moreBtn">
                                            <i class="fas fa-ellipsis-v"></i>
                                        </button>
                                        <div class="moreWrap">
                                            <a href="" class="moreAnchor">삭제</a>
                                        </div>
                                    </div>
                                </c:if>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
                </c:forEach>

            </div>

        </div>
    </div>
</div>
<c:if test="${!empty tList}">
    <div class="modalWrap" data-modal="addAssignment">
        <div class="modalCon" style="width:500px; max-height: 1000px;">
            <p class="modalTitle">
                <span class="codeTransColor_border" data-sucode="${sucode}">과제 만들기</span>
                <i class="fas fa-times modalClose"></i>
            </p>
            <form action="/myboard/assignin.do" method="post" enctype="multipart/form-data">
                <c:forEach items="${tList}" var="teacherVo">
                    <input type="hidden" name="tid" value="${teacherVo.tid}">
                </c:forEach>
                <input type="hidden" name="sucode" value="${sucode}">
                <p class="subTitle">제목</p>
                <div class="inpWrap">
                    <input type="text" name="btitle" class="inp" required>
                    <div class="inpBar"></div>
                </div>
    
                <p class="subTitle">내용</p>
                <div class="inpWrap" style="height: 170px;">
                    <textarea name="bcontent" class="inp" style="resize: none; padding:8px"></textarea>
                    <div class="inpBar"></div>
                </div>
    
                <div class="doubleRow">
                    <p class="subTitle">기한</p>
                    <p class="subTitle">주제</p>
                </div>
                <div class="doubleRow">
                    <select name="rdeadline" class="selectWrap">
                        <option value="0" selected>기한 없음</option>
                        <c:forEach var="cnt" begin="1" end="30">
                            <option value="${cnt}">${cnt}일</option>
                        </c:forEach>
                    </select>
                    <select name="themelist" class="selectWrap">
                        <option value="0" selected>주제 없음</option>
                        <c:forEach items="${thlist}" var="themeVo">
                            <option value="${themeVo.thcode}">${themeVo.thname}</option>
                        </c:forEach>
                    </select>
                </div>
    
                <div class="fileBtn">
                    <i class="far fa-folder-open"></i>
                    <p>파일 첨부하기</p>
                </div>
                <div class="fileSpace">
                    <span></span><i class="fas fa-times"></i>
                </div>
                <input type="file" name="file" id="fileInp" style="display: none;">
    
    
                <div class="btnWrap">
                    <button type="submit" class="adMissionBtn pointBtn codeTransColor_back" data-sucode="${sucode}">등록</button>
                </div>
    
            </form>
        </div>
    </div>
    <div class="modalWrap" data-modal="addStudyFile">
        <div class="modalCon" style="width:500px; max-height: 1000px;">
            <p class="modalTitle">
                <span class="codeTransColor_border" data-sucode="${sucode}">자료 올리기</span>
                <i class="fas fa-times modalClose"></i>
            </p>
            <form action="/myboard/boardin.do" method="post" enctype="multipart/form-data">
                <p class="subTitle">제목</p>
                <div class="inpWrap">
                    <input type="text" name="btitle" class="inp" required>
                    <div class="inpBar"></div>
                </div>
    
                <p class="subTitle">내용</p>
                <div class="inpWrap" style="height: 170px;">
                    <textarea name="bcontent" class="inp" style="resize: none; padding:8px"></textarea>
                    <div class="inpBar"></div>
                </div>
    
                <p class="subTitle">주제</p>

                <select name="themelist" class="selectWrap">
                    <option value="0" selected>주제 없음</option>
                    <c:forEach items="${thlist}" var="themeVo">
                        <option value="${themeVo.thcode}">${themeVo.thname}</option>
                    </c:forEach>
                </select>
    
                <div class="fileBtn2">
                    <i class="far fa-folder-open"></i>
                    <p>파일 첨부하기</p>
                </div>
                <div class="fileSpace2">
                    <span></span><i class="fas fa-times"></i>
                </div>
                <input type="file" name="file" id="fileInp2" style="display: none;">
    
    
                <div class="btnWrap">
                    <button type="submit" class="adMissionBtn pointBtn codeTransColor_back" data-sucode="${sucode}">등록</button>
                </div>
    
            </form>
        </div>
    </div>
    <div class="modalWrap" data-modal="addTheme">
        <div class="modalCon" style="width:300px; max-height: 1000px;">
            <p class="modalTitle">
                <span class="codeTransColor_border" data-sucode="${sucode}">주제 만들기</span>
                <i class="fas fa-times modalClose"></i>
            </p>
            <form action="/list/theme.do" method="post">
                <c:forEach items="${tList}" var="teacherVo">
                    <input type="hidden" name="tid" value="${teacherVo.tid}">
                </c:forEach>
                <input type="hidden" name="sucode" value="${sucode}">
                <c:forEach items="${tList}" var="teacherVo">
                    <input type="hidden" name="tid" value="${teacherVo.tid}">
                </c:forEach>
                <input type="hidden" name="sucode" value="${sucode}">
                <p class="subTitle">주제명</p>
                <div class="inpWrap">
                    <input type="text" name="thname" class="inp" required>
                    <div class="inpBar"></div>
                </div>
    
                <div class="btnWrap">
                    <button type="submit" class="adMissionBtn pointBtn codeTransColor_back" data-sucode="${sucode}">등록</button>
                </div>
    
            </form>
        </div>
    </div>
</c:if>


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

    //파일관련2
    $(document).on('click','.modalWrap .fileBtn2',function(){
        $('#fileInp2').trigger('click');
    })
    $(document).on('change', '#fileInp2', function(){
        var fileName1   = $(this).val().split('\\');
        var fileNameLeng = fileName1.length;
        var fileName = fileName1[fileNameLeng-1];  

        if($(this).val()!=null){
            $('.modalWrap .fileBtn2').hide();
            $('.modalWrap .fileSpace2').css({
                display:'flex'
            });
            $('.modalWrap .fileSpace2>span').text(fileName)
        }
    })

    $(document).on('click', '.modalWrap .fileSpace2>i', function(){
        $(this).closest('.fileSpace2').hide();
        $('.modalWrap .fileBtn2').css({
            display:'flex'
        });
        $('#fileInp2').val('');

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


    //좌측 주제탭 클릭
    $(document).on('click', '.thCodeTab', function(){
        var thisCode = $(this).data('thcode');
        $('.thCodeTab').not($(this)).removeClass('on');
        $(this).addClass('on');
        if(thisCode == ''){
            $('.thCodeBlock').show();
        } else {
            $('.thCodeBlock').not($('thCodeBlock[data-thcode="'+thisCode+'"]')).hide();
            $('.thCodeBlock[data-thcode="'+thisCode+'"]').show();
        }
    })

    //주제타이틀 클릭
    $(document).on('click', '.thCodeTitle', function(){
        var thisCode = $(this).data('thcode');
        $('.thCodeTab').not($('.thCodeTab[data-thcode="'+thisCode+'"]')).removeClass('on');
        $('.thCodeTab[data-thcode="'+thisCode+'"]').addClass('on');
        if(thisCode == ''){
            $('.thCodeBlock').show();
        } else {
            $('.thCodeBlock').not($('thCodeBlock[data-thcode="'+thisCode+'"]')).hide();
            $('.thCodeBlock[data-thcode="'+thisCode+'"]').show();
        }
    })
</script>