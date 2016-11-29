package amazon;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class Test1 {

	private int find(int[] nums, int k) {
		Set<Integer> set=new HashSet<Integer>();
		for(int i:nums){
			set.add(i);
		}
		int result=0;
		for(int i:set){
			if(set.contains(i+k)){
				result++;
			}
		}
		return result;
	}

	@Test
	public void test() {
		int k = 4;
		int[] nums = { 1, 1, 5, 2, 1, 2 };
		System.out.println(find(nums, k));
	}
}
