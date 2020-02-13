<%@page import="java.util.List"%>
<%@page import="review.model.vo.Review"%>
<%@page import="review.model.vo.ReviewComment"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<ReviewComment> commentList = (List<ReviewComment>)request.getAttribute("commentList");
/* System.out.println(commentList.get(0).getMemId()); */
	List<Review> list = (List<Review>)request.getAttribute("list");
	String pageBar = (String)request.getAttribute("pageBar");
	Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn");
%>

<section id="board-container">
	<h2>게시판 </h2>
	<% if(memberLoggedIn != null){ %>
	<input type="button" value="글쓰기" id="btn-add"
		   onclick="location.href='<%=request.getContextPath() %>/review/reviewForm'" />
	<% } %>
	
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
			<% for(Review b : list){ %>
			
			<td><%= b.getReviewNo() %></td>
			<td><%= b.getMemId() %></td>
			<td><%= b.getReviewDate() %></td>
			<td><%= b.getReviewStar() %></td>
			<td><%= b.getReviewContent() %></td>
			<td><%= b.getReviewRecommend() %></td>
			<td>
			<form action="<%=request.getContextPath()%>/review/reviewUpdate"
        	  method="post"
        	  name="boardCommentFrm">
        	  <input type="hidden" name="reviewNo" value="<%=b.getReviewNo()%>"/>
        	   <button type="submit" id="btn-insert">게시글 수정</button>
        	   </form>
       	   <form action="<%=request.getContextPath()%>/review/reviewDelete"
        	  method="post"
        	  name="boardCommentFrm">
        	  <input type="hidden" name="reviewNo" value="<%=b.getReviewNo()%>"/>
		  <button type="submit" id="btn-insert">게시글 삭제</button>
        	   </form>
        	   
        	   
        	   
        	   
			<!-- comment 보이지가 않음 ㅜㅜㅜㅜㅜㅜ-->
			<% for(ReviewComment a : commentList){ %>
			<td><%= a.getMemId() %></td>
			<td><%= a.getCommentContent() %></td>
			<td><%= a.getCommentDate() %></td>
			
			
			<form action="<%=request.getContextPath()%>/review/reviewCommentDelete"
        	  method="post"
        	  name="boardCommentFrm">
       	  <input type="hidden" name="commentNo" value="<%=a.getCommentNo()%>"/>
		  <button type="submit" id="btn-insert">댓글 삭제</button>
        </form> 
        
				<% } %>	<!-- comment -->
				
			
			
			<!-- 로그인되어있고 사업자일경우 답글쓰기 -->
		<% if(memberLoggedIn != null || "1"==memberLoggedIn.getMemRole()){ %>
		 
        	  
		<form action="<%=request.getContextPath()%>/review/reviewCommentInsert"
        	  method="post"
        	  name="boardCommentFrm">
        	<input type="hidden" name="memId" value="<%=memberLoggedIn!=null?memberLoggedIn.getMemId():""%>"/>
            <textarea name="commentContent" cols="60" rows="3"></textarea>
            <button type="submit" id="btn-insert">등록</button>
        </form>
        
		<% } %><!-- 로그인되어있고 사업자일경우 답글쓰기 -->
		</tr>
		
		<% } %><!-- review -->
		
		<tr>	
	 
		</tr>
	</table>
	<div id='pageBar'><%=pageBar %></div>
</section>
