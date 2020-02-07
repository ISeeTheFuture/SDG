<%@page import="member.model.vo.Member"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Member member = (Member)request.getAttribute("member");

	//String[] hobby = member.getHobby().split(",");
	//List<String> hobbyList = null;
	//if(hobby != null ) hobbyList = Arrays.asList(hobby);
%>
<script type="text/javascript">
$(function(){
	
});

/**
 * @실습문제1
 */
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
				<input type="text"  name="memberName" id="memberName" value="<%=member.getMemName() %>"  required><br>
				</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>	
				<input type="date" name="birthDay" id="birthDay" value="<%=member.getMemBirth()%>"><br>
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
					<input type="tel" placeholder="(-없이)01012345678" name="phone" id="phone" maxlength="11" value="<%=member.getMemPhone() %>" required><br>
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
			       		 <input type="radio" name="gender" id="gender0" value="M" <%="0".equals(member.getMemGender())?"checked":"" %>>
						 <label for="gender0">남</label>
						 <input type="radio" name="gender" id="gender1" value="F" <%="1".equals(member.getMemGender())?"checked":"" %>>
						 <label for="gender1">여</label>
				</td>
			</tr>
			<tr>
				
			</tr>
		</table>
        <input type="button" onclick="updateMember();" value="정보수정"/>
        <input type="button" onclick="updatePassword();" value="비밀번호변경" />
        <input type="button" onclick="deleteMember();" value="탈퇴"/>
	</form>
</section>

