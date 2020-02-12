<%@page import="java.util.List"%>
<%@page import="review.model.vo.Review"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Review> list = (List<Review>)request.getAttribute("list");
	String pageBar = (String)request.getAttribute("pageBar");
	int totalReviewCount = (int)request.getAttribute("totalReviewCount");
	int AvgStar = (int)request.getAttribute("AvgStar");
%>

<section id="review-container">
	<h2>이용후기 </h2>
	<tr>
		
		<th>이용후기 <%=totalReviewCount %>개</th>
		<th>평균 평점 <%=AvgStar %>점</th>
		<br/>
	</tr>
		<tr>
			<th>작성자</th>
			<th>내용</th>
			<th>추천수</th>
			<th>별점</th>
		</tr>
		<% for(Review b : list){ %>
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
	

	<div id='pageBar'><%=pageBar %></div>
</section>
