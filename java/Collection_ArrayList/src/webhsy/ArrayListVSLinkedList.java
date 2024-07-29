package webhsy;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVSLinkedList {

	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(5);
		System.out.println("=========add===========");
		System.out.println("LinkedList : "+ add(ll));
		System.out.println("ArrayList : " + add(al));
		System.out.println("=========addMid===========");
		System.out.println("LinkedList : "+ addMid(ll));
		System.out.println("ArrayList : " + addMid(al));
		System.out.println("=========access===========");
		System.out.println("LinkedList : "+ access(ll));
		System.out.println("ArrayList : " + access(al));
		System.out.println("=========remove===========");
//		System.out.println("LinkedList : "+ remove1(ll));
//		System.out.println("ArrayList : " + remove1(al));
		System.out.println("=========remove0===========");
		System.out.println("LinkedList : "+ remove0(ll));
		System.out.println("ArrayList : " + remove0(al));
	}
	
	private static long add(List<Integer> l) {
		Long start = System.currentTimeMillis();
		for(int i=0; i<100000; i++) {
			l.add(i);
		}
		Long end = System.currentTimeMillis();
		return end-start;
	}
	
	private static long addMid(List<Integer> l) {
		Long start = System.currentTimeMillis();
		for(int i=0; i<10000; i++) {
			l.add(1000 ,i);
		}
		Long end = System.currentTimeMillis();
		return end-start;
	}
	
	private static long access(List<Integer> l) {
		Long start = System.currentTimeMillis();
		for(int i=0; i<10000; i++) {
			l.get(i);
		}
		Long end = System.currentTimeMillis();
		return end-start;
	}
	private static long remove1(List<Integer> l) {
		Long start = System.currentTimeMillis();
		for(int i=l.size()-1; i>=0; i--) {
			l.remove(i);
		}
		Long end = System.currentTimeMillis();
		return end-start;
	}
	private static long remove0(List<Integer> l) {
		Long start = System.currentTimeMillis();
		for(int i=0; i<l.size(); i++) {
			l.remove(i);
		}
		Long end = System.currentTimeMillis();
		return end-start;
	}
}
