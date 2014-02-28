package com.bupt.kcrosswind.leetcode;

public class Solution_isValidSudoku {
	public static boolean isValidSudoku(char[][] board) {

		for (int i = 0; i < 8; i = i + 3) {
			for (int j = 0; j < 8; j = j + 3) {
				int[] buoy = new int[100];

				for (int m = i; m < i + 3; m++) {
					for (int n = j; n < j + 3; n++) {
						if (board[m][n] != '.') {
							if (buoy[board[m][n]] == 1) {
								System.out.println("dfdfdfdf");
								return false;
							} else {
								buoy[board[m][n]] = 1;
								System.out.println(m + "" + n + "" + board[m][n]);
							}
						}
					}
				}
				System.out.println("chushihua");
				for (int m = i; m < i + 3; m++) {
					for (int n = j; n < j + 3; n++) {
						if (board[m][n] != '.') {
							int temp = board[m][n];
							for (int x = 0; x < 9; x++) {
								if (x < i || x > i + 3) {
									if (board[x][n] != '.') {
										if (board[x][n] == temp) {

											return false;
										}
									}

								}
							}
							for (int y = 0; y < 9; y++) {
								if (y < j || y > j + 3) {
									if (board[m][y] != '.') {
										if (board[m][y] == temp) {
											System.out.println("343434343434");
											System.out
													.println(m + "" + y + "" + board[m][y] + "" + buoy[board[m][y]]);
											return false;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		char[][] board = new char[9][9];
		String[] t = { ".87654321", "2........", "3........", "4........", "5........", "6........", "7........", "8........", "9........" };
		for (int i = 0; i < 9; i++) {
			String s = t[i];
			for (int j = 0; j < 9; j++) {
				board[i][j] = s.charAt(j);
			}
		}

		isValidSudoku(board);
	}
}
