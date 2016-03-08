package com.zc.binaryAdd;

//http://oj.leetcode.com/problems/add-binary/
// 67 add Binary
public class Solution1 {
	public static void main(String[] args) {
		String a = "1100";
		String b = "1";
		Solution1 solution = new Solution1();
		System.out.println(solution.addBinary(a, b));
	}
	
	public String addBinary(String a, String b) {
		char[] arrayA = a.toCharArray();
		char[] arrayB = b.toCharArray();
		StringBuilder result = new StringBuilder();
		
		int i = arrayA.length - 1;
		int j = arrayB.length - 1;
		int value = 0;
		while(i >= 0 || j >= 0){
			if(i >= 0) value += (arrayA[i] - '0');
			if(j >= 0) value += (arrayB[j] - '0');
			
			result.insert(0, value % 2);
			value = value / 2;
			i--;
			j--;
		}
		
		if(value > 0) result.insert(0, value);
		return result.toString();
    }
}
