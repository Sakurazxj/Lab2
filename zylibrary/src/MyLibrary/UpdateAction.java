package MyLibrary;
import java.io.UnsupportedEncodingException;


public class UpdateAction {
	private String ISBN = null;
	
	public void setISBN(String ISBN) throws UnsupportedEncodingException{
		this.ISBN = new String(ISBN.getBytes("ISO8859_1"), "UTF-8");
	}
	
	public String getISBN(){
		return ISBN;
	}
	
	public String execute()throws Exception{
		return "Success";
	}
}
