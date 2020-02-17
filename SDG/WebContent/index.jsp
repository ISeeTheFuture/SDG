<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<style>

body{
	overflow:hidden;
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
   	<h1 style="display: block;
    position: absolute;
    top: 30%;
    left: 38%;">초특가 송대관</h1>
    <img class="background" src="<%=request.getContextPath() %>/images/index-back.png" alt="" />
<%@ include file="/WEB-INF/views/common/footer.jsp" %>	