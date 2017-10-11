package MyLibrary;
import java.sql.*;

public class InsertAction {
	private String Authorname;
	private String ISBN;
	private String Title;
	private String Publisher;
	private String PublishDate;
	private float Price;
	private String AuthorID;
	
	public String getAuthorname(){
		return Authorname;
	}
	
	public void setAuthorname(String Author){
		this.Authorname = new String(Author);
	}
	
	public String getAuthorID(){
		return AuthorID;
	}
	
	public void setAuthorID(String AuthorID){
		this.AuthorID = new String(AuthorID);
	}
	
	public String getTitle(){
		return Title;
	}
	
	public void setTitle(String Title){
		this.Title = new String(Title);
	}
	
	public String getISBN(){
		return ISBN;
	}
	
	public void setISBN(String ISBN){
		this.ISBN = new String(ISBN);
		System.out.println("成功得到ISBN");
	}
	
	public String getPublisher(){
		return Publisher;
	}
	
	public void setPublisher(String Publisher){
		this.Publisher = new String(Publisher);
	}
	
	public String getPublishDate(){
		return PublishDate;
	}
	
	public void setPublishDate(String PublishDate){
		this.PublishDate = new String(PublishDate);
	}
	
	public void setPrice(float Price){
		this.Price = Price;
	}
	
	public float getPrice(){
		return Price;
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
			
			String sql1 = "INSERT INTO Book(ISBN,Title,AuthorID,Publisher,PublishDate,Price)"+"VALUES('"+ISBN+"','"+Title+"','"+AuthorID+"','"+Publisher+"','"+PublishDate+"','"+Price+"')" ;
			sta = (Statement)con.createStatement();
			int count = sta.executeUpdate(sql1);
			System.out.println("Insert Successful.DataNum:"+count);
			String 	sql2 = "select * from Author";
			ResultSet res = sta.executeQuery(sql2);
			boolean flag = false;
			
			System.out.println(Authorname);
			while(res.next()){
				if(Authorname.equals(res.getString("Name"))){
					flag = true;
					break;
				}
			}
			if(flag){
				return "Success";
			}	
			else{ 
				System.out.println("库中无此作者");
				return "Failed";
			}
		}
		catch(Exception e){
			System.out.println("Errors."+e.getMessage());
			return "Else";
		}
	}
}
