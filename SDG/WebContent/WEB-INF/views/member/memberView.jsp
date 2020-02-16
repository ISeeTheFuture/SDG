<%@page import="member.model.vo.MemberBusi"%>
<%@page import="member.model.vo.Member"%>
<%@page import="java.util.*"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>	
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
<%
/* Member memberLoggedIn = (Member) session.getAttribute("memberLoggedIn"); header에 작성된 코드*/
	Member member = (Member)request.getAttribute("member");
MemberBusi memberBusiIn = (MemberBusi)session.getAttribute("memberBusiIn");
int gn = member.getMemGradeName();
String MemberGradeName = null;
String RoleCheck="사업자가 아닙니다.";
 System.out.println("엠비 로그인 서wqeqwe블릿="+member.getMemGender());

if("1".equals(member.getMemRole())){
	RoleCheck="사업자입니다.";
	
	
}else if ("1".equals(member.getMemRole())){
	RoleCheck="사업자 등록 처리중 입니다.";
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

<script type="text/javascript">
$(function(){
	
});

function updateMember(){
	
	$("#memberFrm").attr("action", "<%=request.getContextPath()%>/member/updateMember")
				   .submit();
}

function updateValidate(){
	return true;
}

function updatePassword(){
	let url = "<%=request.getContextPath()%>/member/updatePassword?memberId=<%=member.getMemId()%>"
/* 	open(url, 
		 "updatePassword", 
		 "left=500px, top=200px, width=480px, height=290px"); */
		location.href=url;
		 
}
</script>


	
<section id=enroll-container>
	
	<div class="container">
		<br>
		<p class="text-center">회원 정보 수정</p>
		<hr>
	</div>
	
	
		  
		<div class="card bg-light">
		<article class="card-body mx-auto" style="max-width: 400px;">
	<form class="card-body mx-auto" id="memberFrm" method="post" 
		  onsubmit="return updateValidate();">


				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">아이디</span>
					</div>
					<input type="text" name="memberId" id="memberId_" class="form-control" value="<%=member.getMemId() %>" readonly>
				</div>

				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">이름</span>
					</div>
					<input type="text"  name="memberName" id="memberName" class="form-control" value="<%=member.getMemName() %>"  required readonly><br>
				</div>
				
				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">생년월일</span>
					</div>
					<input type="date" name="birthDay" id="birthDay" value="<%=member.getMemBirth()%>" class="form-control" >
				</div>				

				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">이메일</span>
					</div>
					<input type="email" placeholder="abc@xyz.com" name="email" id="email" class="form-control" value="<%=member.getMemEmail() %>">
				</div>	

				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">휴대폰</span>
					</div>
					<input type="tel" placeholder="(-없이)01012345678" name="phone" id="phone" maxlength="11" class="form-control" value="<%=member.getMemPhone() %>" required readonly>
				</div>

				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">주소</span>
					</div>
					<input type="text" placeholder="" name="address" id="address" class="form-control" value="<%=member.getMemAddr() %>">
				</div>

				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">포인트</span>
					</div>
					<input type="text"  name="memberPoint" id="memberPoint" class="form-control" value="<%=member.getMemPoint() %>"  required readonly>
				</div>
				
				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">회원 등급</span>
					</div>
					<input type="text"  name="memberGradeName" id="memberGradeName" class="form-control" value="<%=MemberGradeName %>"  required readonly>
				</div>				

				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">사업자 등록 여부</span>
					</div>
					<input type="text"  name="memberGradeName" id="memberGradeName" class="form-control" value="<%=RoleCheck %>"  required readonly>
				</div>
				
				<div class="form-group input-group">
					<% if(memberBusiIn!=null){ %>
					<div class="input-group-prepend">
						<span class="input-group-text">사업장 주소</span>
					</div>
					<input type="text"  name="memberGradeName" id="memberGradeName" class="form-control" value="<%=memberBusiIn.getMemBusiAddr() %>"  required>
					<%} %>
				</div>				

				<div class="form-group input-group">
					<% if(memberBusiIn!=null){ %>
					<div class="input-group-prepend">
						<span class="input-group-text">사업장 전화번호</span>
					</div>
					<input type="text"  name="memberGradeName" id="memberGradeName"  class="form-control" value="<%=memberBusiIn.getMemBusiPhone() %>"  required>
					<%} %>
				</div>
				
				<div class="form-group">
					<input class="btn btn-primary btn-block" onclick="updateMember();" value="정보수정">
				</div>	
							
				<div class="form-group">
					<input class="btn btn-primary btn-block" onclick="updatePassword();" value="비밀번호 변경">
				</div>

				<div class="form-group">
					<input class="btn btn-primary btn-block" onclick="updatePassword();" value="회원탈퇴">
				</div>


				<%--membership의 role값이 1 (트루)인경우 사업자 정보 입력 페이지로 이동 가능하도록 함. --%>
				<%
					if (memberLoggedIn != null && ("1".equals(memberLoggedIn.getMemRole()))) {
				%>
				<div class="form-group">
					<input class="btn btn-primary btn-block" onclick="location.href='<%=request.getContextPath()%>/member/applyRole?memberid=<%=member.getMemId()%>'" value="사업자 신청하기">
				</div>

				<div class="form-group">
					<input class="btn btn-primary btn-block" onclick="location.href='<%=request.getContextPath()%>/member/memberBusi'" value="사업자 등록 페이지">
				</div>
				<%
					}
				%>						
				</form>
			</article>
		</div>
		  
<%-- 		  
		   membership의 role값이 1 (트루)인경우 사업자 정보 입력 페이지로 이동 가능하도록 함.
	<%
		if (memberLoggedIn != null && ("1".equals(memberLoggedIn.getMemRole()))) {
	%>

	<input type="button" value="사업장 등록용 페이지"
		onclick="location.href='<%=request.getContextPath()%>/member/memberBusi'" />

	<%
		}
	%>
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		<table>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="memberId" id="memberId_" class="form-control" value="<%=member.getMemId() %>" readonly>
				</td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td>
					<input type="password" name="password" id="password_" value="<%=member.getPassword() %>" required>
				</td>
			</tr>
			<tr>
				<th>패스워드확인</th>
				<td>	
					<input type="password" id="password_2" value="<%=member.getPassword() %>" required><br>
				</td>
			</tr> 
			<tr>
				<th>이름</th>
				<td>	
				<input type="text"  name="memberName" id="memberName" value="<%=member.getMemName() %>"  required readonly><br>
				</td>
			</tr>
				
			<tr>
				<th>생년월일</th>
				<td>	
				<input type="date" name="birthDay" id="birthDay" value="<%=member.getMemBirth()%>" ><br>
				</td>
			</tr> 
			<tr>
				<th>이메일</th>
				<td>	
					<input type="email" placeholder="abc@xyz.com" name="email" id="email" value="<%=member.getMemEmail() %>"><br>
				</td>
			</tr>
			<tr>
				<th>휴대폰</th>
				<td>	
					<input type="tel" placeholder="(-없이)01012345678" name="phone" id="phone" maxlength="11" value="<%=member.getMemPhone() %>" required readonly><br>
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>	
					<input type="text" placeholder="" name="address" id="address" value="<%=member.getMemAddr() %>"><br>
				</td>
			</tr>
			<tr>
				<th>성별 </th>
				<td>
				
			       		 <input type="radio" name="gender" id="gender0" value="M" <%=0==member.getMemGender()?"checked":"" %>>
						 <label for="gender0">남</label>
						 <input type="radio" name="gender" id="gender1" value="F" <%=1==member.getMemGender()?"checked":"" %>>
						 <label for="gender1">여</label>
				</td>
			</tr>
			
			<tr>
				<th>포인트</th>
				<td>	
				<input type="text"  name="memberPoint" id="memberPoint" value="<%=member.getMemPoint() %>"  required readonly><br>
				</td>
			</tr>
			<tr>
				<th>그레이드네임</th>
				<td>	
				<input type="text"  name="memberGradeName" id="memberGradeName" value="<%=MemberGradeName %>"  required readonly><br>
				</td>
			</tr>
			<tr>
				<th>사업자 허용 여부</th>
				<td>	
				<input type="text"  name="memberGradeName" id="memberGradeName" value="<%=RoleCheck %>"  required readonly><br>
				</td>
			</tr>
			
			
	 		<tr>
			<% if(memberBusiIn!=null){ %>
	 		<th>사업장 주소</th>
	 		<td>
	 		<input type="text"  name="memberGradeName" id="memberGradeName" value="<%=memberBusiIn.getMemBusiAddr() %>"  required><br>
	 			
	 			<td>
	 			
	 		<%} %>
	 			</tr>

			<% if(memberBusiIn!=null){ %>
	 			<tr>
	 		<th>사업장 전화번호</th>
	 		<td>
	 		<input type="text"  name="memberGradeName" id="memberGradeName" value="<%=memberBusiIn.getMemBusiPhone() %>"  required><br>
	 			
	 			<td>
	 			
	 			</tr>
	 			
	 		<%} %>

	 			
			
		</table>
        <input type="button" onclick="updateMember();" value="정보수정"/>
        <input type="button" onclick="updatePassword();" value="비밀번호변경" />
        <input type="button" onclick="deleteMember();" value="탈퇴"/>
	</form>
	

	<button onclick="location.href='<%=request.getContextPath()%>/member/applyRole?memberid=<%=member.getMemId()%>'">사업자 신청하기</button>
</section>


	membership의 role값이 1 (트루)인경우 사업자 정보 입력 페이지로 이동 가능하도록 함.
	<%
		if (memberLoggedIn != null && ("1".equals(memberLoggedIn.getMemRole()))) {
	%>
	
	
	<input type="button" value="사업자 등록용 페이지"
		onclick="location.href='<%=request.getContextPath()%>/member/memberbusiupdate'" />

	<%
		}
	%>


 
 
 membership의 role값이 1 (트루)인경우 사업자 정보 입력 페이지로 이동 가능하도록 함.
	<%
		if (memberLoggedIn != null && ("1".equals(memberLoggedIn.getMemRole()))) {
	%>

	<input type="button" value="사업장 등록용 페이지"
		onclick="location.href='<%=request.getContextPath()%>/member/memberBusi'" />

	<%
		}
	%> --%>