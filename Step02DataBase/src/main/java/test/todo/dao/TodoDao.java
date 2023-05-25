package test.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import test.todo.dto.TodoDto;
import test.util.DbcpBean;

public class TodoDao {
	//2. 
	private static TodoDao dao;
	//1.
	private TodoDao() {}
	//3.
	public static TodoDao getInstance() {
		if(dao==null) {
			dao=new TodoDao();
		}
		//필드에 저장된 참조값 리턴해주기
		return dao;
	}
	//회원 한명의 정보를 추가하는 메소드 
	public boolean insert(TodoDto dto) {
		Connection conn=null;
		PreparedStatement pstmt =null;
		int rowCount =0;
		try {
			conn = new DbcpBean().getConn();
			String sql ="Insert Into todo"
					+" (num,name , what)"
					+" VALUES(todo_seq.NEXTAL,?,?)";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1,dto.getName());
			pstmt.setString(2,dto.getWhat());
			//sql문을 수행하고 변화된(추가,수정,삭제된)row의 갯수리턴하기
			rowCount =pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace(); 
		}finally {
			try {
				if(pstmt !=null)
					pstmt.close();
			}catch(Exception e) {
			}
		}
		//만일 변화된 row의 갯수가 0보다 크면 작업 성공
		if(rowCount>0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
	
	
	
	
}
