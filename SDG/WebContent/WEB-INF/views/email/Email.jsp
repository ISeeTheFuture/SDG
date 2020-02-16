<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의하기</title>
</head>
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
<script>
	function validate() {
		let subject = $('#subject').val();
		let content = $('#content').val();
		let result = 1;
		
		if (subject == "") {
			$("#subject").css("border", "3px solid red");
			$("#subject").val("제목을 입력해주세요");
			result = 0;
			
		} else if (content == "") {
			$("#content").css("border", "3px solid red");
			$("#content").val("내용을 입력해주세요");
			result = 0;
		}
			if (result == 0) {
				return false;
			}
			return true;
		}
</script>
<style>
.detinfo {
	font-size: 2em;
}

.divider-text {
	position: relative;
	text-align: center;
	margin-top: 15px;
	margin-bottom: 15px;
}

.divider-text span {
	padding: 7px;
	font-size: 12px;
	position: relative;
	z-index: 2;
}

.divider-text:after {
	content: "";
	position: absolute;
	width: 100%;
	border-bottom: 1px solid #ddd;
	top: 55%;
	left: 0;
	z-index: 1;
}

.input-group-text {
	min-width: 90px;
}

p.text-center {
	font-size: 2em;
}
</style>
<body>

	<div class="container">
		<br>
		<p class="text-center">문의하기</p>
		<hr>
	</div>
	
	<div class="card bg-light">
		<article class="card-body mx-auto" style="max-width: 400px;">
		
		<form action="<%=request.getContextPath() %>/email/EmailEnd" method="post" class="card-body mx-auto" onsubmit="return validate();">
            
            
				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">제목</span>
					</div>
					<input type="text" name="subject" id="subject" class="form-control" />
				</div>            
            
       				<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text">내용</span>
					</div>
					<textarea name="content" id="content" class="form-control" style="width:350px; height:200px;" placeholder="회신받으실 메일 기입해주세요"/></textarea>
				</div>
				
				<div class="form-group">
					<button class="btn btn-primary btn-block">문의하기</button>
				</div>			
				
				
				
				<input type="hidden" name="from" value="swgo92@naver.com"/>
				<input type="hidden" name="to" value="swgo92@naver.com"/>
				   
				   
				 
            
        </form>
        </article>
        </div>
</body>
</html>