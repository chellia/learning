package com.learn.ds.tree;

public  class Node {
	int data;
	Node left;
	Node right;

	public Node(int value) {
		left = null;
		right = null;
		data = value;
	}
	
	public int getData()
	{
		return this.data;
	}
}