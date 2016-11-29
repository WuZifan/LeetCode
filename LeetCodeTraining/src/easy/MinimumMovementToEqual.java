package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class MinimumMovementToEqual {
	
	/**
	 * the length of input is n; every time only can increase n-1 elements by 1
	 * this movement equal to every time minus the largest one by 1 
	 * @param nums
	 * @return
	 */
	public int minMoves2(int[] nums){
		List<Integer> list=new ArrayList<Integer>();
		for(int i:nums){
			list.add(i);
		}
		Collections.sort(list);
		int result=0;
		for(int i=list.size()-1;i>0;i--){
			result+=list.get(i)-list.get(0);
		}
		return result;
	}
	
	/**
	 * Stupid Way
	 * 
	 * the length of input is n; every time only can increase n-1 elements by 1
	 * 
	 * @param nums
	 * @return
	 */
	public int minMoves(int[] nums) {
		int result = 0;
		if (nums.length >= 1) {
			while (!isEqual(nums)) {
				int maximum = nums[0];
				for (int i = 0; i < nums.length - 1; i++) {
					// the later one is larger than the former one
					if (nums[i + 1] >= maximum) {
						maximum = nums[i + 1];
						nums[i]++;
					} else {
						// the later one is small than the former one
						nums[i + 1]++;
					}
				}
				result++;
			}
		} else {
			result=0;
		}
		return result;
	}
	
	private boolean isEqual(int[] m){
		boolean flag=true;
		for(int i=0;i<m.length-1;i++){
			if(m[i]!=m[i+1]){
				flag=false;
				break;
			}
		}
		return flag;
	}

	@Test
	public void test() {
		int[] nums={1,2188982};
		System.out.println(minMoves2(nums));

	}
}
