package com.bupt.kcrosswind.Leetcode;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.LinkedList;

public class Test2 {
	public double findMedianSortedArrays(int A[], int B[]) {

		int sizeA = A.length;
		int sizeB = B.length;

		int[] C = new int[sizeA + sizeB];

		int signerA = 0;
		int signerB = 0;
		int signerC = 0;

		while (signerC < C.length) {

			if (signerA == sizeA || sizeA == 0) {
				C[signerC] = B[signerB];
				signerB++;
			} else if (signerB == sizeB || sizeB == 0) {
				C[signerC] = B[signerA];
				signerA++;
			} else {
				if (A[signerA] >= B[signerB]) {
					C[signerC] = A[signerA];
					sizeA++;
				} else {
					C[signerC] = B[signerB];
					sizeB++;
				}
			}
			signerC++;
		}

		return findMedianofOne(C);
	}

	public double findMedianofOne(int[] A) {

		int sizeA = A.length;
		double median;

		if (sizeA != 0) {
			if (sizeA % 2 == 1) {
				median = (double) A[sizeA / 2];

			} else {
				median = ((double) A[sizeA / 2] + (double) A[sizeA / 2 - 1]) / 2;
			}

		} else {
			median = 0;
		}
		// System.out.println("median=" + median);
		return median;
	}

	// public class Singleton {
	//
	// private static volatile Singleton instance = null;
	//
	// private Singleton() {}
	//
	// public static Singleton getInstance() {
	//
	// if (instance == null) {
	// synchronized (Singleton.class) {
	// if (instance == null) {
	// instance = new Singleton();
	// }
	// }
	// }
	// return instance;
	// }
	// }

	public static void main(String[] args) {
		// int[] hehe = new int[5];
		//
		// int[][] he = new int[1000][1000];
		// boolean[][] ha = new boolean[1000][1000];
		// Timestamp ts = new Timestamp(System.currentTimeMillis());
		// System.out.println("System.currentTimeMillis() = " + ts.toString());
		// for (int i = 0; i < 1000; i++) {
		// for (int j = 0; j < 1000; j++) {
		// he[i][j] = 1;
		// }
		// }
		// for (int i = 0; i < 1000; i++) {
		// for (int j = 0; j < 1000; j++) {
		// he[i][j] = 5;
		// }
		// }

		// Timestamp ts1 = new Timestamp(System.currentTimeMillis());
		// System.out.println("System.currentTimeMillis() = " + ts1.toString());
		// for (int i = 0; i < 1000; i++) {
		// for (int j = 0; j < 1000; j++) {
		// System.out.println(ha[i][j]);
		// }
		// }
		// for (int i = 0; i < 1000; i++) {
		// for (int j = 0; j < 1000; j++) {
		// ha[i][j] = false;
		// }
		// }
		// Timestamp ts2 = new Timestamp(System.currentTimeMillis());
		// System.out.println("System.currentTimeMillis() = " + ts2.toString());

		LinkedList<Integer> ll = new LinkedList();
		ll.add(0);
		ll.add(1);
		Iterator<Integer> it = ll.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

		Iterator<Integer> it3 = ll.iterator();
		while (it3.hasNext()) {
			System.out.println(it3.next());
			it3.remove();
		}
		
		Iterator<Integer> it2 = ll.iterator();

		while(it2.hasNext()){
			System.out.println(it2.next());
		}
	}
}
