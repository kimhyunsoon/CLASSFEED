<%@ page contentType="text/html; charset=utf-8"%>


<script>

    if(${flag}) {
        alert('삭제 성공 with Spring')
    }else {
        alert('삭제 실패 with Spring')
    }
    location.href='list.do';
</script>