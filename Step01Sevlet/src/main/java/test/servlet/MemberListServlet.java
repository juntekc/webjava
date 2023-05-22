package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*클라이언트가 /member/list 경로로 요청을 해오면 우리가 만든 MemberListServlet 클래스로 생성된 객체가 응답을 한다.*/



import test.dto.MemberDto;

@WebServlet("/member/list") //웹의 url 이름 
public class MemberListServlet extends HttpServlet{
   
   @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //회원 목록을 담을 ArrayList 객체 
	   //마크업 하는게 힘들경우 jsp하면됌. 
      List<MemberDto> list=new ArrayList<>();
      list.add(new MemberDto(1, "김구라", "노량진"));
      list.add(new MemberDto(2, "해골", "행신동"));
      list.add(new MemberDto(3, "원숭이", "상도동"));
      //응답 인코딩 설정
      resp.setCharacterEncoding("utf-8");
      //응답 컨텐트 설정
      resp.setContentType("text/html; charset=utf-8");
      //클라이언트에게 문자열을 응답할수있는 객체의 참조값 얻어내기
      PrintWriter pw=resp.getWriter();
      pw.println("<!doctype html>");
      pw.println("<html>");
      pw.println("<head>");
      pw.println("<meta charset='utf-8'>");
      pw.println("<title>회원 목록페이지</title>");
      pw.println("</head>");
      pw.println("<body>");
      pw.println("<table>");
      	pw.println("<thead>");
      		pw.println("<tr>");
          	pw.println("<th>번호</th>");
          	pw.println("<th>이름</th>");
          	pw.println("<th>주소</th>");
          	pw.println("</tr>");
        pw.println("</thead>");
      	pw.println("<tbody>");
      	for (MemberDto tmp:list) {
      		pw.println("<tr>");
          		pw.println("<td>"+tmp.getNum()+"</td>");
          		pw.println("<td>"+tmp.getName()+"</td>");
          		pw.println("<td>"+tmp.getAddr()+"</td>");
      		pw.println("</tr>");
      	}
      	pw.println("</tbody>");     	
      pw.println("</body>");
      pw.println("</html>");
      pw.close();
   }
}
