
import java.util.Scanner;
import java.util.Calendar;
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
				//String title = new String();
				//String artist = new String();
				//boolean isAvailable = true;
				
				Album testAlbum = new Album();
				
				if (tokenizer.hasMoreElements()) {
					testAlbum.setTitle(tokenizer.nextToken());
					testAlbum.setArtist(tokenizer.nextToken());
					Genre gen = Genre.valueOf(tokenizer.nextToken());
					Date dt = new Date();
					
					switch(gen) {
						case Classical:
							testAlbum.setGenre(gen);
						case Country:
							testAlbum.setGenre(gen);
						case Jazz:
							testAlbum.setGenre(gen);
						case Pop:
							testAlbum.setGenre(gen);
						default:
							testAlbum.setGenre(Genre.valueOf("Unknown"));
					}
					
					if (tokenizer.hasMoreElements()) {
						String dat = tokenizer.nextToken();
						dt.getDate(dat);
					}
					
					
					
					//testAlbum.setGenre(tokenizer.nextToken()); need to convert from string to genre
				}
				
				boolean wtf;
				if (command.equals("A")) {
				 wtf = collection.add(testAlbum); 
				 //if false then output invalid command maybe ?
				}
				
				if (command.equals("D")) {
					wtf = collection.remove(testAlbum);
				}
				
				if (command.equals("L")) {
					wtf = collection.lendingOut(testAlbum);
				}
				
				if (command.equals("R")) {
					wtf = collection.returnAlbum(testAlbum);
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
