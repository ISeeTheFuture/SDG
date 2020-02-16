<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>	
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

		<select name="spcLoc" id="spcLoc">		
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
		<select name="spcType" id="spcType">
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
		<input type="text" name="srchWord" id="srchWord" value="<%=request.getParameter("spcSrch")==null?"":request.getParameter("spcSrch")%>" />
		<button type="button" id="btn1">검색</button>
		
		<div id="SrchResultList">
			
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
					
 					var SrchResult = "<h1>검색결과</h1>";
 					
 					$.each(data, function(idx, d){ // 배열 요소당 한번씩 콜백함수를 호출
 						var tmp = "<%=request.getContextPath()%>/upload/"+d.spcImgTitle;
 						var act = "<%=request.getContextPath()%>/space/spaceView";
						SrchResult += "<div width='400px' height='260px' name='srchContent"+d.spcDetNo+"' class='srchContent'><form method='post' action="+act+" id='srchContent"+d.spcDetNo+"'><img src="+tmp+" alt='' srcset='' width='400px' height='230px'>";
 						SrchResult += "<h1>"+d.spcName+"</h1>";
						SrchResult += "<h4>"+d.spcLocationName+"/"+d.spcTypeName+"</h4>";
						SrchResult += "<h3>"+d.spcPricePrice+"</h3>";
						SrchResult += "<input type='hidden' name='spcNo' class='spcNo' value="+d.spcNo+">";
						SrchResult += "<input type='hidden' name='spcDetNo' class='spcDetNo' value="+d.spcDetNo+"></form></div>";
					});
					$("#SrchResultList").html(SrchResult);
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