package MyLibrary;
import java.sql.*;
public class ShowdetailAction {
	private String ISBN;
	private String AuthorID;
	private String Publisher;
	private String PublishDate;
	private float Price;
	private String Title = null;
	
	private String Name;
	private String Age;
	private String Country;
	
	public String getTitle(){
		return Title;
	}
	public void setTitle(String booktitle){
		this.Title = new String(booktitle);
	}
	public String getISBN(){
		return ISBN;
	}
	public String getAuthorID(){
		return AuthorID;
	}
	public String getPublisher(){
		return Publisher;
	}
	public String getPublishDate(){
		return PublishDate;
	}
	public float getPrice(){
		return Price;
	}
	public String getName(){
		return Name;
	}
	public String getAge(){
		return Age;
	}
	public String getCountry(){
		return Country;
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
		System.out.println(Title);
		try{
			String sql = "select * from Book";
			sta = (Statement)con.createStatement();
			ResultSet res = sta.executeQuery(sql);
			boolean flag = false;
			AuthorID = null;
			while(res.next()){
				if(Title.equals(res.getString("Title"))){
					flag = true;
					ISBN = new String(res.getString("ISBN"));
					AuthorID = new String(res.getString("AuthorID"));
					Publisher = new String(res.getString("Publisher"));
					PublishDate = new String(res.getString("PublishDate"));
					Price = res.getFloat("Price");
					
					break;
				}
			}
			if(flag){
				String sql2 = "select * from Author";
				res = sta.executeQuery(sql2);
				while(res.next())
				{
					if(AuthorID.equals(res.getString("AuthorID"))){
						Name = new String(res.getString("Name"));
						Age = new String(res.getString("Age"));
						Country = new String(res.getString("Country"));
						break;
					}
				}
			}
			System.out.println("得到详细信息");
			con.close();
			return "Success";
		}catch(SQLException e){
			System.out.println("Connect Failed."+e.getMessage());
			return "Failed";
		}
	}
	
	
}
