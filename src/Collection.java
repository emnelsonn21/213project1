/**
 This class defines a Collection and contains all methods to edit a given collection
 @author Emily Nelson, Cristofer Gomez-Martinez
 */
public class Collection {
	private Album[] albums; 
	private int numAlbums;
	
	/**
	Finds the index where the album is located in the albums array
	@param album the album being looked for
	@return the index of the album if found, -1 otherwise
	@author Cristofer Gomez-Martinez
	*/
	private int find(Album album) {
		for (int i = 0; i < numAlbums; i++) {
			if (album.equals(albums[i])) {
				return i;
			} 
		}
		return -1;
	}
	
	/**
	Returns the array of albums
        @return albums array
	@author Emily Nelson 
	*/
	public Album[] getAlbums() {
		  return albums;
	  }
	  
	/**
	  Sets the albums array to a new albums array
	  @param newAlbum the new albums array to set
	  @author Emily Nelson
	  */
	  public void setAlbums(Album[] newAlbum) {
		  this.albums = newAlbum;
	  }
	
	  /**
		Increases the capacity of the albums array by 4
		Grown whenever array is full
		@author Emily Nelson
		*/
	private void grow() {
		Album[] grownCollection = new Album[albums.length + 4];
			
		for (int i = 0; i < albums.length; i++) {
			grownCollection[i] = albums[i];
		}
		
		for (int i = albums.length; i < grownCollection.length; i++) {
			grownCollection[i] = null;
		}
		
		albums = grownCollection;
		
				
	}
	
	/**
	Checks if an album can be added to the albums array
	Adds album to albums array if album is not found in array
	Does nothing if the album is alrady in the albums array
	@param album the album that is to be added
	@return true if album is not in albums array, false otherwise
	@author Cristofer Gomez-Martinez, Emily Nelson
	*/
	public boolean add(Album album) {
		
		if (find(album) != -1) {
			album.setIsAvailable(true);
			return false;
		}
		
		if ((numAlbums != 0) && (numAlbums % 4 == 0)) {
			grow();
		}
		
		
		int index = findEmptySpot(albums);
		
		
		//int emptySpot = find(album) + 1;
		albums[index] = album;
		albums[index].setIsAvailable(true);
		
		numAlbums++;
		return true;
	}
	
	/**
	Checks if an album can be removed from the albums array
	Removes album from albums array if album is found
	Does nothing if the album is not in albums array
	@param album the album that is to be removed
	@return true if album is in albums array, false otherwise
	@author Emily Nelson
	*/
	public boolean remove(Album album) {
		if (find(album) == -1) {
			return false;
		}
		
		int index = find(album);
		albums[index] = null;
		numAlbums--;
		
		//if the album that got deleted isn't the very last album in the current array, move the last entry to there
		//this way there are no empty spots in albums
		if (index < albums.length - 1) {
			
			int lastEntry = albums.length;
			
			while (albums[lastEntry] == null) {
				lastEntry--;
			}
			
			albums[index] = albums[lastEntry];
			albums[lastEntry] = null;
		}
		
		return true;
	}
	
	/**
	Checks if the album can be lended out
	Lends out the album if the album is found in the albums array
	Does nothing if the albums is not in the albums arrays
	@param album the album that is to be lended out
	@return true if album is in albums array, false otherwise
	@author Emily Nelson
	*/
	public boolean lendingOut(Album album) {
		if (find(album) == -1) {
			return false;
		}
		
		albums[find(album)].setIsAvailable(false);
		return true;
	}
	
	/**
	Checks if the album can be returned
	Returns the album if the album is found in the albums array
	Does nothing if the albums is not in the albums arrays
	@param album the album that is to be returned
	@return true if album is in albums array, false otherwise
	@author Emily Nelson
	*/
	public boolean returnAlbum(Album album) {
		if (find(album) == -1) {
			return false;
		}
		
		albums[find(album)].setIsAvailable(true);
		return true;
	}
	
	/**
	Displays the list of albums in the albums array without specifying the order
	@author Cristofer Gomez-Martinez
	*/
	public void print() {
		System.out.println("*List of albums in the collection");
		if (albums[0] == null) {
			System.out.println("The collection is empty!");
			return;
		}

		for(int i = 0; i < numAlbums; i++) {
			System.out.println("length of albums is " + albums.length);
			System.out.println(albums[i].toString());
		}
		
		System.out.println("*End of list");
	}
	
	/**
	Displays the list of albums in the albums array by release date
	@author Cristofer Gomez-Martinez
	*/
	public void printByReleaseDate() {
		System.out.println("*Album collection by the release dates");
		if (albums[0] == null) {
			System.out.println("The collection is empty!");
			return;
		}
		Album[] sortedCollection = new Album[albums.length];
		//sortedCollection will be a copy of the albums array that we will modify so to not change the original
		for(int i = 0; i < albums.length; i++) {
			sortedCollection[i] = albums[i];
		}
		
		int lastAvail = findEmptySpot(sortedCollection) - 1;
		
		for (int i = 0; i <= lastAvail; i++) {
			for (int j = 0; j <= (lastAvail - i - 1); j++) {
				//if j+1 is older than j, swap j and j+1
				if (sortedCollection[j].getReleaseDate().compareTo(sortedCollection[j+1].getReleaseDate()) == 1) {
					Album temp = sortedCollection[j];
					sortedCollection[j] = sortedCollection[j+1];
					sortedCollection[j+1] = temp;
				}
			}
		}
		
		for (int i = 0; i < numAlbums; i++) {
			System.out.println(sortedCollection[i].toString());
		}
		
		System.out.println("*End of list");
	}
	
	/**
	Displays the list of albums in the albums array by genre
	@author Emily Nelson
	*/
	public void printByGenre() {
		System.out.println("*Album collection by genre");
		if (albums[0] == null) {
			System.out.println("The collection is empty!");
			return;
		}
		for(int i = 0; i < numAlbums; i++) {
			Genre gen = albums[i].getGenre();
			if (String.valueOf(gen).equals("classical")) {
				System.out.println(albums[i].toString());
			}
		}
		for(int i = 0; i < numAlbums; i++) {
			Genre gen = albums[i].getGenre();
			if (String.valueOf(gen).equals("country")) {
				System.out.println(albums[i].toString());
			}
		}
		for(int i = 0; i < numAlbums; i++) {
			Genre gen = albums[i].getGenre();
			if (String.valueOf(gen).equals("jazz")) {
				System.out.println(albums[i].toString());
			}
		}
		for(int i = 0; i < numAlbums; i++) {
			Genre gen = albums[i].getGenre();
			if (String.valueOf(gen).equals("pop")) {
				System.out.println(albums[i].toString());
			}
		}
		for(int i = 0; i < numAlbums; i++) {
			Genre gen = albums[i].getGenre();
			if (String.valueOf(gen).equals("unknown")) {
				System.out.println(albums[i].toString());
			}
		}
		
		System.out.println("*Album collection by genre");
	}
	
	/**
	Finds the first empty index/spot in the albums array
	@param albums the albums array where the empty spot is being looked for
	@return the index if an empty spot is found, -1 otherwise
	@author Emily Nelson
	*/
	private int findEmptySpot(Album[] albums) {
		for (int i = 0; i < albums.length; i++ ) {
			if (albums[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
		
		
}
