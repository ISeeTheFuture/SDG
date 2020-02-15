<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.Member" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.4.1.js"></script>
<style>
div#updatePassword-container{background:red;}
div#updatePassword-container table {margin:0 auto; border-spacing: 20px;}
div#updatePassword-container table tr:last-of-type td {text-align:center;}
</style>
<script>
function fn_password_validate(){
	var pwd_new = $("#password_new").val().trim();
	var pwd_chk = $("#password_chk").val().trim();
	
	if(pwd_new!=pwd_chk){
		alert("입력한 비밀번호가 일치하지 않습니다.");
		$("#password_new").select();
		return false;
	}
	
	return true;	
}

function goBack(){
	window.history.back();
}
</script>
</head>
<body>
	<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">비밀번호 수정</h4>
		<form name="updatePwdFrm" action="<%=request.getContextPath()%>/member/updatePasswordEnd" method="post" >
			<input type="hidden" name="memberId" value="<%=request.getParameter("memberId")%>"/>
			
			
			
	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> 현재 비밀번호 </span>
		 </div>
        <input type="password" name="password" id="password" required>
    </div> <!-- form-group// -->
    
    <div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> 변경할 비밀번호 </span>
		 </div>
        <input type="password" name="password_new" id="password_new" required>
    </div> <!-- form-group// -->
    
    <div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> 비밀번호 확인 </span>
		 </div>
        <input type="password" id="password_chk" required><br>
    </div> <!-- form-group// -->
    
    <div class="form-group">
        <button onclick="return fn_password_validate();" class="btn btn-primary btn-block"> 변경  </button>
    </div>
    </form>
    
    <div class="form-group">
        <button onclick="goBack();"class="btn btn-primary btn-block"> 닫기 </button>        
    </div>
    

	</article>
	</div>
	
	
</body>
</html>
