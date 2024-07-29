package webhsy;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(10);
		list.add(30);
		list.add(1, 20);
		System.out.println(list);
		
		int a = list.get(0);
		System.out.println(a);
		
		// 리스트의 길이
		System.out.println("리스트의 길이 : " + list.size());
		
		List<Object> list2 = new ArrayList<>();
		List<Object> list3 = new ArrayList<>();
		
		list3.add(1);
		list3.add(2);		
		list2.add(1);
		list2.add(2);
		list3.add("A");
		list3.add("B");
		list3.add("C");
		System.out.println(list2);
		
		// list에서 겹치는 부분만 남기고 나머지는 삭제한다
		for(int i=0; i<list2.size(); i++) {
			if(list3.contains(list2.get(i))) {
				list3.remove(list3.indexOf(list2.get(i)));
			}
		}
		System.out.println(list3);
		
	}

}
