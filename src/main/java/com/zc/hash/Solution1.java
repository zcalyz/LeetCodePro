package com.zc.hash;

import java.util.HashMap;
import java.util.Map;
// AC
public class Solution1 {
	private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) {
		int[] nums = {100, 4, 200, 1, 3, 2, 30, 5, 6, -1, 0};
//		int[] nums = {2147483646,-2147483647,0,2,2147483644,-2147483645,2147483645};
	
		Solution1 solution = new Solution1();
		solution.longestConsecutive(nums);
	}	
	public int longestConsecutive(int[] nums) {
		initMap(nums);
		int lengthest = 0;
		int len = 0;
		
		for(int i = 0; i < nums.length; i++){
			int key = nums[i];
			Integer value = map.get(key);
			if(value != null){
				len = 1;
				int left = key - 1;
				int right = key + 1;
				while(map.get(left) != null){
					map.remove(left);
					len++;
					left--;
				}
				while(map.get(right) != null){
					map.remove(right);
					len++;
					right++;
				}
				if(lengthest < len){
					lengthest = len;
				}
			}
		}	
		return lengthest;
	}
	
	public void initMap(int[] nums){
		map.put(nums[0], nums[0]);
		
		for(int i = 1; i < nums.length; i++){
			int value = nums[i];
			map.put(value, value);
		}
	}
}
