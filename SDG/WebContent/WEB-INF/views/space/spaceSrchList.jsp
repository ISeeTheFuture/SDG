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

	<form action="">
		<select name="spcLoc" id="spcLoc">
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
		<input type="text" name="srchWord" id="srchWord" value="<%=request.getParameter("spcSrch")%>" />
		<button id="btn1">검색</button>
	</form>

	<script>
		$("#btn1").click(function(){
			$.ajax({
				url: "<%=request.getContextPath()%>/space/spaceSrchEnd.do",
				dataType: "json",
	            data: { 
	                srchWord: $("#srchWord").val(),
	                spcLoc:$("#srchLoc").val(),
	                spcType:$("#srchType").val()
	            },
				success: data => {
					console.log(data);
					
					var SrchResult = "";
					
					$.each(data, function(idx, member){ // 배열 요소당 한번씩 콜백함수를 호출
						SrchResult += "<div width="150px" height="130px"><img src="" alt="" srcset="" width="150px" height="100px">";
						SrchResult += "<h1>타이틀</h1>";
						SrchResult += "<h4>위치</h4>";
						SrchResult += "<h4>공간유형</h4>";
						SrchResult += "<h3>가격</h3>";
						SrchResult += "<form action=""><input type="hidden" name="spcNo" id="spcNo" value="">";
						SrchResult += "<input type="hidden" name="spcDetNo" id="spcDetNo" value=""></form></div>";
					});
					$("SrchResultList").html(SrchResult);
					
				},
				error: (x,s,e) =>{
					//x : xhr
					//s : testStatus
					//e : errorThrown
					console.log(x,s,e);
				}
			});
		});
	</script>

</body>
</html>