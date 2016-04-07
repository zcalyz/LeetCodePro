package com.LIS;

import java.util.Arrays;
//最长递增子序列
public class LIS {
	public static void main(String[] args) {
		int[] array = { 2, 1, 5, 3, 6, 4, 8, 9, 7 };
		int len = LISLength(array);
		System.out.println("len: " + len);
	}
	
	public static int LISLength(int[] array){
		int[] resultArray = new int[array.length];
		resultArray[0] = array[0];
		int len = 1;
		for(int i = 1; i < array.length; i++){
			int elem = array[i];
			if(elem > resultArray[len -1]){
				resultArray[len++] = elem;
			}else{
				int index = Arrays.binarySearch(resultArray, 0, len-1, elem);
				if(index < 0){
					index = -index - 1;
					System.out.println(index);
					resultArray[index] = elem; 
				}
			}
		}
		return len;
	}
}
