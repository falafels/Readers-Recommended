public class FindSimilar {

	public BookT[] FindSimilarBooks(String b){
		BookT[] similarBooks = new BookT[5];
		for (int i = 0; i < Graph.E(); i++){
			if ((Graph.adj.get(i).get(0)).getTitle() == b){
				for (int j = 1 ; j < 6 & j < Graph.adj.get(i).size()+1 ; j++)
					similarBooks[j] = Graph.adj.get(i).get(j);
			}
		}
		return similarBooks;
	}
}
