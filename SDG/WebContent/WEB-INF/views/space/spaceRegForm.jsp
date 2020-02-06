<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/space/spaceRegformEnd" method="POST">
		<label for="spcName">공간명 : </label>
		<br />	
		<input type="text" name="spcName" id="spcName" />
		<br />	
		
		<br />
		<br />
		<select name="region" id="region">
			<option disabled selected value>지역</option>
			<option disabled>----------</option>
			<option value="seoul">서울특별시</option>
			<option value="gyeonggi">경기도</option>
			<option value="incheon">인천광역시</option>
			<option value="sejong">세종특별시</option>
			<option value="choongbuk">충청북도</option>
			<option value="choongnam">충청남도</option>
			<option value="gangwon">강원도</option>
			<option value="daejeon">대전광역시</option>
			<option value="daeggu">대구광역시</option>
			<option value="gyeongbuk">경상북도</option>
			<option value="gyeongnam">경상남도</option>
			<option value="busan">부산광역시</option>
			<option value="ulsan">울산광역시</option>
			<option value="jeonbuk">전라북도</option>
			<option value="jeonnam">전라남도</option>
			<option value="gwangju">광주광역시</option>
			<option value="jeju">제주도</option>
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
		<input type="time" name="spcHourStart" id="spcHourStart" />
		<br />	
		<label for="spcHourEnd">운영 마감 시각</label>
		<input type="time" name="spcHourEnd" id="spcHourEnd" />		
		<hr />			
		<br />
		
		<label for="spcDetHoliday">공휴일 휴무 여부</label>
		<input type="checkbox" name="spcDetHoliday" value="false" />
		
		
		<br />
		<br />
		
		<button>등록</button>
		
	</form>
</body>
</html>