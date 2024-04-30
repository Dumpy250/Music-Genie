package common;


public class Song implements ISong {
	private String Band;
	private String Genre;
	private String RlsDate;
	private String songName;

	@Override
	public String toString() {
		return "Band: " + Band + ", Genre: " + Genre + ", Release Date: " + RlsDate + ", Song Name: " + songName;
	}

	// getters
	public String getBand() {
		return Band;
	}

	public String getGenre() {
		return Genre;
	}

	public String getRlsDate() {
		return RlsDate;
	}

	public String getSongName() {
		return songName;
	}

	// setters
	public void setBand(String band) {
		Band = band;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	public void setRlsDate(String rlsDate) {
		RlsDate = rlsDate;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}
}
