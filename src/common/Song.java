package common;


public class Song {
	
	//@override 
	public String toString() {
		return "Band: " + this.Band + ", Genre: " + this.Genre + ", Release date: " + this.RlsDate
				+ "SongName: " + this.songName + this.songLink;
	}
	
	
public String Band;
public String Genre;
public String RlsDate;
public String songName;
public String songLink;
}
