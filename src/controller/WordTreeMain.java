package controller;

import java.util.Observer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.WordTree;
import views.AddView;
import views.DeleteView;
import views.SearchView;
import views.ShowView;

public class WordTreeMain extends Application {

	private WordTree theTree;				// the binary tree
	private MenuBar menuBar;					// menu bar for the menu driven program
	private Observer currentView;			// current view of the program
	private Observer addView;				// add word view 
	private Observer searchView;				// search for a word view
	private Observer showView;				// show all words view
	private Observer deleteView;				// delete a word view
	
	private BorderPane window;				// main window for the GUI
	public static final int width = 300;		// width of the window
	public static final int height = 500;	// height of the window
	
	public static void main(String[] args) {
		   launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Word Binary Tree");
		window = new BorderPane();
		Scene scene = new Scene(window, width, height);
		
		setupMenus();
		window.setTop(menuBar);
		theTree = new WordTree();
		
		addView = new AddView(theTree);
		searchView = new SearchView(theTree);
		showView = new ShowView(theTree);
		deleteView = new DeleteView(theTree);
		
		setViewTo(addView);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void setupMenus() {
		MenuItem addV = new MenuItem("Add a word");
		MenuItem searchV = new MenuItem("Search for a word");
		MenuItem showV = new MenuItem("Show all words");
		MenuItem deleteV = new MenuItem("Delete a word");
		MenuItem exitV = new MenuItem("Exit");
		
		Menu menu = new Menu("Menu");
		menu.getItems().addAll(addV, searchV, showV, deleteV, exitV);
		
		menuBar = new MenuBar();
		menuBar.getMenus().addAll(menu);
		
		//Add the same listener to all menu items requiring an action
		MenuItemListener menuListener = new MenuItemListener();
		addV.setOnAction(menuListener);
		searchV.setOnAction(menuListener);
		showV.setOnAction(menuListener);
		deleteV.setOnAction(menuListener);
		exitV.setOnAction(menuListener);
	}
	
	private void setViewTo(Observer newView) {
		window.setCenter(null);
		currentView = newView;
		window.setCenter((Node) currentView);
	}
	private class MenuItemListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			String text = ((MenuItem) event.getSource()).getText();
			
			System.out.println(text);
			
			if (text.equals("Add a word"))
//				System.out.println("Switching to add view...");
				setViewTo(addView);
			else if (text.equals("Search for a word"))
				setViewTo(searchView);
			else if (text.equals("Show all words"))
				setViewTo(showView);
			else if (text.equals("Delete a word"))
				setViewTo(deleteView);
			else if (text.equals("Exit"))
				System.exit(0);
		}
	
	}
	
	
	
	
}
