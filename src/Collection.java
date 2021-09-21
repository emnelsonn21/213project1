import java.util.Arrays; 
//are we even allowed to use this?

public class Collection {
	private Album[] albums; //how to initialize it to size 4 if we can't change instance variables?
	private int numAlbums;
	private int find(Album album) {
	for (int i = 0; i< numAlbums; i++) {
			if (album.equals(albums[i])) {
				return i;
			} else {
				return -1;
			}
		}
	}
	
	public Album[] getAlbums() {
		  return albums;
	  }
	  
	  public void setAlbums(Album[] newAlbum) {
		  this.albums = newAlbum;
	  }
	  
	private void grow() {
		Album[] grownCollection = new Album[albums.length + 4];
			
		for (int i = 0; i < albums.length; i++) {
			grownCollection[i] = albums[i];
		}
		
		for (int i = albums.length; i < grownCollection.length; i++) {
			grownCollection[i] = null;
		}
		
		//trying to call grown collection albums instead
		albums = grownCollection;
		
		//albums = new Album[grownCollection.length];
			
		//for (int i = 0; i < grownCollection.length; i++) {
			//albums[i] = grownCollection[i];
		//}
				
	}
	public boolean add(Album album) {
		//use find to check if already in collection
		//put attributes of album in the array
		
		if (find(album) == -1) {
			return false;
		}
		
		
		int emptySpot = find(album) + 1;
		
		albums[emptySpot].setIsAvailable(true);
		albums[emptySpot].setTitle(album.getTitle());
		albums[emptySpot].setArtist(album.getArtist());
		albums[emptySpot].setGenre(album.getGenre());
		
		numAlbums++;
		return true;
	}
	
	public boolean remove(Album album) {
		if (find(album) == -1) {
			return false;
		}
		
		albums[find(album)].setIsAvailable(false);
		albums[find(album)].setTitle(null);
		albums[find(album)].setArtist(null);
		albums[find(album)].setGenre(null);
		albums[find(album)] = null;
		numAlbums--;
		return true;
	}
	
	public boolean lendingOut(Album album) {
		if (find(album) == -1) {
			return false;
		}
		
		albums[find(album)].setIsAvailable(false);
		return true;
	}
	public boolean returnAlbum(Album album) {
		if (find(album) == -1) {
			return false;
		}
		
		albums[find(album)].setIsAvailable(true);
		return true;
	}
	public void print() {}
	public void printByReleaseDate() {}
	public void printByGenre() {}
	
	public int firstEmptySpace(){
		int i = 0;
		 while (albums[i] != NULL) {
			 i++;
		 }
		
		return i;
	}
}
