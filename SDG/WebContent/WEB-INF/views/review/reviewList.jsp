<%@page import="java.util.List"%>
<%@page import="review.model.vo.ReviewComment"%>
<%@page import="review.model.vo.Review"%>
<%@page import="member.model.vo.Member"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ReviewComment reviewComment = (ReviewComment)request.getAttribute("reviewComment");
	List<Review> list = (List<Review>)request.getAttribute("list");
	String pageBar = (String)request.getAttribute("pageBar");
	int totalReviewCount = (int)request.getAttribute("totalReviewCount");
	int AvgStar = (int)request.getAttribute("AvgStar");
	List<ReviewComment> commentList
	= (List<ReviewComment>)request.getAttribute("commentList");
	Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn");
%>

<section id="review-container">
	<h2>이용후기 </h2>
	<tr>
		<th>이용후기 <%=totalReviewCount %>개</th>
		<th>평균 평점 <%=AvgStar %>점</th>
		<br/>
	</tr>
	<table id="tbl-board">
		<tr>
			<th>작성자</th>
			<th>내용</th>
			<th>추천수</th>
			<th>별점</th>
		</tr>
		<% for(Review b : list){ %>
		<tr>
			<td>
				<%= b.getMemId() %>
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
		

	<%--글작성자/관리자인경우 게시글 수정삭제버튼 보일수 있게 함 --%>
	<% if(memberLoggedIn!=null &&
		(b.getMemId().equals(memberLoggedIn.getMemId())
		|| "A".equals(memberLoggedIn.getMemRole())) ){ %>
	<tr>
		<th colspan="2">
			<input type="button" value="수정하기"
				   onclick="updateReview();"/>
			<input type="button" value="삭제하기" onclick="deleteReview();"/>
		</th>
	</tr>
	<%} %>	
	
</table>
<!-- end of table#tbl-board-view -->
<hr style="margin-top:30px;" />	
<div class="comment-container">
    <%-- text-area 포커스, 등록버튼을 누른 경우 로그인여부를 검사해서 경고창을 띄어줌. --%>
    <div class="comment-editor">
    
    
    
    <!-- ssssssssssssssssssssssssssssss -->
    
    
    
        <form action="<%=request.getContextPath()%>/review/reviewCommentInsert"
        	  method="post"
        	  name="reviewCommentFrm">
        	<input type="hidden" name="memId" value="<%=memberLoggedIn!=null?memberLoggedIn.getMemId():""%>"/>
        	<input type="hidden" name="commentContent" value="0"/>
            <textarea name="reviewCommentContent" cols="60" rows="3"></textarea>
            <button type="submit" id="btn-insert">등록</button>
        </form>
    </div>
</div>
<% } %>
<script>
$(function(){
	$("[name=commentContent]").click(function(){
		if(<%=memberLoggedIn == null%>)
			loginAlert();
	});
	$("[name=commentFrm]").submit(function(e){
		//로그인 여부 검사
		if(<%=memberLoggedIn == null%>){
			loginAlert();
			return false;			
		}
		//내용검사
		var content = $("[name=commentContent]").val().trim();
		if(content.length == 0){
			return false;
		}
		return true;
	});
});
function loginAlert(){
	alert("로그인후 이용하실 수 있습니다.");
	$("#login-memId").focus();
}
</script>
</section>
