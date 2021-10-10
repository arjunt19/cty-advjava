//Arjun Tammishetti
import javafx.geometry.*; //necessary fx imports
import javafx.scene.*; 
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;

import javafx.application.*;

public class Assignment_10 extends Application { //extends application
	public void start(Stage stage) {
		
		try { //try catch because using fileinputstream
			stage.setTitle("app"); //sets name of stage
			FlowPane rootNode = new FlowPane();
			rootNode.setAlignment(Pos.CENTER);
		Image image1 = new Image(new FileInputStream("src/card1.gif")); //creating images and then adding them to layout
		rootNode.getChildren().add(new ImageView(image1));
		Image image2 = new Image(new FileInputStream("src/card2.gif"));
		rootNode.getChildren().add(new ImageView(image2));
		Image image3 = new Image(new FileInputStream("src/card3.gif"));
		rootNode.getChildren().add(new ImageView(image3));
		Scene scene = new Scene(rootNode, 400 , 200);
		stage.setScene(scene); //passing stage the scene
		stage.show();
		}
		catch(Exception e) { //catch
			System.err.println(e.getMessage());
		}
		}
}
