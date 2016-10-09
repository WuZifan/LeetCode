package easy;

import org.junit.Test;

public class NimGame {
    public boolean canWinGame(int n) {
        return (n % 4 != 0);
    }
    @Test
    public void test() {
        int number = 4;
        System.out.println(canWinGame(number));
    }
    public void test1(){
    	System.out.println("HELLO WORDL");
    }
}