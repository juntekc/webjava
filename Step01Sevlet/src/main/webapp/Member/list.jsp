<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="test.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% List<MemberDto> list=new ArrayList<>();
    list.add(new MemberDto(1, "김구라", "노량진"));
    list.add(new MemberDto(2, "해골", "행신동"));
    list.add(new MemberDto(3, "원숭이", "상도동"));
     %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/member/list.jsp</title>
</head>
<body>
	<h1>회원 목록</h1>
	<table>
		<thead>
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>주소</td>
		</tr>
		</thead>
			<tr>
				<% for (MemberDto tmp:list){%>
				<td><%=tmp.getNum()%></td>
				<td><%=tmp.getName()%></td>	
				<td><%=tmp.getNum()%></td>				
			</tr>
		<%}%>
	
	</table> 
</body>
</html>