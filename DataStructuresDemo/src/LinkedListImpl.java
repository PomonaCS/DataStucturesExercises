import java.util.Iterator;

/**
 * A Doubly Linked List implementation based on the Singly Linked List queue
 * present in Sedgewick and Wayne's Algorithms textbook. Can have methods added
 * if necessary, as this implementation is meant as a teaching exercise and is
 * missing some potentially useful methods.
 * 
 * @author Aden Siebel
 *
 * @param <Item> The type of the Doubly Linked List
 */
public class LinkedListImpl<Item> implements Iterable<Item> {
	private Node first; // first element of the list
	private Node last; // last element of the list
	private int N; // number of items

	/**
	 * This nested class defines the nodes in the list, with a value and pointers to
	 * the front and back
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
	public boolean isEmpty() {
		return N == 0;
	} // Or: N == 0.

	/**
	 * Returns the number of elements in the list
	 * 
	 * @return the number of elements in the list
	 */
	public int size() {
		return N;
	}

	/**
	 * Inserts an item at the front of the list
	 * 
	 * @param item the item to be inserted
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
	 * @param item the item to be inserted
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
	 * @return the removed item
	 */
	public Item removeFront() {
		return remove(0);
	}

	/**
	 * Removes the item at the back of the list
	 * 
	 * @return the removed item
	 */
	public Item removeBack() {
		return remove(N - 1);
	}

	/**
	 * Inserts a node before a given indexed element
	 * 
	 * @param index the index to insert the node before
	 * @param item  the item to insert
	 * @return the item at the given index
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
		if (isEmpty()) { // if empty, only set head and tail
			first = insert;
			last = insert;
		} else if (first == current) { // if at the front, correct for new front
			first = insert;
			current.prev = insert;
		} else { // otherwise, set pointers for the ones before current
			current.prev.next = insert;
			current.prev = insert;
		}

		N++;
		return current.item;
	}

	/**
	 * Inserts a node after a given indexed element
	 * 
	 * @param index the index to insert the node after
	 * @param item  the item to insert
	 * @return the item at the given index
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
		if (isEmpty()) { // if empty, just set first and last pointers
			first = insert;
			last = insert;
		} else if (last == current) { // if at the back, correct for new last
			last = insert;
			current.next = insert;
		} else { // otherwise, set new pointers
			current.next.prev = insert;
			current.next = insert;
		}

		N++;
		return current.item;
	}

	/**
	 * Removes an item at the given index
	 * 
	 * @param index the index to remove the item
	 * @return the removed item
	 */
	public Item remove(int index) {
		rangeCheck(index);

		Node current = first;

		// Go through and find the desired element
		for (int i = 0; i < index; i++)
			current = current.next;
		if (N == 1) {
			first = null;
			last = null;
		} else {
			if (current == first || current == last) {
				if (current == first) { // If first,
					first = current.next;
					first.prev = null;
				}

				if (current == last) {
					last = current.prev;
					last.next = null;
				}
			}

			else {
				// Set the ones on either side to point to each other
				current.next.prev = current.prev;
				current.prev.next = current.next;
			}
		}

		N--;
		return current.item;

	}

	/**
	 * A helper method to check if an index is in range
	 * 
	 * @param index the index to check
	 */
	private void rangeCheck(int index) {
		if (index >= N || index < 0)
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
	}
	
	/**
	 * A method for converting the LinkedList to a String
	 */
	public String toString() {
		if(isEmpty()) {
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
		LinkedListImpl<Integer> dll = new LinkedListImpl<Integer>();
		dll.insertFront(1);
		System.out.println(dll);
		dll.insertBefore(0, 2);
		System.out.println(dll);
		dll.insertBefore(0, 3);
		System.out.println(dll);
		dll.insertAfter(2, 4);
		System.out.println(dll);
		dll.insertAfter(1, 5);
		System.out.println(dll);
		dll.insertAfter(0, 2);
		System.out.println(dll);
		dll.insertBack(20);
		System.out.println(dll);
		dll.insertFront(30);
		System.out.println(dll);
		dll.removeFront();
		System.out.println(dll);
		dll.removeBack();
		System.out.println(dll);
		dll.removeBack();
		System.out.println(dll);
		dll.remove(2);
		System.out.println(dll);
		dll.remove(3);
		System.out.println(dll);
		dll.removeFront();
		System.out.println(dll);
		dll.removeFront();
		System.out.println(dll);
		dll.removeFront();
		System.out.println(dll);
	}
}
