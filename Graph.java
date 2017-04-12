import java.util.ArrayList;


public class Graph {
	static ArrayList<ArrayList<BookT>>	adj;
	private int V;
	private static int E;
	private ArrayList<String> Books;
	
	
	public Graph(int V){
		this.V =	V;	this.E =	0;
		adj =	new ArrayList<ArrayList<BookT>>(0);	//	Create	array	of	BookT
		
		for (int v	=	0;	v	<	V;	v++)	//	Initialize all	lists to empty lists
			adj.add(new ArrayList<BookT>(0));
		}
	
	public Graph(BookT[] in){
		//Iterates through the BookT array
		for (int i = 0; i < in.length;i++){
			ArrayList<Integer> users = new ArrayList<Integer>(in[i].getUsers());
			//Creates an arraylist of books that each user who has read the book has rated
			for (int j = 0; i < users.size() - 1; j++){
				ArrayList<String> ISBN = new ArrayList<String>(Search.searchUserIdForISBN(users.get(j)));
				for (int k = 0; k < ISBN.size(); k++){
					String Book = Search.searchISBNForTitle(ISBN.get(i));
					Books.add(Book);
				}
				//Creates an arraylist of ratings that corresponds to the books that the user has rated
				ArrayList<Integer> ratings = new ArrayList<Integer>(Search.searchUserIdForRatings(j));
				
				//Checks to see if books have been given a similar rating by a user and creates an edge between them if they have
				if (Math.abs(ratings.get(j) - ratings.get(Books.indexOf(in[i].getTitle()))) <= 1){
					for (int c = 0; c < in.length;c++){
						if (in[c].getTitle().equals(Books.get(j))){
							addEdge(in[i], in[c], i, c);
						}
					}
				}
			}
		}
	}
	
	public int V(){
		return V;
	}
	
	public static int E(){
		return E;
	}
	
	public void addEdge(BookT v,	BookT w, int i, int c){
		adj.get(i).add(w);	//	Add	w	to	v�s	list.
		adj.get(c).add(v);	//	Add	v	to	w�s	list.
		E++;
	}	
	
	public static Iterable<BookT>	adj(int v)
	{	return adj.get(v);	}
	
	@SuppressWarnings("unused")
	public static int degree(Graph	G,	int v){
		int degree	=	0;
		for (BookT w :	G.adj(v))	degree++;
		return degree;
	}
	
	public static int maxDegree(Graph	G){
		int max	=	0;
		for (int v	=	0;	v	<	G.V();	v++)
		if (degree(G,	v)	>	max)
		max	=	degree(G,	v);
		return max;
	}
	
	public static int avgDegree(Graph	G)
	{	return 2	*	G.E()	/	G.V();	}
	
}
