package webhsy.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordBookImpl implements WordBook{
	
	@Override
	public boolean addWord(String word, String mean) {
		boolean result = false;
		ArrayList<String> means = null;
		try {
			if(wordBook.containsKey(word)) {
				means = wordBook.get(word);
				means.add(mean);
				wordBook.put(word, means);
				result = true;
			}else { 
				means = new ArrayList<>();
				means.add(mean);
				wordBook.put(word, means);
				result = true;
			}
		}catch(Exception e) {
			System.out.println("단어 추가중 에러 발생 : " + e.getMessage());
		}
		return result;
	}

	@Override
	public void searchByWord(String word) {
		try {
			boolean findWord = false;
			Map<String, ArrayList<String>> words = new HashMap<String, ArrayList<String>>();
			for(String key : wordBook.keySet()) {
				if(key.contains(word)) {
					words.put(key, wordBook.get(key));
					findWord = true;
				}
			}
			if(findWord) {
				for(Map.Entry<String, ArrayList<String>> found : words.entrySet()) {
					String key = found.getKey();
					ArrayList<String> means = found.getValue();
					displayMean(key, means);
				}
			}else {
				throw new WordNotFoundException();
			}
		}catch(WordNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void searchByMean(String mean) {
		try {
			Map<String, ArrayList<String>> wordLists = new HashMap<>();
			if(wordBook.size() > 0) {
				for (Map.Entry<String, ArrayList<String>> entry : wordBook.entrySet()) {
					String word = entry.getKey();
					ArrayList<String> means = entry.getValue();
					for(String meanV : means) {
						if(meanV.contains(mean)) {
							wordLists.put(word, means);
						}
					}
				}
				if(wordLists.size() < 1) throw new WordNotFoundException();
				System.out.printf("%s 의 뜻을 가진 단어입니다. \n", mean);
				for(Map.Entry<String, ArrayList<String>> found : wordLists.entrySet()) {
					String foundKey = found.getKey();
					ArrayList<String> foundMean = found.getValue();
					displayMean(foundKey, foundMean);
				}
				System.out.println("-----------------------------");
			}else {
				throw new WordNotFoundException();
			}
		}catch (WordNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void getWordList() {
		try {
			if(wordBook.size() > 0) {
				System.out.println("총 단어 수 : " + wordBook.size());
				for(Map.Entry<String, ArrayList<String>> entry : wordBook.entrySet()) {
					String word = entry.getKey();
					ArrayList<String> means = entry.getValue();
					displayMean(word, means);
				}
			}else {
				throw new WordNotFoundException("등록된 단어가 없습니다.");
			}
		}catch(WordNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void removeByWord(String word) {
		try {
			if(wordBook.containsKey(word)) {
				wordBook.remove(word);
				System.out.println("삭제 성공");
			}else {
				throw new WordNotFoundException();
			}
		}catch(WordNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void displayMean(String word, ArrayList<String> means) {
		System.out.println("단어 : " + word);
		for(int i=0; i<means.size(); i++) {
			if(i==means.size()-1) {
				System.out.println(means.get(i));
			}else {
				System.out.print(means.get(i) + ", ");
			}
		}
		System.out.println("-----------------------------------");
	}

}
