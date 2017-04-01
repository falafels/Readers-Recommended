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

public class TitleTest {
	public static void main(String[] args){
		String filename = "BX-Books.csv";
		ArrayList<String> Titles = new ArrayList<String>();
				File file = new File(filename); //TODO: read about file
				try {
					BufferedReader br = new BufferedReader(new FileReader(file));
					String line;
					try {
						while((line = br.readLine()) != null){
							String[] values = line.split(";");
							Titles.add(values[1] + ";" + values[0]);
						}
						titleSort(Titles);
						for (String t: Titles)
							System.out.println(t);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	public static void titleSort(ArrayList<String>list) throws FileNotFoundException{
		Collections.sort(list, new Comparator<String>(){
			public int compare(String s1, String s2){
				return s1.compareToIgnoreCase(s2);
			}
		});
		PrintStream out = new PrintStream(new FileOutputStream("SortedTitles.txt"));
			for(int i = 0; i < list.size(); i++){
				out.println(list.get(i));
			}
	}
	
}
