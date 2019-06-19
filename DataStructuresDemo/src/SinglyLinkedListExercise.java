package algs4;

import java.util.Iterator;

/**
 * The {@code SinglyLinkedList} class represents a singly linked list. It has
 * been implemented based on Sedgewick and Wayne's Algorithms textbook (4th
 * edition).
 * 
 * @author TODO Your name
 *
 */
public class SinglyLinkedListExercise<Item> implements Iterable<Item> {
	private Node first; // head of the singly linked list
	private int n; // number of nodes in the singly linked list

	/**
	 * This nested class defines the nodes in the singly linked list with a value
	 * and pointer to the next node they are connected.
	 */
	private class Node {
		Item item;
		Node next;
	}

	/**
	 * Returns true if the singly linked list does not contain any item.
	 * 
	 * @return true if the singly linked list does not contain any item
	 */
	public boolean isEmpty() {
		return false; // TODO fix
	}

	/**
	 * Returns the number of items in the singly linked list.
	 * 
	 * @return the number of items in the singly linked list
	 */
	public int size() {
		return 0; // TODO fix
	}

	/**
	 * Returns item at the specified index.
	 * 
	 * @param index
	 *            the index of the item to be returned
	 * @return the item at specified index
	 */
	public Item get(int index) {
		rangeCheck(index);
		return null;
		// TODO A slow iteration through the list to return index-th node.

	}

	/**
	 * Inserts the specified item at the head of the singly linked list.
	 * 
	 * @param item
	 *            the item to be inserted
	 */
	public void add(Item item) {
		// TODO Save the old node

		// TODO Make a new node and assign it to head. Fix pointers.

		// TODO increase number of nodes in singly linked list.
	}

	/**
	 * Inserts the specified item at the specified index.
	 * 
	 * @param index
	 *            the index to insert the node
	 * @param item
	 *            the item to insert
	 */
	public void add(int index, Item item) {

		// TODO Check edge cases for head and tail and reuse code from before
		// TODO Otherwise, go through and find the desired node.
		// TODO Create a new node and fix pointers.
		// TODO Increase number of nodes
	}

	/**
	 * Retrieves and removes the head of the singly linked list.
	 * 
	 * @return the head of the singly linked list.
	 */
	public Item remove() {
		// TODO Save the old node

		// TODO Fix pointers

		// TODO decrease number of nodes in doubly linked list

		// TODO fix returned value

		return null;
	}

	/**
	 * Retrieves and removes the item at the specified index.
	 * 
	 * @param index
	 *            the index of the item to be removed
	 * @return the item previously at the specified index
	 */
	public Item remove(int index) {
		rangeCheck(index);

		// TODO Check edge case for head and reuse code from before
		// TODO Otherwise, go through and find the desired node.
		// TODO Create a new node and fix pointers.
		// TODO Decrease number of nodes
		return null;
	}

	/**
	 * A helper method to check if the specified index is in range.
	 * 
	 * @param index
	 *            the index to check
	 */
	private void rangeCheck(int index) {
		if (index >= n || index < 0)
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
	}

	/**
	 * A method for converting the singly linked list to a String.
	 */
	public String toString() {
		if (isEmpty()) {
			return "Singly Linked List: []";
		}

		String ret = "Singly Linked List: [<- ";
		Iterator<Item> i = this.iterator();
		while (i.hasNext()) {
			ret += i.next();
			ret += " <-> ";
		}
		ret = ret.substring(0, ret.length() - 5);

		ret += " ->] First: ";
		ret += first.item;
		return ret;
	}

	/**
	 * A method for creating an iterator for the singly linked list.
	 */
	public Iterator<Item> iterator() {
		return new SinglyLinkedListIterator();
	}

	/**
	 * A subclass that defines the iterator for the singly linked list.
	 */
	private class SinglyLinkedListIterator implements Iterator<Item> {
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
		// TODO Create at least one singly linked list and experiment with your
		// implemented methods.
	}
}