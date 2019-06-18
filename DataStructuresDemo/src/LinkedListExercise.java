package algs4;

import java.util.Iterator;

/**
 * The {@code DoublyLinkedList} class represents a doubly linked list. It has
 * been implemented based on Sedgewick and Wayne's Algorithms textbook (4th
 * edition).
 * 
 * @author TODO: Your name
 *
 */
public class DoublyLinkedListExercise<Item> implements Iterable<Item> {
	private Node first; // head of the doubly linked list
	private Node last; // tail of the doubly linked list
	private int n; // number of nodes in the doubly linked list

	/**
	 * This nested class defines the nodes in the doubly linked list with a value
	 * and pointers to the previous and next node they are connected.
	 */
	private class Node {
		Item item;
		Node next;
		Node prev;
	}

	/**
	 * Checks if the DoublyLinkedList is empty.
	 * 
	 * @return true if the DoublyLinkedList is empty.
	 */
	public boolean isEmpty() {
		return false;
		// TODO Implement a correct isEmpty method
	}

	/**
	 * Returns the number of elements in the list.
	 * 
	 * @return the number of elements in the list.
	 */
	public int size() {
		return 0;
		// TODO Implement a correct size method
	}

	/**
	 * c *
	 * 
	 * @param index
	 *            the index to get the contents of node from.
	 * @return the contents of node at given index.
	 */
	public Item get(int index) {
		rangeCheck(index);

		// TODO Simple cases for the head and tail

		// TODO Otherwise a slow iteration through the list

		return null;
	}

	/**
	 * Inserts a new node with item contents at the front of the list.
	 * 
	 * @param item
	 *            the contents of the node to be inserted.
	 */
	public void insertFront(Item item) {
		// TODO Save the old node

		// TODO Make a new node and assign it to head. Fix pointers.

		// TODO if first node to be added, adjust tail to it.

		// TODO increase number of nodes in doubly linked list.
	}

	/**
	 * Inserts a new node with item contents at the back of the list.
	 * 
	 * @param item
	 *            the contents of the node to be inserted.
	 */
	public void insertBack(Item item) {
		// TODO Save the old node

		// TODO Make a new node and assign it to tail. Fix pointers.

		// TODO if first node to be added, adjust head to it.

		// TODO increase number of nodes in doubly linked list.
	}

	/**
	 * Removes the node from the front of the list.
	 * 
	 * @return the contents of the removed node.
	 */
	public Item removeFront() {
		// TODO Save the old node

		// TODO Fix pointers

		// TODO at least 1 nodes left or not

		// TODO decrease number of nodes in doubly linked list

		// TODO fix returned value
		return null;
	}

	/**
	 * Removes the node from the back of the list.
	 * 
	 * @return the contents of the removed node.
	 */
	public Item removeBack() {

		// TODO Follow basic idea behind removeFront to remove the back element

		return null;
	}

	/**
	 * Inserts a node at a given index.
	 * 
	 * @param index
	 *            the index to insert the node
	 * @param item
	 *            the item to insert
	 */
	public void insert(int index, Item item) {
		rangeCheck(index);

		// TODO Check edge cases for head and tail and reuse code from before
		// TODO Otherwise, go through and find the desired node.
		// TODO Create a new node and fix pointers.
		// TODO Increase number of nodes
	}

	/**
	 * Removes an item at the given index
	 * 
	 * @param index
	 *            the index to remove the item
	 * @return the removed item
	 */
	public Item remove(int index) {
		rangeCheck(index);

		// TODO Check edge cases for head and tail and reuse code from before
		// TODO Otherwise, go through and find the desired node. You can use two
		// pointers for ease.
		// TODO Fix pointers.
		// TODO Decrease number of nodes and return old node.

		return null;

	}

	/**
	 * A helper method to check if an index is in range
	 * 
	 * @param index
	 *            the index to check
	 */
	private void rangeCheck(int index) {
		if (index >= n || index < 0)
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
	}

	/**
	 * A method for converting the LinkedList to a String
	 */
	public String toString() {
		if (isEmpty()) {
			return "Doubly Linked List: []";
		}

		String ret = "Doubly Linked List: [<- ";
		Iterator<Item> i = this.iterator();
		while (i.hasNext()) {
			ret += i.next();
			ret += " <-> ";
		}
		ret = ret.substring(0, ret.length() - 5);

		ret += " ->] First: ";
		ret += first.item;
		ret += ", Last: " + last.item;
		return ret;
	}

	/**
	 * A method for creating an iterator for the list
	 */
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	/**
	 * A subclass that defines the iterator
	 */
	private class ListIterator implements Iterator<Item> {
		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
		}

		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	public static void main(String args[]) {
		// TODO Create at least one doubly linked list and experiment with your
		// implemented methods.
	}
}