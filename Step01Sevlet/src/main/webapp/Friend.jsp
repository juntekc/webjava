<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <% ArrayList<String> names=new ArrayList<>();
      names.add("김구라");
      names.add("해골");
      names.add("원숭이");
      
       for(String tmp:names) {
         pw.println("<li>"+tmp+"</li>");
%>	
	   <p><%pw.print("<li>"+tmp+"</li>")%> </p>
		
		
         </body>
</html>