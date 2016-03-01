package com.zc.hash;

import java.util.HashMap;
import java.util.Map;
// overtime
public class Solution {
	private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	private int lastKey;
	
	private int startKey;
	
	public static void main(String[] args) {
//		int[] nums = {100, 4, 200, 1, 3, 2,30,5,6,-1,0};
		int[] nums = {2147483646,-2147483647,0,2,2147483644,-2147483645,2147483645};
	
		Solution solution = new Solution();
		int longestConsecutive = solution.longestConsecutive(nums);
		System.out.println(longestConsecutive);
	}
	
	public int longestConsecutive(int[] nums) {
		initMap(nums);
		int lengthest = 0;
		int len2 = 0;
		
		for(int i = startKey; i < lastKey; i++){
			Integer value = map.get(i);
			if(value != null){
				len2++;
			}else{
				if(lengthest < len2){
					lengthest = len2;
					len2 = 0;
				}
			}
		}
		
		return lengthest;
	}
	
	public void initMap(int[] nums){
		lastKey = startKey = nums[0];
		map.put(nums[0], nums[0]);
		
		for(int i = 1; i < nums.length; i++){
			int value = nums[i];
			if(value > lastKey)
				lastKey = value;
			if(value < startKey){
				startKey = value;
			}
			map.put(value, value);
		}
	}
}
