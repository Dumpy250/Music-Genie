package common;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class File_Reader {
	
	public static ArrayList<Song> SongList = new ArrayList<Song>();
	public static FileInputStream fileByteStream = null;
	public static Scanner inFS = null;
	public static PrintWriter outFS = null;
	//public static FileOutputStream fileStream = null;
	
	//adding a comment
	public static void ReadSongs() {
		
		try {
			
		fileByteStream = new FileInputStream("List.txt");
		
		inFS = new Scanner(fileByteStream);
		
		while(inFS.hasNext()) {	
		Song song1 = new Song();
		 song1.Band = inFS.next();
		 song1.Genre = inFS.next();
		 song1.RlsDate = inFS.next();
		 song1.songName = inFS.next();
		 SongList.add(song1);
		 //new comment here testing for GitBash
		}				 			
		fileByteStream.close();
		}
		catch (IOException Test1){
			
			System.out.println("Handeled exception");
			System.out.println(Test1.getMessage());
					}
	
	}
	
	//if Only the band is being searched return the bands found//
	public static void SearchSongs(String Band, view.SearchResults frame1) {
		frame1.taSearchResult.setText(null);
		for (Song a: SongList) {
			if (a.Band.equals(Band)) {
				System.out.println("results for same band name: " + a);
				frame1.taSearchResult.append(a.toString() + "\n");
				}
			}								
	}
	
	//Search function for band and genre returns results//
	public static void SearchSongs(String Band, String Genre, view.SearchResults frame1) {
		frame1.taSearchResult.setText(null);
		for (Song s: SongList) {
			if (s.Band.equals(Band) && s.Genre.equals(Genre))  {
				System.out.println("results for same band name: " + s);	
				frame1.taSearchResult.append(s.toString() + "\n");			
			}
			
			}
		
	}
	
	//Search function for band, genre, and release date returns the results.
	public static void SearchSongs(String Band, String Genre, String RlsDate, view.SearchResults frame1) {
		frame1.taSearchResult.setText(null);		
		System.out.println("Im here");
		for (Song b: SongList) {
			if (b.Band.equals(Band) && b.Genre.equals(Genre) && b.RlsDate.equals(RlsDate))  {
				System.out.println("results for same band name: " + b);
					
			
			
				frame1.taSearchResult.append(b.toString() + "\n");
			
			}
			
			}	
	}
	
	//Search function only for the songname//
	public static void Searchname(String Songname, view.SearchResults frame1) {
		frame1.taSearchResult.setText(null);
		for (Song c: SongList) {
			if (c.songName.equals(Songname))  {
				System.out.println("results for same band name: " + c);
				frame1.taSearchResult.append(c.toString() + "\n");
				}
			
			}
	}
	
	
}
