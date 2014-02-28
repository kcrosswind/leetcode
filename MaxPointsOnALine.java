package com.bupt.kcrosswind.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
	class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	private int gcd(int a, int b) {
		return b > 0 ? gcd(b, a % b) : a;
	}

	public int maxPoints(Point[] points) {
		int ret = 0;

		if (points == null) {
			return 0;
		}

		int N = points.length;
		if (N <= 2) {
			return N;
		}

		Map<String, Integer> records = new HashMap<String, Integer>();
		for (int i = 0; i < N - 1; ++i) {
			int same = 1;
			int max = 0;
			records.clear();
			for (int j = i + 1; j < N; ++j) {
				// keep x not negative
				int x, y = 0;
				if (points[i].x >= points[j].x) {
					x = points[i].x - points[j].x;
					y = points[i].y - points[j].y;
				} else {
					x = points[j].x - points[i].x;
					y = points[j].y - points[i].y;
				}

				int gcdXY = gcd(Math.abs(x), Math.abs(y));
				if (gcdXY == 0) {
					// both x and y are zero
					// imply that points[i] and points[j] are equal
					++same;
				} else {
					x /= gcdXY;
					y /= gcdXY;
					// record
					if (x == 0 || y == 0) {
						x = Math.abs(x);
						y = Math.abs(y);
					}
					String key = x + ":" + y;
					int value = 0;
					if (records.containsKey(key)) {
						value = records.get(key);
					}
					records.put(key, ++value);
					max = Math.max(max, value);
				}
			}
			ret = Math.max(ret, max + same);
		}
		return ret;
	}
}
