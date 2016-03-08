package com.zc.mostWater;
//11. Container With Most Water
//https://leetcode.com/problems/container-with-most-water/
public class Solution {
	
	public static void main(String[] args) {
		int[] heights = {2, 5, 4, 9}; 
		Solution solution = new Solution();
		System.out.println(solution.maxArea(heights));
	}
	
	public int maxArea(int[] height) {
		if(height.length < 2){
			return 0;
		}
		int startPointer = 0;
		int endPointer = height.length - 1;
		int maxArea = 0;
		
		while(startPointer < endPointer){
			int minHeight = 0;
			boolean signal = false;
			if(height[startPointer] < height[endPointer]){
				minHeight = height[startPointer];
			}else{
				minHeight = height[endPointer];
				signal = true;
			}
			int area = (endPointer - startPointer) * minHeight;
			if(maxArea < area){
				maxArea = area;
			}
			if(signal){
				endPointer --;
			}else{
				startPointer ++;
			}
		}
		return maxArea;
	}
}
