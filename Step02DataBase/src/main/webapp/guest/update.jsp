<%@page import="test.guest.dao.GuestDao"%>
<%@page import="test.guest.dto.GuestDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   //한글 깨지지 않도록
   request.setCharacterEncoding("utf-8");
   //1. 폼 전송되는 수정할 회원의 정보를 얻어온다.
   int num=Integer.parseInt(request.getParameter("num"));
   String name=request.getParameter("name");
   String content=request.getParameter("content");
   //2. DB 에 수정 반영한다.
   GuestDto dto=new GuestDto(num, name, content );
   boolean isSuccess=GuestDao.getInstance().update(dto);
   //3. 결과를 응답한다
%>        
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<body>
 <div class="container mt-5">
      <h1>알림</h1>
      <%if(isSuccess){ %>
         <p class="alert alert-success">
            <strong><%=num %></strong> 번 회원의 정보를 수정했습니다.
            <a class="alert-link" href="list.jsp">목록보기</a>
         </p>
      <%}else{ %>
         <p class="alert alert-danger">
            수정실패!
            <a class="alert-link" href="updateform.jsp?num=<%=num %>">다시 수정</a>
         </p>
      <%} %>
</body>
</html>