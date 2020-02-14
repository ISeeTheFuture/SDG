<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
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

.btn-facebook {
    background-color: #405D9D;
    color: #fff;
}
.btn-twitter {
    background-color: #42AEEC;
    color: #fff;
}
.input-group-text{
	min-width: 90px;	
}
#gender1{
	align : center;
	margin-left : 50px;
}
</style>
<script>
$(function(){
	//비밀번호 확인 blur이벤트 발생이 동일여부 확인
	$("#password_2").blur(function(){
		let $p1 = $("#password_");
		let $p2 = $("#password_2");
		
		if($p1.val() != $p2.val()){
			alert("패스워드가 일치하지 않습니다.");
			$p1.select();
		}
	});
	//아이디 중복검사 이후 아이디를 변경한 경우
	$("#memberId_").change(function(){
		console.log($("#memberId_").val());
		$("#idValid").val(0);
	});
	
});

function enrollValidate(){
	let $memberId = $("#memberId_");
	if($memberId.val().length < 4){
		alert("아이디는 최소 4글자 이상입니다.");
		$memberId.select();
		return false;
	}
	
	let $idValid = $("#idValid");
	if($idValid.val() == 0){
		alert("중복검사 해주세요.");
		return false;
	}
	return true;
}


function checkIdDuplicate(){
	let memberId = $("#memberId_").val().trim();
	if(!memberId || memberId.length < 4){
		alert("아이디는 4글자이상 작성하세요.");
		return;
	}
	
	let title  = "checkIdDuplicate";//팝업과 폼을 연결
	let popup = open("", title, "left=500px, top=100px, width=300px, height=200px");
	
	let frm = document.checkIdDuplicateFrm;
	frm.action = "<%=request.getContextPath()%>/member/checkIdDuplicate";
	frm.method = "post";
	frm.target = title;
	frm.memberId.value = memberId;
	frm.submit();
}
</script>


<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">


<div class="container">

<hr>

<div class="card bg-light">
<!-- 회원가입 action -->
<form name="checkIdDuplicateFrm">
	<input type="hidden" name="memberId" />
</form>
<article class="card-body mx-auto"  style="max-width: 400px;">
    	   <form action="<%=request.getContextPath() %>/member/memberEnrollEnd" 
    	  name="memberEnrollFrm" 
    	  method="post" 
    	  onsubmit="return enrollValidate();" >
    	  
	<h4 class="card-title mt-3 text-center">회원가입</h4>
	
	
	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text">아이디</span>
		 </div>
        <input name="memberId" class="form-control" id="memberId_" placeholder="4글자 이상" type="text" required>
        <input type="button" onclick="checkIdDuplicate();" value="중복검사"/>
   		<input type="hidden" name="idValid" id="idValid" value="0" />
    </div> <!-- form-group// -->
    
    
    <div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> 이름 </span>
		 </div>
        <input name="memberName" class="form-control" id="memberName" placeholder="이름 입력" type="text">
    </div> <!-- form-group// -->
    
    <div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text">생년월일 </span>
		 </div>
        <input name="birthDay" class="form-control" id="birthDay" placeholder="생년월일" type="date">
    </div> <!-- form-group// -->
    
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text">이메일 </span>
		 </div>
        <input name="email" class="form-control"  id="email" placeholder="abc@xyz.com" type="email">
    </div> <!-- form-group// -->
    
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text">전화번호</span>
		</div>
    	<input name="tel" class="form-control" id="phone" placeholder="(-없이)01012345678" type="text">
    </div> <!-- form-group// -->
    
	
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text">패스워드 </span>
		</div>
        <input name="password" class="form-control" id="password_" placeholder="" type="password" required>
    </div> <!-- form-group// -->
    
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text">패스확인</span>
		</div>
        <input class="form-control" placeholder="" id="password_2" type="password" required>
       </div>
       
    <div class="form-group input-group">
    	<div class="input-group-prepend" id="gender">
		    <span class="input-group-text"> 성별 </span>
		    <div id="gender1">
		    		<input type="radio" name="gender" id="gender0" value="M" checked>
					<label for="gender0">남</label>
					
					<input type="radio" name="gender" id="gender1" value="F">
					<label for="gender1">여</label>
					</div>
		</div>
	</div> <!-- form-group end.// -->     
	
	                                      
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block"> 가입  </button>
        <button type="reset" class="btn btn-primary btn-block"> 취소  </button>
    </div> <!-- form-group// --> 
                 
	<!--container end.//-->
                 </div>         
                                                         
</form>
</article>