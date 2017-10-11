package MyLibrary;

import java.sql.*;
public class UpdateBookAction {
	private String Name;
	private String Publisher; 
	private String PublishDate;
	private String Country;
	private String ISBN;
	private float Price;
	private int Age;
	
	public void setName(String Name){
		this.Name = new String(Name);
	}
	
	public void setPublisher(String Publisher){
		this.Publisher = new String(Publisher);
		
	}
	
	public void setPublishDate(String PublishDate){
		this.PublishDate = new String(PublishDate);
	}
	
	public void setCountry(String Country){
		this.Country = new String(Country);
	}
	
	public void setISBN(String ISBN){
		this.ISBN=new String(ISBN);
	}
	public void setPrice(float Price){
		this.Price = Price;
	}
	
	public void setAge(int Age){
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
			String sql1="update Book set Publisher='"+Publisher+"',PublishDate='"+PublishDate+"',Price='"+Price+"' where ISBN='"+ISBN+"'";
			sta = (Statement)con.createStatement();
			System.out.println(sql1);
			int count = sta.executeUpdate(sql1);
			String IDtemp = null;
			String sql2="select * from Book";
			ResultSet res = sta.executeQuery(sql2);
			while(res.next()){
				if(ISBN.equals(res.getString("ISBN"))){
					IDtemp=new String(res.getString("AuthorID"));
					break;
				}
			}
			String sql3="update Author set Name='"+Name+"',Age='"+Age+"',Country='"+Country+"' where AuthorID='"+IDtemp+"'";
			System.out.println(sql3);
			int count2 = sta.executeUpdate(sql3);
			System.out.println("Update Successful.DataNum is:"+(count+count2));
			con.close();
			return "Success";
		}catch(SQLException e){
			System.out.println("Update Failed.");
			return "Failed";
		}
	}
}
