package com.dp;

import java.util.ArrayList;

/*
 * 96.Unique Binary Search Trees
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 */

public class Solution {
	ArrayList<Integer> numTreesArray = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int numTrees2 = solution.numTrees(3);
		System.out.println(numTrees2);
	}

	public int numTrees(int n) {
		numTreesArray.add(0,1);
		
		for(int i = 1; i <= n; i++){
			int tempValue = 0;
			for(int j = 0; j < i; j++ ){
				tempValue += numTreesArray.get(j)* numTreesArray.get(i -1 -j);
			}
			numTreesArray.add(i, tempValue);
		}
		return numTreesArray.get(n);
	}
}
