package com.zc.sameTree;
//https://leetcode.com/submissions/detail/56514041/
//100. Same Tree
public class Solution {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
        	return true;
        }
        if(p == null || q == null){
        	return false;
        }
        if(p.val == q.val){
        	boolean leftTreeSame = isSameTree(p.left, q.left);
        	boolean rightTreeSame = isSameTree(p.right, q.right);
        	if(leftTreeSame && rightTreeSame){
        		return true;
        	}
        }
        return false;
    }
}
