<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>	
<%@ page import="member.model.vo.Member" %>
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

<style>
.detinfo {
	font-size: 2em;
}

.divider-text {
	position: relative;
	text-align: center;
	margin-top: 15px;
	margin-bottom: 15px;
}

.divider-text span {
	padding: 7px;
	font-size: 12px;
	position: relative;
	z-index: 2;
}

.divider-text:after {
	content: "";
	position: absolute;
	width: 100%;
	border-bottom: 1px solid #ddd;
	top: 55%;
	left: 0;
	z-index: 1;
}

.input-group-text {
	min-width: 90px;
}

p.text-center {
	font-size: 2em;
}
</style>

	<link
		href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
		rel="stylesheet" id="bootstrap-css">
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<!------ Include the above in your HEAD tag ---------->

	<link rel="stylesheet"
		href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

</head>
<body>

	<div class="container">
		<br>
		<p class="text-center">비밀번호 변경</p>
		<hr>
	</div>


	<div class="card bg-light">
	<article class="card-body mx-auto" style="max-width: 400px;">
		<form class="card-body mx-auto" name="updatePwdFrm" action="<%=request.getContextPath()%>/member/updatePasswordEnd" method="post" >
			<input type="hidden" name="memberId" value="<%=request.getParameter("memberId")%>"/>
			<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> 현재 비밀번호 </span>
		 </div>
        <input type="password" name="password" id="password" class="form-control" required>
    </div> <!-- form-group// -->
    
    <div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> 변경할 비밀번호 </span>
		 </div>
        <input type="password" name="password_new" id="password_new" class="form-control" required>
    </div> <!-- form-group// -->
    
    <div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> 비밀번호 확인 </span>
		 </div>
        <input class="form-control" type="password" id="password_chk" required><br>
    </div> <!-- form-group// -->
    
    <div class="form-group">
        <button onclick="return fn_password_validate();" class="btn btn-primary btn-block"> 변경  </button>
    </div>
    
    <div class="form-group">
        <button onclick="goBack();"class="btn btn-primary btn-block"> 닫기 </button>        
    </div>
    </form>
    

	</article>
	</div>
</body>
</html>
