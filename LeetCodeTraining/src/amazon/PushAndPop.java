package amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class PushAndPop {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] row1 = sc.nextLine().split(" ");
		String[] row2 = sc.nextLine().split(" ");
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < row1.length; i++) {
			list1.add(Integer.parseInt(row1[i]));
			list2.add(Integer.parseInt(row2[i]));
		}
		result.add("push" + list1.get(0));

		for (int i = 0, j = 0;;) {
			if (list2.get(j) == list1.get(i)) {
				int temp = list1.remove(i);
				result.add("pop" + temp);
				if (j < list2.size() - 1) {
					j++;
				} else {
					break;
				}

				if (i != 0) {
					i--;
				} else {
					result.add("push" + list1.get(i));
				}
			} else {
				i++;
				result.add("push" + list1.get(i));
			}
		}
		System.out.println(result);
	}

	@Test
	public void test() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		System.out.println(list.get(0));
		list.remove(0);
		System.out.println(list.get(0));
	}

}
