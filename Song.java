//Arjun Tammishetti
import java.io.*;
public class Song implements Serializable { //implements serializable as it needs to be serialized
	String title; //necessary data attributes
	String artist;
	String genre;
	Date releaseDate;
	public Song() { //constructor that creates date object
		releaseDate = new Date();
	}
	public void setTitle(String a ) { //setters and getters for attributes
		title = a;
	}
	public void setArtist(String a ) {
		artist = a;
	}
	public void setGenre(String a ) {
		genre = a;
	}
	public void setDate(int m, int d, int y ) {
		releaseDate.setDate(m,d,y);
	}
	public String getTitle() {
		return title;
	}
	public String getArtist() {
		return artist;
	}
	public String getGenre() {
		return genre;
	}
	public String getDate() {
		return releaseDate.getDateString();
	}
}
