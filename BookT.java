import java.util.ArrayList;

public class BookT {

	private String title;
	private String author;
	private String ISBN;
	private ArrayList<Integer> Users;
	
	// ISBN, Title, Author from BX-Books.csv
	// user from BX-Users.csv
	public BookT(String bookTitle, String bookAuthor, String bookISBN){
		this.title = bookTitle;
		this.author = bookAuthor;
		this.ISBN = bookISBN;
		this.Users = new ArrayList<Integer>(0);
	}
	
	public String getTitle(){ return this.title; }
	public String getAuthor(){ return this.author; }
	public String getID(){ return this.ISBN; }
	public ArrayList<Integer> getUsers(){ return this.Users; }
	public void addUser(int user){ this.Users.add(user); }
	
}
