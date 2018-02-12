package model;

import java.util.Observable;

public class WordTree extends Observable {

	int height;		// height of the binary tree
	Word rootWord;	// root node of the binary tree
	
	public WordTree() {
		height = 0;
		rootWord = new Word("null");
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
	
	public void addWord(Word newWord) {
		if (rootWord.getString() == "null") {
			rootWord = newWord;
			height = 1;
		}
		else {
			Word currentWord = rootWord;
			for (int i = 1; i <= height; i++) {
				
				String newWordString = newWord.getString();
				String currentWordString = currentWord.getString();
				
				if (newWordString.compareTo(currentWordString) <= 0) { // the new word is less than or equal to the current word in the tree 
					String leftChildString = currentWord.getLeftChild().getString();
					if (leftChildString.equals("null")) {
						currentWord.setLeftChild(newWord);
						if (currentWord.getRightChild().getString().equals("null"))
							height++; // no exisiting nodes at this height so the tree height increases
					}
					else {
						// TODO: move to the next node in the tree
					}
				}
				else if (newWordString.compareTo(currentWordString) > 0) { // the new word is greater than the current word in the tree 
					String rightChildString = currentWord.getRightChild().getString();
					if (rightChildString.equals("null")) {
						currentWord.setRightChild(newWord);
						if (currentWord.getLeftChild().getString().equals("null"))
							height++; // no exisiting nodes at this height so the tree height increases
					}
					else {
						// TODO: move to the next node in the tree
					}
				}
			}
		}
	}
}
