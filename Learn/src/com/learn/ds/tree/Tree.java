package com.learn.ds.tree;

import com.learn.ds.queue.QueueLLWithTreeNode;

public class Tree {

	Node root;

	

	public Tree() {
		root = null;
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	private Node insert(Node node, int data) {
		if (node == null) {
			node = new Node(data);
		} else if (node.left == null) {
			node.left = insert(node.left, data);
		} else {
			node.right = insert(node.right, data);
		}
		return node;
	}
	
	public void levelOrderInsertion(int data)
	{
		root = levelOrderInsertion(root,data);
	}
	public Node levelOrderInsertion(Node node,int data)
	{
		if(node != null)
		{
			QueueLLWithTreeNode lQueue = new QueueLLWithTreeNode();
			lQueue.enQ(node);
			while(!lQueue.isEmpty())
			{
				Node lCurrent = lQueue.deQ();
				if(lCurrent.left == null)
				{
					lCurrent.left = new Node(data);
					break;
				}
				//System.out.println(lCurrent.getData());
				if(lCurrent.left != null)
				{
					lQueue.enQ(lCurrent.left );
				}
				if(lCurrent.right == null)
				{
					lCurrent.right = new Node(data);
					break;
				}
				if(lCurrent.right != null)
				{
					lQueue.enQ(lCurrent.right );
				}
			}
			return node;
			
		}else{
			node = new Node(data);
			return node;
		}
	}
	
	public static void levelOrder(Tree tree)
	{
		Node root = tree.root;
		if(root != null)
		{
			QueueLLWithTreeNode lQueue = new QueueLLWithTreeNode();
			lQueue.enQ(root);
			while(!lQueue.isEmpty())
			{
				Node lCurrent = lQueue.deQ();
				System.out.print(lCurrent.getData()  + " ");
				if(lCurrent.left != null)
				{
					lQueue.enQ(lCurrent.left );
				}
				if(lCurrent.right != null)
				{
					lQueue.enQ(lCurrent.right );
				}
			}
			
			
		}
	}
	
	public void preOrder(Node node) //Node, left, right
	{
		if(node == null)
		{
			return;
		}
		System.out.print(node.data+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public void inOrder(Node node) //left, node, right
	{
		if(node == null)
		{
			return;
		}
		inOrder(node.left);
		System.out.print(node.data+" ");
		inOrder(node.right);
		
	}
	
	public int findMax(Node node,int max)
	{
		if(node == null)
		{
			return max;
		}
		if(node.data > max)
		{
			max = node.data;
		}
		max = findMax(node.left,max);
		max = findMax(node.right,max);
		return max;
	}
	
	public void postOrder(Node node) //left, right, node
	{
		if(node == null)
		{
			return;
		}
		postOrder(node.left);		
		postOrder(node.right);
		System.out.print(node.data+ " ");
		
	}
	
	public int maxDepth(Node node)
	{
		if(node == null)
		{
			return 0;
		}
		int leftDep = maxDepth(node.left);
		int rightDep = maxDepth(node.right);
		return Math.max(leftDep, rightDep) + 1;
	}
	
	public void printCousins(int nodedata)
	{
		Node root = this.root;
		if(root != null)
		{
			QueueLLWithTreeNode lQueue = new QueueLLWithTreeNode();
			lQueue.enQ(root);
			while(!lQueue.isEmpty())
			{
				Node lCurrent = lQueue.deQ();
			//	System.out.print(lCurrent.getData()  + " ");
				if(lCurrent.left != null)
				{
					if(nodedata == lCurrent.left.data)
					{
						System.out.println("Siblings");
						if(lCurrent.right != null)
						{
							System.out.print(lCurrent.right.left.data);
							System.out.print(" "+lCurrent.right.right.data);
							break;
						}
					}
					lQueue.enQ(lCurrent.left );
				}
				if(lCurrent.right != null)
				{
					if(nodedata == lCurrent.right.data)
					{
						System.out.println("Siblings");
						if(lCurrent.right != null)
						{
							System.out.print(lCurrent.left.left.data);
							System.out.print(" "+lCurrent.left.right.data);
							break;
						}
					}
					lQueue.enQ(lCurrent.right );
				}
			}
			
			
		}
		
	}

	
	public static void main(String args[]) {
		Tree tree = new Tree();
		tree.levelOrderInsertion(1);
		tree.levelOrderInsertion(2);
		tree.levelOrderInsertion(3);
		tree.levelOrderInsertion(4);
		tree.levelOrderInsertion(5);
		tree.levelOrderInsertion(6);
		tree.levelOrderInsertion(7);
		
		tree.printCousins(2);
		System.out.println();
		tree.printCousins(3);
		
		Tree tree1 = new Tree();
		tree1.levelOrderInsertion(1);
		tree1.levelOrderInsertion(2);
		tree1.levelOrderInsertion(3);
		tree1.levelOrderInsertion(4);
		tree1.levelOrderInsertion(5);
		tree1.levelOrderInsertion(6);
		tree1.levelOrderInsertion(7);
		System.out.println();
		System.out.println("is same="+isIdentical(tree.root,tree1.root));
		
		Tree tree2 = new Tree();
		tree2.levelOrderInsertion(1);
		tree2.levelOrderInsertion(2);
		tree2.levelOrderInsertion(3);
		tree2.levelOrderInsertion(5);
		tree2.levelOrderInsertion(5);
		tree2.levelOrderInsertion(6);
		tree2.levelOrderInsertion(7);
		System.out.println();
		System.out.println("is same="+isIdentical(tree.root,tree2.root));
		
		System.out.println("start level order");
		levelOrder(tree);		
		System.out.println();
		System.out.println("start pre order");
		tree.preOrder(tree.root);
		System.out.println();
		System.out.println("start post order");
		tree.postOrder(tree.root);
		System.out.println();
		System.out.println("start in order");
		tree.inOrder(tree.root);
		System.out.println();
		System.out.println("Max="+tree.findMax(tree.root,0));
		
		System.out.println();
		System.out.println("Depth="+tree.maxDepth(tree.root));
		
		
		
	}

	private static boolean isIdentical(Node node, Node node1) {
		
		if(node == null && node1 == null)
			return true;
		else
		{
			if(node.data == node1.data)
			{
				return isIdentical(node.left,node1.left) && isIdentical(node.right,node1.right)  ;
			}else
			{
				return false;
			}
		}		
		
	}
}
