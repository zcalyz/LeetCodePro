package com.zc.binaryAdd;


// 超出范围
public class Solution {
	
	public static void main(String[] args) {
		String a = "1101";
		String b = "1";
		Solution solution = new Solution();
//		System.out.println(solution.transBinaryToInt(a));
		System.out.println(solution.addBinary(a, b));
	}
	
    public String addBinary(String a, String b) {
        int valueA = transBinaryToInt(a);
        int valueB = transBinaryToInt(b);
        return transIntToBinary(valueA + valueB);
    }
    
    public int transBinaryToInt(String var){
    	char[] charArray = var.toCharArray();
    	int sum = 0;
    	int inc = 1;
    	for(int i = charArray.length - 1; i >= 0; i--){
    		sum = sum + Integer.valueOf(charArray[i] + "") * inc;
    		inc = inc * 2;
    	}
    	return sum;
    }
    
    public String transIntToBinary(int var){
    	StringBuilder builder = new StringBuilder();
    	while(true){
    		int remainder = var % 2;
    		var = var / 2;
    		builder.insert(0, remainder);
    		if(var == 0){
    			break;
    		}
    	}
    	return builder.toString();
    }
}
