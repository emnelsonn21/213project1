import java.util.Scanner;
import java.util.StringTokenizer;

/**
This class contains the method that organizes the user input
@author Emily Nelson, Cristofer Gomez-Martinez
*/
public class CollectionManager {
	
  
	/**
	Reads the command lines from the console
	@author Emily Nelson
	*/
	public void run() {
		Collection collection = new Collection();
		Album[] newListOfAlbums = new Album[4]; //need to rename
		collection.setAlbums(newListOfAlbums);
	  
		System.out.println("Collection Manager starts running");
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		
		
		while (sc.hasNextLine()) {
			
			String input = sc.next();
			
			if (input.equals("Q")) {
				break;
			}
			input.replace(" ", "");
			StringTokenizer tokenizer = new StringTokenizer(input, ",");
			
			if (tokenizer.hasMoreElements()) {
				String command = tokenizer.nextToken();
				if (!command.equals("A") && !command.equals("D") && !command.equals("L") && !command.equals("R")) {
					command = command.replaceAll("\\r|\\n", "");
				}
				
				Album newAlbum = new Album();
				
				if (tokenizer.hasMoreElements()) {
					String newTitle = tokenizer.nextToken();
					newAlbum.setTitle(newTitle);
				}
				
				if (tokenizer.hasMoreElements()) {
					String newArtist = tokenizer.nextToken();
					newAlbum.setArtist(newArtist);
				}
				
				
				if(tokenizer.hasMoreElements()) {
					String stringGen = tokenizer.nextToken();
					String stringGenCap = stringGen.substring(0,1).toUpperCase() + stringGen.substring(1);
					if (!stringGenCap.equals("Pop") && !stringGenCap.equals("Jazz") && !stringGenCap.equals("Country") && !stringGenCap.equals("Classical") ) {
						newAlbum.setGenre(Genre.valueOf("Unknown"));
					} 
					else {
						Genre gen = Genre.valueOf(stringGenCap);
					
						switch(gen) {
							default:
								newAlbum.setGenre(Genre.valueOf("Unknown"));
							case Classical:
								newAlbum.setGenre(gen);
							case Country:
								newAlbum.setGenre(gen);
							case Jazz:
								newAlbum.setGenre(gen);
							case Pop:
								newAlbum.setGenre(gen);
								
						}
					}
					
					
					if (tokenizer.hasMoreElements()) {
						String stringDate = tokenizer.nextToken();
						
						Date date = new Date(stringDate);
						newAlbum.setDate(date);
						
						
						if (!newAlbum.getReleaseDate().isValid()) {
							System.out.println("Invalid Date!");
						}
					}
					
					
				}
				
				boolean didWork;
		
				if (command.equals("A") && newAlbum.getReleaseDate().isValid()) {
					didWork = collection.add(newAlbum); 
					if (didWork == true) {
						System.out.println(newAlbum.toString() + " >> added"); 
					}
					else {
						System.out.println(newAlbum.toString() + " >> already in collection"); 
					}
				}
				
				else if (command.equals("D") && newAlbum.getReleaseDate().isValid()) {
					didWork = collection.remove(newAlbum);
					if (didWork == true) {
						System.out.println(newAlbum.toString() + " >> deleted"); 
					 }
					 else {
						 System.out.println(newAlbum.toString() + " >> not in collection"); 
					 }
				}
				
				else if (command.equals("L") && newAlbum.getReleaseDate().isValid()) {
					didWork= collection.lendingOut(newAlbum);
					if (didWork == true) {
						System.out.println(newAlbum.toString() + " >> lended out"); 
					 }
					 else {
						 System.out.println(newAlbum.toString() + " >> not available"); 
					 }
				}
				
				else if (command.equals("R") && newAlbum.getReleaseDate().isValid()) {
					didWork = collection.returnAlbum(newAlbum);
				}
				
				else if (command.equals("P")) {
					collection.print();
				}
				
				else if (command.equals("PD")) {
					collection.printByReleaseDate();
				}
				
				else if (command.equals("PG")) {
					collection.printByGenre();
				}
				
				else {
					if (newAlbum.getReleaseDate().isValid()) {
						System.out.println("Invalid Command!");
					}
				}
			}			
		}
		
		sc.close();
		System.out.println("Collection Manager stops running");
	}
}
