<%@ page contentType="text/html; charset=utf-8"%>


<script>
    var msg = "${msg}";
    if(msg== "success"){
        location.href="../main/list.do";
    }else {
        alert("아이디 또는 비밀번호가 일치하지 않습니다. 다시 확인하신 후 입력해주세요.");
        history.back();
    }

</script>