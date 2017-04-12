import java.util.ArrayList;

public class BookT {

	private String title;
	private String author;
	private String ISBN;
	
	// ISBN, Title, Author from BX-Books.csv
	public BookT(String bookTitle, String bookAuthor, String bookISBN){
		this.title = bookTitle;
		this.author = bookAuthor;
		this.ISBN = bookISBN;
	}
	
	public String getTitle(){ return this.title; }
	public String getAuthor(){ return this.author; }
	public String getID(){ return this.ISBN; }
	
}
