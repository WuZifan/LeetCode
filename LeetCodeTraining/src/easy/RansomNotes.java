package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class RansomNotes {
    /**
     思路和下面那个是一样的
     只是用了两个HashMap来实现，太笨了= - 
    */
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ranMap = new HashMap<Character, Integer>();
        Map<Character, Integer> magMap = new HashMap<Character, Integer>();
        for (Character ch : ransomNote.toCharArray()) {
            Set<Character> set = ranMap.keySet();
            if (set.contains(ch)) {
                int count = ranMap.get(ch);
                count++;
                ranMap.put(ch, count);
            } else {
                ranMap.put(ch, 1);
            }
        }
        for (Character ch : magazine.toCharArray()) {
            Set<Character> set = magMap.keySet();
            if (set.contains(ch)) {
                int count = magMap.get(ch);
                count++;
                magMap.put(ch, count);
            } else {
                magMap.put(ch, 1);
            }
        }
        Set<Character> magSet = magMap.keySet();
        for (Character ch : ranMap.keySet()) {
            if (!magSet.contains(ch)) {
                return false;
            } else {
                if (ranMap.get(ch) > magMap.get(ch)) {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * 看了一圈，其实没有什么聪明的办法，
     * 都是列字母表，然后计算每个字母出现的次数
     * 比较两个字符串中每个字母出现的次数；
     * 如果magazine中某个字母出现的次数小于ransomNote中对应字母出现的次数
     * 那么就返回false；
     * 不然就返回true；
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean smartWay(String ransomNote, String magazine) {
        int[] arr = new int[26];
        /*
         * 注意这里两个循环的顺序，不能反了!!!；
         * 要先把后面那个遍历
         * 再遍历前面那个
         */
        for (char c : magazine.toCharArray()) {
            arr[c - 'a'] += 1;
        }
        for (char c : ransomNote.toCharArray()) {
            arr[c - 'a'] -= 1;
            if (arr[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
    @Test
    public void test() {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
        System.out.println(smartWay(ransomNote, magazine));
    }
}
