package MyLibrary;
import java.util.*;
import java.sql.*;
public class QueryAction{
	Connection con;
	Statement sta;
	
	private String Authorname;
	private ArrayList<String> Booklist = new ArrayList<String>();
	
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
	
	public String getAuthorname(){
		return Authorname;
	}
	
	public void setAuthorname(String Author){
		this.Authorname = new String(Author);
		System.out.println("已赋值");
	}
	
	public ArrayList<String> getBooklist(){
		return Booklist;
	}
	
	public String execute()throws Exception{
		con = getConnection();
		System.out.println("链接成功");
		try{
			String sql1 = "select * from Author";
			sta = (Statement)con.createStatement();
			ResultSet res = sta.executeQuery(sql1);
			boolean flag = false;
			String AuthorID = null;
			System.out.println(Authorname);
			while(res.next()){
				if(Authorname.equals(res.getString("Name"))){
					AuthorID=new String(res.getString("AuthorID"));
					flag = true;
					break;
				}
			}
			if(flag){
				String sql2 = "select * from Book";
				res = sta.executeQuery(sql2);
				while(res.next())
					if(AuthorID.equals(res.getString("AuthorID"))){
						Booklist.add(new String(res.getString("Title")));
						System.out.println("成功加入书单");
					}
						
				con.close();
				return "Success";
			}	
			else{ 
				con.close();
				return "Failed";
			}
		}
		catch(Exception e){
			System.out.println("Errors."+e.getMessage());
			return "Else";
		}
	}
}
