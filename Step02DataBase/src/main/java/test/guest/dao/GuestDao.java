package test.guest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.guest.dto.GuestDto;
import test.member.dto.MemberDto;
import test.util.DbcpBean;

public class GuestDao {
	// 2.
	private static GuestDao dao;

	// 1.
	private GuestDao() {
	}

	// 3.
	public static GuestDao getInstance() {
		// 서버시작후 최초 요청이면
		if (dao == null) {
			// 객체를 생성해서 static필드에 저장해둔다
			dao = new GuestDao();
		} // 필드에 저장된 참조값 리턴해주기
		return dao;
	}
	//회원 한명의 정보를 수정하는 메소드 
		public boolean update(GuestDto dto) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			int rowCount = 0;
			try {
				conn = new DbcpBean().getConn();
				String sql = "UPDATE "
						+ " SET writer=?,content=?,pwd=?"
						+ " WHERE num=?";
				pstmt = conn.prepareStatement(sql);
				//실행할 sql 문이 미완성이라면 여기서 완성
				pstmt.setString(1, dto.getName());
				pstmt.setString(2,dto.getContent());
				pstmt.setString(3,dto.getPwd());
				//sql 문을 수행하고 변화된(추가, 수정, 삭제된) row 의 갯수 리턴 받기
				rowCount = pstmt.executeUpdate();
			} catch (SQLException se) {
				se.printStackTrace();
			} finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (Exception e) {
				}
			}
			//만일 변화된 row 의 갯수가 0 보다 크면 작업 성공
			if (rowCount > 0) {
				return true;
			} else {
				return false;
			}
			
			
		}
	
	//회원 한명의 정보를 리턴하는 메소드 //번호를 받아서 셀렉트 
		public GuestDto getData(int num) {
			//필요한 객체의 참조값을 담을 지역변수 미리 만들기
			GuestDto dto=null;
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
		try {
			//DbcpBean 객체를 이용해서 Connection 객체를 얻어온다(Connection Pool 에서 얻어오기)
			conn=new DbcpBean().getConn();
			//실행할 sql 문 
			String sql="SELECT writer,content,pwd"
					+ " FROM guest"
					+ " WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			//sql 문이 미완성이라면 여기서 완성
			pstmt.setInt(1, num);
			//select 문 수행하고 결과값 받아오기
			rs=pstmt.executeQuery();
			//반복문 돌면서 ResultSet 에 담긴 내용 추출
			while(rs.next()) {
				//MemberDto 객체생성해서
				dto=new GuestDto();
				dto.setNum(num);//번호는 지역변수에 있는 값을 담고
				//이름과 주소는 ResultSet으로 부터 얻어내서 담는다.
				dto.setName(rs.getString("writer"));
				dto.setContent(rs.getString("content"));
				dto.setPwd(rs.getString("pwd"));
			}
		}catch(SQLException se) {
				se.printStackTrace();
			}finally {
				try {
		            if (rs != null)
		                rs.close();
		            if (pstmt != null)
		                pstmt.close();
		            if (conn != null)
		                conn.close();
		        } catch (Exception e) {
		            e.printStackTrace();
				}
	}
		return dto;
	}
	
	//글 한개의 정보를 삭제하는 메소드
	public boolean delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			conn = new DbcpBean().getConn();
			String sql = "DELETE FROM board_guest"
					+ " WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			//실행할 sql 문이 미완성이라면 여기서 완성
			pstmt.setInt(1, num);
			//sql 문을 수행하고 변화된(추가, 수정, 삭제된) row 의 갯수 리턴 받기
			rowCount = pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		//만일 변화된 row 의 갯수가 0 보다 크면 작업 성공
		if (rowCount > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	
	
	
	
	
	// 글 한개의 정보를 추가하는 메소드
	public boolean insert(GuestDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			conn = new DbcpBean().getConn();
			String sql = "INSERT INTO board_guest" + " ( num, writer ,content,pwd,regdate)"
					+ " VALUES (board_guest_seq.NEXTVAL,?,?,?,SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			// 실행할 sq|문이 미완성이라면 여기서 완성
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getPwd());

			// sql문을 수행하고 변화된(추가,수정,삭제된)row의 갯수 리턴
			rowCount = pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		// 만약 변화된 row의 갯수가 0보다 크면 작업 성공
		if (rowCount > 0) {
			return true;
		} else {
			return false;
		}

	}

	// 회원 목록을 리턴하는 메소드
	public List<GuestDto> getList() {
		// 회원 목록을 담을 객체 미리 생성하기
		List<GuestDto> list = new ArrayList<>();
		// 필요한 객체를 담을 지역변수 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// DbcpBean 객체를 이용해 Connection객체를 얻어라
			conn = new DbcpBean().getConn();
			// 실행할 sql문
			String sql = "SELECT * FROM board_guest";
			pstmt = conn.prepareStatement(sql);
			// sql문이 미완성이라면 여기서 완성

			// SELECT문 수행하고 결과값 받아오기
			rs = pstmt.executeQuery();
			// 반복문 돌면서 ResultSet에 담긴 내용 추출
			while (rs.next()) {
				// Resultset에 cursor가 위치한곳의 칼럼 정보 얻어와서 dto에 넣기
				GuestDto dto = new GuestDto();
				dto.setNum(rs.getInt("num"));// 번호는 지역변수에 있는 값을 담고
				// 이름과 주소는 ResultSet으로 부터 얻어내서 담는다
				dto.setName(rs.getString("writer"));
				dto.setContent(rs.getString("content"));
				dto.setPwd(rs.getString("Pwd"));
				dto.setDate(rs.getString("regdate"));
				list.add(dto);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}

		}
		return list;

	}
}
