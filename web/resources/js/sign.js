//회원종류 선택
$(document).on('click', '.memCheck' ,function(){
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

//이메일 인증번호 발송 클릭
$(document).on('click', '.emailNumSend', function(){
    alert('CLASSFEED는 포트폴리오 샘플사이트로서, \n외부 메일링 서비스에 가입되지 않았습니다.\n\n기능 체험을 원하시면 인증번호 1234를 입력해주세요.');
    $('.emailNumSend').removeClass('on')
    $('#emailInp').prop('readonly',true)
    $('.checkNumWrap').slideDown();
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
    if($('#emailCheck').val() == '0'){
        alert('이메일 인증을 진행해주세요.');
        return false;
    }
    if($('#passwordInp').val() !=  $('#passwordInp2').val()) {
        alert('비밀번호가 일치하지 않습니다.')
        return false;
    }
    
    var data = {};
    for(i=0; i<$('.formData').length; i++){
        data[$('.formData').eq(i).attr('name')] = $('.formData').eq(i).val()
    }
    
    
    alert('form으로 전송되는 데이터\n\ntype : ' + data['type'] + '\nname : ' + data['name'] + '\nemail : ' + data['email'] + '\npassword : ' + data['password'])

    return false;
})