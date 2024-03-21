package common;


public class Song {

	public String Band;
	public String Genre;
	public String RlsDate;
	public String songName;
	public String songLink;
	//@override 
	public String toString() {
		return "Band: " + this.Band + ", Genre: " + this.Genre + ", Release date: " + this.RlsDate
				+ "SongName: " + this.songName + this.songLink;
	}

	public String getBand() {
		return Band;
	}

	public void setBand(String band) {
		Band = band;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	public String getRlsDate() {
		return RlsDate;
	}

	public void setRlsDate(String rlsDate) {
		RlsDate = rlsDate;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getSongLink() {
		return songLink;
	}

	public void setSongLink(String songLink) {
		this.songLink = songLink;
	}

}
