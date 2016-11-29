package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class AssignCookies {
	/**
	 * be attention to the maximum requirement;
	 * for that each child should be just satisfied, no over satisfied
	 * (assign equal to the desire,no larger than the desire) 
	 * @param g
	 * @param s
	 * @return
	 */
	public int findContentChildren(int[] g, int[] s) {
		int result=0;
		List<Integer> gList=new ArrayList<Integer>();
		List<Integer> sList=new ArrayList<Integer>();
		for(int i:g){
			gList.add(i);
		}
		for(int j:s){
			sList.add(j);
		}
		Collections.sort(gList);
		Collections.sort(sList);
		for(int i=0;i<gList.size();i++){
			for(int j=0;j<sList.size();j++){
				if(sList.get(j)>=gList.get(i)){
					sList.set(j, -1);
					result++;
					break;
				}
			}
		}
		return result;
	}
	
	@Test
	public void test(){
		int[] g={2,2,3};
		int[] s={1,1};
		System.out.println(findContentChildren(g, s));
	}
}
