package easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class IntersectionOfTwoArray {
	/**
	 * 用了很蠢的办法完成了= - 
	 * 基本上也是这个办法了，还有一个用的是 Binary Search
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] intersection(int[] nums1,int[] nums2){
		Set<Integer> set=new HashSet<Integer>();
		
		for (int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]);
		}
		
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<nums2.length;i++){
			if(set.contains(nums2[i])){
				list.add(nums2[i]);
				set.remove(nums2[i]);
			}
		}
		int[] result=new int[list.size()];
		int count=0;
		for (int i : list) {
			result[count]=i;
			count++;
		}
		return result;
	}
	
	@Test
	public void test(){
		int[] nums1={1,2,2,1};
		int[] nums2={2,2};
		int[] result=intersection(nums1, nums2);
		for (int i : result) {
			System.out.println(i);
		}
	}
}
