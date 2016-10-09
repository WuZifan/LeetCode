package easy;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ValidSudoku {
	/**
	 * 看了下思路，用这个方法的人也比较多；即分三种情况分别进行判断。 所不同的是验证的思路，
	 * 我的办法是采用set本身有的去重特性，通过set的size和自己计数的结果进行比较；
	 * 有人的办法是将每个数字都放入list，通过判断是否contain来判断
	 * 
	 * @param board
	 * @return
	 */
	public boolean isValidSudoku(char[][] board) {
		/*
		 * 判断列
		 */
		for (int i = 0; i < board[0].length; i++) {
			int count = 0;
			Set<Character> set = new HashSet<Character>();
			for (int j = 0; j < board[0].length; j++) {
				if (Character.isDigit(board[i][j])) {
					set.add(board[i][j]);
					count++;
				}
			}
			if (count != set.size()) {
				return false;
			}
		}
		/*
		 * 判断行
		 */
		for (int i = 0; i < board[0].length; i++) {
			int count = 0;
			Set<Character> set = new HashSet<Character>();
			for (int j = 0; j < board[0].length; j++) {
				if (Character.isDigit(board[j][i])) {
					set.add(board[j][i]);
					count++;
				}
			}
			if (count != set.size()) {
				return false;
			}
		}
		/*
		 * 判断9宫格
		 */
		for (int i = 0; i < 9; i++) {
			int a = i / 3;
			int b = i % 3;
			int count = 0;
			Set<Character> set = new HashSet<Character>();
			for (int j = 0; j < 3; j++) {
				if (Character.isDigit(board[3 * a][j + 3 * b])) {
					set.add(board[3 * a][j + 3 * b]);
					count++;
				}
				if (Character.isDigit(board[3 * a + 1][j + 3 * b])) {
					set.add(board[3 * a + 1][j + 3 * b]);
					count++;
				}
				if (Character.isDigit(board[3 * a + 2][j + 3 * b])) {
					set.add(board[3 * a + 2][j + 3 * b]);
					count++;
				}
			}
			if (count != set.size()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 还有一种方法是这个，和之前用C刷数据结构时一样，提供一个长度为10的数组
	 * 每个位置表示数字是否存在；比如，如果数字8存在，那么就在第8个位置上写8； 因为不存在0，所以没有0号位的事情。
	 * 
	 * 同时，将行判断，列判断以及九宫格判断放在同一个循环里面进行。
	 * 
	 * @param board
	 * @return
	 */
	public boolean isValidSudoku2(char[][] board) {
		for (int i = 0; i < 9; i++) {
			int[] rowValid = new int[10];// 用来判断每一行是否合法，每次需要更新
			int[] colValid = new int[10];// 用来判断每一列是否合法，每次需要更新
			int[] ninValid = new int[10];// 用来判断每个九宫格是否合法，每次需要更新
			for (int j = 0; j < 9; j++) {
				// 需要对i进行比较特殊的处理
				if (!check(rowValid, board[i][j]) || !check(colValid, board[j][i])
						|| !check(ninValid, board[(i / 3) * 3 + j / 3][j % 3 + (i % 3) * 3])) {
					/*
					 * 只要三者有一个出现false，就进入该if语句，返回false
					 */
					return false;
				}
			}
		}
		return true;
	}

	private boolean check(int[] testValid, char val) {
		if (val != '.') {
			int valDigit = val - '0';
			if (testValid[valDigit] != valDigit) {
				testValid[valDigit] = valDigit;
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	@Test
	public void test() {
		char[][] c = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' }, 
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' }, 
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' }, 
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' }, 
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		System.out.println(isValidSudoku2(c));
	}
}