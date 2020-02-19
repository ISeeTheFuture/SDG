<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
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
    <img style="z-index:0" class="background" src="<%=request.getContextPath() %>/images/index-back.png" alt="" />
    <div class="container">
<%--     	<img style="position:absolute; top:20%;transform: translate(-50%, 0);" src="<%=request.getContextPath() %>/images/logo.png" alt="" /> --%>
    	<h1 style="color:rgb(245,245,245); font-weight:bold;position: absolute; top: 30%; left: 50%;transform: translate(-50%, 0);">지금 바로 예약하세요!!</h1>
    	<form action="<%=request.getContextPath()%>/space/spaceSrchList" method="GET">
    		<button class="btn btn-danger btn-xs" style="position: absolute; top: 40%; left: 50%;transform: translate(-50%, 0);">지금 예약하기!</button>
    	</form>
    </div>
    
<%@ include file="/WEB-INF/views/common/footer.jsp" %>	