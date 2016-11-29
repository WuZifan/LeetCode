package medium;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Golf {
	public boolean isGolf(int n,int[] nums,int d){
		List<Integer> list=new ArrayList<Integer>();
		for(int i:nums){
			list.add(i);
		}
		
		int minD=d;
		int temp=d;
		boolean flag=true;
		while(!(d==0)){
			for(int i:nums){
				if(list.contains(Math.abs(d-i)) || Math.abs(d-i)==0){
					minD=Math.abs(d-i);
					break;
				}
				if(Math.abs(d-i)<minD){
					minD=Math.abs(d-i);
				}
			}
			d=minD;
			if(temp==d){
				flag=false;
				break;
			}else{
				temp=d;
			}
		}
		return flag;
	}
	
	@Test
	public void Test(){
		int n=3;
		int[] nums={3,1000};
		int d=4;
		System.out.println(isGolf(n,nums,d));
	}
}
