package com.zc.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ToBolishExp {
	
	public static List<String> operators;
	
	static{
		operators = new ArrayList<String>();
		operators.add("+");
		operators.add("-");
		operators.add("*");
		operators.add("/");
		operators.add("(");
		operators.add(")");
	}
	
	public static void main(String[] args) {
		String[] expression = new String[]{"(","2","+","5",")","*","4"};
//		String[] expression1 = new String[]{"4","+","13","/","5"};
		ToBolishExp bolishObj = new ToBolishExp();
		String[] bolish = bolishObj.toBolish(expression);	
		
		for(String str : bolish){
			System.out.println(str + " ");
		}
	}
	
	public String[] toBolish(String[] expression){
		List<String> operands = new ArrayList<String>();
		Stack<Operator> operatorsStack = new Stack<Operator>();
		
		for(String var : expression){
			if(isOperator(var)){
				Operator currentOperator = new Operator(var);
				if(operatorsStack.isEmpty() || "(".equals(var)){
					operatorsStack.add(currentOperator);
				}else if(")".equals(var)){
					String operator = operatorsStack.pop().getOperator();
					while(!"(".equals(operator)){
						operands.add(operator);
						operator = operatorsStack.pop().getOperator();
					}
				}else{
					while(true){
						Operator peek = operatorsStack.peek();
						if(currentOperator.getLevel() > peek.getLevel()){
							operatorsStack.add(currentOperator);
							break;
						}else{
							operands.add(operatorsStack.pop().getOperator());
							if(operatorsStack.isEmpty()){
								break;
							}
						}
					}
				}
				
			}else{
				operands.add(var);
			}
		}
		
		while(!operatorsStack.isEmpty()){
			operands.add(operatorsStack.pop().getOperator());
		}
		return operands.toArray(new String[operands.size()]);
	}
	
	public boolean isOperator(String var){
		return operators.contains(var);
	}
}

class Operator{
	private int level;
	
	private String operator;
	public Operator(String operator) {
		this.operator = operator;
		// TODO Auto-generated constructor stub
		if("+".equals(operator) || "-".equals(operator)){
			level = 1;
		}else if("*".equals(operator) || "/".equals(operator)){
			level = 2;
		}else if("(".equals(operator)){
			level = 0;
		}else{
			level = 5;
		}
	}
	
	public int getLevel() {
		return level;
	}
	
	public String getOperator(){
		return operator;
	}
}
