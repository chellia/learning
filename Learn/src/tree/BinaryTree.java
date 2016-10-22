package tree;

public class BinaryTree {

	Node root;

	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int value) {
			left = null;
			right = null;
			data = value;
		}
	}

	public BinaryTree() {
		root = null;
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	private Node insert(Node node, int data) {
		if (node == null) {
			node = new Node(data);
			// return node;
		} else if (data >= node.data) {
			node.left = insert(node.left, data);
		} else {
			node.right = insert(node.right, data);
		}
		return node;
	}

	public boolean lookup(int data) {
		return lookup(root, data);
	}

	private boolean lookup(Node node, int data) {
		if (node == null)
			return false;
		else if (node.data == data)
			return true;
		else if (data <= node.data)
			return lookup(node.left, data);
		else
			return lookup(node.right, data);
		// return false;
	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		}
		return 1 + size(node.left) + size(node.right);
	}

	public int maxDepth() {
		return (maxDepth(root));
	}

	private int maxDepth(Node node) {
		if (node == null) {
			return (0);
		} else {
			int lDepth = maxDepth(node.left);
			int rDepth = maxDepth(node.right);

			// use the larger + 1
			return (Math.max(lDepth, rDepth) + 1);
		}
	}

	public int minValue() {
		return minValue(root);
	}

	private int minValue(Node node) {
		if (node == null) {
			return -1;
		} else if (node.left == null) {
			return node.data;
		}
		// TODO Auto-generated method stub
		return minValue(node.left);
	}

	public void printTree() {
		printTree(root);
		System.out.println();
	}

	private void printTree(Node node) {
		// TODO Auto-generated method stub
		if (node == null) {
			return;
		}
		printTree(node.left);
		System.out.print(node.data + " ");
		printTree(node.right);
	}

	public void printpostTree() {
		printPostTree(root);
	}

	private void printPostTree(Node node) {
		// TODO Auto-generated method stub
		if (node == null) {
			return;
		}
		printPostTree(node.left);
		printPostTree(node.right);
		System.out.print(node.data + " ");
	}

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node node) {
		if (node != null) {
			// do the sub-trees
			mirror(node.left);
			mirror(node.right);

			// swap the left/right pointers
			Node temp = node.left;
			node.left = node.right;
			node.right = temp;
		}
	}

	public void doubleTree() {
		doubleTree(root);
	}

	private void doubleTree(Node node) {
		Node oldLeft;

		if (node == null)
			return;

		// do the subtrees
		doubleTree(node.left);
		doubleTree(node.right);

		// duplicate this node to its left
		oldLeft = node.left;
		node.left = new Node(node.data);
		node.left.left = oldLeft;
	}

	public boolean sameTree(BinaryTree other) {
		return (sameTree(root, other.root));
	}

	/**
	 * Recursive helper -- recurs down two trees in parallel, checking to see if
	 * they are identical.
	 */
	boolean sameTree(Node a, Node b) {
		// 1. both empty -> true
		if (a == null && b == null)
			return (true);

		// 2. both non-empty -> compare them
		else if (a != null && b != null) {
			return (a.data == b.data && sameTree(a.left, b.left) && sameTree(
					a.right, b.right));
		}
		// 3. one empty, one not -> false
		else
			return (false);
	}

	public static int countTrees(int numKeys) {
		if (numKeys <= 1) {
			return (1);
		} else {
			// there will be one value at the root, with whatever remains
			// on the left and right each forming their own subtrees.
			// Iterate through all the values that could be the root...
			int sum = 0;
			int left, right, root;

			for (root = 1; root <= numKeys; root++) {
				left = countTrees(root - 1);
				right = countTrees(numKeys - root);

				// number of possible trees with this root == left*right
				sum += left * right;
			}

			return (sum);
		}
	}

	public void printPaths() {
		int[] path = new int[1000];
		printPaths(root, path, 0);
	}

	/**
	 * Recursive printPaths helper -- given a node, and an array containing the
	 * path from the root node up to but not including this node, prints out all
	 * the root-leaf paths.
	 */
	private void printPaths(Node node, int[] path, int pathLen) {
		if (node == null)
			return;

		// append this node to the path array
		path[pathLen] = node.data;
		pathLen++;

		// it's a leaf, so print the path that led to here
		if (node.left == null && node.right == null) {
			printArray(path, pathLen);
		} else {
			// otherwise try both subtrees
			printPaths(node.left, path, pathLen);
			printPaths(node.right, path, pathLen);
		}
	}

	/**
	 * Utility that prints ints from an array on one line.
	 */
	private void printArray(int[] ints, int len) {
		int i;
		for (i = 0; i < len; i++) {
			System.out.print(ints[i] + " ");
		}
		System.out.println();
	}

	public boolean isBST2() {
		return (isBST2(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	/**
	 * Efficient BST helper -- Given a node, and min and max values, recurs down
	 * the tree to verify that it is a BST, and that all its nodes are within
	 * the min..max range. Works in O(n) time -- visits each node only once.
	 */
	private boolean isBST2(Node node, int min, int max) {
		if (node == null) {
			return (true);
		} else {
			// left should be in range min...node.data
			boolean leftOk = isBST2(node.left, min, node.data);

			// if the left is not ok, bail out
			if (!leftOk)
				return (false);

			// right should be in range node.data+1..max
			boolean rightOk = isBST2(node.right, node.data + 1, max);

			return (rightOk);
		}
	}

	public static void main(String args[]) {
		BinaryTree bt = new BinaryTree();
		bt.insert(5);
		bt.insert(1);
		bt.insert(7);
		bt.insert(6);
		// bt.printTree();
		// bt.printpostTree();
		// bt.printPaths();
		System.out.println(bt.isBST2());
		/*
		 * System.out.println(bt.lookup(6)); System.out.println(bt.lookup(1));
		 * System.out.println(bt.lookup(5)); System.out.println(bt.lookup(3));
		 * System.out.println(bt.size()); System.out.println(bt.maxDepth());
		 * System.out.println(bt.minValue());
		 */
	}
}
