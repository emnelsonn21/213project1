import java.util.Scanner;
import java.util.Calendar;
import java.util.StringTokenizer;

public class CollectionManager {
	
  	/**
	Reads the command lines from the console
	@author Emily Nelson
	*/
	public void run() {
		Collection collection = new Collection();
		Album[] ugh = new Album[4]; //need to rename
		collection.setAlbums(ugh);
	  
		System.out.println("Collection Manager starts running");
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		
		
		while (sc.hasNextLine()) {
			//read each line and see what to do - [A]dd, [D]elete, [L]end, [R]eturn, [P][PD][PG] display
			
			String input = sc.next();
			
			if (input.equals("Q")) {
				break;
			}
			
			input.replace(" ", "");
			
			StringTokenizer tokenizer = new StringTokenizer(input, ",");
			
			while (tokenizer.hasMoreElements()) {
				String command = tokenizer.nextToken();
				
				Album newAlbum = new Album();
				
				if (tokenizer.hasMoreElements()) {
					newAlbum.setTitle(tokenizer.nextToken());
					newAlbum.setArtist(tokenizer.nextToken());
				}
				
				if(tokenizer.hasMoreElements()) {
					Genre gen = Genre.valueOf(tokenizer.nextToken());
					
					switch(gen) {
						case Classical:
							newAlbum.setGenre(gen);
						case Country:
							newAlbum.setGenre(gen);
						case Jazz:
							newAlbum.setGenre(gen);
						case Pop:
							newAlbum.setGenre(gen);
						default:
							newAlbum.setGenre(Genre.valueOf("Unknown"));
					}
					
					if (tokenizer.hasMoreElements()) {
						String stringDate = tokenizer.nextToken();
						
						Date date = new Date(stringDate);
						newAlbum.setDate(date);
						
					}
					
					
				}
				
				boolean wtf;
		
				if (command.equals("A")) {
				 wtf = collection.add(newAlbum); 
				 //if false then output invalid command maybe ?
				}
				
				if (command.equals("D")) {
					wtf = collection.remove(newAlbum);
				}
				
				if (command.equals("L")) {
					wtf = collection.lendingOut(newAlbum);
				}
				
				if (command.equals("R")) {
					wtf = collection.returnAlbum(newAlbum);
				}
				
				if (command.equals("P")) {
					collection.print();
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
		System.out.println("Collection Manager stops running");
	}
}
