package amazon;

import org.junit.Test;

public class Feibonaci {
	private int dofei(int i){
		if(i==1 || i==2){
			return 1;
		}else{
			return dofei(i-1)+dofei(i-2);
		}
	}
	
	@Test
	public void test(){
		System.out.println(dofei(6));
	}
}
