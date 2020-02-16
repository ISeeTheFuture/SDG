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






<form action="<%=request.getContextPath() %>/review/reviewFormEnd" method="post">
	<label for="memId">아이디</label>
	<input type="text"  name="memId" id="memId" value="<%=memberLoggedIn.getMemId() %>"  readonly><br>
	<br>
	
	 <label for="memBusiNo">사업장 번호</label>
      <input type="text" name="spc_no" id="spc_no" placeholder="사업장 번호를 입력하세요." />
      <br> 
      
     <label for="reviewTitle">제목</label>
      <input type="text" name="reviewTitle" id="reviewTitle" placeholder="제목을 입력하세요." />
      <br>
     <label for="reviewContent">내용</label>
      <input type="text" name="reviewContent" id="reviewContent" placeholder="내용을 입력하세요." />
      <br>
     
      <label for="reviewStar">별점 입력</label>
      <select  name="reviewStar" id="reviewStar" maxlength="11" required>
		    <option value="5">5</option>
		    <option value="4">4</option>
		    <option value="3">3</option>
		    <option value="2">2</option>
		    <option value="1">1</option>
		</select>
      <br>
      
     <!--  <input type="hidden" name="memBusiAllow" id="memBusiAllow" value="N" /> -->
      <!--기본값 0으로  0일때 승인 거부 상태 , 관리자가 1로 update해야 승인됨 -->
      
      <input type='submit' value="전송" />
      <input type="reset" value="취소">
	
	</form>
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



			<%
				}
			%>

		</tr>
	</table>
	
	
	
	
	
	
	
	
	<div id='pageBar'><%=pageBar%></div>
</section>

	

