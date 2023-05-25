package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.dto.MemberDto;
@WebServlet("/send")
public class SendServlet extends HttpServlet{

	
	
	@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//"msg"라는 피라미터 명으로 전달되는 문자열을 읽어와서 msg라는 지역변수
		//해당 피라미터 명으로 전달되는 정보가 없으면 null이 리턴된다.
		
		String msg=req.getParameter("msg");
		//콘솔창에 출력해보기 
		System.out.println("msg:"+msg);
		 
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
	      pw.println("<title>메세지 전송 결과 페이지</title>");
	      pw.println("</head>");
	      pw.println("<body>");
	      pw.println("<p>메세지 잘받았어</p>");
	      pw.println("</body>");
	      pw.println("</html>");
	      pw.close();
}
}
