package com.zc.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
	private static List<String> operators;
	
	static{
		operators = new ArrayList<String>();
		operators.add("+");
		operators.add("-");
		operators.add("*");
		operators.add("/");
	}
	
	public static void main(String[] args) {
		String[] tokens = new String[]{"4", "13", "5", "/", "+"};
		int evalRPN = new Solution().evalRPN(tokens);	
		System.out.println(evalRPN);
	}
	
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		
		for(String var : tokens){
			if(isOperator(var)){
				 int value2 = Integer.valueOf(stack.pop());
				 int value1 = Integer.valueOf(stack.pop());
				 stack.push(operate(value1, value2, var));
			}else{
				stack.push(Integer.valueOf(var));
			}
		}
		
		return stack.pop();
    }
	
	public boolean isOperator(String operator){
		return operators.contains(operator);
	}
	
	public int operate(int value1, int value2, String operator){
		switch(operator){
			case "+": return value1 + value2;
			case "-": return value1 - value2;
			case "*": return value1 * value2;
			default : return value1 / value2;
		} 
	}
}
