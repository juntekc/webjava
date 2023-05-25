<%@page import="java.util.List"%>
<%@page import="test.guest.dto.GuestDto"%>
<%@page import="test.guest.dao.GuestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%
    // GuestDao 객체의 참조값
    GuestDao dao = GuestDao.getInstance();
    // 회원 목록 얻어오기
    List<GuestDto> list = dao.getList();
%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
    <title>Guest List</title>
</head>
<body>
    <div class="container">
        <h3 class="text-end">회원 목록입니다.</h3>
        <div class="text-end">
            <a href="insertform.jsp" class="btn btn-primary">글 추가</a>
        </div>
        <table class="table table-dark table-striped-columns">
            <thead>
                <tr>
                    <th>번호</th>            
                    <th>작성자</th>
                    <th>내용</th>
                    <th>등록일</th>
                    <th>수정</th>
                    <th>삭제</th>
                </tr>
            </thead>
            <tbody>
                <% for(GuestDto dto : list) { %>
                    <tr>
                        <td><%= dto.getNum() %></td>
                        <td><%= dto.getName() %></td>
                        <td><%= dto.getContent() %></td>
                        <td><%= dto.getDate() %></td>
                        <td><a href="updateform.jsp?num=<%= dto.getNum() %>" class="btn btn-warning">수정</a></td>
                        <td><a href="delete.jsp?num=<%= dto.getNum() %>" class="btn btn-danger">삭제</a></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>