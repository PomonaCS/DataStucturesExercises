package algs4;

import java.util.Iterator;

/**
 * The {@code DoublyLinkedList} class represents a doubly linked list. It has
 * been implemented based on Sedgewick and Wayne's Algorithms textbook (4th
 * edition).
 * 
 * @author Aden Siebel
 * @author Alexandra Papoutsaki
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
	 * Returns true if the doubly linked list does not contain any item.
	 * 
	 * @return true if the doubly linked list does not contain any item
	 */
	public boolean isEmpty() {
		return false;
		// TODO Implement a correct isEmpty method
	}

	/**
	 * Returns the number of items in the doubly linked list.
	 * 
	 * @return the number of items in the doubly linked list
	 */
	public int size() {
		return 0;
		// TODO Implement a correct size method
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

		// TODO Simple cases for the head and tail

		// TODO Otherwise a slow iteration through the list

		return null;
	}

	/**
	 * Inserts the specified item at the head of the doubly linked list.
	 * 
	 * @param item
	 *            the item to be inserted
	 */
	public void addFirst(Item item) {
		// TODO Save the old node

		// TODO Make a new node and assign it to head. Fix pointers.

		// TODO if first node to be added, adjust tail to it.

		// TODO increase number of items in doubly linked list.
	}

	/**
	 * Inserts the specified item at the tail of the doubly linked list.
	 * 
	 * @param item
	 *            the item to be inserted
	 */
	public void addLast(Item item) {
		// TODO Save the old node

		// TODO Make a new node and assign it to tail. Fix pointers.

		// TODO if first node to be added, adjust head to it.

		// TODO increase number of items in doubly linked list.
	}

	/**
	 * Inserts the specified item at the specified index.
	 * 
	 * @param index
	 *            the index to insert the item
	 * @param item
	 *            the item to insert
	 */
	public void add(int index, Item item) {
		rangeCheck(index);

		// TODO Check edge cases for head and tail and reuse code from before

		// TODO Otherwise, go through and find the desired item.

		// TODO Create a new node and fix pointers.

		// TODO Increase number of items
	}

	/**
	 * Retrieves and removes the head of the doubly linked list.
	 * 
	 * @return the head of the doubly linked list.
	 */
	public Item removeFirst() {
		// TODO Save the old node

		// TODO Fix pointers

		// TODO at least 1 node left or not

		// TODO decrease number of items in doubly linked list

		// TODO fix returned value
		return null;
	}

	/**
	 * Retrieves and removes the tail of the doubly linked list.
	 * 
	 * @return the tail of the doubly linked list.
	 */
	public Item removeLast() {

		// TODO Follow basic idea behind removeFirst to remove the tail

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

		// TODO Check edge cases for head and tail and reuse code from before

		// TODO Otherwise, go through and find the desired item. You can use two
		// pointers for ease.

		// TODO Fix pointers.

		// TODO Decrease number of items and return old node.

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
	 * Converts the doubly linked list to a String.
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
	 * Constructs an iterator for the doubly linked list.
	 */
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	/**
	 * A subclass that defines the iterator for the doubly linked list.
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
		// implemented methods.s
	}
}