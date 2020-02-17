<%@page import="jdk.internal.org.objectweb.asm.tree.FieldNode"%>
<%@page import="java.lang.reflect.Parameter"%>
<%@page import="java.util.List"%>
<%@page import="review.model.vo.Review"%>
<%@page import="review.model.vo.ReviewComment"%>
<%@page import="member.model.vo.Member"%>
<%@page import="res.model.vo.Res"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	Res res = (Res) request.getAttribute("res");
	Member memberLoggedIn = (Member) session.getAttribute("memberLoggedIn");
	int totalReviewCount = (int) request.getAttribute("totalReviewCount");
	int avgStar = (int) request.getAttribute("AvgStar");
	List<ReviewComment> commentList = (List<ReviewComment>) request.getAttribute("commentList");
	List<Review> list = (List<Review>) request.getAttribute("list");
	String pageBar = (String) request.getAttribute("pageBar");
	Review review = (Review) request.getAttribute("review");
%>



<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
<style>
.row {
	display: -ms-flexbox;
	display: flex;
	-ms-flex-wrap: wrap;
	flex-wrap: wrap;
	margin-right: -41px;
	margin-left: -11px;
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

.btn-facebook {
	background-color: #405D9D;
	color: #fff;
}

.btn-twitter {
	background-color: #42AEEC;
	color: #fff;
}

.input-group-text {
	min-width: 100px;
	text-align: center;
}

#gender1 {
	align: center;
	margin-left: 50px;
}

input#memId {
	text-align: center;
}

input#spc_no {
	text-align: center;
}

div.col {
	left: 20px;
	text-align: center;
	padding: 0 0 0 0px;
}

h4.card-title mt-3 text-center {
	font-size: 15px;
	margin: 0 0 0 0px;
}

input#memId {
	margin: 0 36 0 0px;
}
</style>

<article class="card-body mx-auto" style="max-width: 550px;">
	<form action="<%=request.getContextPath()%>/review/reviewFormEnd"
		name="memberEnrollFrm" method="post">

		<h4 class="card-title mt-3 text-center">이용후기 작성하기</h4>


		<div class="form-group input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">아이디</span>
			</div>
			<input type="text" name="memId" id="memId"
				value="<%=memberLoggedIn.getMemId()%>" readonly> <span
				class="input-group-text">별점</span> <select name="reviewStar"
				id="reviewStar" maxlength="11" required>
				<option value="5">★★★★★</option>
				<option value="4">★★★★☆</option>
				<option value="3">★★★☆☆</option>
				<option value="2">★★☆☆☆</option>
				<option value="1">★☆☆☆☆</option>
			</select>
		</div>
		<!-- form-group// -->




		<div class="form-group input-group">


			<input type="hidden" value="<%=request.getParameter("spcNo")%>"
				name="fieldNo" id="fieldNo" placeholder="사업장 번호 입력.">




			<div class="form-group input-group">
				<div class="input-group-prepend">
					<span class="input-group-text">내용</span>
				</div>
				<textarea name="reviewContent" class="form-control" rows="5"
					name="content" id="content" placeholder="내용을 입력해 주세요"></textarea>
			</div>
			<!-- form-group// -->
			<div class="form-group"></div>
			<!-- form-group// -->





			<!--container end.//-->
		</div>
		<button type="submit" class="btn btn-primary btn-block">등록</button>
	</form>
</article>




<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"
	integrity="sha384-6khuMg9gaYr5AxOqhkVIODVIvm9ynTT5J4V1cfthmT+emCG6yVmEZsRHdxlotUnm"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/custom.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/login.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/galleria.css">
<link
	href="https://fonts.googleapis.com/css?family=Yeon+Sung&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Noto+Serif+KR&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Black+Han+Sans|Yeon+Sung&display=swap"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/b39f3be55a.js"
	crossorigin="anonymous"></script>
<style>
div#pagebar {
	text-align: center;
	font-size: 10px;
}

body {
	font-family: 'Black Han Sans', sans-serif;
}

div#content.col {
	font-size: 20px;
}

div#memId.col {
	text-align: left;
	color: color: #656565;
	font-size: 25px;
}

div.rbox_info_base {
	font-size: 10px;
}

div.container.body-content {
	font-size: 10px;
	max-width: 648px;
}

h5.h_intro {
	font-size: 18px;
	right: 15px;
	margin: 0 0 -12px 60px;
}

div#memId.col {
	font-size: 15px;
}

div#content.col {
	font-size: 12px;
	text-align: left;
}

div#like.col {
	text-align: right;
	margin: 0 97px 0px 0px;
}

div.rbox_info_base {
	text-align: right;
	margin: 0 97px 0px 0px;
}
</style>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width">
<title>HTML Result</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<div class="container body-content">
		<h5 class="h_intro">
			이용 후기 <strong class="txt_primary"><em><%=totalReviewCount%></em>개</strong>
			<span class="dot"></span> 평균 평점 <strong class="txt_primary"><em><%=avgStar%></em>점</strong>
		</h5>
		<div id="button" class="col" style="padding-top: 10px;">
			<table id="button">
				<tr>
					<td>

						</div>
					</td>
				</tr>
				<tr>
					-top
					<td>
						<%
							if (memberLoggedIn != null && "1".equals(memberLoggedIn.getMemAdmin())) {
						%>
						<button class="btn btn-primary"
							onclick="location.href='<%=request.getContextPath()%>/review/reviewRprtPrcss'">신고게시글확인</button>
						<%
							}
						%>
					</td>
				</tr>
			</table>
			<%
				for (Review b : list) {//2
			%>

			<div class="container">
				<div class="row justify-content-start" style="padding-top: 10px;">

					<div id="memId" class="col" style="padding-top: 10px;">
						<strong class="guest_name"><%=b.getMemId()%></strong>
						<p class="p_review"></p>


					</div>

					<div id="like" class="col" style="padding-top: 10px;">

						<form
							action="<%=request.getContextPath()%>/review/reviewRecommend"
							method="post" name="">
							<button>
								<i
									onclick="location.href='<%=request.getContextPath()%>/review/reviewRecommend'"
									class="far fa-thumbs-up"></i>
							</button>
						</form>

						<span class="rate_area"><span class="blind"><%=b.getReviewRecommend()%></span>
							개</span> <br> <span class="rate_area"><span class="blind"><%=b.getReviewStar()%></span>
							점</span>

					</div>
				</div>
				<div class="row justify-content-start" style="padding-top: 10px;">

					<div id="content" class="col" style="padding-top: 10px;">

						<%=b.getReviewContent()%>
					</div>

					<div id="date" class="col" style="padding-top: 10px;">

						<div class="rbox_info_base">
							<%=b.getReviewDate()%>
						</div>
						<div class="col" style="padding-top: 10px;">
							<%
								if (memberLoggedIn != null) {//1
							%>
							<table>

								<%
									}
								%>
								<%
									if (memberLoggedIn != null && b.getMemId().equals(memberLoggedIn.getMemId())
												|| "1" == memberLoggedIn.getMemAdmin()) {//6
								%>
								<form action="<%=request.getContextPath()%>/review/reviewUpdate"
									method="post" name="">
									<input type="hidden" name="reviewNo"
										value="<%=b.getReviewNo()%>" />

									<button>
										<i class="fas fa-cut"
											onclick="location.href='<%=request.getContextPath()%>/review/reviewUpdate'"></i>
									</button>

								</form>


								<form action="<%=request.getContextPath()%>/review/reviewDelete"
									method="post" name="">
									<input type="hidden" name="reviewNo"
										value="<%=b.getReviewNo()%>" />

									<button type="submit">
										<i class="fas fa-times"></i>
									</button>
									<%-- onclick="location.href='<%=request.getContextPath()%>/review/reviewDelete'" --%>
								</form>
								<%
									} //6
								%>

								<form action="<%=request.getContextPath()%>/review/reviewReport"
									method="post" name="">
									<input type="hidden" name="reviewNo"
										value="<%=b.getReviewNo()%>" />

									<button type="submit" id="btn-insert">
										<i class="fas fa-exclamation"
											onclick="location.href='<%=request.getContextPath()%>/review/reviewReport'"></i>
									</button>
								</form>
							</table>

						</div>

					</div>
				</div>

				<hr>
			</div>
			<%
				} //9
			%>
			<div id='pageBar'><%=pageBar%></div>
</body>
</html>



