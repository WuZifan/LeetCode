package easy;

import org.junit.Test;

public class ReverseString {
	public String reverseString(String s) {
		/*
		 * 标准答案里面不用进行空字符串删除，我觉得不是很好= -
		 */
		if (!s.isEmpty()) {
			char[] c = new char[s.length()];
			for (int i = 0; i < c.length; i++) {
				c[i] = s.charAt(s.length() - 1 - i);
			}
			s = new String(c);
			return s;
		} else {
			throw new RuntimeException("Runtime Exception");
		}
	}

	@Test
	public void test() {
		String s = "hello";
		System.out.println(reverseString(s));
	}
}