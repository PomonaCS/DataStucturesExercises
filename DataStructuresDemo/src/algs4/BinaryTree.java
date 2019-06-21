package algs4;

/**
 * Binary tree implementation.
 * 
 * @param <Item>  The type of the BinaryTree
 */

public class BinaryTree<Item> {
	private Item item;

	private BinaryTree<Item> parent;

	private BinaryTree<Item> left;
	private BinaryTree<Item> right;

	/**
	 * Constructor for one item tree
	 * 
	 * @param item value of root
	 */
	public BinaryTree(Item item) {
		this.item = item;
		left = null;
		right = null;
	}

	/**
	 * Constructor for tree with left and right children
	 * 
	 * @param item  value of root
	 * @param left  left subtree
	 * @param right right subtree
	 */
	public BinaryTree(Item item, BinaryTree<Item> left, BinaryTree<Item> right) {
		this.item = item;
		this.left = left;
		this.right = right;

		left.parent = this;
		right.parent = this;
	}

	/**
	 * Returns value of root
	 * 
	 * @return value of root
	 */
	public Item item() {
		return item;
	}

	/**
	 * Returns left subtree
	 * 
	 * @return left subtree
	 */
	public BinaryTree<Item> left() {
		return left;
	}

	/**
	 * Returns right subtree
	 * 
	 * @return right subtree
	 */
	public BinaryTree<Item> right() {
		return right;
	}

	/**
	 * Returns parent node
	 * 
	 * @return parent subtree
	 */
	public BinaryTree<Item> parent() {
		return parent;
	}

	/**
	 * Set left subtree
	 * 
	 * @param left new left subtree
	 */
	public void setLeft(BinaryTree<Item> left) {
		this.left = left;
		left.parent = this;
	}

	/**
	 * Set right subtree
	 * 
	 * @param right new right subtree
	 */
	public void setRight(BinaryTree<Item> right) {
		this.right = right;
		right.parent = this;
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
	 * Checks if a given item is contained in the tree
	 * 
	 * @param item the item to search for
	 * @return whether the item is in the tree
	 */
	public boolean search(Item item) {
		if (item.equals(item)) {
			return true;
		} else if (isLeaf()) {
			return false;
		} else {
			return left.search(item) || right.search(item);
		}
	}

	/**
	 * Returns if the tree is complete (every level, except possibly the last,
	 * is completely filled, and all nodes are as far left as possible)
	 * 
	 * @return true if the tree is complete
	 */
	public boolean isCompleteSlow() {
		if (isLeaf()) {
			return true;
		} else if (left.height() != right.height()) {
			return false;
		} else {
			return left.isCompleteSlow() && right.isCompleteSlow();
		}
	}

	/**
	 * Returns if the tree is complete (every level, except possibly the last,
	 * is completely filled, and all nodes are as far left as possible).
	 * More efficient than isCompleteSlow.
	 * 
	 * @return true if the tree is complete
	 */
	public boolean isComplete() {
		return size() == Math.pow(2, height() + 1) - 1;
	}
}