package model;

import java.util.Observable;

public class WordTree extends Observable {

	int height;		// height of the binary tree
	Word rootWord;	// root node of the binary tree
	
	public WordTree() {
		height = 0;
		rootWord = new Word("null");
		rootWord.setParentWord(new Word("null"));
		rootWord.setLeftChild(new Word("null"));
		rootWord.setRightChild(new Word("null"));
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int newHeight) {
		height = newHeight;
	}
	public Word getRootWord() {
		return rootWord;
	}
	public void setRootWord(Word root) {
		rootWord = root;
	}
	
	public void addWord(String text) {
		
		Word newWord = new Word(text);
		newWord.setParentWord(new Word("null"));
		newWord.setLeftChild(new Word("null"));
		newWord.setRightChild(new Word("null"));
		
		if (rootWord.getString() == "null") {
			System.out.println("adding '" + newWord.getString() + "' to the root...");
			rootWord = newWord;
			height = 1;
		}
		else {
			Word currentWord = rootWord;
			System.out.println("* Root word -> " + currentWord.getString());
			
			for (int i = 1; i <= height; i++) {
				
				String newWordString = newWord.getString();
				String currentWordString = currentWord.getString();
				
				if (newWordString.compareTo(currentWordString) <= 0) { // the new word is less than or equal to the current word in the tree 
					String leftChildString = currentWord.getLeftChild().getString();
					if (leftChildString.equals("null")) {
						newWord.setParentWord(currentWord);
						currentWord.setLeftChild(newWord);
						if (currentWord.getRightChild().getString().equals("null"))
							height++; // no exisiting nodes at this height so the tree height increases
						i++;
					}
					else {
						// TODO: move to the next node in the tree
					}
				}
				else if (newWordString.compareTo(currentWordString) > 0) { // the new word is greater than the current word in the tree 
					System.out.println("* Right child word -> " + currentWord.getRightChild().getString());
					String rightChildString = currentWord.getRightChild().getString();
					
					if (rightChildString.equals("null")) {
						newWord.setParentWord(currentWord);
						currentWord.setRightChild(newWord);
						if (currentWord.getLeftChild().getString().equals("null")) 
							height++; // no exisiting nodes at this height so the tree height increases
						i++;
					}
					else {
						// TODO: move to the next node in the tree
					}
				}
			}
		}
		setChanged();
		notifyObservers();
		System.out.println("notifying observers...");
	}
}
