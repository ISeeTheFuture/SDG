<%@page import="java.util.List"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	List<Member> list = (List<Member>) request.getAttribute("list");

/* Member memberLoggedIn = (Member) session.getAttribute("memberLoggedIn"); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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
<body>
<div id="heightweightkwj">


		<table class="table table-striped table-dark">
			<thead>
				<tr>
		
					<th scope="col">멤버 아이디</th>
					<th scope="col">멤버 주소</th>
					<th scope="col">멤버 이름</th>
					<th scope="col">전화번호</th>

				</tr>
			</thead>
			<tbody>



				<%
					int i = 0;
					for (Member b : list) {
						i++;
				%>
				<tr>
					<th scope="row"><%=i%></th>
						<td><%=b.getMemId()%></td>
			<td><%=b.getMemAddr()%></td>
			<td><%=b.getMemName()%></td>
			<td><%=b.getMemPhone()%></td>

				

				</tr>

				<%
					}
				%>
</tbody>


</table>





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


















<%-- 




	<table id="tbl-board">
		<tr>
			<th>번호</th>
			<th>주소</th>
			<th>이름</th>
			<th>전화번호</th>

			첨부파일이 있는 경우, /images/file.png 표시 width:16px

		</tr>
		<%
			for (Member b : list) {
		%>
		<tr>
			<td><%=b.getMemId()%></td>
			<td><%=b.getMemAddr()%></td>
			<td><%=b.getMemName()%></td>
			<td><%=b.getMemPhone()%></td>
		
		</tr>
		
		
		<%
 	if (memberLoggedIn != null && ("1".equals(memberLoggedIn.getMemAdmin()))) {
 %>

				<form action="<%=request.getContextPath()%>/review/reviewReport"
					method="post" name="boardCommentFrm">
					<input type="hidden" name="reviewNo" value="<%=b.getMemId()%>" />
					<%
						if (memberLoggedIn != null && b.getMemId().equals(memberLoggedIn.getMemId())
											|| "1" == memberLoggedIn.getMemAdmin()) {
					%>
					<button type="submit" id="btn-insert">사용자 벤</button>
					<%
						}
					%>
				</form> <%
 	}
 %>
		
		<%
			}
		%> --%>
	</table>





</div>
</body>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</html>