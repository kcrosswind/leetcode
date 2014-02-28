package com.bupt.kcrosswind.Leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import org.hsqldb.lib.Sort;

public class Solution_merge {
	public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		if (intervals.size() <= 1) {
			return intervals;
		}
		for (int i = 0; i < intervals.size() - 1; i++) {
			for (int j = i + 1; j < intervals.size(); j++) {
				if (intervals.get(i).start > intervals.get(j).start) {
					Interval temp = intervals.get(i);
					intervals.set(i, intervals.get(j));// 不能单纯指向
					intervals.set(j, temp);
				}
			}
		}
		System.out.println("sorted" + intervals);
		int i = 0;
		while (i < intervals.size() - 1) {
			if (intervals.get(i).end >= intervals.get(i + 1).start) {
				intervals.set(i, new Interval(Math.min(intervals.get(i).start, intervals.get(i + 1).start), Math
						.max(intervals.get(i).end, intervals.get(i + 1).end)));
				intervals.remove(i + 1);
			} else {
				i++;
			}
		}
		return intervals;
	}

	private static final int INSERTIONSORT_THRESHOLD = 7;

	private static void mergeSort(Object[] src,
			Object[] dest,
			int low,
			int high,
			int off) {
		int length = high - low;

		// Insertion sort on smallest arrays
		if (length < INSERTIONSORT_THRESHOLD) {
			for (int i = low; i < high; i++)
				for (int j = i; j > low &&
						((Comparable) dest[j - 1]).compareTo(dest[j]) > 0; j--)
					swap(dest, j, j - 1);
			return;
		}

		// Recursively sort halves of dest into src
		int destLow = low;
		int destHigh = high;
		low += off;
		high += off;
		int mid = (low + high) >>> 1;
		mergeSort(dest, src, low, mid, -off);
		mergeSort(dest, src, mid, high, -off);

		// If list is already sorted, just copy from src to dest. This is an
		// optimization that results in faster sorts for nearly ordered lists.
		if (((Comparable) src[mid - 1]).compareTo(src[mid]) <= 0) {
			System.arraycopy(src, low, dest, destLow, length);
			return;
		}

		// Merge sorted halves (now in src) into dest
		for (int i = destLow, p = low, q = mid; i < destHigh; i++) {
			if (q >= high || p < mid && ((Comparable) src[p]).compareTo(src[q]) <= 0)
				dest[i] = src[p++];
			else
				dest[i] = src[q++];
		}
	}

	private static void swap(Object[] x, int a, int b) {
		Object t = x[a];
		x[a] = x[b];
		x[b] = t;
	}

	public static void main(String[] args) {
		Interval i = new Interval(1, 4);
		Interval j = new Interval(2, 4);
		Interval k = new Interval(3, 4);
		ArrayList<Interval> al = new ArrayList<Interval>();
		al.add(k);
		al.add(i);
		al.add(j);
		Collections.sort(al, new Comparator<Interval>() {
			public int compare(Interval b1, Interval b2) {
				return b1.start - b2.start;
			}
		});

		Arrays.sort(al);
		
		
		for (int m = 0; m < al.size(); m++) {
			System.out.println(al.get(m).start + " " + al.get(m).end);
		}

	}
}
