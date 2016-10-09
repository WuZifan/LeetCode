package easy;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TwoSum {
		// 这个写法太丑了…
		public int[] twoSum(int[] sums, int target) {
			boolean flag = false;
			int add_first = 0;
			int add_second = 0;
			for (int i : sums) {
				int add = target - i;
				add_second = 0;
				for (int j : sums) {
					if (j == add && add_first != add_second) {
						flag = true;
						break;
					}
					add_second += 1;
				}
				if (flag) {
					break;
				}
				add_first += 1;
			}
			return new int[] { add_first, add_second };
		}

		// 时间复杂度为O(n²)的算法
		public int[] twoSum1(int[] nums, int target) {
			/**
			 * 和自己的算法比较，最大的差别就是对数组的遍历，用的是增强for还是下标
			 * 在返回值要求是下标的问题上，利用下标来遍历对代码的简洁性有很大的提升。
			 */
			for (int i = 0; i < nums.length; i++) {
				for (int j = 0; j < nums.length; j++) {
					if (target - nums[i] == nums[j] && i != j) {
						return new int[] { i, j };
					}
				}
			}
			throw new RuntimeException("No such solution");
		}

		// 时间复杂度为O(n)的算法
		public int[] twoSum2(int[] nums, int target) {
			/**
			 * 大致思路就是 把数组中的元素存入HashMap中 由于HashMap是以Hash table作为底层的 所以查找速度是O(1)
			 * 因此总的时间复杂度就是O(n)*O(1)=O(n)
			 */
			Map<Integer, Integer> iMap = new HashMap<Integer, Integer>();
			for (int i = 0; i < nums.length; i++) {
				/**
				 * 注意这里是把数组中的值作为key 下标作为value加入的 这里是否就默认了数组中的值不能有重复
				 */
				iMap.put(nums[i], i);
			}
			for (int i = 0; i < nums.length; i++) {
				int add = target - nums[i];
				if (iMap.containsKey(add) && iMap.get(add) != i) {
					return new int[] { i, iMap.get(add) };
				}
			}
			throw new RuntimeException("No such solution");
		}

		@Test
		public void test() {
			int[] sums = { 3, 2, 4 };
			int target = 6;
			for (int i : twoSum(sums, target)) {
				System.out.println(i);
			}
			for (int i : twoSum1(sums, target)) {
				System.out.println(i);
			}
			for (int i : twoSum2(sums, target)) {
				System.out.println(i);
			}
		}
	}
