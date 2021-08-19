//버튼 클릭 애니메이션
$(document).on('click', '.clickAniBtn', function(){
    var thisBtn = $(this)
    thisBtn.addClass('active')
    setTimeout(function(){
        thisBtn.removeClass('active')
    },300);
})

//사이드메뉴 열기 이벤트
$(document).on('click', '.sideMenuBtn', function(){
    setTimeout(function(){
        $('.sideMenu').addClass('on')
        $('.sideMenuWrap').addClass('on')
        $('.homeLink').addClass('on')
    }, 300);
})

//바깥 클릭시 사이드메뉴 닫기
$(document).on('click', '.sideMenuWrap', function(){
    $('.sideMenu').removeClass('on')
    $('.sideMenuWrap').removeClass('on')
    $('.homeLink').removeClass('on')
    // $('.feedCenterBox').removeClass('on')
})

//알림센터 열기 이벤트
$(document).on('click' , '.feedCenter' ,function(){
    $('.feedCenterBox').toggleClass('on')
    // $('.sideMenuWrap').addClass('on')
})

//알림센터 닫기 이벤트
$(document).on('click', '.feedCenterClose',function(){
    $('.feedCenterBox').removeClass('on')
    // $('.sideMenuWrap').removeClass('on')
})

//모달 열기
function modalOpen(){
    var thisModal = $('.modalWrap[data-modal="'+$(this).data('modal')+'"]');

    thisModal.css({
        display:'flex'
    });
    setTimeout(function(){
        thisModal.css({
            opacity:'1'
        })
        thisModal.children('.modalCon').css({
            transform:'scale(1)'
        })
    },400)
}
$(document).on('click', '.modalBtn', modalOpen)

//모달 닫기
function modalClose(){
    $('.modalWrap').css({
        opacity:'0'
    })
    $('.modalCon').css({
        transform:'scale(0.4)'
    })
    setTimeout(function(){
        $('.modalWrap').hide();
    },400)
}

//바깥 클릭시 모달닫기
$(document).on('click', '.modalWrap', function(e){
    if(e['target'].classList.contains('modalWrap')){
        modalClose();
    }
})
$(document).on('click', '.modalClose', modalClose)

// 회원모드 스위치
$(document).on('click', '.memberSwitch', function(){
    if($(this).text() == '선생님모드'){
        $(this).text('학생모드')
        $('.stuSample').show();
        $('.teaSample').hide();
    }else {
        $(this).text('선생님모드')
        $('.stuSample').hide();
        $('.teaSample').show();
    }
})