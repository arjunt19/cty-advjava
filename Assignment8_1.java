import java.io.*; //importing necessary packages
import java.util.*;
public class Assignment8_1 {

	public static void main(String[] args) {
		TreeMap <String, Song> songMap = new TreeMap<String, Song>(); //new treemap with key String and value song
		Scanner input = new Scanner(System.in);
		ObjectOutputStream out = null; //to serialize the array
		boolean keepGoing = true;
		//the while loop asks the user to give info for songs and adds to treemap, makes a collection of the songs
		while (keepGoing) { //until user says exit, the program keeps going
			Song song = new Song(); //creates song and asks user for input
			System.out.println("Name of Song?");
			String name = input.nextLine();
			System.out.println("Genre?");
			String genre = input.nextLine();
			System.out.println("Name of Artist?");
			String artist = input.nextLine();
			System.out.println("Date released? (m d y)");
			int m = input.nextInt();
			int d = input.nextInt();
			int y = input.nextInt();
			song.setArtist(artist);
			song.setDate(m, d, y);
			song.setGenre(genre);
			song.setTitle(name);
			songMap.put(name, song);
			System.out.println("Do you want to add another song? (enter 1 for yes and 2 for no)");
			int choice = input.nextInt();
			switch (choice) { //switch choice if keep adding songs or not
			case 1: break;
			case 2: keepGoing = false;
					   break;
			}
			input.nextLine();
		}
		try { //serializes and writes map to chosen file so it can deserialized and modified in program 2
			System.out.println("What file do you want to store the songs in?");
			String fileName = input.nextLine();
			out = new ObjectOutputStream( new BufferedOutputStream (new FileOutputStream(fileName)));	
			out.writeObject(songMap);
			out.close();
			}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
