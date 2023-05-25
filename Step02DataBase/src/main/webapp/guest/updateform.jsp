<%@page import="test.guest.dao.GuestDao"%>
<%@page import="test.guest.dto.GuestDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//1.수정할 회원의 번호를 얻어낸다 .
int num=Integer.parseInt(request.getParameter("num"));
//2.번호를 이용해 db에 저장된 수정할 회원의 정보를 얻어낸다.
GuestDto dto=GuestDao.getInstance().getData(num);
//3.수정할 양식을 클라이언트에게 응답한다.
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>글 정보 수정 양식 </h1>
		<form action="update.jsp" method="post">
<div>
            <label class="form-label" for="num">번호</label>
            <input class="form-control" type="text" id="num" name="num" value="<%=dto.getNum()%>"/>
         </div>
         <div>
            <label class="form-label" for="name">이름</label>
            <input class="form-control" type="text" id="name" name="name" value="<%=dto.getName()%>"/>
         </div>
         <div>
            <label class="form-label"  for="addr">내용</label>
            <input class="form-control" type="text" id="content" name="dontent" value="<%=dto.getContent()%>"/>
         </div>
         <button class="btn btn-outline-primary" type="submit">수정확인</button>
         <button class="btn btn-outline-primary" type="reset">취소</button>
      </form>
   </div>
</body>
</html>