import java.io.*;
import java.util.*;

//Search.java will search through the sorted files and return desired information
public class Search {

	//takes an int (userID) as input.  Searches through ratings file (sorted by userID) and returns a list of 
	//ratings (representing the ratings that the user gave the books reviewed).
	public static ArrayList<String> searchUserIdForISBN(int num){
		
		ArrayList<String> ISBNs = new ArrayList<String>();
		
		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
		    try {
				inputStream = new FileInputStream("SortedUsers.txt");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    sc = new Scanner(inputStream, "UTF-8");
		    while (sc.hasNextLine()) {
		        String line = sc.nextLine();
		        int userID = Integer.parseInt(line.substring(1, line.indexOf(";")-1));
		        if (num==userID){
		        	String ISBN = line.substring( line.indexOf(";")+2, line.lastIndexOf(";")-1);
		        	ISBNs.add(ISBN);
		        }
		    }
		    
		    if (sc.ioException() != null) {
		        try {
					throw sc.ioException();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		} finally {
		    if (inputStream != null) {
		        try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		    if (sc != null) {
		        sc.close();
		    }
		}
		return ISBNs;
		
		
	}//end method searchUserIDForISBN
	
	//takes an int (userID) as input.  Searches through ratings file (sorted by userID) and returns 
	//a list of ratings (representing the ratings that the user gave the books reviewed)
	public static ArrayList<Integer> searchUserIdForRatings(int num){
		
		ArrayList<Integer> Ratings = new ArrayList<Integer>();
		
		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
		    try {
				inputStream = new FileInputStream("SortedUsers.txt");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    sc = new Scanner(inputStream, "UTF-8");
		    while (sc.hasNextLine()) {
		        String line = sc.nextLine();
		        int userID = Integer.parseInt(line.substring(1, line.indexOf(";")-1));
		        if (num==userID){
		        	
		        	int rating = Integer.parseInt(line.substring(line.lastIndexOf(";")+2, line.lastIndexOf("\"")));
		        	Ratings.add(rating);
		        }
		    }
		    
		    if (sc.ioException() != null) {
		        try {
					throw sc.ioException();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		} finally {
		    if (inputStream != null) {
		        try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		    if (sc != null) {
		        sc.close();
		    }
		}
		return Ratings;
		
		
	}//end method searchUserIDForRatings
	
	//takes a string (an ISBN) as input.  Searches through ratings file (sorted by ISBN) and returns 
	//a list of userIDs (as strings), representing all the users that reviewed the given book.
	public static ArrayList<Integer> searchISBNForUserID(String str){
		
		ArrayList<Integer> userIDs = new ArrayList<Integer>();
		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
		    try {
				inputStream = new FileInputStream("SortedISBN.txt");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    sc = new Scanner(inputStream, "UTF-8");
		    while (sc.hasNextLine()) {
		        String line = sc.nextLine();
		        String ISBN = line.substring(1, line.indexOf(";")-1);
		        if (str.equals(ISBN)){
		        	int userID = Integer.parseInt(line.substring( line.indexOf(";")+2, line.lastIndexOf(";")-1));
		        	userIDs.add(userID);
		        }
		    }
		    
		    if (sc.ioException() != null) {
		        try {
					throw sc.ioException();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		} finally {
		    if (inputStream != null) {
		        try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		    if (sc != null) {
		        sc.close();
		    }
		}
		return userIDs;
		
	}
	
	//takes a string (an ISBN) as input.  Searches through the titles file (sorted by ISBN) 
	//and returns the corresponding book title as a string.
	public static String searchISBNForTitle(String str){
		
		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
		    try {
				inputStream = new FileInputStream("SortedTitlesByISBN.txt");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    sc = new Scanner(inputStream, "UTF-8");
		    while (sc.hasNextLine()) {
		        String line = sc.nextLine();
		        String ISBN = line.substring(1, line.indexOf(";")-1);
		        if (str.equals(ISBN)){
		        	String title = line.substring(line.indexOf(";",+2), line.lastIndexOf("\""));
		        	return title.substring(3);
		        }
		    }
		    
		    if (sc.ioException() != null) {
		        try {
					throw sc.ioException();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		} finally {
		    if (inputStream != null) {
		        try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		    if (sc != null) {
		        sc.close();
		    }
		}
		
		return null;
		
	}//end method searchISBNForTitle
		

	//takes a string (book title) as input.  Searches through the titles file (sorted by title) 
	//and returns the corresponding ISBN as a string.
	public static String searchTitleForISBN(String str){
		
		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
		    try {
				inputStream = new FileInputStream("SortedTitles.txt");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    sc = new Scanner(inputStream, "UTF-8");
		    while (sc.hasNextLine()) {
		        String line = sc.nextLine();
		        String title = line.substring(1, line.indexOf(";")-1);
		        if (title.contains(str)){
		        	String ISBN = line.substring(line.indexOf(";")+1,line.lastIndexOf("\""));
		        	return ISBN.substring(1);
		        }
		    }
		    
		    if (sc.ioException() != null) {
		        try {
					throw sc.ioException();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		} finally {
		    if (inputStream != null) {
		        try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		    if (sc != null) {
		        sc.close();
		    }
		}
		
		return null;
		
	}//end method searchTitleForISBN
	
	
}//end class
	

