

public class Album {
	private String title;
	  private String artist;
	  private Genre genre;
	  private Date releaseDate;
	  private boolean isAvailable;
	  
	  @Override
	  public boolean equals(Object obj) {
		return false; 
		}
	  
	  @Override
	  public String toString() { 
		  return "yoyo";
	  }
	  
	  
	  public String getTitle() {
		  return title;
	  }
	  
	  public void setTitle(String newTitle) {
		  this.title = newTitle;
	  }
	  
	  public String getArtist() {
		  return artist;
	  }
	  
	  public void setArtist(String newArtist) {
		  this.artist = newArtist;
	  }
	  
	  public Genre getGenre() {
		  return genre;
	  }
	  
	  public void setGenre(Genre newGenre) {
		  this.genre = newGenre;
	  }
	  
	  public Date getReleaseDate() {
		  return releaseDate;
	  }
	  
	  public void setDate(Date newReleaseDate) {
		  this.releaseDate = newReleaseDate;
	  }
	  
	  public boolean getIsAvailable() {
		  return isAvailable;
	  }
	  
	  public void setIsAvailable(boolean newIsAvailable) {
		  this.isAvailable = newIsAvailable;
	  }
}
