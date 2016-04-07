package com.wangyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static List<String> sort(List<String> bookList){
		if(bookList == null || bookList.size() == 0){
			return null;
		}
		int len = bookList.size();
		ArrayList<String> resultList = new ArrayList<String>();
		boolean[] visited = new boolean[len];
		//set false
		for(int i = 0; i < len; i++){
			visited[i] = false;
		}
		// deep traverse
		for(int i = 0; i < len; i++){
			if(!visited[i]){
				DFSCore(i, visited, resultList, bookList);
			}
		}
		return resultList;
	}
	
	public static void DFSCore(int i, boolean[] visited, List<String> resultList, List<String> booksList) {
		visited[i] = true;
		String valueA = booksList.get(i);
		//
		resultList.add(valueA);
		List<Integer> insection = getInsection(visited, valueA, booksList);
		if(insection.size() > 0){
			for(int j = 0; j < insection.size(); j++){
				Integer index = insection.get(j);
				if(!visited[index]){
					DFSCore(index, visited, resultList, booksList);
				}
			}
		}
		
	}
	
	public static List<Integer> getInsection(boolean[] visited, String valueA, List<String> booksList){
			ArrayList<Integer> result = new ArrayList<Integer>();
			int len = booksList.size();
			for(int i = 0; i < len; i++){
				String valueB = booksList.get(i);
				if(!visited[i]){
					if(isInsection(valueA,valueB)){
						result.add(i);
					}
				}
			}
			return result;
	}
	
	public static boolean isInsection(String valueA, String valueB){
		String[] nums = valueB.split(" ");
		for(String num : nums){
			if(valueA.contains(num)){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> bookList = new ArrayList<String>();
		while(scanner.hasNextLine()){
			String value = scanner.nextLine();
			if(value.equals("n")){
				break;
			}
			bookList.add(value);
		}
		List<String> resultlist = sort(bookList);
		display(resultlist);
	}
	
	public static void display(List<String> list){
		for(String str : list){
			System.out.println(str);
		}
	}
}
