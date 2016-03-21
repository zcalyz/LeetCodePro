package com.sort.select;
//求出无序数组中第k大的元素
public class Solution {
	public static void main(String[] args) {
		int[] array = {4,3,9,6,2,8,1};
		int k = 5;
		int value = select(array, 0, array.length - 1, k - 1);
		System.out.println(value);
	}
	
	public static int select(int[] array,int start, int end, int k){
		while(true){
			int partition = partition(array, start, end);
			if(partition == k){
				return array[k];
			}else if(partition > k){
				end = partition -1;
			}else{
				start = partition + 1;
			}
		}
	}
	
	public static int partition(int[] array,int start, int end){
		int front = start;
		int partitionValue = array[front];
		for(int behind = front+1; behind <= end; behind++){
			if(array[behind] < partitionValue){
				exchange(array, ++front, behind);
			}
		}
		exchange(array, start, front);
		return front;
	}
	
	public static void exchange(int[] array, int index1, int index2){
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	public static void print(int[] array){
		for(int elem : array){
			System.out.print(elem + " ");
		}
		System.out.println();
	}
}
