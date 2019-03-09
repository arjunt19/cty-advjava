//Arjun Tammishetti 8-16-18
import javafx.scene.*;
import javafx.stage.*;//necessary imports
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.*;
import java.io.*;
import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.control.Button;
public class Assignment_11 extends Application { // extends application
	int counter1 = 1; //counters to determine flip
	int counter2 = 1;
	int counter3 = 1;
	public void start(Stage stage) {
		try { // try catch because using fileinputstream
			stage.setTitle("app"); // sets name of stage
			FlowPane rootNode = new FlowPane( 5, 5); //layout manager flowPane used with gaps
			rootNode.setAlignment(Pos.CENTER); //center position to keep cards in center

			Image image1 = new Image(new FileInputStream("src/card1.gif")); //new image which is passed to imageview
			ImageView imageOne = new ImageView(image1);
			imageOne.setFitWidth(150); //configure size
			imageOne.setFitHeight(200);
			
			Button button1 = new Button("Flip"); //create button
                 button1.setOnAction(new EventHandler<ActionEvent>(){ //event handler for flip for card 1
					public void handle(ActionEvent event) {
						try { //the try and catch is for the fileinputstream and the if else determines what side it should display when the flip button is clicked
							//it allows the user to keep flipping/unflipping the card
							if (counter1 % 2 != 0 ) {
							imageOne.setImage(new Image(new FileInputStream("src/purple.gif")));
							counter1++;
							}
							else if (counter1 %2 == 0) {
								imageOne.setImage(new Image(new FileInputStream("src/card1.gif")));
								counter1++;
							}
						} catch (Exception e) {
							System.err.println(e.getMessage());
						}
					}
                 });
			Image image2 = new Image(new FileInputStream("src/card2.gif")); //the same process is repeated with the other images and buttons
			ImageView imageTwo = new ImageView(image2);
			imageTwo.setFitWidth(150);
			imageTwo.setFitHeight(200);
			
			Button button2 = new Button("Flip");
            button2.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event) {
					try {
						if (counter2 % 2 != 0 ) {
						imageTwo.setImage(new Image(new FileInputStream("src/purple.gif")));
						counter2++;
						}
						else if (counter2 %2 == 0) {
							imageTwo.setImage(new Image(new FileInputStream("src/card2.gif")));
							counter2++;
						}
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
				}
            });
            
			Image image3 = new Image(new FileInputStream("src/card3.gif"));
			ImageView imageThree = new ImageView(image3);
			imageThree.setFitWidth(150);
			imageThree.setFitHeight(200);
			Button button3 = new Button("Flip");
            button3.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event) {
					try {
						if (counter3 % 2 != 0 ) {
						imageThree.setImage(new Image(new FileInputStream("src/purple.gif")));
						counter3++;
						}
						else if (counter3 %2 == 0) {
							imageThree.setImage(new Image(new FileInputStream("src/card3.gif")));
							counter3++;
						}
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
				}
            });
			HBox buttons = new HBox(110); //creating HBox in order to position the buttons below the images
			buttons.setAlignment(Pos.BOTTOM_LEFT);
			rootNode.getChildren().addAll(imageOne, imageTwo, imageThree); //adding nodes to layout manager
			buttons.getChildren().addAll(button1, button2, button3);
			rootNode.getChildren().add(buttons);
			Scene scene = new Scene(rootNode, 700, 350); //passing layout manager and size parameters to scene
			stage.setScene(scene); // passing stage the scene
			stage.show(); //displaying the scene
		}
		catch (Exception e) { //catch any errors
			System.err.println(e.getMessage());
		}
		
	}
	}

