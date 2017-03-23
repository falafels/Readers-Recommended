import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BookBuilder {

	// This only has to be run once to get all of the required data.
	// Possibly do a write to file and pull data from there instead
	// after this has been run.
	// We don't need the BX-Users.csv since it only holds the 
	// User ID, their Location, and their Age
	// I can make a list holding all the book ID's after the user ID
	public void build(){
		try {
			BufferedReader bookRead = 
					new BufferedReader(new FileReader("BX-Books.csv"));
			FileWriter bookWrite = new FileWriter("Books.txt");
			// The first line is NOT data, so we skip them
			String bookLine = bookRead.readLine();
			
			while((bookLine = bookRead.readLine()) != null){
				String[] bookParse = bookLine.split(";");
				// ISBN, Book Title, Book Author
				bookWrite.write(bookParse[0] + "," + bookParse[1] + "," + bookParse[2]);
			}
			bookRead.close(); bookWrite.close();
			
			BufferedReader userRead = 
					new BufferedReader(new FileReader("BX-Book-Ratings.csv"));
			FileWriter userWrite = new FileWriter("Users.txt");
			// The first line is NOT data, so we skip them
			String userLine = userRead.readLine();
			
			while((userLine = userRead.readLine()) != null){
				String[] userParse = userLine.split(";");
				// User ID, ISBN, Book Rating
				userWrite.write(userParse[0] + "," + userParse[1] + "," + userParse[2]);
			}
			userRead.close(); userWrite.close();
			
			// Add File to store data? Other Ways to store data and 
			// NOT run through every time we want to test/present this
		
		} 
		catch (FileNotFoundException e) { e.printStackTrace(); }
		catch (IOException e) { e.printStackTrace(); }
	}
}
