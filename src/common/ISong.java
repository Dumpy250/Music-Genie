package common;

public interface ISong {
    String getBand();
    String getGenre();
    String getRlsDate();
    String getSongName();
    void setBand(String band);
    void setGenre(String genre);
    void setRlsDate(String rlsDate);
    void setSongName(String songName);
}
