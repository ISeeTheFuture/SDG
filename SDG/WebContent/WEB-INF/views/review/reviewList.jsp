<%@page import="java.lang.reflect.Parameter"%>
<%@page import="java.util.List"%>
<%@page import="review.model.vo.Review"%>
<%@page import="review.model.vo.ReviewComment"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<ReviewComment> commentList = (List<ReviewComment>) request.getAttribute("commentList");
	List<Review> list = (List<Review>) request.getAttribute("list");
	String pageBar = (String) request.getAttribute("pageBar");
	Member memberLoggedIn = (Member) session.getAttribute("memberLoggedIn");
%>

<section id="board-container">
	<h2>게시판</h2>
	<%
		if (memberLoggedIn != null) {
	%>
	<input type="button" value="글쓰기" id="btn-add"
		onclick="location.href='<%=request.getContextPath()%>/review/reviewForm'" />

	<%
		}
	%>

	<table id="tbl-board">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>별점</th>
			<th>내용</th>
			<th>추천수</th>
		</tr>
		<tr>
			<!-- review -->
			<%
				for (Review b : list) {
			%>

			<%-- <%=b.getMemId()%> --%>

			<td><%=b.getReviewNo()%></td>
			<td><%=b.getMemId()%></td>
			<td><%=b.getReviewDate()%></td>
			<td><%=b.getReviewStar()%></td>
			<td><%=b.getReviewContent()%></td>
			<td><%=b.getReviewRecommend()%></td>
			<td>
				<%
					if (memberLoggedIn != null ) {
				%> <%
 	if (memberLoggedIn != null && b.getMemId().equals(memberLoggedIn.getMemId())
 					|| ("1".equals(memberLoggedIn.getMemAdmin()))) {
 %>


				<form action="<%=request.getContextPath()%>/review/reviewUpdate"
					method="post" name="boardCommentFrm">
					<input type="hidden" name="reviewNo" value="<%=b.getReviewNo()%>" />
					<%
						if (memberLoggedIn != null && b.getMemId().equals(memberLoggedIn.getMemId())
											|| "1" == memberLoggedIn.getMemAdmin()) {
					%>
					<button type="submit" id="btn-insert">게시글 수정</button>
					<%
						}
					%>
				</form> <%
 	}
 %> <%
 	if (memberLoggedIn != null && b.getMemId().equals(memberLoggedIn.getMemId())
 					|| ("1".equals(memberLoggedIn.getMemAdmin()))) {
 %>

				<form action="<%=request.getContextPath()%>/review/reviewDelete"
					method="post" name="boardCommentFrm">
					<input type="hidden" name="reviewNo" value="<%=b.getReviewNo()%>" />
					<%
						if (memberLoggedIn != null && b.getMemId().equals(memberLoggedIn.getMemId())
											|| "1" == memberLoggedIn.getMemAdmin()) {
					%>
					<button type="submit" id="btn-insert">게시글 삭제</button>
					<%
						}
					%>
				</form> <%
 	}
 %> <%
 	if (memberLoggedIn != null && b.getMemId().equals(memberLoggedIn.getMemId())
 					|| ("1".equals(memberLoggedIn.getMemAdmin()))) {
 %>

				<form action="<%=request.getContextPath()%>/review/reviewReport"
					method="post" name="boardCommentFrm">
					<input type="hidden" name="reviewNo" value="<%=b.getReviewNo()%>" />
					<%
						if (memberLoggedIn != null && b.getMemId().equals(memberLoggedIn.getMemId())
											|| "1" == memberLoggedIn.getMemAdmin()) {
					%>
					<button type="submit" id="btn-insert">게시글 신고</button>
					<%
						}
					%>
				</form> <%
 	}
 %>
			
		</tr>



		<tr>






		</tr>








		<%
			}
		%>



		<tr>



			관리자인 경우 신고 삭제 관리 페이지로 이동.
			 	<%
				if (memberLoggedIn != null && "1".equals(memberLoggedIn.getMemAdmin())) {
			%>


			<button
				onclick="location.href='<%=request.getContextPath()%>/review/reviewRprtPrcss'">신고게시글확인</button>










			<%
				}
			%>
			<%
				}
			%>

		</tr>
	</table>
	<div id='pageBar'><%=pageBar%></div>
</section>
