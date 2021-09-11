
public class Collection {
	private Album[] albums;
	private int numAlbums;
	private int find(Album album) {}
	private void grow() {
		Album[] grownCollection = new Album[albums.length + 4]
			
		for (int i = 0; i < albums.length; i++) {
			grownCollection[i] = albums[i]
		}
		
		//trying to call grown collcetion album instead
		albums = new Album[grownCollection.length]
			
		for (int i = 0; i < grownCollection.length; i++) {
			albums[i] = grownCollection[i]
		}
				
	}
	public boolean add(Album album) {}
	public boolean lendingOut(Album album) {}
	public boolean returnAlbum(Album album)
	public void print() {}
	public void printByReleaseDate() {}
	public void printByGenre() {}
}
