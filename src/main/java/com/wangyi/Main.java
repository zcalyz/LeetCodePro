package com.wangyi;

import java.util.Scanner;
import java.util.ArrayList;

public class Main{
	  public static void main(String[] args){
	   	Scanner input = new Scanner(System.in);
	    ArrayList<String[]> array = new ArrayList<String[]>();
	    while(input.hasNext()){
	        String str = input.nextLine();
	      	if(str.equals("n")){
	      		break;
	        }
	      	String[] strArray = str.split(" ");
	        array.add(strArray);
	    }
	    if(array.size() > 0){
	         ArrayList<String[]> tempArray = new ArrayList<String[]>();
	    	 tempArray.add(array.get(0));
	    }
	  }
	  
	  public static void print(ArrayList<String[]> array, int index){
	     String[] strArray = array.get(index);
	    for(String str:strArray){
	      System.out.print(str + " "); 
	    }
	    System.out.println();
	  }
	  
	  public static boolean isInclude(ArrayList<String[]> array,ArrayList<String[]> result,int index){
	    for(int i=0; i < array.size();i++){
	    	
	    }
	    return true;
	  }
	}
