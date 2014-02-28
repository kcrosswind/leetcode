package com.bupt.kcrosswind.Leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution_isPalindrome {
	public static boolean isPalindrome(int x) {

		if (x < 0) {
			return false;
		}

		long temp = x;//绕过int
		int size = 0;

		while (true) {
			double dividend = Math.pow(10, size);// 注意长度 肯定比最长的长一位 要转换的
			if (temp % dividend == temp) {// 为什么=0就不行呢 肯定和int long double 有关
				break;
			}
			size++;
			System.out.println(size);
		}

		int flag = 1;
		long dividend0;
		long dividend1;
		long multiplier;

		long reslut = 0;

		while (true) {
			dividend0 = (long) Math.pow(10, flag);
			dividend1 = dividend0 / 10;
			multiplier =(long) Math.pow(10, size - 1);

			reslut = reslut + temp % dividend0 / dividend1* multiplier;
			size--;
			flag++;

			if (temp % dividend0 == temp) {
				break;
			}
		}

		System.out.println(reslut);

		if ((int) reslut == (int) temp) {
			System.out.println("1");
			return true;
		} else {
			System.out.println("0");
			return false;
		}

	}

	/*
	 * 分解一个int中的不同数字
	 */
	public List<Integer> getNumber(int x) {
		List<Integer> arr = new ArrayList();// 容器里放的是对象，所以int是个语法，并没有对象，使用对象要用Integer,Double
		// new 是一种构建方法 LinkedList()；而直接用LinkedList<>很无理头的！！！！

		int flag = 1;
		int dividend0;
		int dividend1;

		int temp = x;

		while (true) {
			dividend0 = (int) Math.pow(10, flag);
			dividend1 = (int) Math.pow(10, flag - 1);

			arr.add(x % dividend0 / dividend1);
			System.out.println(x % dividend0 / dividend1);
			flag++;

			if (x % dividend0 == temp) {
				break;
			}
		}
		return arr;
	}

	public static void main(String srgs[]) {

		isPalindrome(121);
	}
}
