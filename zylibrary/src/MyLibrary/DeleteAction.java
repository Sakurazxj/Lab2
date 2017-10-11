package MyLibrary;
import java.io.UnsupportedEncodingException;
import java.sql.*;
public class DeleteAction {
	private String ISBN=null;
	
	public String getISBN(){
		return ISBN;
	}
	
	public void setISBN(String ISBN) throws UnsupportedEncodingException{
		this.ISBN = new String(ISBN.getBytes("ISO8859_1"), "UTF-8");
	}
	Connection con;
	Statement sta;
	
	public static Connection getConnection(){
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://ihgzvszboidn.mysql.sae.sina.com.cn:10609/bookdb","root","197052");
		}catch(Exception e){
			System.out.println("Connect Fail:"+e.getMessage());
		}
		return con;
	}
	
	public String execute()throws Exception{
		con = getConnection();
		try{
			String sql = "delete from Book where ISBN="+"'"+ISBN+"'";
			System.out.println(sql);
			sta = (Statement)con.createStatement();
			int count = sta.executeUpdate(sql);
			System.out.println("Delete Successful.Delete DataNum:"+count);
			con.close();
			return "Success";
		}catch(SQLException e){
			return "Failed";
		}
	}
}
