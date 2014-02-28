package com.bupt.kcrosswind.Leetcode;

//Given two sorted integer arrays A and B, merge B into A as one sorted array.
//
//Note:
//You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
public class Solution_mergeSortedArray {
	public static void merge(int A[], int m, int B[], int n) {
		if (n == 0) {
			return;
		}
		if (m == 0) {
			// A = new int[n];
			System.out.println(A.length);
			for (int i = 0; i < B.length; i++) {
				A[i] = B[i];
			}
			System.out.println("A=B");
			return;
		}
		System.out.println("bbbbbbb");
		int[] C = new int[A.length];
		int flagA = 0;
		int flagB = 0;
		int flagC = 0;
		while (flagB < n && flagA < m) {
			if (A[flagA] <= B[flagB]) {
				C[flagC] = A[flagA];
				flagA++;
				flagC++;
			} else {
				C[flagC] = B[flagB];
				flagB++;
				flagC++;
			}
		}
		while (flagB < n) {
			C[flagC] = B[flagB];
			flagB++;
			flagC++;
		}
		while (flagA < m) {
			C[flagC] = A[flagA];
			flagA++;
			flagC++;
		}

		for (int i = 0; i < flagC; i++) {
			A[i] = C[i];
		}
	}

	public static void main(String[] args) {
		int[] A = { 0, 0, 0, 0 };
		int[] B = { 1 };
		// merge(A, 0, B, 1);
		A = B;
		System.out.println(A.length);
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
		}
	}
}
