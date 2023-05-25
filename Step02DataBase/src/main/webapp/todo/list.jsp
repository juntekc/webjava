<%@page import="test.todo.dao.TodoDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="test.todo.dto.TodoDto"%>
<%
    // TodoDao 객체의 참조값 얻어오기
    TodoDao dao = TodoDao.getInstance();
    // 할일 목록 얻어오기
    List<TodoDto> list = dao.getList();
%>	    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
<title>할일 목록</title>
</head>
<body>
<div class="text-end">
	<h1>할일 목록입니다.</h1>		
</div>	
<table class="table table-bordered border-primary">
	<thead>
		<tr>
			<th>순서</th>
			<th>할일</th>
			<th>몇시</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody>
		<% for(TodoDto tmp : list) { %>
			<tr>
				<td><%= tmp.getNum() %></td>
				<td><%= tmp.getName() %></td>
				<td><%= tmp.getWhat() %></td>
			</tr>
		<% } %>
	</tbody>
</table>
</body>
</html>