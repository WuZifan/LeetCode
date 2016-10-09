package easy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FindTheDifference {
    /**
     * 看了下，基本一种方法就是构建2个长度为26的数组
     * 统计字符串s和字符串t中每个字母出现的次数
     * 最后比较这两个字符串，不同的就是要找的。
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        char[] schar=s.toCharArray();
        char[] tchar=t.toCharArray();
        List<Character> list=new ArrayList<Character>();
        for (char c:tchar) {
            list.add(c);
        }
        for(char c:schar){
            int index=list.indexOf(c);
            list.remove(index);
        }
        return list.get(0);
    }
    /**
     * 用异或运算吧！
     */
    public char findTheDifference2(String s,String t){
        int ans=0;
        for(char c:s.toCharArray()){
            ans^=c;
        }
        for(char c:t.toCharArray()){
            ans^=c;
        }
        return (char)ans;
    }
    @Test
    public void test(){
        String s="abcd";
        String t="aecbd";
        System.out.println(findTheDifference(s, t));
    }
}
