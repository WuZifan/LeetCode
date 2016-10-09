package easy;

import org.junit.Test;

public class MoveZeroes {
    /**
     * 用冒泡排序来实现的
     **/
    public void moveZeros(int[] nums) {
     /*
      * 冒牌排序两层循环代表的意思：
      *     1、外层表示有几次冒泡，一般来说，每个元素都需要冒泡，所以和数组长度一样
      *     2、内层循环表示某一个元素被移到的"最后"那个正确的位置上
      * 比如 2 1 4 3 想变成1234
      * 第一次：
      *     外循环，表示第一次交换
      *     内循环：开始将某个数移到最后 
      *            2 1 4 3→ 1 2 4 3→1 2 4 3(2比4小，不用交换)→1 2 3 4      
      */
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                int temp = nums[j];
                if (temp != 0) {
                    continue;
                } else {
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
    /**
     * 果然上面的方法太蠢了，可以用线性的方法解决
     * @param nums
     */
    public void moveZeros2(int[] nums) {
        for(int indexOfNoneZero=0,cur=0;cur<nums.length;cur++){
            if(nums[cur]!=0){
                /*
                 * 这里使用交换的办法，其实用数有多少个0的办法也可以 
                 */
                int temp=nums[indexOfNoneZero];
                nums[indexOfNoneZero]=nums[cur];
                nums[cur]=temp;
                indexOfNoneZero++;
            }
        }
    }
    @Test
    public void test() {
        int[] nums = { 0, 1, 0, 3, 12 };
        moveZeros2(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
