
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@page import="java.util.*"%>
<%@page import="member.model.vo.MemberBusi"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Member member = (Member)request.getAttribute("member");
MemberBusi memberBusiIn = (MemberBusi)session.getAttribute("memberBusiIn");
int gn = member.getMemGradeName();
String MemberGradeName = null;
String RoleCheck="사업자가 아닙니다.";
 //System.out.println("엠비 로그인 서wqeqwe블릿="+memberBusiIn.getMemBusiAddr());

if("1".equals(member.getMemRole())){
	RoleCheck="사업자입니다.";
	
	
}

switch(gn){
case 0: MemberGradeName="등급없음"; break;
case 1 :MemberGradeName="브론즈"; break;
case 2 :MemberGradeName="실버"; break;
case 3 :MemberGradeName="골드"; break;
case 4 :MemberGradeName="플레티넘"; break;
case 5 :MemberGradeName="다이아몬드"; break;

}

	//String[] hobby = member.getHobby().split(",");
	//List<String> hobbyList = null;
	//if(hobby != null ) hobbyList = Arrays.asList(hobby);
%>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/memberForm.css">
<script type="text/javascript">
function updateMember(){
	$("#memberFrm").attr("action", "<%=request.getContextPath()%>/member/updateMember")
				   .submit();
}

function updateValidate(){
	return true;
}

function updatePassword(){
	let url = "<%=request.getContextPath()%>/member/updatePassword?memberId=<%=member.getMemId()%>"
	open(url, 
		 "updatePassword", 
		 "left=500px, top=200px, width=480px, height=290px");
}

</script>

<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">회원 정보 수정</h4>
	<form id="memberFrm" method="post" 
		  onsubmit="return updateValidate();">
	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> 아이디 </span>
		 </div>
        <input name="mem_id" id="mem_id" value="<%=member.getMemId() %>" readonly class="form-control" type="text">
    </div> <!-- form-group// -->
	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> 이름 </span>
		 </div>
        <input name="mem_name" id="mem_name" value="<%=member.getMemName() %>"  required class="form-control" placeholder="Full name" type="text">
    </div> <!-- form-group// -->
	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> 생년월일 </span>
		 </div>
        <input name="mem_birth" id="mem_birth" value="<%=member.getMemBirth()%>" class="form-control" type="date">
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> 이메일 </span>
		 </div>
        <input name="mem_email" id="mem_email" value="<%=member.getMemEmail() %>" class="form-control" placeholder="Email address" type="email">
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text">전화번호</span>
		</div>
    	<input name="mem_phone" id="mem_phone" maxlength="11" value="<%=member.getMemPhone() %>" required class="form-control" type="text">
    </div>
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text">주소</span>
		</div>
    	<input name="address" id="address" value="<%=member.getMemAddr() %>" required class="form-control" type="text">
    </div>
    <div class="form-group">
        <button onclick="updateMember();" class="btn btn-primary btn-block"> 수정  </button>
    </div>                                                             
</form>
</article>
</div> 

