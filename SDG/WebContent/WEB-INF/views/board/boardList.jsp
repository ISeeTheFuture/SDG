<%@page import="java.util.List"%>
<%@page import="board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Board> list = (List<Board>)request.getAttribute("list");
	String pageBar = (String)request.getAttribute("pageBar");
	int totalBoardCount = (int)request.getAttribute("totalBoardCount");
	int AvgStar = (int)request.getAttribute("AvgStar");
%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/board.css" />
<section id="board-container">
	<h2>게시판 </h2>
	 <% if(memberLoggedIn != null){ %>
	<input type="button" value="글쓰기" id="btn-add"
		   onclick="location.href='<%=request.getContextPath() %>/board/boardForm'" />
	<% } %>
	<table id="tbl-board">
	<tr>
		
		<th>이용후기 <%=totalBoardCount %>개</th>
		<th>평균 평점 <%=AvgStar %>점</th>
		
	</tr>
		<tr>
			<th>작성자</th>
			<th>내용</th>
			<th>추천수</th>
			<th>별점</th>
		</tr>
		<% for(Board b : list){ %>
		<tr>
			<td>
				<%= b.getMemberId() %>
			</td>
			<td>
				<%= b.getReviewContent() %>
			</td>
			<td>
				<%=b.getReviewRecommend() %>
			</td>
			<td>
				<%=b.getReviewStar() %>
			</td>
		</tr>
		<% } %>
	</table>

	<div id='pageBar'><%=pageBar %></div>
</section>

