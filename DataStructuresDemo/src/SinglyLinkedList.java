package algs4;

import java.util.Iterator;

/**
 * The {@code SinglyLinkedList} class represents a singly linked list. It has
 * been implemented based on Sedgewick and Wayne's Algorithms textbook (4th
 * edition).
 * 
 * @author Aden Siebel
 * @author Alexandra Papoutsaki
 *
 */
public class SinglyLinkedList<Item> implements Iterable<Item> {
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
	 * Checks if the singlyLinkedList is empty.
	 * 
	 * @return true if the singlyLinkedList is empty.
	 */
	public boolean isEmpty() {
		return n == 0;
	}

	/**
	 * Returns the number of elements in the list.
	 * 
	 * @return the number of elements in the list.
	 */
	public int size() {
		return n;
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

		Node finger = first;
		// search for index-th element or end of list
		while (index > 0) {
			finger = finger.next;
			index--;
		}
		return finger.item;
	}

	/**
	 * Inserts a new node with item contents at the front of the list.
	 * 
	 * @param item
	 *            the contents of the node to be inserted.
	 */
	public void insertFront(Item item) {
		// Save the old node
		Node oldfirst = first;

		// Make a new node and assign it to head. Fix pointers.
		first = new Node();
		first.item = item;
		first.next = oldfirst;

		n++; // increase number of nodes in singly linked list.
	}

	/**
	 * Inserts a new node with item contents at the back of the list.
	 * 
	 * @param item
	 *            the contents of the node to be inserted.
	 */
	public void insertBack(Item item) {
		// create new node
		Node temp = new Node();
		temp.item = item;
		temp.next = null;
		// if at least one node already
		if (first != null) {
			// find tail and make temp the new tail
			Node finger = first;
			while (finger.next != null) {
				finger = finger.next;
			}
			finger.next = temp;
		} else {
			first = temp;
		}

		n++;
	}

	/**
	 * Removes the node from the front of the list.
	 * 
	 * @return the contents of the removed node.
	 */
	public Item removeFront() {
		Node temp = first;
		// Fix pointers.
		first = first.next;

		n--;

		return temp.item;
	}

	/**
	 * Removes the node from the back of the list.
	 * 
	 * @return the contents of the removed node.
	 */
	public Item removeBack() {
		Node previous = null;
		Node finger = first;
		// search for tail
		while (finger.next != null) {
			previous = finger;
			finger = finger.next;
		}
		// if exactly one element
		if (previous == null) {
			first = null;
		} else {
			previous.next = null;
		}

		n--;
		// finger's value is old tail, return it
		return finger.item;

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

		if (index == 0) {
			insertFront(item);
		} else if (index == size()) {
			insertBack(item);
		} else {

            Node previous = null;
            Node finger = first;
            // search for index-th position
            while (index > 0)
            {
                previous = finger;
                finger = finger.next;
                index--;
            }
            // create new value to insert in correct position.
            Node current = new Node();
            current.next = finger;
            current.item = item;
            // make previous value point to new value.
            previous.next = current;
            
            n++;
		}
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

		if (index == 0) {
			return removeFront();
		} else if (index == size() - 1) {
			return removeBack();
		} else {
			Node previous = null;
			Node finger = first;
			// search for value indexed, keep track of previous
			while (index > 0) {
				previous = finger;
				finger = finger.next;
				index--;
			}
			previous.next = finger.next;

			n--;
			// finger's value is old value, return it
			return finger.item;
		}

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
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.insertFront(1);
		System.out.println(sll);
		sll.insert(0, 2);
		System.out.println(sll);
		sll.insertBack(20);
		System.out.println(sll);
		sll.insertFront(30);
		System.out.println(sll);
		sll.removeFront();
		System.out.println(sll);
		sll.removeBack();
		System.out.println(sll);
		sll.removeBack();
		System.out.println(sll);
		sll.insertBack(1);
		System.out.println(sll);
		sll.insertFront(3);
		System.out.println(sll);
		sll.removeFront();
		System.out.println(sll);
		sll.removeFront();
		System.out.println(sll);
		sll.removeFront();
		System.out.println(sll);
	}
}