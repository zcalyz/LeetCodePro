package com.wangyi;

import java.util.Scanner;
import java.util.ArrayList;
/*
 * 网易2016实习招聘 书单排序  http://blog.csdn.net/jiangxishidayuan/article/details/51020112
 * 现在学校图书馆需要一个借书系统，每个人只需要在网上提交借书申请即可，一个人一个清单，
 * 借书上线为n,每本书用数字1-n,表示，同时可能有m个人上网借书，现图书馆办公网络中已经提交了一批借书清单，
 * 在屏幕中,每行表示一个清单，并且处于清单中同一行的不同书号以空格划分，最后一行用n表示，请为屏幕中的所有借书清单重新排序，排序要求为 
	1：如果没有交集，则按清单提交顺序排序 
	2：如何两个清单有交集，要求有交集的清单尽量放在一起，并且按照清单提交的顺序进行排序。 
 * 
 * 比如说输入为： 
	2 3 11 
	4 8 
	5 3 
	2 6 9 
	5 7 
	n 
   输出为 
	2 3 11 
	5 3 
	5 7 
	2 6 9 
	4 8
 */

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
