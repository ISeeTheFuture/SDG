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
	            },
				success: data => {
					console.log(data);
					
					var memberInfo = "<tr><th>프로필</th><th>이름</th><th>전화번호</th></tr>";
					
					$.each(data, function(idx, member){ // 배열 요소당 한번씩 콜백함수를 호출
						memberInfo += "<tr><td><img src='<%=request.getContextPath()%>/images/"+member.profile+"'/></td>";
						memberInfo += "<td>"+member.name+"</td>";
						memberInfo += "<td>"+member.phone+"</td></tr>";
					});
					$("#memberInfo").html(memberInfo);
					
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