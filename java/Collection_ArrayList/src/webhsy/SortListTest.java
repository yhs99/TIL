package webhsy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortListTest {
	public static void main(String[] args) {
		String[] strArr = {"a", "b", "c", "e", "q", "E", "W", "B"};
		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
		System.out.println(Arrays.toString(strArr));
		
		List<String> list = new ArrayList<String>();
		list.add("a홍길동");
		list.add("e둘리");
		list.add("b마이콜");
		list.add("z도우너");
		System.out.println(list);

		Comparator<String> comp = new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};
		list.sort(comp);
		System.out.println(list);
		
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(11);
		intList.add(30);
		intList.add(5);
		intList.add(22);
		intList.add(20);
		System.out.println(intList);
		Comparator<Integer> intComp = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				return (o1<o2)? 1 : (o1==o2) ? 0 : -1;
			}
		};
		
		intList.sort(intComp);
		System.out.println(intList);
	}
}
