public class Collection {
	private Album[] albums; 
	private int numAlbums;
	private int find(Album album) {
		for (int i = 0; i < numAlbums; i++) {
			if (album.equals(albums[i])) {
				return i;
			} 
		}
		return -1;
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
		
		if (find(album) != -1) {
			return false;
		}
		
		int index = findEmptySpot(albums);
		
		
		//int emptySpot = find(album) + 1;
		albums[index] = album;
		albums[index].setIsAvailable(true);
		
		numAlbums++;
		return true;
	}
	
	public boolean remove(Album album) {
		if (find(album) == -1) {
			return false;
		}
		
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
	public void print() {
		String placeHolder = "";
		for(int i = 0; i < numAlbums; i++) {
			System.out.println("length of albums is " + albums.length);
			placeHolder = albums[i].toString();
			System.out.println(placeHolder);
		}
	}
	public void printByReleaseDate() {}
	public void printByGenre() {}
	
	private int findEmptySpot(Album[] albums) {
		for (int i = 0; i < albums.length; i++ ) {
			if (albums[i] == null) {
				return i;
			}
		}
		return -1;
	}
		
		
}
