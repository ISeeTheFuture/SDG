<%@ include file="/WEB-INF/views/common/header.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
<meta charset="UTF-8">
<title>spaceSrchList</title>
</head>
<body>
		<hr />
		<div class="container">
			<div class="col-xs-8 col-xs-offset-2">
				<div class="input-group">
					<select name="spcLoc" id="spcLoc" class="btn btn-secondary dropdown-toggle">		
						<option value="0">전체</option>
						<option value="1">서울</option>
						<option value="2">경기도</option>
						<option value="3">인천</option>
						<option value="4">세종</option>
						<option value="5">충청북도</option>
						<option value="6">충청남도</option>
						<option value="7">강원도</option>
						<option value="8">대전</option>
						<option value="9">대구</option>
						<option value="10">경상북도</option>
						<option value="11">경상남도</option>
						<option value="12">부산</option>
						<option value="13">울산</option>
						<option value="14">전라북도</option>
						<option value="15">전라남도</option>
						<option value="16">광주</option>
						<option value="17">제주도</option>
					</select>
					<select name="spcType" id="spcType" class="btn btn-secondary dropdown-toggle">
						<option value="0">전체</option>
						<option value="1">회의실</option>
						<option value="2">다목적홀</option>
						<option value="3">레저시설</option>
						<option value="4">파티룸</option>
						<option value="5">공연장</option>
						<option value="6">카페</option>
						<option value="7">스터디룸</option>
						<option value="8">독립오피스</option>
						<option value="9">코워킹오피스</option>
						<option value="10">일하기좋은카페</option>			
					</select>
					<div class="col-xs-4">
						<input type="text" name="srchWord" id="srchWord" value="<%=request.getParameter("spcSrch")==null?"":request.getParameter("spcSrch")%>"  class="form-control" placeholder="Search spaces..."/>
					</div>
					<button type="button" id="btn1" class="btn btn-secondary">검색</button>
				</div>
			</div>
		</div>
		
		<hr />
		
		<div id="SrchResultList" class="container">
			
		</div>
		
	<script>
	
		$(function(){ // 온로드 함수
			$("#btn1").trigger("srchStart");
		});
	
		$("#btn1").click(function(){ // 즉시 실행이 한 번 필요해서 바인드 방식으로 클릭 처리
			$("#btn1").trigger("srchStart");	
		})

			
		$("#btn1").bind("srchStart", function(){
			$.ajax({
				url: "<%=request.getContextPath()%>/space/spaceSrchEnd.do",
				type: "post",
	            data: { 
	                srchWord: $("#srchWord").val(),
	                spcLoc:$("#spcLoc").val(),
	                spcType:$("#spcType").val()
	            },
				dataType: "json",
				success: function(data) {
					
 					var srchResult = "<div class='row'><div class='row'>";
 					
 					$.each(data, function(idx, d){ // 배열 요소당 한번씩 콜백함수를 호출
 						var tmp = "<%=request.getContextPath()%>/upload/"+d.spcImgTitle;
 						var act = "<%=request.getContextPath()%>/space/spaceView";
 						srchResult += "<div class='srchContent col-lg-4 col-md-6 mb-4' name='srchContent"+d.spcDetNo+"'><form method='post' action="+act+" id='srchContent"+d.spcDetNo+"'><div class='card h-100'><img class='card-img-top' src="+tmp+" alt='' width='700px' height='300px'>";
 						srchResult += "<div class='card-body'><h4 class='card-title'>"+d.spcName+"</h4>";
 						srchResult += "<h5>"+d.spcPricePrice+"원/시간(인)</h5>";
 						srchResult += "<p class='card-text'>"+d.spcLocationName+"/"+d.spcTypeName+"</p></div>";
 						srchResult += "<div class='card-footer'><small class='text-muted'>&#9733; &#9733; &#9733; &#9733; &#9734;</small>";
 						srchResult += "<input type='hidden' name='spcNo' class='spcNo' value="+d.spcNo+">";
						srchResult += "<input type='hidden' name='spcDetNo' class='spcDetNo' value="+d.spcDetNo+"></form></div></div></div>";	
					});
 					srchResult += "</div></div>";
					$("#SrchResultList").html(srchResult);
				},
				error: (x,s,e) => {
					//x : xhr
					//s : testStatus
					//e : errorThrown
					console.log(x,s,e);
				}, complete: function(data) {
					$(".srchContent").click(function(){
						var srchNo = $(this).attr('name')
						$("#"+srchNo+"").submit();
					});
				}
			});
		});
		


		
	</script>

</body>
</html>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>	