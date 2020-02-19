<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
<style>
body{
	overflow:hidden;
}

.container{
	text-align:center;
}

.background{
	width:100%;
	height:100%;
}

.layer {
    background-color: darkgray;
    opacity: 0.5;
    position: absolute;
    top: 57px;
    left: 0;
    width: 100%;
    height: 100%;
    z-index: 0;
}
</style>
    <div class="layer"></div>
    <div class="container">
    	<h1 style="color:rgb(245,245,245); font-weight:bold;position: absolute; top: 30%; left: 50%;transform: translate(-50%, 0);">결제 완료!</h1>
    	<form action="<%=request.getContextPath()%>/res/resMe" method="GET">
    		<button class="btn btn-danger btn-xs" style="position: absolute; top: 40%; left: 50%;transform: translate(-50%, 0);">내 예약으로</button>
    	</form>
    </div>
    

</body>
</html>
    