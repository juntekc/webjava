package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//3.어떤 경로 요청을 할것인지 경로 설정(반드시 /로 시작해야함.)
@WebServlet("/fortune")

//1.할일 httpServlet 클래스 (extends)상속해야함 
public class FortuneServlet extends  HttpServlet{ 
	 
	
	
	//2.service()메소드 오버라이드
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1,2,3은 형식이 다 정해져있고 자유롭게 할 수 있는건 이 칸부터 가능
		//클라이언트에게 문자열을 응답할 수 있는 객체의 참조값 얻어내기 
		//응답 인코딩 실행
		resp.setCharacterEncoding("utf-8");
		//응답 컨텐츠 설정
		resp.setContentType("text/html; cahrset=utf-8");
		//클라이언트에게 문자열을 응답할 수 있는 객체의 참조값 얻어내기
		
		PrintWriter pw=resp.getWriter();
		pw.println("<!doctype html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset='utf-8'>");
		pw.println("<title>오늘의 운세 페이지 </title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<title>동쪽으로 가면 귀인을 만나요</title>");
		pw.println("</body>");
		
		//오늘의 운세 5개를 미리 준비해둔다.
		String[] fortunes= {"동쪽으로 가면 귀인을 만나요","오늘은 집에만 있어라"
		           ,"너무 멀리가지마","오늘은 뭘해도 되는 날","로또가 당첨"};
		Random ran=new Random();
		//0~4사이의 랜덤한 정수를 얻어내서
		int ranNum=ran.nextInt(5);
		
		pw.println("<p>"+ fortunes[ranNum]+ "</p>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}

}
