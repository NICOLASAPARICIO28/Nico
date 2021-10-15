


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//  declare five buttons, a label, and a textfield
	Button hello, howdy, chinese, spanish, clear, exit;
	
	Label Feedback;
	
	TextField textfield;
	//  declare two HBoxes
	
	HBox hBoxOne, hBoxTwo;
	
	//  declare an instance of DataManager
	
	DataManager dataMg;
	
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		
		dataMg = new DataManager();
		
		hello = new Button("Hello");
		
		howdy = new Button("Howdy");
		
		chinese = new Button("Chinese");
		
		spanish = new Button("Spanish");
		
		clear = new Button("Clear");
		
		exit = new Button("Exit");
		
		Feedback = new Label("Feedback: ");
		
		textfield = new TextField();
		
		hBoxOne = new HBox();
		
		hBoxTwo = new HBox();
		
		//Allows buttons to be visible on the GUI
		hBoxOne.getChildren().addAll(Feedback, textfield);
		
		hBoxTwo.getChildren().addAll(hello, howdy, chinese, spanish, clear, exit);

		getChildren().addAll(hBoxOne, hBoxTwo);
		
		//Allows buttons to responde on the GUI
		hello.setOnAction(new ButtonHandler());
		
		howdy.setOnAction(new ButtonHandler());
		
		chinese.setOnAction(new ButtonHandler());
		
		spanish.setOnAction(new ButtonHandler());
		
		clear.setOnAction(new ButtonHandler());
		
		exit.setOnAction(new ButtonHandler());
		
		//Centers components and text
		Insets inset = new Insets(10);
		HBox.setMargin(hello, inset);
		HBox.setMargin(howdy, inset);
		HBox.setMargin(chinese, inset);
		HBox.setMargin(spanish, inset);
		HBox.setMargin(clear, inset);
		HBox.setMargin(exit, inset);
		
		hBoxOne.setAlignment(Pos.CENTER);
		
		hBoxTwo.setAlignment(Pos.CENTER);
		
	}
	
	//Class that calls each method from the datamanager file that corresponds with the buttons
	private class ButtonHandler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event) {
			if (event.getTarget() == hello) {
				textfield.setText(dataMg.getHello());
			}
			else if (event.getTarget() == howdy) {
				textfield.setText(dataMg.getHowdy());
			}
			else if (event.getTarget() == chinese) {
				textfield.setText(dataMg.getChinese());
			}
			else if (event.getTarget() == spanish) {
				textfield.setText(dataMg.getSpanish());
			}
			else if (event.getTarget() == clear) {
				textfield.setText(" ");
			}
			else if (event.getTarget() == exit) {
				System.exit(0);
			}
		}
	}

}
	