public class BookT {

	private String title;
	private String author;
	private String ISBN;
	private int user;
	
	// ISBN, Title, Author from BX-Books.csv
	// user from BX-Users.csv
	public BookT(String bookTitle, String bookAuthor, String bookISBN, int user){
		this.title = bookTitle;
		this.author = bookAuthor;
		this.ISBN = bookISBN;
		this.user = user;
	}
	
	public String getTitle(){ return this.title; }
	public String getAuthor(){ return this.author; }
	public String getID(){ return this.ISBN; }
	public int getUser(){ return this.user; }
	
}
