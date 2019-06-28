package algs4;

/**
 * Binary tree implementation.
 * 
 * @param <Item> The type of the BinaryTree
 */

public class BinaryTreeNode<Item> {
	private Node root;

	/**
	 * A node subclass which contains various recursive methods
	 *
	 * @param <Item>  The type of the BinaryTree and Node
	 */
	private class Node {
		private Item item;

		private Node left;
		private Node right;
		private Node parent;

		/**
		 * Node constructor without subtrees
		 * 
		 * @param parent  the parent of the node
		 * @param item	  the item contained in the root
		 */
		public Node(Node parent, Item item) {
			this.parent = parent;
			this.item = item;
		}

		/**
		 * Node constructor with subtrees
		 * 
		 * @param parent  the parent of the node
		 * @param left	  the left node child
		 * @param right	  the right node child
		 * @param item	  the item contained in the node
		 */
		public Node(Node parent, Node left, Node right, Item item) {
			this.parent = parent;
			this.left = left;
			this.right = right;
			this.item = item;
		}

		public Node getLeft() {
			return left;
		}

		public Node getRight() {
			return right;
		}

		public Node getParent() {
			return parent;
		}

		public Item getItem() {
			return item;
		}

		public void setLeft(Node newLeft) {
			left = newLeft;
		}

		public void setRight(Node newRight) {
			right = newRight;
		}

		public void setItem(Item newItem) {
			item = newItem;
		}

		/**
		 * Returns if the tree is a leaf (no children)
		 * 
		 * @return true if the tree is a leaf
		 */
		public boolean isLeaf() {
			return left == null && right == null;
		}

		/**
		 * Returns if the tree is a root (no parent)
		 * 
		 * @return true if the tree is a root
		 */
		public boolean isRoot() {
			return parent == null;
		}

		/**
		 * Returns the height of the tree (distance from a leaf)
		 * 
		 * @return height of the tree
		 */
		public int height() {
			if (isLeaf()) {
				return 0;
			} else {
				return Math.max(1 + left.height(), 1 + right.height());
			}
		}

		/**
		 * Returns the depth of the tree (distance from the root)
		 * 
		 * @return the depth of the tree
		 */
		public int depth() {
			if (isRoot()) {
				return 0;
			} else {
				return 1 + parent.depth();
			}
		}

		/**
		 * Returns the size of the tree
		 * 
		 * @return size of the tree
		 */
		public int size() {
			if (isLeaf()) {
				return 1;
			} else {
				return 1 + left.size() + right.size();
			}
		}

		/**
		 * Checks if an item is present in a given subtree
		 * 
		 * @param item  the item to search for 
		 * @return		true if the item is in this subtree
		 */
		public boolean search(Item item) {
			if (item.equals(this.item)) {
				return true;
			} else if (isLeaf()) {
				return false;
			} else {
				return left.search(item) || right.search(item);
			}
		}

	}

	/**
	 * Constructor for one item tree
	 * 
	 * @param item value of root
	 */
	public BinaryTreeNode(Item item) {
		root = new Node(null, item);
	}

	/**
	 * Constructor for tree with left and right children
	 * 
	 * @param item  value of root
	 * @param left  left subtree
	 * @param right right subtree
	 */
	public BinaryTreeNode(Item item, Node left, Node right) {
		root = new Node(null, left, right, item);
	}

	/**
	 * Returns the height of the tree
	 * 
	 * @return the height of the tree
	 */
	public int height() {
		return root.height();
	}

	/**
	 * Returns the size of the tree
	 * 
	 * @return the size of the tree
	 */
	public int size() {
		return root.size();
	}

	/**
	 * Checks if a given item is contained in the tree
	 * 
	 * @param item the item to search for
	 * @return true if the item is in the tree
	 */
	public boolean search(Item item) {
		return root.search(item);
	}

	/**
	 * Returns if the tree is complete (every level, except possibly the last, is
	 * completely filled, and all nodes are as far left as possible). More efficient
	 * than isCompleteSlow.
	 * 
	 * @return true if the tree is complete
	 */
	public boolean isComplete() {
		return size() == Math.pow(2, height() + 1) - 1;
	}
}