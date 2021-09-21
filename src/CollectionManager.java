
import java.util.Scanner;
import java.util.StringTokenizer;

public class CollectionManager {
	
  
	//public Album[] albums = new Album[4];
	
 
	public void run() {
		Collection collection = new Collection();
		Album[] ugh = new Album[4]; //need to rename
		collection.setAlbums(ugh);
	  
		System.out.println("Collection Manager starts running");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		StringTokenizer tokenizer = new StringTokenizer(input, ",");
		
		
		while (sc.hasNextLine()) {
			//read each line and see what to do - [A]dd, [D]elete, [L]end, [R]eturn, [P][PD][PG] display
			
					
			while (tokenizer.hasMoreElements()) {
				String command = tokenizer.nextToken();
				String title = new String();
				String artist = new String();
				Genre genre = new Genre();
				Date releaseDate = new Date();
				boolean isAvailable = true;
				
				Album testAlbum = new Album();
				
				if (tokenizer.hasMoreElements()) {
					testAlbum.setTitle(tokenizer.nextToken());
					testAlbum.setArtist(tokenizer.nextToken());
					//testAlbum.setGenre(tokenizer.nextToken()); need to convert from string to genre
				}
				
				boolean wtf;
				if (command.equals("A")) {
					//Album newAlbum = new Album();
				 wtf = collection.add(testAlbum); 
				 //in the add method make sure it goes to the
				 //array not the collection itself?
				}
				
				if (command.equals("D")) {
				}
				
				if (command.equals("L")) {
				}
				
				if (command.equals("R")) {
				}
				
				if (command.equals("P")) {
				}
				
				if (command.equals("PD")) {
				}
				
				if (command.equals("PG")) {
				}
				
				else {
				  System.out.println("Invalid Command!");
				}
			}			
		}
		
		sc.close();
		System.out.println("Collection Manager storps running");
	}
}
