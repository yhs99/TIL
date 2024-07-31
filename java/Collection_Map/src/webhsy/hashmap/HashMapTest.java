package webhsy.hashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1, "apple");
		map.put(2, "grape");
		map.put(3, "pineapple");
		map.put(4, "watermelon");
		if(map.containsKey(4)) {
//			System.out.println(map.get(4));	
		}
		
		Set<Integer> keys = map.keySet();
		Collection<String> values = map.values();
//		System.out.println(map.putIfAbsent(7, "putIfAbsent"));
		map.replace(7, "replace");
		map.replace(7, "replace", "replace new");
		map.remove(1);
		map.remove(2, "grape");
//		keys.stream().forEach(System.out::println);
//		values.stream().forEach(System.out::println);
//		map.entrySet().stream().forEach(System.out::println);
		
		Map<String, Integer> students = new HashMap<String, Integer>();
		students.put("101", 94);
		students.put("102", 30);
		students.put("103", 32);
		students.put("104", 66);
		students.put("105", 92);
		int total = 0;
		for(int val : students.values()) {
			total += val;
		}
		double avg = (double)total / students.size();
		for (Map.Entry<String, Integer> entry : students.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			System.out.printf("학번 : %s, 점수 : %d\n", key, val);
		}
		System.out.printf("총점 : %d, 평균 : %.2f", total, avg);
	}
}
