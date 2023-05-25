package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/send2")
public class Send2Servlet extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	

	String msg=req.getParameter("msg");
	 
	 
	//post방식 전송할때는 요청 인코딩 설정을 해주어야 한글이 꺠지지않는다.
      resp.setCharacterEncoding("utf-8");
     
      //"msg"라는 파라미터 명으로 전달되는 문자열을 읽어와서 msg라는 지역변수에 담기
      //해당 파라미터 명으로 전달되는 문자열을 읽어와서 msg해줘야
      
      resp.setContentType("text/html; charset=utf-8");
      //클라이언트에게 문자열을 응답할수 있는 객체의 참조값 얻어내기
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

