import java.io.*;
import java.util.Scanner;

public class Trie{
	TrieNode root;
	
	class TrieNode{
		TrieNode[] wordArray;
		boolean isFilled;
		//TrieNode initialization with limiters being alphabet
		public TrieNode(){
			this.wordArray = new TrieNode[26];
		}
	}

	public Trie(){
		root = new TrieNode();
	}

	public void insert(String word){
		TrieNode insertNode = root;
		for(int i = 0; i < word.length(); i++){
			char c = word.charAt(i);
			int charIndex = c - 'a';
			if(insertNode.wordArray[charIndex] == null){
				TrieNode temp = new TrieNode();
				insertNode.wordArray[charIndex] = temp;
				insertNode = temp;
			} else {
				insertNode = insertNode.wordArray[charIndex];
			}
		}
		insertNode.isFilled = true;
	}


	public TrieNode search(String word){
		TrieNode temp = root;
		for (int i = 0; i < word.length(); i++){
			char c = word.charAt(i);
			int charIndex = c - 'a';
			if(temp.wordArray[charIndex]!=null){
				temp = temp.wordArray[charIndex];
			} else {
				return null;
			}
		}
		if(temp == root){
			return null;
		}
		return temp;
	}


	//findWord finds if a word is in the trie;
	public boolean findWord(String word){
		TrieNode temp = search(word);
		if(temp == null){
			return false;
		} else {
			return true;
		}
	}

	//findStart finds if a word begins with the prefix parameters
	public boolean findStart(String prefix){
		TrieNode temp = search(prefix);
		if(temp == null){
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) throws IOException{
	Trie musicalLyric = new Trie();
	Scanner s = null;
        try {
            s = new Scanner(System.in);
            while (s.hasNext()) {
                String word = s.next(); // Scanner splits input on whitespace, by default
                musicalLyric.insert(word);
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
	}

}



