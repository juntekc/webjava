<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%//몇번 상품 몇개인지를 HtpServletRequest 객체를 이용해서 얻어낸 후
//아래의 html 요소에 출력해보세요
request.setCharacterEncoding("utf-8");
/*전달되는 파라미터가 숫자인 경우에 실제 숫자로 바꿔야 되는 경우가 많다
그런 경우 Integer 클래스 혹은 Double 클래스의 
parseInt(),parseDouble()static 메소드를 활용하면된다 */
int amount=Integer.parseInt(request.getParameter("amount"));
int num=Integer.parseInt(request.getParameter("num")); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
	<strong><%=num %></strong>번 상품 <strong><%=amount %></strong>개를 주문 했습니다.
	</p>
	
	
	
</body>
</html>