package com.bupt.kcrosswind.Leetcode;

import org.hibernate.mapping.Array;

public class Solution_searchRange {
	public int[] searchRange(int[] A,int target ){
		int[] reslut={-1,-1};
		int length=A.length;
		int i=0;
		int insertposition=0;
		while(i<length){

			if(A[i]==target){
				reslut[insertposition]=i;
				insertposition=1;
			}
			i++;
		}
		if(reslut[0]!=-1&&reslut[1]!=-1){
			return reslut;
		}else {
			reslut[0]=-1;
			reslut[1]=-1;
			return reslut;
		}
	}
}
