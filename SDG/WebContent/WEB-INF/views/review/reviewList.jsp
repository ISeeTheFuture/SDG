<%@page import="review.model.vo.ReviewComment"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="review.model.vo.Review, java.util.List" %>

<%
Review review = (Review)request.getAttribute("review");
List<Review> list = (List<Review>)request.getAttribute("list");
String pageBar = (String)request.getAttribute("pageBar");
int totalReviewCount = (int)request.getAttribute("totalReviewCount");
int AvgStar = (int)request.getAttribute("AvgStar");
ReviewComment reviewComment = (ReviewComment)request.getAttribute("reviewComment");
List<ReviewComment> commentList
= (List<ReviewComment>)request.getAttribute("commentList");
Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn");
%>

<section id="board-container">
<h2>이용후기</h2>
<table id="tbl-board-view">
<% for(Review review1 : list){ %>
	<tr>
		
		<td><%=review1.getMemId() %></td>
	</tr>
	<tr>
		<td><%=review1.getReviewTitle() %></td>
	</tr>
	<tr>
		
		<td><%=review1.getReviewContent() %></td>
	</tr>
	<tr>
		
		<td><%=review1.getReviewStar() %></td>
	</tr>
	
	<%--글작성자/관리자인경우 게시글 수정삭제버튼 보일수 있게 함 --%>
	<% if(memberLoggedIn!=null &&
		(review1.getMemId().equals(memberLoggedIn.getMemId())
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
        <form action="<%=request.getContextPath()%>/review/reviewCommentInsert"
        	  method="post"
        	  name="reviewCommentFrm">
        	<input type="hidden" name="memId" value="<%=memberLoggedIn!=null?memberLoggedIn.getMemId():""%>"/>
        	
            <textarea name="commentContent" ></textarea>
            <button type="submit" id="btn-insert">등록</button>
        </form>
    </div>
</div>
<%} %>	
<script>
$(function(){
	$("[name=commentContent]").click(function(){
		if(<%=memberLoggedIn == null%>)
			loginAlert();
	});
	$("[name=reviewCommentFrm]").submit(function(e){
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
	$("#login-membId").focus();
}
</script>
<!-- 댓글목록테이블 -->
<table id="tbl-comment">
<%
	if(commentList != null){
		for(ReviewComment bc : commentList){
		/* 	if(bc. == 1){ */
%>		
		<tr class="level1">
			<td>
				<sub class="comment-writer"><%=bc.getMemId() %></sub>
				<sub class="comment-date"><%=bc.getCommentDate() %></sub>
				<br />
				<%=bc.getCommentContent() %>
			</td>
			<td>
				<button class="btn-reply"
						value="<%=bc.getCommentNo()%>">답글</button>
						<%if(memberLoggedIn!=null && (bc.getMemId().equals(memberLoggedIn.getMemId()) || "A".equals(memberLoggedIn.getMemRole())
								)){%>
								<button class="btn-delete" value="<%=bc.getCommentNo() %>">삭제</button>
								<%} %>
			</td>		
		</tr>		
<%
			/* } else { */
%>				
		<%-- <tr class="level2">
			<td>
				<sub class="comment-writer"><%=bc.getBoardCommentWriter() %></sub>
				<sub class="comment-date"><%=bc.getBoardCommentDate() %></sub>
				<br />
				<%=bc.getBoardCommentContent() %>
			</td>
			<td>
									<%if(memberLoggedIn!=null && (bc.getBoardCommentWriter().equals(memberLoggedIn.getMemberId()) || "A".equals(memberLoggedIn.getMemberRole())
								)){%>
								<button class="btn-delete" value="<%=bc.getBoardCommentNo() %>">삭제</button>
								<%} %>
			</td>		
		</tr>	 --%>
<%		
			}//end of if(level)
		}//end of for
	//end of if(commentList)
%>
</table>
</section>


<!-- 게시물삭제폼 -->
<%-- <form action="<%=request.getContextPath()%>/review/reviewDelete"
	  name="reviewDelFrm"
	  method="POST">
	  <input type="hidden" name="reviewNo" value="<%=review.getReviewNo()%>"/>
	 
</form> --%>
<script>
//삭제버튼 클릭시 댓글 삭제후 현재페이지 돌아오기
$(".btn-delete").click(function(){
	if(!confirm('정말삭제하시겠습니까?'))
		return;
	location.href = "<%=request.getContextPath()%>/review/reviewCommentDelete?delNo="+$(this).val();
});
$(".btn-reply").click(function(){
	<%if(memberLoggedIn != null) {%>
	//현재댓글 번호
	var commentNo = $(this).val();
	//답글작성폼 생성
	var tr = $("<tr></tr>");
	var td = $("<td style='display:none;text-align:left;' colspan='2'></td>");
	var form = $("<form action='<%=request.getContextPath()%>/review/reviewCommentInsert' method='POST'></form>");
	form.append("<input type='hidden' name='reviewNo' value='<%=review.getReviewNo()%>'/>");
	form.append("<input type='hidden' name='memId' value='<%=memberLoggedIn != null?memberLoggedIn.getMemId():""%>'/>");
	form.append("<input type='hidden' name='commentNo' value='"+commentNo+"'/>");
	form.append("<textarea name='commentContent' cols='60' rows='1'></textarea>");
	form.append("<button type='submit' class='btn-insert2'>등록</button>;");
	td.html(form);
	tr.html(td);
	tr.insertAfter($(this).parent().parent())//tr>td>.btn-reply
	.children("td")
	.slideDown(800)
	.children("form")
	.submit(function(e){
		let content = $(this).children("textarea")
							.val()
							.trim();
		if(content.length == 0)
			e.preventDefault();
	})
	.find("textare")
	.focus();
	//클릭이벤트 한번 실행후에는 핸들러 제거
	$(this).off('click');
	<%} else{%>
		loginAlert();
	<%}%>
});
function updateReview(){
	location.href
	= "<%=request.getContextPath()%>/review/reviewUpdate?reviewNo=<%=review.getReviewNo()%>";
}
function deleteReview(){
	if(!confirm("정말로 삭제하시겠습니까?"))
		return;
	$("[name=reviewDelFrm]").submit();
}
function fileDownload(oName, rName){
	oName = encodeURIComponent(oName);
	console.log(oName);
	location.href = "<%=request.getContextPath()%>/board/boardFileDownload"
				  + "?oName="+oName
			  	  + "&rName="+rName;
}
</script> 