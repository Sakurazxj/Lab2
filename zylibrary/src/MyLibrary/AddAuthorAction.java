package MyLibrary;
import java.sql.*;

public class AddAuthorAction {
	private String Name;
	private String AuthorID;
	private String Country;
	private float Age;
	
	public String getName(){
		return Name;
	}
	
	public void setName(String Name){
		this.Name = new String(Name);
	}
	
	public String getAuthorID(){
		return AuthorID;
	}
	
	public void setAuthorID(String AuthorID){
		this.AuthorID = new String(AuthorID);
	}
	
	public String getCountry(){
		return Country;
	}
	
	public void setCountry(String Country){
		this.Country = new String(Country);
	}
	
	public float getAge(){
		return Age;
	}
	
	public void setAge(float Age){
		this.Age = Age;
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
			String sql1 = "INSERT INTO Author(AuthorID,Name,Age,Country)"+"VALUES("+"'"+AuthorID+"','"+Name+"','"+Age+"','"+Country+"')";
			sta = (Statement)con.createStatement();
			int count = sta.executeUpdate(sql1);
			System.out.println("Insert Successful.DataNum:"+count);
			return "Success";
		}
		catch(Exception e){
			System.out.println("Errors."+e.getMessage());
			return "Failed";
		}
	}
}
