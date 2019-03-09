import java.util.*;
import java.io.*;
public class Assignment8_2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("What file contains the songs you want to access?");
		String fileName = input.nextLine();
		ObjectInputStream in = null;
		ObjectOutputStream out = null;
		boolean keepGoing = true;
		try {
			in = new ObjectInputStream( new BufferedInputStream (new FileInputStream(fileName)));	
			TreeMap<String, Song> holder = new TreeMap<String, Song>();
			holder = (TreeMap<String,Song>)in.readObject();
			while (keepGoing) {
				System.out.println("Do you want to display the songs (1), delete a song (2), add a song (3), or exit (4)? Enter the corresponding value");
				int choice = input.nextInt();
				input.nextLine();
				switch(choice) {
				case 1:
					System.out.println("Displaying Songs:");
					for (Map.Entry e: holder.entrySet()) {
						System.out.println(e.getKey());
					}
					break;
				case 2:
					System.out.println("Enter the song you want to delete");
					String delete = input.nextLine();
					holder.remove(delete);
					break;
				case 3:
					Song song = new Song();
					System.out.println("Enter the name of the song");
					String name = input.nextLine();
					System.out.println("Enter the genre of the song");
					String genre = input.nextLine();
					System.out.println("Enter the artist of the song");
					String artist = input.nextLine();
					System.out.println("Enter the release date of the song (m d y)");
					int m = input.nextInt();
					int d = input.nextInt();
					int y = input.nextInt();
					song.setArtist(artist);
					song.setDate(m, d, y);
					song.setGenre(genre);
					song.setTitle(name);
					holder.put(name, song);
					break;
				case 4: 
					keepGoing = false;
					break;
				}
			}
			out = new ObjectOutputStream( new BufferedOutputStream (new FileOutputStream(fileName)));	
			out.writeObject(holder);
			}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
		}
}
