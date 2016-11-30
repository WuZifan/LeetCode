package amazon;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pair {
	private static int cont(int[] numbers, int k) {

		Arrays.sort(numbers);
		List<Integer> list = new ArrayList<Integer>();
		Set<String> set = new HashSet<String>();
		for (int i : numbers) {
			list.add(i);
		}
		for (int i = 0; i < list.size(); i++) {
			int first = list.get(i);
			if (list.contains(first + k)) {
				set.add("" + first + " " + (first + k));
			}
		}

		return set.size();
	}
	
	private static int cont3(int[] numbers, int k) {

		HashMap<Integer,Boolean> list = new HashMap<Integer,Boolean>(2*100000);
		Set<String> set = new HashSet<String>();
		for (int i =0;i<2*100000;i++) {
			list.put(i, false);
		}
		for(int i:numbers){
			list.put(i, true);
		}
		for (int i = 0; i < numbers.length; i++) {
			int first = numbers[i];
			if(first-k>=0 && first-k<2*10000){
				if(list.get(first-k)){
					set.add(""+(first-k)+" "+first);
				}
			}
			if(first+k>=0&&first+k<2*10000){
				if(list.get(first+k)){
					set.add(""+(first)+" "+(first+k));
				}
			}
			
		}

		return set.size();
	}

	private static int count2(int[] numbers, int k) {
		int n = numbers.length;
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for (int i = 0; i < 2 * 100000; i++) {
			map.put(i, false);
		}

		for (int i : numbers) {
			map.put(i, true);
		}

		Set<String> set=new HashSet<String>();
		for (int i = 0; i < n; i++) {
			int temp = numbers[i];
			if (temp - k >= 0) {
				if(map.get(temp - k)!=null){
				set.add(""+(temp-k)+" "+temp);
				}
			}
			if (temp + k < n && map.get(temp + k)) {
				set.add(""+(temp)+" "+(temp+k));
			}
		}
		return set.size();
	}

	public static void main(String[] args) {
//		 int[] numbers={1,2,3,4,5,6};
		int[] numbers = { 1, 2, 5, 6, 9, 10 };
		int k = 2;
		System.out.println(cont3(numbers, k));
	}
}
