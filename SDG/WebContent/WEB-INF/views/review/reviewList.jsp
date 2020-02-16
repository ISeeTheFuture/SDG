<%@page import="jdk.internal.org.objectweb.asm.tree.FieldNode"%>
<%@page import="java.lang.reflect.Parameter"%>
<%@page import="java.util.List"%>
<%@page import="review.model.vo.Review"%>
<%@page import="review.model.vo.ReviewComment"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
<%
	int totalReviewCount = (int)request.getAttribute("totalReviewCount");
	int avgStar = (int)request.getAttribute("AvgStar");
	List<ReviewComment> commentList = (List<ReviewComment>) request.getAttribute("commentList");
	List<Review> list = (List<Review>) request.getAttribute("list");
	String pageBar = (String) request.getAttribute("pageBar");
%>

<section id="board-container">
	<h2>게시판</h2>
	<%
		if (memberLoggedIn != null) {//1
	%>
	<input type="button" value="글쓰기" id="btn-add"
		onclick="location.href='<%=request.getContextPath()%>/review/reviewForm'" />

	<%
		}//1
	%>
	
	<%
		if (memberLoggedIn != null && "1".equals(memberLoggedIn.getMemAdmin())) {
	%>
	<button onclick="location.href='<%=request.getContextPath()%>/review/reviewRprtPrcss'">신고게시글확인</button>
	<%
		}
	%>
		
	
	
	

	<table id="tbl-board">
	
	<tr>
	<td>
	<div id='totalReviewCount'>개시물 개수<%=totalReviewCount %></div>
	<div id='AvgStar'>평균 별점<%=avgStar %></div>
	</td>
	<%-- <div id='AvgStar'>추천수<%=reviewRcomd %></div> --%>
	<%-- <input type="button" value="추천" id="btn-add"
		onclick="location.href='<%=request.getContextPath()%>/review/reviewRcmd'" /> --%>
	</tr>
	
		<tr>
			<th>글 번호</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>별점</th>
			<th>내용</th>
			<th>추천수</th>
		</tr>
		<tr>
			<!-- review -->
			<%
				for (Review b : list) {//2
			%>

			<td><%=b.getReviewNo()%></td>
			<td><%=b.getMemId()%></td>
			<td><%=b.getReviewDate()%></td>
			<td><%=b.getReviewStar()%></td>
			<td><%=b.getReviewContent()%></td>
			<td><%=b.getReviewRecommend()%></td>
			
		</tr>
		<tr>
			<td>
			<form>
			<input type="button" value="게시글 추천" id="btn-add"
		 onclick="location.href='<%=request.getContextPath()%>/review/reviewRecommend'" />
			</form>
			
				<%
					if (memberLoggedIn != null ) {//4
				%> 
				<%
 	if (memberLoggedIn != null && b.getMemId().equals(memberLoggedIn.getMemId())
 					|| ("1".equals(memberLoggedIn.getMemAdmin()))) {//5
 %>


				<form action="<%=request.getContextPath()%>/review/reviewUpdate"
					method="post" name="boardCommentFrm">
					<input type="hidden" name="reviewNo" value="<%=b.getReviewNo()%>" />
					<%
						if (memberLoggedIn != null && b.getMemId().equals(memberLoggedIn.getMemId())
											|| "1" == memberLoggedIn.getMemAdmin()) {//6
					%>
					<button type="submit" id="btn-insert">게시글 수정</button>
					<%
						}//6
					%>
				</form> 
				<%} //5%> 
				
					
 <%
 	if (memberLoggedIn != null && b.getMemId().equals(memberLoggedIn.getMemId())
 					|| ("1".equals(memberLoggedIn.getMemAdmin()))) {//7
 %>

				<form action="<%=request.getContextPath()%>/review/reviewDelete"
					method="post" name="boardCommentFrm">
					<input type="hidden" name="reviewNo" value="<%=b.getReviewNo()%>" />
					<%
						if (memberLoggedIn != null && b.getMemId().equals(memberLoggedIn.getMemId())
											|| "1" == memberLoggedIn.getMemAdmin()) {//8
					%>
					<button type="submit" id="btn-insert">게시글 삭제</button>
					<%
						}//8
					%>
				</form> <%
 	}//7
 %> 
 <%
 	if (memberLoggedIn != null ) {//9
 %>

				<form action="<%=request.getContextPath()%>/review/reviewReport"
					method="post" name="boardCommentFrm">
					<input type="hidden" name="reviewNo" value="<%=b.getReviewNo()%>" />
					<%
						if (memberLoggedIn != null && b.getMemId().equals(memberLoggedIn.getMemId())
											|| "1" == memberLoggedIn.getMemAdmin()) {//10
					%>
					<button type="submit" id="btn-insert">게시글 신고</button>
					<%
						}//10
					%>
					
				</form> 
				</td>
				</tr>
				<%
 	}//9
 %>
 	
			<%
				for (ReviewComment c : commentList) {//3
			if(b.getReviewNo() == c.getReviewNo()){
			%>
			<tr>
			<td>
			<%if("1" == memberLoggedIn.getMemRole()) %>
			<% %>
			</td>
			<td>답글 <%=c.getCommentContent()%></td>
			</tr>
			
			<%}%>
			 <%} //3%>
 		<tr>
 			<td>
       	 <form action="<%=request.getContextPath()%>/review/reviewCommentInsert"
        	  method="post"
        	  name="reviewCommentFrm">
        	<input type="hidden" name="reviewNo" value="<%=b.getReviewNo() %>" />
        	<input type="hidden" name="memId" value="<%=memberLoggedIn.getMemId() %>"/>
            <textarea name="commentContent" cols="60" rows="3"></textarea>
      	      <button type="submit" id="btn-insert">등록</button>
      	  </form>
			</td>
	</tr>
			
		<%}%>
			<%
			}
			%>
			

	</table>
	
	<div id='pageBar'><%=pageBar%></div>
</section>

	

