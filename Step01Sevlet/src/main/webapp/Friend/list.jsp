<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% ArrayList<String> names=new ArrayList<>();
      names.add("김구라");
      names.add("해골");
      names.add("원숭이");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>친구 목록입니다.</h1>
	<ul>
	<%for(String tmp:names){ %>
		<li><%=tmp %></li>
	<%}%>

	</ul>
</body>
</html>