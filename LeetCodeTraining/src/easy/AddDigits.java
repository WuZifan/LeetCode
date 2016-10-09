package easy;

import org.junit.Test;

public class AddDigits {
    /**
     * 看解答，第一种方法用的是递归（抠鼻，不要用递归………）
     * @param num
     * @return
     */
    public int addDigits(int num){
        int sum=0;
        while(num/10!=0){
            sum=0;
            for(;num/10!=0;){
                sum+=num%10;
                num=num/10;
            }
            num=sum+num%10;
        }
        return num;
    }
    /**
     * 第二种方法直接是找数学规律强行解开
     */
    public int addDigits2(int num){
        return num-9*((num-1)/9);
    }
    @Test
    public void test(){
        int num=44;
        System.out.println(addDigits(num));
    }
}
