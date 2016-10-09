package easy;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class SingleNumber {
	/**
	 * 这里的思路是这样的，把每个数字都存到map中，作为key，value为他们的出现的次数 之后根据value来取key就好了。
	 * 
	 * @param nums
	 * @return
	 */
	public int singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.keySet().contains(nums[i])) {
				int count = map.get(nums[i]);
				count += 1;
				map.put(nums[i], count);
			} else {
				map.put(nums[i], 1);
			}
		}
		for (int i : map.keySet()) {
			if (map.get(i) == 1) {
				return i;
			}
		}
		throw new RuntimeException("No solution");
	}

	/**
	 * 这里是利用位运算中的异或运算（同一位上数字不同，则置1，否则写0）， 比如 0101 和0110进行运算后，得到 0011
	 * 而一个数与自己进行异或运算，得到0； 任何数和0进行异或运算，得到自己；
	 * 因此，对nums里面所有的数进行异或运算，成对的数都是0，最后得到落单的数
	 * 
	 * @param nums
	 * @return
	 */
	public int singleNumber2(int[] nums) {
		int x = 0;
		for (int i : nums) {
			x = x ^ i;
			System.out.println(x);
		}
		return x;
	}

	@Test
	public void test() {
		int[] nums = { 1, 1, 2, 2, 3, 42, 3 };
		System.out.println(singleNumber2(nums));
	}
}
