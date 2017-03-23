import java.io.*;
import java.util.*;

public class Search {

	
	public static ArrayList<String> searchUserIdForISBN(int num){
		
		ArrayList<String> ISBNs = new ArrayList<String>();
		
		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
		    try {
				inputStream = new FileInputStream("Ratings");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    sc = new Scanner(inputStream, "UTF-8");
		    while (sc.hasNextLine()) {
		        String line = sc.nextLine();
		        String lineWithoutBeg = line.substring(38);
		        int userID = Integer.parseInt(lineWithoutBeg.substring(0, lineWithoutBeg.indexOf(",")));
		        if (num==userID){
		        	String ISBN = lineWithoutBeg.substring(lineWithoutBeg.indexOf("'"), lineWithoutBeg.lastIndexOf("'"));
		        	ISBNs.add(ISBN.substring(1));
		        }
		    }
		    // note that Scanner suppresses exceptions
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
		
		
	}
	
	public static ArrayList<Integer> searchISBNForUserID(String str){
		
		ArrayList<Integer> userIDs = new ArrayList<Integer>();
		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
		    try {
				inputStream = new FileInputStream("Ratings");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    sc = new Scanner(inputStream, "UTF-8");
		    while (sc.hasNextLine()) {
		        String line = sc.nextLine();
		        String lineWithoutBeg = line.substring(38);
		        String ISBN = lineWithoutBeg.substring(lineWithoutBeg.indexOf("'"), lineWithoutBeg.lastIndexOf("'"));
		        if (str.equals(ISBN.substring(1))){
		        	int userID = Integer.parseInt(lineWithoutBeg.substring(0, lineWithoutBeg.indexOf(",")));
		        	userIDs.add(userID);
		        }
		    }
		    // note that Scanner suppresses exceptions
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
	
	public static String searchISBNForTitle(String str){
		
		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
		    try {
				inputStream = new FileInputStream("Titles");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    sc = new Scanner(inputStream, "UTF-8");
		    while (sc.hasNextLine()) {
		        String line = sc.nextLine();
		        String lineWithoutBeg = line.substring(32);
		        String ISBN = lineWithoutBeg.substring(0, lineWithoutBeg.indexOf("'",+10));
		        if (str.equals(ISBN)){
		        	String title = lineWithoutBeg.substring(lineWithoutBeg.indexOf("'",+10), lineWithoutBeg.lastIndexOf("'"));
		        	return title.substring(3);
		        }
		    }
		    // note that Scanner suppresses exceptions
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
		
	}
		
	
	public static String searchTitleForISBN(String str){
		
		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
		    try {
				inputStream = new FileInputStream("Titles");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    sc = new Scanner(inputStream, "UTF-8");
		    while (sc.hasNextLine()) {
		        String line = sc.nextLine();
		        String lineWithoutBeg = line.substring(32);
		        String title = lineWithoutBeg.substring(lineWithoutBeg.indexOf("'",+10), lineWithoutBeg.lastIndexOf("'"));
		        if (title.contains(str)){
		        	String ISBN = lineWithoutBeg.substring(0, lineWithoutBeg.indexOf("'",+10));
		        	return ISBN.substring(1);
		        }
		    }
		    // note that Scanner suppresses exceptions
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
		
	}
	
	
}
	

