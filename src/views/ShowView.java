package views;

import java.util.Observable;
import java.util.Observer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.WordTree;

public class ShowView extends BorderPane implements Observer {

	private WordTree theTree;
	private ListView<String> list;

	// constructor
	public ShowView(WordTree tree) {
		theTree = tree;
		list = new ListView<String>();
		this.setCenter(list);
		initializePane();
	}
	
	private void initializePane() {
		
		list.setPrefWidth(300);
		list.setPrefHeight(500);
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		theTree = (WordTree) o;
		System.out.println("updating list for show...");
		addWords();
	}
	
	private void addWords() {
		if (!theTree.getRootWord().getString().equals("null")) {
			ObservableList<String> words = FXCollections.observableArrayList(theTree.getRootWord().getString());
			list.setItems(words);
		}
	}
}
