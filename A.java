package amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class A {

	private static String[] braces(String[] values) {
		String[] result = new String[values.length];

		for (int i = 0; i < values.length; i++) {
			char[] c = values[i].toCharArray();
			Map<Character, Character> map = new HashMap<Character, Character>();
			map.put('(', ')');
			map.put('{', '}');
			map.put('[', ']');
			Stack<Character> st = new Stack<Character>();
			Set<Character> set = map.keySet();
			String res = "YES";
			for (char ch : c) {
				if (!set.contains(ch)) {
					char leftc = '\0';
					if (st.isEmpty()) {
						res = "NO";
						break;
					} else {
						leftc = st.pop();
					}
					
					if (map.get(leftc) == ch) {

					} else {
						res = "NO";
						break;
					}
				} else {
					st.add(ch);
				}
			}
			result[i] = res;
		}
		return result;

	}
	
	private static String[] braces2(String[] values) {
		String[] result = new String[values.length];

		for (int k = 0; k < values.length; k++) {
			char[] c = values[k].toCharArray();
	        Stack<Character> stack = new Stack<Character>();
	        for(int i = 0;i < c.length;i++){
	            if(c[i] == '(' || c[i] == '{' || c[i] == '['){
	                stack.push(c[i]);
	            } else{
	                if(!stack.isEmpty()){
	                    char stackTop = stack.peek();
	                    if(stackTop == '(' && c[i] == ')'){
	                        stack.pop();
	                        continue;
	                    } else if(stackTop == '{' && c[i] == '}'){
	                        stack.pop();
	                        continue;
	                    } else if(stackTop == '[' && c[i] == ']'){
	                        stack.pop();
	                        continue;
	                    } else if(((c[i] == ')' && stackTop != '(') || (c[i] == '}' && stackTop != '{') || (c[i] == ']' && stackTop != '['))){
	                        stack.push(c[i]);
	                        break;
	                    }
	                } else if(c[i] == ')' || c[i] == '}' || c[i] == ']'){
	                    stack.push(c[i]);
	                    break;
	                }
	            }
	        }
	        if(stack.isEmpty()){
	        	result[k]="YES";
	        } else{
	        	result[k]="NO";
	        }
		}
		return result;

	}

	public static void main(String[] args) {
		String[] aa={"]{}["};
		for(String s:braces2(aa)){
			System.out.println(s);
		}
	}

}
