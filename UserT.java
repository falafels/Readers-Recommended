import java.util.ArrayList;

public class UserT {

	private int User;
	private ArrayList<String> Books;
	private ArrayList<Integer> Ratings;
	
	public UserT(int user){
		this.User = user;
		this.Books = new ArrayList<String>(0);
		this.Ratings = new ArrayList<Integer>(0);
	}
	
	public int getUser(){ return this.User; }
	public ArrayList<String> getBooks(){ return this.Books; }
	public void addBook(String book, int rating){ 
		this.Books.add(book); 
		this.Ratings.add(rating);
	}
	
}
