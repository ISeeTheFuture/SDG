<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
</head>
<body>
	<form action="<%=request.getContextPath()%>/space/spaceRegformEnd">
		<label for="spcName">공간명 : </label>
		<br />	
		<input type="text" name="spcName" id="spcName" />
		<br />	
		
		<label for="addr">주소 : </label>
		<br />	
		<input type="text" name="addr" id="addr" />
		
		<br />	
		<label for="spcContent">공간 소개 : </label>
		<br />	
		<textarea name="spcContent" id="spcContent" /></textarea>
		<br />	
		
		<label for="spcDetSize">크기(m2) : </label>
		<br />	
		<input type="number" name="spcDetSize" id="spcDetSize" />
		<br />	
		
		<label for="spcDetStorable">수용가능인원 : </label>
		<br />	
		<input type="number" name="spcDetStorable" id="spcDetStorable" />
		<br />	
		
		<label for="spcManMin">최소 인원 : </label>
		<br />	
		<input type="number" name="spcManMin" id="spcManMin" min="1" placeholder="1"/>
		<br />	
		
		<label for="spcManMax">최대 인원 : </label>
		<br />	
		<input type="number" name="spcManMax" id="spcManMax" min="1" placeholder="1"/>
		<br />
			
		<label for="spcTimeMin">최소 시간 : </label>
		<br />	
		<input type="number" name="spcTimeMin" id="spcTimeMin" min="1" placeholder="1"/>
		<br />	
			
		<label for="spcTimeMax">최대 시간 : </label>
		<br />	
		<input type="number" name="spcTimeMax" id="spcTimeMax" min="1" placeholder="1"/>
		<br />
			
		<label for="spcDateStart">운영 시작 시간 : </label>
		<br />	
		<input type="date" name="spcDateStart" id="spcDateStart"/>
		<br />	
			
		<label for="spcDateEnd">운영 종료 시간 : </label>
		<br />	
		<input type="date" name="spcDateEnd" id="spcDateEnd"/>
		<br />	
		
		<hr />
		<h3>주중 운영일 : </h3>
		<hr />
		월요일 :	
		<input type="checkbox" name="spcDay" value="mon" />
		<span style="border-right:2px solid gray;width:1px;"></span>
		화요일 :
		<input type="checkbox" name="spcDay" value="tue" />
		<span style="border-right:2px solid gray;width:1px;"></span>
		수요일 :
		<input type="checkbox" name="spcDay" value="wed" />
		<span style="border-right:2px solid gray;width:1px;"></span>
		목요일 :
		<input type="checkbox" name="spcDay" value="thu" />
		<span style="border-right:2px solid gray;width:1px;"></span>
		금요일 :
		<input type="checkbox" name="spcDay" value="fri" />
		<span style="border-right:2px solid gray;width:1px;"></span>
		토요일 :
		<input type="checkbox" name="spcDay" value="sat" />
		<span style="border-right:2px solid gray;width:1px;"></span>
		일요일 :
		<input type="checkbox" name="spcDay" value="sun" />
		<span style="border-right:2px solid gray;width:1px;"></span>	
		<br />	
		<br />	
		<hr />
		<label for="spcHourStart">운영 시작 시각</label>
		<input type="time" name="spcHourStart" id="spcHourStart" />
		<br />	
		<label for="spcHourEnd">운영 마감 시각</label>
		<input type="time" name="spcHourEnd" id="spcHourEnd" />		
		<hr />			
		<br />
		
		<label for="spcDetHoliday">공휴일 휴무 여부</label>
		<input type="checkbox" name="spcDetHoliday" id="spcDetHoliday" value=""/>
		

		
	</form>
</body>
<script>
	
$(document).ready(function(){
    $("#spcDetHoliday").change(function(){
        if($("#spcDetHoliday").is(":checked")){
    		$("#spcDateHoliday").val(1);
        }else{
    		$("#spcDateHoliday").val(0);
        }
    });
});

</script>
</html>