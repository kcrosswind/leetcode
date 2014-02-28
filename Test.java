package com.bupt.kcrosswind.Leetcode;

import junit.framework.TestCase;

public class Test extends TestCase {

	/*
	 * 返回中位数
	 */
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
		System.out.println("median=" + median);
		return median;
	}

	public double findMedianSortedArrays(int A[], int B[]) {

		int sizeA = A.length;// 初始化数组，及长度
		int sizeB = B.length;

		int[] C = new int[sizeA + sizeB];

		int signerA = 0;// 初始化标志位
		int signerB = 0;
		int signerC = 0;

		while (signerC < C.length) {// 合并两个有序数组

			if (signerA == sizeA) {
				C[signerC] = B[signerB];
				signerB++;
			} else if (signerB == sizeB) {
				C[signerC] = A[signerA];
				signerA++;
			} else {
				if (A[signerA] >= B[signerB]) {

					C[signerC] = B[signerB];
					signerB++;
				} else {
					C[signerC] = A[signerA];
					signerA++;
				}
			}
			signerC++;
		}

		System.out.println("clength=" + C[0] + C[1] + C[2] + C[3]);
		return findMedianofOne(C);
	}

	public void test() {

		double haha = 5 / 2;
		System.out.println(haha);
		int[] a = { 1, 2 };
		int[] b = { 1, 2 };
		System.out.println("alength=" + a.length + "blength=" + b.length);
		System.out.println(findMedianSortedArrays(a, b));
		System.out.println("dfdfdfd");
		int hehe=-123/10;
		System.out.println(hehe);
		
		int flag=0;
		int hii=0;
		while (flag<5) {
			if(flag==2){
				break;
			
			}
			if(hii<5){
				flag++;
			}
			flag++;
		}
		System.out.println("flag="+flag);
	}

	public void division() {
		int hehe = -123 % 10;
		String ha = "dfdfd";

	}

}
