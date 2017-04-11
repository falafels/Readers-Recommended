import java.io.*;
import java.util.*;

public class Search {

	
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
				inputStream = new FileInputStream("SortedTitlesByISBN");
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
	

