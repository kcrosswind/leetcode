package com.bupt.kcrosswind.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

public class Solution_reverseInteger {

	public static int reverse(int x) {

		List<Integer> arr = new ArrayList();// ������ŵ��Ƕ�������int�Ǹ��﷨����û�ж���ʹ�ö���Ҫ��Integer,Double
		// new ��һ�ֹ������� LinkedList()����ֱ����LinkedList<>������ͷ�ģ�������

		int flag = 1;

		int dividend0;
		int dividend1;

		int multiplier;

		int temp = x;

		int reslut = 0;

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

		Iterator it  = arr.iterator();

		int size = arr.size();
		while (it.hasNext()) {
			multiplier = (int) Math.pow(10, size - 1);
			reslut = reslut + (Integer) it.next() * multiplier;
			size--;
		}

		return reslut;
	}

	public static void main(String srgs[]) {

		System.out.println(reverse(-123));
	}
}
