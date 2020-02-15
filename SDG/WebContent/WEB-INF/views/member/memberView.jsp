<%@page import="member.model.vo.MemberBusi"%>
<%@page import="member.model.vo.Member"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
<%
	Member member = (Member)request.getAttribute("member");
MemberBusi memberBusiIn = (MemberBusi)session.getAttribute("memberBusiIn");
int gn = member.getMemGradeName();
String MemberGradeName = null;
String RoleCheck="사업자가 아닙니다.";
 System.out.println("엠비 로그인 서wqeqwe블릿="+member.getMemGender());

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
	open(url, 
		 "updatePassword", 
		 "left=500px, top=200px, width=480px, height=290px");
}
</script>
<section id=enroll-container>
	<h2>회원 정보 수정</h2>
	<form id="memberFrm" method="post" 
		  onsubmit="return updateValidate();">
		<table>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="memberId" id="memberId_" value="<%=member.getMemId() %>" readonly>
				</td>
			</tr>
			<%-- <tr>
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
			</tr>  --%>
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
	
	
	
	
	<%-- <form>
	<input type="button" onclick="<%=request.getContextPath()%>/member/applyRole?memberid=<%=member.getMemId() %>">사업자 신청</input>
	</form> --%>
	
	<button onclick="location.href='<%=request.getContextPath()%>/member/applyRole?memberid=<%=member.getMemId()%>'">내정보보기</button>
</section>

