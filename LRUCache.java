package com.bupt.kcrosswind.Leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
	private int capacity;
	private Map<Integer, Integer> map;

	public LRUCache(int c) {
		this.capacity = c;
		this.map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
			private static final long serialVersionUID = 7486237341382662L;

			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
				return size() > capacity;
			}
		};
	}

	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}
		return map.get(key);
	}

	public void set(int key, int value) {
		map.put(key, value);
		String s = new String();
		s.equals(anObject)
		s.sub
	}
}