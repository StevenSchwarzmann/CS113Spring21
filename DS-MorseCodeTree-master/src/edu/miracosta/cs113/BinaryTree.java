package edu.miracosta.cs113;

import java.io.Serializable;
import java.util.Scanner;


public class BinaryTree<E> implements Serializable {
	
	protected static class Node<E> implements Serializable {
        // Data Fields
        /** The information stored in this node. */
        protected E data;
        /** Reference to the left child */
        protected Node<E> left;
        protected Node<E> right;

        /** Construct a node with the given data and no children.
         * @param data The data to store in this node
         */
        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }
        // Methods
        public String toString() {
            return data.toString();
        }
    }
	
	private Node<E> root;
	
	public BinaryTree() {
        root = null;
    }

    protected BinaryTree(Node<E> root) {
        this.root = root;
    }

    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
        root = new Node<>(data);
        if (leftTree != null) {
            root.left = leftTree.root;
        } else {
            root.left = null;
        }

        if (rightTree != null) {
            root.right = rightTree.root;
        } else {
            root.right = null;
        }
    }


    /** Return the left subtree.
     * @return the left subtree or null if either the root or the left subtree is null
     */
    public BinaryTree<E> getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BinaryTree<>(root.left);
        } else {
            return null;
        }
    }


    /** Return the right subtree.
     * @return the right subtree or null if either the root or the right subtree is null
     */
    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.right !=null) {
            return new BinaryTree<>(root.right);
        } else {
            return null;
        }
    }


	 public static BinaryTree<String>  readBinaryTree(Scanner scan) {
        // Read a line and trim leading and trailing spaces.
        String data = scan.nextLine().trim();
        if (data.equals("null")) {
            return null;
        } else {
            BinaryTree<String> leftTree = readBinaryTree(scan);
            BinaryTree<String> rightTree = readBinaryTree(scan);
            return new BinaryTree<>(data,leftTree, rightTree);
        }
    }

	 
	/** Returns the data in the root
     * @return the data in the root
     */
    public E getData() {
        return root.data;
    }

    public boolean isLeaf() {
        return (root.left == null && root.right == null);
    }

    /** Converts a sub-tree to a string.
     *  Performs a preorder traversal
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, 1, sb);
        return sb.toString();
    }
    
    /** Converts a sub-tree to a string.
     *  Performs a preorder traversal
     * @param node The local root
     * @param depth The depth
     * @param sb The StringBuilder to save the output
     */
    private void toString(Node<E> node, int depth, StringBuilder sb) {
        for (int i = 1; i < depth; i++) {
            sb.append(" ");
        }
        if (node == null) {
            sb.append("null\n");
        } else {
            sb.append(node.toString());
            sb.append("\n");
            toString(node.left, depth + 1, sb);
            toString(node.right, depth + 1, sb);

        }
    }

	private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
		for (int i = 1; i < depth; i++) {
			sb.append(" ");
		}
		if (node == null) {
			sb.append("null\n");
		} else {
			sb.append(node.toString() + "\n");
			preOrderTraverse(root.left, depth + 1, sb);
			preOrderTraverse(root.right, depth + 1, sb);
		}
	}


	
	
}
