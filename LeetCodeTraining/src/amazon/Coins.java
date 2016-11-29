package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Coins {
	private static List<Integer> coinList = new ArrayList<Integer>();

	private static int findOut(int amount) {
		int Five = 0;
		int Three = 0;
		int One = 0;
		int result = 0;
		// recusive stop
		if (amount == 0) {
			return 0;
		}

		for (int i = coinList.size() - 1; i >= 0; i--) {
			// start from the largest coin
			if (amount >= coinList.get(i)) {
				/*
				 * judge whether the remain money is less than the smallest coin(and large than 0) or not 
				 */
				if((amount-coinList.get(i))<coinList.get(0) && (amount-coinList.get(i))>0){
					// if yes, continue, ignore this coin;
					continue;
				}
				// if no, use the coin,let the remain money into next recusive
				result = 1 + findOut(amount - coinList.get(i));
				// leave the loop
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String coinValues = sc.nextLine();
		String targetValue = sc.nextLine();
		String[] coins = coinValues.split(" ");
		for (String string : coins) {
			coinList.add(Integer.parseInt(string));
		}
		Collections.sort(coinList);
		System.out.println(coinList);
		System.out.println(targetValue);
		System.out.println(findOut(Integer.parseInt(targetValue)));
	}
}
