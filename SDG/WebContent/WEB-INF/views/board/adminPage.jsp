<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<html>
<head>
<meta charset="UTF-8">
<title>어드민페이지</title>
<style>


#heightweightkwj{
height:1024px;
weight:768px;
no-repeat fixed;
background-repeat: no-repeat; 



background-image      : url("<%=request.getContextPath() %>/images/index-back.png");
 background-size: cover;
}
</style>

</head>


<div id="heightweightkwj">
<body>
<%-- 

<%
			if (memberLoggedIn != null && ("1".equals(memberLoggedIn.getMemAdmin()))) {
		%>
		<form action="<%=request.getContextPath()%>/member/memberIgnore">


  <div class="card my-4">
         <h5 class="card-header">사용자 수동 벤하기:</h5>
         <div class="card-body">
            <!-- <form> -->
            <div class="form-group">
               <input type="hidden" name="memId" id="memId"
                  value="<%=memberLoggedIn.getMemId()%>" readonly> <input
                  type="text" name="ignoreId" id="ignoreMemIndex" value=""
                  placeholder="벤 대상자의 아이디" /> <label for="reviewContent"></label>
               <textarea class="form-control" name="ignoreReason" id="ignoreReasonIndex" placeholder="벤 사유를 입력하세요." rows="3"></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            <!-- </form> -->
         </div>
      </div>

		</form>
		<%
			}
		%>




 --%>




<%-- 

   <img class="background" src="<%=request.getContextPath() %>/images/index-back.png" alt="" />


		관리자인경우 직접 벤이 가능하도록 함.
		<%
			if (memberLoggedIn != null && ("1".equals(memberLoggedIn.getMemAdmin()))) {
		%>
		<form action="<%=request.getContextPath()%>/member/memberIgnore"
			name="memberIgnoreFrm" method="post">
			<input type="text" name="ignoreId" id="ignoreMemIndex"
				placeholder="벤 대상자의 id를 입력하세요." /> <input type="text"
				name="ignoreReason" id="ignoreReasonIndex"
				placeholder="벤 사유를 입력하세요." /> <input type='submit' value="전송" />
		</form>
		<%
			}
		%>

 --%>


		<%--관리자인경우 사업자 등록, 관리자 등록페이지로 이동이 가능하도록 함. --%>
		<%
			if (memberLoggedIn != null && ("1".equals(memberLoggedIn.getMemAdmin()))) {
		%>
<button type="button" class="btn btn-primary btn-sm" onclick="location.href='<%=request.getContextPath()%>/member/MemberApplyMemberView'">사업자
			등업 관리 페이지로 이동</button>
	<%-- 	<button
			onclick="location.href='<%=request.getContextPath()%>/member/MemberApplyMemberView'">사업자
			등업 관리 페이지로 이동</button>
	 --%>
		<%
			}
		%>

<%-- 

		<!-- 	관리자인 경우 신고 삭제 관리 페이지로 이동. -->
		<%
			if (memberLoggedIn != null && "1".equals(memberLoggedIn.getMemAdmin())) {
		%>


		<button
			onclick="location.href='<%=request.getContextPath()%>/review/reviewRprtPrcss'">신고 게시글 확인</button>

		<%
			}
		%>
		 --%>
		
			<%
			if (memberLoggedIn != null && "1".equals(memberLoggedIn.getMemAdmin())) {
		%>




		<button
			onclick="location.href='<%=request.getContextPath()%>/member/memberAllCheck'">모든 사용자 조회</button>

		<%
			}
		%>
		
		
	</div>
</body>




</body>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>	
</html>