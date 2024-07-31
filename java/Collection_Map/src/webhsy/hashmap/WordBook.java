package webhsy.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface WordBook {
	public static Map<String, ArrayList<String>> wordBook = new HashMap<>();
	public boolean addWord(String word, String mean);
	public void searchByWord(String word);
	public void searchByMean(String mean);
	public void removeByWord(String word);
	public void getWordList();
	public void displayMean(String word, ArrayList<String> means);
}
