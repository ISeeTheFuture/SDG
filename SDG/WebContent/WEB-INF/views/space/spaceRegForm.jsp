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
	
	<%String cat = request.getParameter("cat");%>

	<form action="<%=request.getContextPath()%>/space/spaceRegformEnd" method="POST">
		<input type="hidden" name="cat" value="<%=cat %>" />
		
		<label for="spcName">회사명 : </label>
		<br />	
		<input type="text" name="spcName" id="spcName" />
		<br />	
		
		<label for="compAddr">회사주소 :</label>
		<input type="text" name="compAddr" id="compAddr" />
		<br />
		
		<label for="compContent">회사 소개 :</label>
		<textarea name="compContent" id="compContent" /></textarea>
		<br />
		
		
		<br />
		<br />
		<select name="region" id="region">
			<option disabled selected value>지역</option>
			<option disabled>----------</option>
			<option value="1">서울특별시</option>
			<option value="2">경기도</option>
			<option value="3">인천광역시</option>
			<option value="4">세종특별시</option>
			<option value="5">충청북도</option>
			<option value="6">충청남도</option>
			<option value="7">강원도</option>
			<option value="8">대전광역시</option>
			<option value="9">대구광역시</option>
			<option value="10">경상북도</option>
			<option value="11">경상남도</option>
			<option value="12">부산광역시</option>
			<option value="13">울산광역시</option>
			<option value="14">전라북도</option>
			<option value="15">전라남도</option>
			<option value="16">광주광역시</option>
			<option value="17">제주도</option>
		</select>
		
		<br />
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
		<input type="range" name="spcHourStart" id="spcHourStart" min="1" max="24"/>
		<br />	
		<label for="spcHourEnd">운영 마감 시각</label>
		<input type="range" name="spcHourEnd" id="spcHourEnd" min="1" max="24" />		
		<hr />			
		<br />
		
		<label for="spcDetHoliday">공휴일 휴무 여부</label>
		<input type="checkbox" name="spcDetHoliday"value="1"/>
		<input type="hidden" name="spcDetHoliday" value="0"/>
		
		<br />
		<br />
		
		<button>등록</button>
		
	</form>
	
</body>
</html>