package easy;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ReverseVowels {
    public String reverseVowels(String s){
        char[] newString=new char[s.length()];
        Set<Character> set=new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        /*
         * String的方法中没有直接替换某个位置上字符的办法
         * 所以新的思路是这样：
         *  1、重新 以正常顺序，一个字符一个字符的构造一个字符串
         *  2、当碰到元音时，停下，记录当前位置
         *  3、开始倒序遍历字符串，碰到元音，停下，记录当前位置
         *  4、将2中位置的元音以3中位置的元音替换
         *  5、2继续开始，到下一个元音时，重复3，4
         */
        for (int i = 0,j=s.length()-1; i < s.length(); i++) {
            char ch=Character.toLowerCase(s.charAt(i));
            if(set.contains(ch)){
                for (; j>=0; j--) {
                    char ch2=Character.toLowerCase(s.charAt(j));
                    if(set.contains(ch2)){
                        newString[i]=s.charAt(j);
                        j--;
                        break;
                    }
                }
            }else{
                newString[i]=s.charAt(i);
            }
        }
        return new String(newString);
    }
    @Test
    public void test(){
        String s="leetcode";
        System.out.println(reverseVowels(s));
    }
}
