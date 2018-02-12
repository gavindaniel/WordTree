package views;

import java.util.Observable;
import java.util.Observer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.WordTree;

public class SearchView extends BorderPane implements Observer {

	private WordTree theTree;
	private GridPane gp;
	
	private TextField textField;
	private Button addButton;

	// constructor
	public SearchView(WordTree tree) {
		theTree = tree;
		gp = new GridPane();
		this.setCenter(gp);
		initializePane();
	}
	
	private void initializePane() {
		addButton = new Button("Add Word");
		textField = new TextField();
		textField.setEditable(true);
		gp.setPrefWidth(300);
		gp.setPrefHeight(500);
		
		ButtonListener handler = new ButtonListener();
		addButton.setOnAction(handler);
		
		GridPane.setConstraints(textField, 1, 1);
		GridPane.setConstraints(addButton, 2, 1);
		
		gp.getChildren().addAll(textField, addButton);
		
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
			System.out.println("Adding -> '" + textField.getText() + "' to the tree...");
		}
	}
}
