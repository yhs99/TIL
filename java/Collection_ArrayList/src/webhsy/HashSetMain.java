package webhsy;

import java.util.*;

public class HashSetMain {
	public static void main(String[] args) {
		HashSet<Integer> hashA = new HashSet<>();
		Long start1 = System.currentTimeMillis();
		System.out.println();
		for(int i=0; i< 10000000; i++) {
			hashA.add(i);
		}
		Long start2 = System.currentTimeMillis();
		System.out.println("add 끝 : " +(start2-start1));
		for(int i=0; i<10000000; i++) {
			hashA.add(1);
		}
		Long start3 = System.currentTimeMillis();
		System.out.println("add 중복 : "+(start3-start2));
		System.out.println();
	}
	
	private static Set<Integer> diffrence(Set<Integer> hashA, Set<Integer> hashB) {
		Set<Integer> result = new HashSet<Integer>();
		for(Integer res : hashA) {
			if(!hashB.contains(res)) {
				result.add(res);
			}
		}
		return result;
	}
	
	private static Set<Integer> union(Set<Integer> hashA, Set<Integer> hashB) {
		Set<Integer> result = new HashSet<Integer>(hashA);
		for(Integer res : hashB) {
			if(!result.contains(res)) {
				result.add(res);
			}
		}
		return result;
	}
}
