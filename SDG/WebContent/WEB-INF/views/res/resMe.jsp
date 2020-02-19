<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
<div id="resContainer">
	<div class="row" >
    	<div class='col-md-4 center-block' style='float:none;margin:0 auto;'>
    		<hr />
    		<h2>예약 변경</h2>
    		<iframe src="<%=request.getContextPath()%>/res/resUpdate" width='600' height='540' frameborder=0 framespacing=0 marginheight=0 marginwidth=0 scrolling=no vspace=0></iframe>
		</div>			
	</div>
	<div class="row" id="resMeList">
					
	</div>
</div>

<div>

</div>

<script>
$(function(){
	$.ajax({
		url: "<%=request.getContextPath()%>/res/resMeEnd.do",
		type: "post",
        data: { 
            memberId: "<%=memberLoggedIn.getMemId()%>",
        },
		dataType: "json",
		success: function(data) {
				var resMeResult = "<div class='col-md-4 center-block' style='float:none;margin:0 auto;'><hr><h2>예약 내역<br></h1>";
				
				$.each(data, function(idx, d){ // 배열 요소당 한번씩 콜백함수를 호출
					var tmp = "<%=request.getContextPath()%>/upload/"+d.spcImgTitle;
					var act = "<%=request.getContextPath()%>/space/spaceView?spcNo="+d.spcNo;
					resMeResult += "<div class='card mb-4'><img class='card-img-top' src='"+tmp+"' alt='Card image cap' width='600px'><div class='card-body'>";
 					resMeResult += "<h2 class='card-title'>"+d.spcName+"</h2>";
					resMeResult += "<p class='card-text'>예약인원 : "+d.resMany+"명</br>예약시간: "+d.resTimeStart+"~"+d.resTimeEnd+"</br>예약가격 : "+d.spcPrice+"원</p>";
					resMeResult += "<a href='"+act+"' class='btn btn-primary'>후기 남기기 &rarr;</a>";
					resMeResult += "<input type='hidden' name='spcNo' class='spcNo' value="+d.spcNo+">";
					resMeResult += "<input type='hidden' name='spcTimeEnd' value="+d.resTimeEnd+">";
					resMeResult += "<input type='hidden' name='spcDetNo' class='spcDetNo' value="+d.spcDetNo+">";	
					resMeResult += "<input type='hidden' name='spcDetNo' class='spcDetNo' value="+d.spcDetNo+"></div></div>";	
			});
				resMeResult += "</div>";
			$("#resMeList").html(resMeResult);
		},
		error: (x,s,e) => {
			//x : xhr
			//s : testStatus
			//e : errorThrown
			console.log(x,s,e);
		}, complete: function(data) {
/* 			$(".srchContent").click(function(){
				var srchNo = $(this).attr('name')
				$("#"+srchNo+"").submit();
			}); */
		}
	});
});
</script>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>