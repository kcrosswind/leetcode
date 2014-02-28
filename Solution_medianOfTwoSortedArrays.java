package com.bupt.kcrosswind.Leetcode;

import java.util.LinkedList;

public class Solution_medianOfTwoSortedArrays {
	// 合并数组，搜索中值
	public double findMedianSortedArrays(int[] A, int[] B) {

		int sizeA = A.length;// 数组不支持插入啊
		int sizeB = B.length;

		int signerA = 0;
		int signerB = 0;
		LinkedList<Integer> ll = null;

		while (signerB <= sizeB && signerA <= sizeA) {
			if (A[signerA] >= B[signerB]) {
				ll.add(A[signerA]);
			} else {
				ll.add(B[signerB]);
			}
			signerA++;
			signerB++;
		}
		if (sizeA < sizeB) {
			while (signerB <= sizeB) {
				ll.add(B[signerB]);
				signerB++;
			}
		} else if (sizeA > sizeB) {
			while (signerA < sizeA) {
				ll.add(A[signerA]);
				signerA++;
			}
		}

		return ll.get(ll.size() / 2);
	}

	// 分别搜索数组
	public double mediaTwoSortedArrys2(int[] A, int B[]) {

		int sizeA = A.length;
		int sizeB = B.length;

		int signerA = 0;
		int signerB = 0;
		int signer = 0;

		int reslut = 0;

		while (signer < (sizeA + sizeB) / 2) {

			signer++;

			if (signerA <= sizeA && signerB <= sizeB) {
				if (A[signerA] > B[signerB]) {
					signerB++;
					if (signer == (sizeA + sizeB) / 2) {
						reslut = B[signerB];
					}
				} else {
					signerA++;
					if (signer == (sizeA + sizeB) / 2) {
						reslut = A[signerA];
					}
				}
			} else if (signerA <= sizeA) {
				signerA++;
				if (signer == (sizeA + sizeB) / 2) {
					reslut = A[signerA];
				}
			} else {
				signerB++;
				if (signer == (sizeA + sizeB) / 2) {
					reslut = B[signerB];
				}
			}
		}
		return reslut;
	}

	// 用数组
	public double findMedianSortedArrays2(int[] A, int[] B) {

		int sizeA = A.length;// 数组不支持插入啊
		int sizeB = B.length;

		int signerA = 0;
		int signerB = 0;
		int[] aandb = null;
		int signer = 0;

		if (sizeA == 0) {
			
		}else if(sizeB==0){
			
		}

		while (signer <= sizeA + sizeB) {
			if (A[signerA] >= B[signerB]) {

			} else {
			}
			signerA++;
			signerB++;
		}
		if (sizeA < sizeB) {
			while (signerB <= sizeB) {
				signerB++;
			}
		} else if (sizeA > sizeB) {
			while (signerA < sizeA) {
				signerA++;
			}
		}

		return ll.get(ll.size() / 2);
	}
	public double findMedianofOne(int[] A){
		int sizeA=A.length;
		if(sizeA!=0){
			if(sizeA%2==1){
				return A[sizeA/2];
			}else {
				return 	(A[sizeA/2]+A[sizeA/2-1])/2;
			}
			 
		}else{
			return 0;
		}
	}
	
}
