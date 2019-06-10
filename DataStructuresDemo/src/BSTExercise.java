/**
 * A Binary Search Tree implementation based on the implementation presented in
 * Sedgewick and Wayne's Algorithms textbook. Can have methods added if
 * necessary, as this implementation is meant as a teaching exercise and is
 * missing some potentially useful methods.
 * 
 * @author Aden Siebel
 *
 * @param <Key> The type of Key of the tree. Must be Comparable
 * @param <Value> The value type of the tree associated with the tree
 */
public class BSTExercise<Key extends Comparable<Key>, Value> {
	private Node root;

	/**
	 * Nested subclass defining the nodes in the tree, with 
	 * a key, value, left and right pointers and the root of the BST
	 */
	private class Node {
		private Key key;
		private Value val; // associated value
		private Node left, right; // links to subtrees
		private int N; // root of BST

		public Node(Key key, Value val, int N) {
			this.key = key;
			this.val = val;
			this.N = N;
		}

	}

	/**
	 * Returns the size of the tree
	 * @return the size of the tree
	 */
	public int size() {
		return size(root);
	}

	/**
	 * Size of the tree rooted at x
	 * 
	 * @param x  root of the tree
	 * @return   size of the tree
	 */
	private int size(Node x) {
		return 0;
	}

	/**
	 * Return value associated with key, return null if not present
	 * 
	 * @param key  key to search for 
	 * @return     value associated with key, or null if not present
	 */
	public Value get(Key key) {
		return get(root, key);
	}

	/**
	 * Return value associated with key in the subtree rooted at x,
	 * return null if key not present in subtree rooted at x.
	 * 
	 * @param x    root of the subtree to search
	 * @param key  key to search for 
	 * @return	   value associated with key, or null if not present 
	 */
	private Value get(Node x, Key key) {
		if (x == null)
			return null;

		int cmp = key.compareTo(x.key);

		if (cmp < 0)
			return get(x.left, key);
		else if (cmp > 0)
			return get(x.right, key);
		else
			return x.val;
	}

	/**
	 * Search for key. Update value if found; grow table if new
	 * 
	 * @param key  key to search for
	 * @param val  value to update
	 */
	public void put(Key key, Value val) { 
		root = put(root, key, val);
	}

	/**
	 * Change key’s value to val if key in subtree rooted at x.
	 * Otherwise, add new node to subtree associating key with val.
	 * 
	 * @param x    root of the subtree to search
	 * @param key  key to search for
	 * @param val  value to update
	 * @return     the node where the key was found
	 */
	private Node put(Node x, Key key, Value val) {
		return null;
	}

	/**
	 * Find the minimum value of the tree
	 * 
	 * @return  the minimum value of the tree
	 */
	public Key min() {
		return min(root).key;
	}

	/**
	 * Find the minimum value of a subtree 
	 * 
	 * @param x  The subtree to search
	 * @return   The minimum value of the subtree
	 */
	private Node min(Node x) {
		if (x.left == null)
			return x;

		return min(x.left);
	}

	/**
	 * Find the largest key less than or equal to a given key
	 * 
	 * @param key  The key to search for
	 * @return     The largest key less than or equal to key
	 */
	public Key floor(Key key) {
		Node x = floor(root, key);

		if (x == null)
			return null;
		return x.key;
	}

	/**
	 * Find the largest key less than or equal to a given key in a given
	 * subtree
	 * 
	 * @param x	   The root of the subtree to search
	 * @param key  The key to search for
	 * @return     The largest key less than or equal to key
	 */
	private Node floor(Node x, Key key) {
		if (x == null)
			return null;

		int cmp = key.compareTo(x.key);

		if (cmp == 0)
			return x;
		if (cmp < 0)
			return floor(x.left, key);

		Node t = floor(x.right, key);

		if (t != null)
			return t;
		else
			return x;
	}

	/**
	 * Delete the minimum value of the tree
	 */
	public void deleteMin() {
		root = deleteMin(root);
	}

	/**
	 * Delete the minimum value of a given subtree
	 * 
	 * @param x  The root of the subtree to search
	 * @return   The node where the minimum value was found 
	 */
	private Node deleteMin(Node x) {
		if (x.left == null)
			return x.right;

		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;

		return x;
	}

	/**
	 * Find the maximum value of the tree
	 * 
	 * @return  the maximum value of the tree
	 */
	public Key max() {
		return null;
	}

	/**
	 * Find the maximum value of a subtree 
	 * 
	 * @param x  The subtree to search
	 * @return   The maximum value of the subtree
	 */
	private Node max(Node x) {
		return null;
	}

	/**
	 * Find the smallest key greater than or equal to a given key
	 * 
	 * @param key  The key to search for
	 * @return     The smallest key greater than or equal to the key
	 */
	public Key ceiling(Key key) {
		return null;
	}

	/**
	 * Find the smallest key greater than or equal to a given key in a given
	 * subtree
	 * 
	 * @param x	   The root of the subtree to search
	 * @param key  The key to search for
	 * @return     The smallest key greater than or equal to key
	 */
	private Node ceiling(Node x, Key key) {
		return null;
	}

	/**
	 * Delete the maximum value of the tree
	 */
	public void deleteMax() {
		
	}

	/**
	 * Delete the maximum value of a given subtree
	 * 
	 * @param x  The root of the subtree to search
	 * @return   The node where the maximum value was found 
	 */
	private Node deleteMax(Node x) {
		return null;
	}

	/**
	 * Delete a given node from the tree
	 * 
	 * @param key  The key of the node to delete
	 */
	public void delete(Key key) {
		root = delete(root, key);
	}

	/**
	 * Delete a given node from a subtree 
	 * 
	 * @param x    The root of the subtree to search
	 * @param key  The key of the node to delete
	 */
	private Node delete(Node x, Key key) {
		return null;
	}

}