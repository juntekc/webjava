<%@page import="test.guest.dao.GuestDao"%>
<%@page import="test.guest.dto.GuestDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% 
    request.setCharacterEncoding("utf-8");
    String name = request.getParameter("name");
    String content = request.getParameter("content");
    String date = request.getParameter("date");

    GuestDto dto = new GuestDto();
    dto.setName(name);
    dto.setContent(content);
    dto.setPwd("1111");
    dto.setDate(date);

    GuestDao dao = GuestDao.getInstance();
    boolean isSuccess = dao.insert(dto);
%>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">  
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <div class="container">
        <h1>알림</h1>
        <% if (isSuccess) { %>
            <p class="alert alert-success">
                <strong><%= name %></strong>님의 글이 저장되었습니다.
                <a href="list.jsp">확인</a>
            </p>
        <% } else { %>
            <p class="alert alert-warning">
                글 저장 실패!
                <a class="alert-link" href="insertform.jsp">다시 작성</a>
            </p>
        <% } %>	
    </div>
</body>
</html>