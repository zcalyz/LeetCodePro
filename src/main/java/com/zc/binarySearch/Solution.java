package com.zc.binarySearch;
// 34. Search for a Range
public class Solution {
	
	public static void main(String[] args) {
		int[] nums = {5, 7, 7, 8, 8, 8, 8, 10};
		Solution obj = new Solution();
		int[] searchRange = obj.searchRange(nums, 8);
		System.out.println("[" + searchRange[0] + "," + searchRange[1] + "]");
	}
	
	public int[] searchRange(int[] nums, int target) {
		int[] result = {-1,-1};		
		int index = binarySearch(nums, 0, nums.length-1, target);
		if(index != -1){
			int start = index;
			int end = index;
			while(--start >= 0 && nums[start] == target){}
			while(++end < nums.length && nums[end] == target){};
			result[0] = start + 1;
			result[1] = end - 1;
		}
		
		return result;
	}
	
	public int binarySearch(int[] nums, int start, int end, int target){
		while(start <= end){
			int middle = (start + end) /2;
			if(nums[middle] == target){
				return middle;
			}else if(nums[middle] < target){
				start = middle + 1;
			}else{
				end = middle -1;
			}
		}
		return -1;
	}
}
