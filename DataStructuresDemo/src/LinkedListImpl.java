import java.util.Iterator;

/**
* A Doubly Linked List implementation based on the Singly Linked List queue present in
* Sedgewick and Wayne's Algorithms textbook. Can have methods added if necessary,
* as this implementation is meant as a teaching exercise and is missing some 
* potentially useful methods. 
* 
* @author Aden Siebel
*
* @param <Item> The type of the Doubly Linked List
*/
public class LinkedListImpl<Item> implements Iterable<Item> {
	private Node first; // first element of the list
	private Node last;  // last element of the list
	private int N; // number of items

	/**
	 * This nested class defines the nodes in the list, with a value
	 * and pointers to the front and back
	 */
	private class Node {
		Item item;
		Node next;
		Node prev;
	}

	/** 
	 * Checks if the DoublyLinkedList is empty
	 * 
	 * @return true if the DoublyLinkedList is empty
	 */
	public boolean isEmpty() { return first == null; } // Or: N == 0.

	/**
	 * Returns the number of elements in the list
	 * 
	 * @return the number of elements in the list
	 */
	public int size() {	return N; }

	/**
	 * Inserts an item at the front of the list
	 * 
	 * @param item  the item to be inserted
	 */
	public void insertFront(Item item) {
		// Save the old node
		Node oldfirst = first;
		
		// Change the pointers
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		first.prev = null;

		if (isEmpty())
			last = first;
		else
			oldfirst.prev = first;

		N++;
	}

	/**
	 * Inserts an item at the back of the list
	 * 
	 * @param item  the item to be inserted
	 */
	public void insertBack(Item item) {
		// Save the old node
		Node oldlast = last;
		
		// Change the pointers
		last = new Node();
		last.item = item;
		last.next = null;
		last.prev = oldlast;

		if (isEmpty())
			first = last;
		else
			oldlast.next = last;

		N++;
	}

	/**
	 * Removes the item at the front of the list
	 * 
	 * @return  the removed item
	 */
	public Item removeFront() {
		Item item = first.item;
		first = first.next;

		if (isEmpty())
			last = null;

		N--;
		return item;
	}

	/**
	 * Removes the item at the back of the list
	 * 
	 * @return  the removed item
	 */
	public Item removeBack() {
		Item item = last.item;
		last = last.prev;

		if (isEmpty())
			first = null;

		N--;
		return item;

	}

	/**
	 * Inserts a node before a given indexed element
	 * 
	 * @param index  the index to insert the node before
	 * @param item   the item to insert
	 * @return		 the item at the given index
	 */
	public Item insertBefore(int index, Item item) {
		rangeCheck(index);

		Node current = first;

		// Go through and find the desired element
		for (int i = 0; i < index; i++)
			current = current.next;

		// Set that item's pointers
		Node insert = new Node();
		insert.item = item;
		insert.next = current;
		insert.prev = current.prev;

		// Set the pointers on either side
		if (isEmpty()) {
			first = insert;
			last = insert;
		} else {
			current.prev.next = insert;
			current.prev = insert;
		}

		N++;
		return current.item;
	}

	/**
	 * Inserts a node after a given indexed element
	 * 
	 * @param index  the index to insert the node after
	 * @param item   the item to insert
	 * @return		 the item at the given index
	 */
	public Item insertAfter(int index, Item item) {
		rangeCheck(index);

		Node current = first;

		// Go through and find the desired element
		for (int i = 0; i < index; i++)
			current = current.next;

		// Set that item's pointers
		Node insert = new Node();
		insert.item = item;
		insert.prev = current;
		insert.next = current.next;

		// Set the pointers on either side
		if (isEmpty()) {
			first = insert;
			last = insert;
		} else {
			current.next.prev = insert;
			current.next = insert;
		}

		N++;
		return current.item;
	}

	/**
	 * Removes an item at the given index
	 * 
	 * @param index  the index to remove the item
	 * @return		 the removed item
	 */
	public Item remove(int index){
		rangeCheck(index);

		Node current = first;

		// Go through and find the desired element
		for (int i = 0; i < index; i++)
			current = current.next;
		
		// Set the ones on either side to point to each other
		current.next.prev = current.prev;
		current.prev.next = current.next;
		
		N--;
		return current.item;
		
	}

	/**
	 * A helper method to check if an index is in range
	 * 
	 * @param index  the index to check
	 */
	private void rangeCheck(int index) {
		if (index >= N || index < 0)
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
	}

	/**
	 * A method for creating an iterator for the list
	 */
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	/**
	 * A subclass that defines the iterator
	 * 
	 * @author Aden
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
}