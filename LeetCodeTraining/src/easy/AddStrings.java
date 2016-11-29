package easy;

import org.junit.Test;

public class AddStrings {

	/**
	 * 1. no leading zero 
	 * 2. both numbers are less than 5100 
	 * 3. only contains digital 0~9 
	 * 4. cant conver string into integer
	 * Good Algorithm, beats 88.74%
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String addStrings(String num1, String num2) {
		char[] longerNum = null;
		char[] shorterNum = null;
		// get the longer number in two num
		if (num1.length() >= num2.length()) {
			longerNum = num1.toCharArray();
			shorterNum = num2.toCharArray();
		} else {
			longerNum = num2.toCharArray();
			shorterNum = num1.toCharArray();
		}
		// result array
		char[] result = new char[longerNum.length + 1];
		int flag = 0;
		for (int l = longerNum.length - 1, s = shorterNum.length - 1; l >= 0; s--, l--) {
			
			int bitResult=0;
			if (s >= 0) {
				 bitResult= longerNum[l] - '0' + shorterNum[s] - '0' + flag;
				if (bitResult >= 10) {
					flag = 1;
					result[l + 1] = (char) (bitResult % 10 + '0');
				} else {
					flag = 0;
					result[l + 1] = (char) (bitResult + '0');
				}
			} else {
				bitResult=longerNum[l]-'0'+flag;
				if (bitResult >= 10) {
					flag = 1;
					result[l + 1] = (char) (bitResult % 10 + '0');
				} else {
					flag = 0;
					result[l + 1] = (char) (bitResult + '0');
				}
			}
		}
		if(flag==1){
			result[0]='1';
		}
		String res=new String(result);
		return res.trim();
	}

	@Test
	public void test() {
		String num1 = "19";
		String num2 = "299";
		System.out.println(addStrings(num1, num2));
	}
}
