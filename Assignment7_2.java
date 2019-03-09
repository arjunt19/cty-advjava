//Arjun Tammishetti
import java.io.*;
import java.util.Scanner;
public class Assignment7_2 {

	public static void main(String[] args) {
		ObjectInputStream in; //creates objectinputstream to deserialize array
		Scanner input = new Scanner(System.in);
		System.out.println("What is the file name?");
		String choice = input.next(); //gets file name
		Song[] deserialized = null; //array to hold the deserialized array
		int count = 0;
		try { 
			in = new ObjectInputStream( new BufferedInputStream (new FileInputStream(choice))); //references chosen file
			deserialized = (Song[]) in.readObject();
			for ( Song e: deserialized) { //foreach loop to display array info using getters
				System.out.println("Song " + ++count);
				System.out.println("Title: " + e.getTitle());
				System.out.println("Artist: " + e.getArtist());
				System.out.println("Genre: "+ e.getGenre());
				System.out.println("Release Date: " + e.getDate());
			}
			in.close();
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
