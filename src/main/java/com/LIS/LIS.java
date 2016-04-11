package com.LIS;

import java.util.Arrays;
//最长递增子序列
public class LIS {
	public static void main(String[] args) {
		int[] array = { 2, 1, 5, 3, 6, 4, 8, 9, 7 };
		int len = LISLength2(array);
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
	
	public static int LISLength2(int[] array){
		int maxLenIndex = 0;
		int[] lenArray = new int[array.length];
		for(int i = 0; i < lenArray.length; i ++){
			lenArray[i] = 1;
		}
		
		for(int i = 1; i < lenArray.length; i++){
			if(array[i] > array[maxLenIndex]){
				lenArray[i] = lenArray[maxLenIndex] + 1;
				maxLenIndex = i;
			}else{
				for(int j = i-1 ; j >= 0; j--){
					if(array[j] < array[i]){
						int tempLen = lenArray[j] + 1;
						if(tempLen >  lenArray[i]){
							lenArray[i] = tempLen;
						}
					}
				}
				if(lenArray[i] == lenArray[maxLenIndex] && array[i] < array[maxLenIndex]){
					maxLenIndex = i;
				}
			}
			System.out.println("maxIndexValue is " + array[maxLenIndex]);
		}
		System.out.println(maxLenIndex);
		return lenArray[maxLenIndex];
	}
}
