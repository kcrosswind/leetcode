package com.bupt.kcrosswind.Leetcode;

public class Solution_setZeroes {
	public void setZeroes(int[][] matrix) {
		int rowFlag = 1;
		int columnFlag = 1;
		int columnLength = matrix.length;
		int rowLength = matrix[0].length;

		for (int i = 0; i < columnLength; i++) {
			if (matrix[i][0] == 0) {
				columnFlag = 0;
				break;
			}
		}

		for (int i = 0; i < rowLength; i++) {
			if (matrix[0][i] == 0) {
				rowFlag = 0;
				break;
			}
		}

		for (int i = 0; i < columnLength; i++) {
			for (int j = 0; j < rowLength; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < columnLength; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 1; j < rowLength; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int i = 1; i < rowLength; i++) {
			if (matrix[0][i] == 0) {
				for (int j = 1; j < columnLength; j++) {
					matrix[j][i] = 0;
				}
			}
		}

		if (rowFlag == 0) {
			for (int i = 0; i < rowLength; i++) {
				matrix[0][i] = 0;
			}
		}

		if (columnFlag == 0) {
			for (int i = 0; i < columnLength; i++) {
				matrix[i][0] = 0;
			}
		}

	}

	public static void main(String[] args) {
		int[][] i = new int[2][3];
		System.out.println(i.length);
		System.out.println(i[0].length);
	}
}
