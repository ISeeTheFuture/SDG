<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="review.model.vo.*" %>
<%
	Review b = (Review)request.getAttribute("review");
%>

<script>
function reviewValidate(){
	var content = $("[name=content]").val();
	//console.log(content.length)
	if(content.trim().length==0){
		alert("내용을 입력하세요");
		return false;
	}
	return true;
}
function reviewView(){
	history.go(-1);
}
</script>
<section id="review-container">
<h2>게시판 작성</h2>
<form action="<%=request.getContextPath() %>/review/reviewUpdateEnd" 
	  method="post" 
	  enctype="multipart/form-data">
  <input type="hidden" name="boardNo" value="<%=b.getReviewNo() %>" />
  <table id="tbl-board-view">
	<tr>
		<th>제 목</th>
		<td><input type="text" name="boardTitle" value="<%=b.getReviewTitle()%>" required></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>
			<%-- <input type="text" name="boardWriter" value="<%=b.getBoardWriter()%>" readonly/> --%>
		</td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td style="position:relative;">
			<input type="file" name="upFile" >
			<%-- <span id="fname"><%=b.getOriginalFileName()!=null?b.getOriginalFileName():"" %></span> --%>
			<%-- 기존첨부파일 유지를 위해 기존파일명을 hidden으로 전송한다. --%>
			<!-- <input type="hidden" name="oldOriginalFileName" -->
			<%--        value="<%=b.getOriginalFileName()!=null?b.getOriginalFileName():"" %>" /> --%>
			<!-- <input type="hidden" name="oldRenamedFileName" -->
			       <%-- value="<%=b.getRenamedFileName()!=null?b.getRenamedFileName():"" %>" /> --%>
			
		</td>
	</tr>
	<tr>
		<th>내 용</th>
		<td><textarea rows="5" cols="50" name="reviewContent"><%=b.getReviewContent() %></textarea></td>
	</tr>
	<tr>
		<th colspan="2">
			<input type="submit" value="수정하기" onclick="return boardValidate();">
			<input type="button" value="취소" onclick="reviewView();">
		</th>
	</tr>
</table>
</form>
</section>
<script>
$(function(){
	$("[name=upFile]").change(function(){
		let fname = $(this).val(); 
		//첨부파일이 있는 경우
		if(fname != ""){
			$("#fname").hide();
		}
		//첨부파일이 없는 경우
		else {
			$("#fname").show();
		}
	});
});

</script>
