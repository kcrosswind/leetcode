package com.bupt.kcrosswind.Leetcode;

import java.util.Arrays;

public class Solution_twoSum {

	public static int[] twoSum(int[] numbers, int target) {// 328ms_自己的方法

		int flag = 0;
		int size = numbers.length;
		int index1 = 0;
		int index2 = 0;

		while (flag < size - 1) {
			int temp = numbers[flag];
			int inflag = flag + 1;
			while (inflag < size) {
				if (target == temp + numbers[inflag]) {
					// if (temp <= numbers[inflag]) {
					// index1 = flag;
					// index2 = inflag;
					// } else {
					// index1 = inflag;
					// index2 = flag;
					// }
					index1 = flag;
					index2 = inflag;
					break;
				}
				inflag++;
			}
			flag++;
		}
		int[] reslut = { index1 + 1, index2 + 1 };
		return reslut;
	}

	public int[] twoSum_sort(int[] numbers, int target) {

		int index1 = 0;
		int index2 = 0;
		int[] reslut = { index1, index2 };

		quickSort(numbers, 0, numbers.length - 1);

		int low = 0;
		int high = numbers.length - 1;
		int signer;
		while (low < high) {
			signer = low;

			while (signer <= high && target <= numbers[signer] + numbers[low]) {
				if (target == numbers[signer] + numbers[low]) {
					index1 = low;
					index2 = signer;
					return reslut;
				}
				signer++;
			}

			if (target > numbers[signer] + numbers[low]) {
				high = --signer;// i++:先引用后增加 ; ++i:先增加后引用
			}

			while (signer >= low) {
				if (target == numbers[signer] + numbers[high]) {
					index1 = signer;
					index2 = high;
					return reslut;
				}
				signer--;
			}
			low++;
		}
		return reslut;
	}

	public static int partition(int[] numbers, int low, int high) {// 分治的统一方法
		int pivot = low;
		int temp = numbers[pivot];
		while (low <= high) {// 移动的距离
			if (numbers[low] < numbers[pivot]) {
				int tem;
				tem = numbers[low];
				numbers[low] = numbers[pivot];
				numbers[pivot] = tem;
				low = pivot;
			}
			low++;// 移动的标志位
		}
		return pivot;// 返回标志位
	}

	public static void quickSort(int[] numbers, int low, int high) {// 快排递归
		int signer;
		if (low < high) {
			signer = partition(numbers, low, high);
			quickSort(numbers, low, signer - 1);
			quickSort(numbers, signer + 1, high);
		}
	}

	public int[] twoSum2(int[] numbers, int target) {

		int flag = 0;
		int size = numbers.length;
		int index1 = 0;
		int index2 = 0;

		int[] temp = Arrays.copyOf(numbers, size);
		Arrays.sort(temp);

		int[] reslut = { index1 + 1, index2 + 1 };
		return reslut;
	}

	public static int[] twoSum222(int[] numbers, int target) {

		int[] temp = Arrays.copyOf(numbers, numbers.length);
		int index1 = 0;
		int index2 = numbers.length - 1;
		int[] flag = new int[2];
		Arrays.sort(numbers);
		while (index1 < index2) {
			if (numbers[index1] + numbers[index2] > target) {
				index2--;
			} else if (numbers[index1] + numbers[index2] < target) {
				index1++;
			} else {
				flag[0] = numbers[index1];
				flag[1] = numbers[index2];
				System.out.println(flag[0] + "+" + flag[1]);
				break;
			}
		}
		System.out.println(flag[0] + "+" + flag[1]);
		int[] result = new int[2];
		int i = 0;
		while (i < temp.length) {
			if (temp[i] == flag[0]) {
				result[0] = i + 1;
				flag[0] = flag[1];
				break;
			}
			if (temp[i] == flag[1]) {
				result[0] = i + 1;
				break;
			}
			i++;
		}
		i++;
		while (i < temp.length) {
			if (temp[i] == flag[0]) {
				result[1] = i + 1;
				break;
			}
			i++;
		}
		return result;
	}

	public static void main(String args[]) {
		int[] numbers = { 5, 75, 25 };
		int target = 100;
		System.out.println(Integer.toString(twoSum222(numbers, target)[0]) + Integer
				.toString(twoSum222(numbers, target)[1]));
	}
}
