package views;

import java.util.Observable;
import java.util.Observer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.WordTree;

public class AddView extends BorderPane implements Observer {

	private WordTree theTree;
	private GridPane gp;
	
	private TextField textField;
	private Button addButton;
	private Label responseText;

	// constructor
	public AddView(WordTree tree) {
		theTree = tree;
		gp = new GridPane();
		this.setCenter(gp);
		initializePane();
	}
	
	private void initializePane() {
		addButton = new Button("Add");
		textField = new TextField();
		textField.setEditable(true);
		responseText = new Label("Enter a word to add");
		gp.setPrefWidth(300);
		gp.setPrefHeight(400);
		
		ButtonListener handler = new ButtonListener();
		addButton.setOnAction(handler);
		
		
		GridPane.setConstraints(textField, 1, 1);
		GridPane.setConstraints(addButton, 2, 1);
		GridPane.setConstraints(responseText, 1, 2);
		
		gp.setHgap(10);
		gp.setVgap(30);
		gp.getChildren().addAll(textField, addButton, responseText);
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		//theTree = (WordTree) o;
	}
	
	public class ButtonListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			String text = textField.getText();
			if (!text.isEmpty()) {
				System.out.println("Adding -> '" + text + "' to the tree...");
				responseText.setText("'" + text + "' added successfully");
			} else {
				responseText.setText("Please enter a word");
			}
			textField.setText("");
		}
	}
}
