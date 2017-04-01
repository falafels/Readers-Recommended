import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UserSortTest {
	public static void main(String[] args){
		String filename = "BX-Book-Ratings.csv";
		ArrayList<String> Users = new ArrayList<String>();
				File file = new File(filename); //TODO: read about file
				try {
					BufferedReader br = new BufferedReader(new FileReader(file));
					String line;
					try {
						while((line = br.readLine()) != null){
							String[] values = line.split(";");
							Users.add(values[0] + ";" + values[1] + ";" + values[2]);
						}
						userSort(Users);
						for (String u: Users)
							System.out.println(u);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	public static void userSort(ArrayList<String>list) throws FileNotFoundException{
		Collections.sort(list, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				String[] values = o1.split(";");
				String[] values2 = o2.split(";");
				return Integer.valueOf(values[0].replace("\"", "")).compareTo(Integer.valueOf(values2[0].replace("\"", "")));
			}
		});
		@SuppressWarnings("resource")
		PrintStream out = new PrintStream(new FileOutputStream("SortedUsers.txt"));
			for(int i = 0; i < list.size(); i++){
				out.println(list.get(i));
			}
	}
}
