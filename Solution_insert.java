package com.bupt.kcrosswind.Leetcode;

import java.util.ArrayList;

public class Solution_insert {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        if(intervals.size()==0){
            intervals.add(newInterval);
            return intervals;
        }
        
		// Collections.sort(intervals, new Comparator<Interval>() {
		// public int compare(Interval i1, Interval i2) {
		// return i1.start - i2.start;
		// }
		// });

		ArrayList<Interval> reslut = new ArrayList<Interval>();

		int i = 0;
		for (; i < intervals.size(); i++) {
			if (intervals.get(i).start >= newInterval.start) {
				if (intervals.get(i).start <= newInterval.end) {
					newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
					newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
				} else {
					reslut.add(newInterval);
					break;
				}
			} else {
				if (intervals.get(i).end >= newInterval.start) {
					newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
					newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
				} else {
					reslut.add(intervals.get(i));
				}
			}
		}

		if (i == intervals.size()) {
			reslut.add(newInterval);
		} else {
			for (; i < intervals.size(); i++) {
				reslut.add(intervals.get(i));
			}
		}

		return reslut;
	}
}
