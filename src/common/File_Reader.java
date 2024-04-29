package common;
import view.SearchResults;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.function.Predicate;

public class File_Reader {
	
	public static ArrayList<Song> SongList = new ArrayList<Song>();
	public static FileInputStream fileByteStream = null;
	public static Scanner inFS = null;
	public static PrintWriter outFS = null;
	
	public static void ReadSongs() {
		
		try {
			
		fileByteStream = new FileInputStream("List.txt");
		
		inFS = new Scanner(fileByteStream);

			while(inFS.hasNext()) {
				Song song1 = new Song();
				song1.setBand(inFS.next());
				song1.setGenre(inFS.next());
				song1.setRlsDate(inFS.next());
				song1.setSongName(inFS.next());
				SongList.add(song1);
			}
		fileByteStream.close();
		}
		catch (IOException Test1){
			
			System.out.println("Handeled exception");
			System.out.println(Test1.getMessage());
					}
	
	}

	public static void SearchSongs(SearchResults frame, Predicate<Song>... predicates) {
		frame.taSearchResult.setText(null);
		for (Song song : SongList) {
			boolean matches = true;
			for (Predicate<Song> predicate : predicates) {
				if (!predicate.test(song)) {
					matches = false;
					break;
				}
			}
			if (matches) {
				System.out.println("Results found: " + song);
				frame.taSearchResult.append(song.toString() + "\n");
			}
		}
	}
	
	//Search function only for the songname//
	public static void Searchname(String Songname, view.SearchResults frame1) {
		frame1.taSearchResult.setText(null);
		for (Song c: SongList) {
			if (c.getSongName().equals(Songname))  {
				System.out.println("results for same band name: " + c);
				frame1.taSearchResult.append(c.toString() + "\n");
				}
			
			}
	}
	
	
}
