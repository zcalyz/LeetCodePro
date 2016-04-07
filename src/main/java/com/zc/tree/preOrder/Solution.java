package com.zc.tree.preOrder;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode right = new TreeNode(3);
		TreeNode left = new TreeNode(10);
		root.right = right;
		right.left = left;
		Solution solution = new Solution();
		List<Integer> pre = solution.preorderTraversal(root);
		for(Integer in : pre){
			System.out.print(in + " ");
		}
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		if (root != null) {
			list.add(root.val);
			preorder(root.left);
			preorder(root.right);
		}
		return list;
	}

	public void preorder(TreeNode root) {
		if (root != null) {
			list.add(root.val);
			preorder(root.left);
			preorder(root.right);
		}
	}
}
