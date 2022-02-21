package database;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DBManager {
   private Connection con, con2;
   String user_db_name, msg_db_name, user, password;
   public DBManager() {
	   // ** user_db_name : 유저 데이터 베이스 이름** //
	   this.user_db_name = "user_db";
		// ** msg_db_name : 메세지 데이터 베이스 이름** //
	   this.msg_db_name = "msg_db";
		// ** user : 데이터 베이스 아이디** //
	   this.user = "root";
		// ** password : 데이터 베이스 비밀번호** //
	   this.password = "misun0824@";
      try {
         Class.forName("org.mariadb.jdbc.Driver");
         InetAddress local = InetAddress.getLocalHost();
         String ip = local.getHostAddress();
         String url = "jdbc:mariadb://localhost:3308/"+user_db_name;
         String url2 = "jdbc:mariadb://localhost:3308/"+msg_db_name;
         con = DriverManager.getConnection(url, user, password);
         con2 = DriverManager.getConnection(url2, user, password);
      } catch(Exception e) {
         System.out.println("************ [DB 접속 오류] ************");
      }
   }
   public Statement getSTMT() {
      Statement stmt = null;
      try {
         stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      } catch(Exception e) {
         e.printStackTrace();
      }
      return stmt;
   }
   
   public PreparedStatement getPSTMT(String sql) {
      PreparedStatement pstmt = null;
      try {
         pstmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      } catch(Exception e) {
         e.printStackTrace();
      }
      return pstmt;
   }
   public void saveLog(String date, String msg) {
		try {
			Statement stmt = con2.createStatement();
			String sql = "insert into msg_log(date,msg) values";
			sql += "('"+date+"','"+msg+"')";
			int i = stmt.executeUpdate(sql);
			if( i == 1 )
				System.out.println("레코드 추가 성공");
			else 
				System.out.println("레코드 추가 실패");
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
   public void registInfo(String user_id, String user_pwd, String user_nickName) {
		try {
			Statement stmt = con.createStatement();
			String sql = "insert into user_table(id,pw,nickName) values";
			sql += "('"+user_id+"','"+user_pwd+"','"+user_nickName+"')";
			int i = stmt.executeUpdate(sql);
			if( i == 1 )
				System.out.println("레코드 추가 성공");
			else 
				System.out.println("레코드 추가 실패");
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
   public void close(Object o) {
      try {
         if(o instanceof Connection) {
            ((Connection)o).close();
         } else if(o instanceof Statement) {
            ((Statement)o).close();
         } else if(o instanceof PreparedStatement) {
            ((PreparedStatement)o).close();
         } else if(o instanceof ResultSet) {
            ((ResultSet)o).close();
         }
      } catch(Exception e) {}
   }

   public Connection getCon() {
      return con;
   }

   
}