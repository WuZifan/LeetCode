package amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.junit.Test;

public class Test2 {
	
	public String varify(String s){
		char[] c=s.toCharArray();
		Map<Character,Character> map=new HashMap<Character,Character>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		Stack<Character> st=new Stack<Character>();
		Set<Character> set=map.keySet();
		String res="valid";
		for(char ch:c){
			if(!set.contains(ch)){
				char leftc='\0';
				if(st.isEmpty()){
					res="unvalid";
					break;
				}else{
					leftc=st.pop();
				}
				if(map.get(leftc) == ch){
					
				}else{
					res="unvalid";
					break;
				}
			}else{
				st.add(ch);
			}
		}
		return res;
	}
	
	@Test
	public void test(){
		String s="](){";
		System.out.println(varify(s));
	}
}
