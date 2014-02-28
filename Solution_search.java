package com.bupt.kcrosswind.Leetcode;

public class Solution_search {
	public int search(int[] A, int target) {

    	int length = A.length;
		int i = 0;
		int reslut = -1;
		while (i < length) {
			if (A[i] == target) {
				reslut = i;
				break;
			}
			i++;
		}
		return reslut;
    
	}

	// 二分查找，二分查找的理念：分解后的部分与整体相关
	public int search2(int[] A, int target) {
		int i = 0;
		int length = A.length;
		return RotatedBinarySearch(A, i, length - 1, target);
	}

	// 普通二分查找
	public int BinarySearch(int[] A, int a, int b, int target) {

		int middle = (a + b) / 2;
		if (A[middle] == target) {
			return middle;
		} else if ((A[middle] < target) && (middle + 1 <= b)) {
			return BinarySearch(A, middle + 1, b, target);
		} else if ((A[middle] > target) && (middle - 1 >= a)) {
			return BinarySearch(A, a, middle - 1, target);
		} else {
			return -1;
		}
	}

	// 循环数组的二分查找
	public int RotatedBinarySearch(int[] A, int a, int b, int target) {

		int middle = (a + b) / 2;
		if (A[middle] == target) {
			return middle;
		} else if (middle + 1 <= b && A[middle + 1] <= A[b]) {
			if ((A[middle + 1] <= target) && (target <= A[b])) {
				return BinarySearch(A, middle + 1, b, target);
			} else if (middle - 1 >= a) {
				return RotatedBinarySearch(A, a, middle - 1, target);
			} else {
				return -1;
			}
		} else if (middle - 1 >= a && A[middle - 1] >= A[a]) {
			if ((A[middle - 1] >= target) && (target >= A[a])) {
				return BinarySearch(A, a, middle - 1, target);
			} else if (middle + 1 <= b) {
				return RotatedBinarySearch(A, middle + 1, b, target);
			} else {
				return -1;
			}

		} else {
			return -1;
		}
	}

	public int getWhat(int[] A, int a, int b) {
		if (A[a] < A[b])
			return 0;
		else
			return 1;
	}
}
