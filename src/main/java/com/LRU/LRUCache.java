package com.LRU;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class LRUCache {
	LinkedHashMap<Integer, Integer> map;
	
	private int capacity;
    
	public LRUCache(int capacity) {
    	this.capacity = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity,1,true){
			@Override
			protected boolean removeEldestEntry(Entry<Integer, Integer> eldest) {
				// TODO Auto-generated method stub
				return size() >= LRUCache.this.capacity;
			}
        };
    }
    public int get(int key) {
        Integer value = map.get(key);
        if(value == null){
        	return -1;
        }
        return value;
    }
    
    public void set(int key, int value) {
        map.put(key, value);
    }
    
    public void displayAll(){
    	Set<Entry<Integer, Integer>> entrySet = map.entrySet();
    	for(Entry<Integer, Integer> entry : entrySet){
    		System.out.println(entry.getKey() + " " + entry.getValue());
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(4);
		lruCache.set(1, 1);
		lruCache.set(2, 2);
		lruCache.set(3, 3);
		lruCache.displayAll();
		System.out.println("******************************************");
		System.out.println(lruCache.get(20));
		System.out.println(lruCache.get(1));
		System.out.println("******************************************");
		lruCache.set(4, 4);
		lruCache.displayAll();
		System.out.println("******************************************");
		lruCache.set(5, 5);
		lruCache.displayAll();
		
	}
}
