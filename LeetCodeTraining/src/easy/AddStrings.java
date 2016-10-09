package easy;

import org.junit.Test;

public class AddStrings {
	/**
	 * 还没有完成，加法功能还是有问题，去0功能还没有完全实现
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String addString(String num1, String num2) {
		char[] longer=null;
		char[] shorter=null;
		if (num1.length() >= num2.length()) {
			longer= num1.toCharArray();
			shorter = num2.toCharArray();
		}else{
			longer = num2.toCharArray();
			shorter = num1.toCharArray();
		}
		int ahead=0;
		for (int i = longer.length - 1, j = shorter.length - 1; i>=0; i--, j--) {
			int shortIndex=0;
			if(j>=0){
				shortIndex=shorter[j]-'0';
			}else{
				shortIndex=0;
			}
				int result=(longer[i]-'0')+shortIndex+ahead;
				if(result<10){
					result=result+'0';
					longer[i]=(char)result;
					ahead=0;
				}else{
					result=result%10;
					result=result+'0';
					longer[i]=(char)result;
					ahead=1;
				}
		}
		return new String(longer);
	}

	@Test
	public void test() {
		String num1 = "19";
		String num2 = "2";
		System.out.println(addString(num1, num2));
	}
}
