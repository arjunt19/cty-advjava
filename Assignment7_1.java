//Arjun Tammishetti 
import java.io.*; // scanner and io imported for user input and output stream
import java.util.Scanner;
public class Assignment7_1{

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("How many songs do you want to add? ");
		int choice  = input.nextInt(); //allows user to enter size of array and then creates array of Song
		Song [] collection = new Song[choice]; 
		ObjectOutputStream out = null; //to serialize the array
		for (int i = 0; i < choice; i++) { //for loop gathers input and uses setters from Song class
			collection[i] = new Song();
			System.out.println("Song " + (i+1));
			System.out.println("Song title?");
			input.nextLine(); //need to skip because Scanner is in wrong place after reading int and then a line
			String title = input.nextLine();
			 collection[i].setTitle(title);
			 System.out.println("Song Artist?");
			String artist = input.nextLine();
			 collection[i].setArtist(artist);			
			 System.out.println("Song Genre?");
			 String genre = input.nextLine();
			 collection[i].setGenre(genre);			
			 System.out.println("Song release date (m d y)?");
			int m= input.nextInt();
			int d= input.nextInt();
			int y= input.nextInt();
			collection[i].setDate(m,d,y);
		}
		System.out.println("What file name do you want?");
		String fileName = input.next(); //asks for file name
		try { //serializes the collection array of Song Objects inside of a try catch
			out = new ObjectOutputStream( new BufferedOutputStream (new FileOutputStream(fileName)));
			out.writeObject(collection);
			out.close();
		}
		catch(Exception e) {
			System.err.println(e.getMessage()); //displays any error message
		}
	}

}
