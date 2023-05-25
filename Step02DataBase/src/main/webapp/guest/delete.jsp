<%@page import="test.guest.dao.GuestDao"%>
<%@page import="test.member.dao.MemberDao"%>
<%@page import="test.member.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   /*
      이페이지에 요청이 될때  <a href="delete.jsp?num=x"></a>  형식의 링크를 눌러서 
      GET 방식 요청이 되는 것이다.
      따라서 GET 방식 요청 파라미터로 삭제할 회원의 번호가 전달이 된다.
      해당 파라미터를 추출해서 DB 에서 삭제 하면 된다.
   */

   //1. 삭제할 회원의 번호를 얻어내서 
   int num=Integer.parseInt(request.getParameter("num"));
   //2. DB 에서 삭제하고
   boolean isSuccess=GuestDao.getInstance().delete(num);
	//3.비밀번호
	
 
 
String cPath=request.getContextPath();
//리다일렉트 응답하기
response.sendRedirect(cPath+"/guest/list.jsp");//절대경로로 적어야함.
%>
 