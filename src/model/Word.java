package model;

public class Word {

	String element;		// content of the Word (e.g., element = "Bee")
	Word parentWord;		// parent node in the binary tree
	Word leftChild;		// left child node in the binary tree
	Word rightChild;		// right child node in the binary tree
	
	public Word(String w) {
		element = w;		// the word = element = key
//		parentWord = new Word("null");
//		leftChild = new Word("null");
//		rightChild = new Word("null");
	}
	
	public String getString() {
		return element;
	}
	public void setString(String s) {
		element = s;
	}
	public Word getParentWord() {
		return parentWord;
	}
	public void setParentWord(Word parentNode) {
		parentWord = parentNode;
	}
	public Word getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(Word leftChildNode) {
		leftChild = leftChildNode;
	}
	public Word getRightChild() {
		return rightChild;
	}
	public void setRightChild(Word rightChildNode) {
		rightChild = rightChildNode;
	}
}
