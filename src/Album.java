/**
 This class defines the type Album, with all of its attributes and methods
 @author Emily Nelson, Cristofer Gomez-Martinez
 */
public class Album {
	private String title;
	  private String artist;
	  private Genre genre;
	  private Date releaseDate;
	  private boolean isAvailable;
	
	
	  /**
	  Checks if the titles and artists are the same for two albums.
	  Does nothing if the object is not an album.
	  @param obj the object that is compared to the album.
	  @return true if the titles and artists are the same, false otherwise.
	  @author Emily Nelson
	  */  
	  @Override
	  public boolean equals(Object obj) {
		if (obj instanceof Album) {
			Album album = (Album) obj;
			return album.title.equals(this.title) && album.artist.equals(this.artist);
		}
		return false;
	  }
	  
	/**
	Returns the album in string form
	@return textual represential of an album 
	@author Emily Nelson
	*/  
	@Override
	public String toString() { 
		  String date = releaseDate.printAsString(releaseDate);
		  String availability;
		  if (isAvailable == true ) {
			  availability = "is Available";
		  }
		  else {
			  availability = "is not available";
		  }
		  return title + "::" + artist + "::" + genre + "::" + date + "::" + availability ;
	  }
	  
	  
	  /**
	  Returns the title of the album
	  @return title of album
	  @author Emily Nelson
	  */ 
	  public String getTitle() {
		  return title;
	  }
	  
	/**
	Sets the title of the album to a new title
	@param newTitle the new title to set 
	@author Emily Nelson
	*/  
	public void setTitle(String newTitle) {
		  this.title = newTitle;
	  }
	  
	  /**
	  Returns the artist of the album
	  @return artist of album
	  @author Emily Nelson
	  */
	  public String getArtist() {
		  return artist;
	  }
	  
	/**
	Sets the artist of the album to a new artist
	@param newArtist the new artist to set 
	@author Emily Nelson
	*/  
	public void setArtist(String newArtist) {
		  this.artist = newArtist;
	  }
	  
	/**
	Returns the genre of the album
	@return genre of album
	@author Emily Nelson
	*/  
	public Genre getGenre() {
		  return genre;
	  }
	  
	/**
	Sets the genre of the album to a new genre
	@param newGenre the new genre to set 
	@author Emily Nelson
	*/ 
	public void setGenre(Genre newGenre) {
		  this.genre = newGenre;
	  }
	  
	  /**
	  Returns the release date of the album
	  @return releaseDate of album
	  @author Emily Nelson
	  */
	  public Date getReleaseDate() {
		  return releaseDate;
	  }

	  /**
	  Sets the release date of the album to a new release date
	  @param newReleaseDate the new release date to set 
	  @author Emily Nelson
	  */
	  public void setDate(Date newReleaseDate) {
		  this.releaseDate = newReleaseDate;
	  }

	  /**
	  Checks if the album is available
	  @return true if album is available, false otherwise
	  @author Emily Nelson
	  */
	  public boolean getIsAvailable() {
		  return isAvailable;
	  }
	  
	/**
	Sets the album to either being available or not available
	@param newIsAvailable the new boolean value to set
	@author Emily Nelson
	*/  
	public void setIsAvailable(boolean newIsAvailable) {
		  this.isAvailable = newIsAvailable;
	  }
}
