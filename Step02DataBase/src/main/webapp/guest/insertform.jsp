<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">

</head>
<body>
 
	<form action="insert.jsp" method="post">  
		
		<div> <!-- 마진 바텀을 1단계로 늘림.  -->
			<label for="name">작성자</label>
			<input  type="text" id="name" name="name"/>
		</div>
		
		<div class="mb-1">
			<label for="content">내용</label>
		<textarea for="content" name="content"
          	rows="3" cols="20">
		</textarea>	 
		</div>
		
		<div class="mb-1">
			<label for="date" class="form-Label">등록일</label>
			<input   type="text" id="date" name="date"/>
		</div>
		
		<button type="submit">글 추가</button>
	</form>	
</div>	
</body>
</html>