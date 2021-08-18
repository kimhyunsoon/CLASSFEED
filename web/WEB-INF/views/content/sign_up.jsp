<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html;charset=utf-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CLASSFEED | 회원가입</title>
    <link rel="shortcut icon" href="../img/favicon.ico" type="image/x-icon">
	<link rel="icon" href="../img/favicon.ico" type="image/x-icon">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">

    <script src="https://kit.fontawesome.com/5a210d3256.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/sign.css">
    <script src="../js/common.js"></script>
</head>

<body>
<div class="signBoxWrap" style="width: 350px;">
    <div class="signBox">
        <div class="logoWrap">
            <p class="title">회원가입</p>

            <img src="../img/classfeedLogo.png" class="logo">
        </div>
        <form class="signUpForm" onSubmit="return false;">
            <div class="stepWrap stepWrap1" style="margin-top:15px;">
                <p>회원종류를 선택해주세요.</p>
                <div class="memCheckWrap">
                    <input type="hidden" class="formData" name="type" id="memberType">
                    <label class="memCheck" data-val="teacher">
                        <i class="fas fa-chalkboard-teacher"></i>
                        <p><i class="fas fa-check"></i>선생님</p>
                    </label>
                    <label class="memCheck" data-val="student">
                        <i class="fas fa-user-edit"></i>
                        <p><i class="fas fa-check"></i>학생</p>
                    </label>
                </div>
                <p class="actionBtn nextBtn off">다음</p>
                <a href="../" class="otherBtn">돌아가기</a>
            </div>
            <div class="stepWrap stepWrap2">

                <div class="inpWrap">
                    <input type="text" class="inp formData" name="name" placeholder="이름" id="nameInp">
                    <div class="inpBar"></div>
                </div>

                <div class="inpWrap">
                    <input type="text" class="inp formData" name="agency" placeholder="기관명(학교 및 학원 등)" id="schoolInp">
                    <div class="inpBar"></div>
                </div>

                <div class="inpWrap">
                    <input type="text" class="inp formData" name="id" placeholder="아이디" id="idInp">
                    <input type="hidden" id="idCheck" value="0">
                    <div class="inpBar"></div>
                    <div class="idCheckSend inpInnerBtn">ID 중복검사</div>
                </div>
                <p class="idMsg signMsg">아이디는 영문(소문자)과 숫자이며, 4~12글자 여야 합니다.</p>
                <div class="br"></div>


                <div class="inpWrap">
                    <input type="tel" class="inp formData" name="phone" placeholder="휴대전화번호" id="phoneInp" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
                    <input type="hidden" id="phoneCheck" value="0">

                    <div class="inpBar"></div>
                </div>
                <p class="phoneMsg signMsg">전화번호 형식을 확인해주세요.</p>

                <div class="br"></div>

                <div class="inpWrap">
                    <input type="text" class="inp formData" name="email" id="emailInp" placeholder="이메일">
                    <input type="hidden" id="emailCheck" value="0">
                    <div class="inpBar"></div>
                    <div class="emailNumSend inpInnerBtn">인증번호 발송</div>
                </div>
                <p class="emailMsg signMsg">이메일 형식을 확인해주세요.</p>

                <div class="inpWrap checkNumWrap" style="margin-top:10px;">
                    <input type="text" class="inp" id="numCheckInp" placeholder="인증번호 (4자리)">
                    <div class="inpBar"></div>
                    <div class="emailNumCheck inpInnerBtn">확인</div>
                    <div class="emailNumCheck2 inpInnerBtn on" style="display: none;">재발송</div>
                </div>
                <p class="numCheckMsg signMsg">인증번호가 일치하지 않습니다.</p>

                <div class="br"></div>

                <div class="inpWrap">
                    <input type="password" class="inp formData" name="pwd" id="passwordInp" placeholder="비밀번호">
                    <div class="inpBar"></div>
                </div>
                <div class="inpWrap">
                    <input type="password" class="inp" id="passwordInp2" placeholder="비밀번호 확인">
                    <div class="inpBar"></div>
                </div>
                <p class="passwordMsg signMsg">비밀번호가 일치하지 않습니다.</p>

                <button class="actionBtn" id="completeBtn">가입완료</button>
                <p class="otherBtn prevBtn">이전</p>
            </div>
        </form>
    </div>
    <p class="copy">Copyright © 2021 CLASSFEED.</p>
</div>
</body>
<script>

//회원종류 선택
$(document).on('click', '.memCheck' ,function(){
    if($(this).data('val') == 'student'){
        $('#schoolInp').closest('.inpWrap').hide();
    }else {
        $('#schoolInp').closest('.inpWrap').show();

    }
    $('.memCheck').removeClass('on')
    $(this).addClass('on')
    $('.nextBtn').removeClass('off')
    $('.formData[name="type"]').val($(this).data('val'))
})

//회원종류 선택_다음 버튼
$(document).on('click', '.nextBtn' ,function(){
    if($(this).hasClass('off')){
        alert('회원종류를 선택해주세요.')
    }else {
        $('.stepWrap1').css({
            'margin-left':'-308px',
            opacity:'0'
        })
        $('.stepWrap2').css({
            opacity:'1'
        })
    }
})
// 회원정보 입력_이전 버튼
$(document).on('click', '.prevBtn', function(){
    $('.stepWrap1').css({
        'margin-left':'0px',
        opacity:'1'
    })
    $('.stepWrap2').css({
        opacity:'0'
    })
})




//아이디 정규식 체크
var idReg =  /^[a-z0-9+]{4,12}$/;
$(document).on('keyup', '#idInp', function(){
    if(!idReg.test($(this).val())){
        $('.idCheckSend').removeClass('on')
        $('.idMsg').slideDown()
    }else {
        $('.idCheckSend').addClass('on')
        $('.idMsg').slideUp();
    }
})

//아이디중복검사
$(document).on('click','.idCheckSend', function(){
    var thisId = $('#idInp').val();
    console.log(thisId)
    $.ajax({ 
		url: "../member/checkId",
		type: "post",
        data: {
            id:thisId,
            type:$('#memberType').val()
        },
		async: false,
		success: function(data) {
		    console.log(data);
            if(data=="noId"){
                alert("사용가능한 아이디입니다.")
                $('#idInp').prop('readonly', true)
                $('.idCheckSend').removeClass('on')
                $('#idCheck').val('1')
            }else if(data=="yesId"){
                alert("중복된 아이디입니다.")
                $('#idInp').val('')
                $('#idInp').prop('readonly', false)
                $('.idCheckSend').removeClass('on')
                $('#idCheck').val('0')
            }
		}
    })
})

//전화번호 체크
$(document).on('keyup', '#phoneInp', function(){
    if($(this).val().length != 11 || $(this).val().substring(0,3) != '010'){
        $('.phoneMsg').slideDown()
        $('#phoneCheck').val('0')
    }else {
        $('.phoneMsg').slideUp();
        $('#phoneCheck').val('1')     
    }
})







//이메일 형식 정규식
var emailReg = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;

//이메일 형식체크
$(document).on('keyup', '#emailInp' ,function(){
    if(!emailReg.test($(this).val())){
        $('.emailNumSend').removeClass('on')
        $('.emailMsg').slideDown()
    }else {
        $('.emailNumSend').addClass('on')
        $('.emailMsg').slideUp();
    }
})

//이메일 인증번호 발송 클릭
$(document).on('click', '.emailNumSend', function(){
    $.ajax({ 
		url: "../member/checkEmail",
		type: "post",
		async: false,
        data: {
            email:$('#emailInp').val(),
            type:$('#memberType').val(),
        },
		success: function(data) {
		    console.log(data);
            if(data=="noEmail"){
                alert('CLASSFEED는 포트폴리오 샘플사이트로서, \n외부 메일링 서비스에 가입되지 않았습니다.\n\n기능 체험을 원하시면 인증번호 1234를 입력해주세요.');
                $('.emailNumSend').removeClass('on')
                $('#emailInp').prop('readonly',true)
                $('.checkNumWrap').slideDown();
            }else if(data=="yesEmail"){
                alert("중복된 이메일입니다.")
                $('#emailInp').val('')
                $('.emailNumSend').removeClass('on')
                $('.checkNumWrap').slideUp();
            }
		}
    })
    
})

//이메일 인증번호 체크
$(document).on('keyup', '#numCheckInp' ,function(){
    if($(this).val().length == 4){
        $('.emailNumCheck').addClass('on')
    }
})

//이메일 인증번호 확인 클릭
$(document).on('click', '.emailNumCheck', function(){
    if($('#numCheckInp').val() == '1234'){
        $('.emailMsg').slideDown().text('인증되었습니다.').css({
            'color':'#0993FB'
        });
        $('#emailCheck').val('1')
        $('.checkNumWrap').slideUp();
        $('.numCheckMsg').slideUp();
        $('#numCheckInp').val('')
    } else {
        $('.numCheckMsg').slideDown();
        $('.emailNumCheck2').show();
    }
})

//이메일 인증번호 재발송 클릭
$(document).on('click', '.emailNumCheck2', function(){
    alert('CLASSFEED는 포트폴리오 샘플사이트로서, \n외부 메일링 서비스에 가입되지 않았습니다.\n\n기능 체험을 원하시면 인증번호 1234를 입력해주세요.');
    $(this).hide();
})



//비밀번호 확인1
$(document).on('keyup', '#passwordInp' ,function(){
    if($('#passwordInp2').val().length){
        if($(this).val() == $('#passwordInp2').val()){
            $('.passwordMsg').slideUp();
        } else {
            $('.passwordMsg').slideDown();
        }
    }else {
        $('.passwordMsg').slideUp();
    }
})

//비밀번호 확인2
$(document).on('keyup', '#passwordInp2' ,function(){
    if($('#passwordInp').val().length){
        if($(this).val() == $('#passwordInp').val()){
            $('.passwordMsg').slideUp();
        } else {
            $('.passwordMsg').slideDown();
        }
    }else {
        $('.passwordMsg').slideUp();
    }
})

//가입완료시 데이터 체크
$(document).on('click', '#completeBtn', function(){
    
    if(!$('#nameInp').val()){
        alert('이름을 입력해주세요.')
        $('#nameInp').focus();
        return false;
    }
    if($('.formData[name="type"]').val() == 'teacher'){
        if(!$('#schoolInp').val()){
            alert('기관명을 입력해주세요.')
            $('#schoolInp').focus();
            return false;
        }
    }
    if(!$('#idInp').val()){
        alert('아이디를 입력해주세요.')
        $('#idInp').focus();
        return false;
    }
    if(!$('#emailInp').val()){
        alert('이메일을 입력해주세요.')
        $('#emailInp').focus();
        return false;
    }
    if(!$('#passwordInp').val()){
        alert('비밀번호를 입력해주세요.')
        $('#passwordInp').focus();
        return false;
    }
    if($('#phoneCheck').val() == '0'){
        alert('전화번호 형식을 확인해주세요.');
        return false;
    }
    if($('#idCheck').val() == '0'){
        alert('아이디 중복검사를 진행해주세요.');
        return false;
    }
    if($('#emailCheck').val() == '0'){
        alert('이메일 인증을 진행해주세요.');
        return false;
    }
    if($('#passwordInp').val() !=  $('#passwordInp2').val()) {
        alert('비밀번호가 일치하지 않습니다.')
        return false;
    }
    
    var memberData = {};
    for(i=0; i<$('.formData').length; i++){
        memberData[$('.formData').eq(i).attr('name')] = $('.formData').eq(i).val()
    }
    memberData['phone'] = memberData['phone'].substring(0,3) + '-' + memberData['phone'].substring(3,7) + '-' + memberData['phone'].substring(7,11)

    $.ajax({ 
		url: "../member/signUp",
		type: "post",
        data: memberData,
		async: false,
		success: function(data) {
		    if(data == 'OK'){
                alert('회원가입이 완료되었습니다. \n가입하신 정보로 로그인해주세요.')
                location.href= '/';
            }
		}
    })
})

</script>
</html>
