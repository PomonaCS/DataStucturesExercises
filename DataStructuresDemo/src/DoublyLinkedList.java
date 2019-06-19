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
public class DoublyLinkedList<Item> implements Iterable<Item> {
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
		return n == 0; //or return first == null;
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

		if (index == 0)
			return first.item;

		else if (index == size() - 1)
			return last.item;

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
		first.prev = null;

		// if first node to be added, adjust tail to it.
		if (last == null)
			last = first;
		else
			oldfirst.prev = first;

		n++; // increase number of nodes in doubly linked list.
	}

	/**
	 * Inserts a new node with item contents at the back of the list.
	 * 
	 * @param item
	 *            the contents of the node to be inserted.
	 */
	public void insertBack(Item item) {
		// Save the old node
		Node oldlast = last;

		// Make a new node and assign it to tail. Fix pointers.
		last = new Node();
		last.item = item;
		last.next = null;
		last.prev = oldlast;

		// if first node to be added, adjust head to it.
		if (first == null)
			first = last;
		else
			oldlast.next = last;

		n++;
	}

	/**
	 * Removes the node from the front of the list.
	 * 
	 * @return the contents of the removed node.
	 */
	public Item removeFront() {
		Node oldFirst = first;
		//Fix pointers.
		first = first.next;
		//at least 1 nodes left.
		if (first != null) {
			first.prev = null;
		} else {
			last = null; // remove final node.
		}
		oldFirst.next = null;
		
		n--;
		
		return oldFirst.item;
	}

	/**
	 * Removes the node from the back of the list.
	 * 
	 * @return the contents of the removed node.
	 */
	public Item removeBack() {

		Node temp = last;
		last = last.prev;

		// if there was only one node in the doubly linked list.
		if (last == null) {
			first = null;
		} else {
			last.next = null;
		}
		n--;
		return temp.item;
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
            // create new value to insert in correct position
            
            // create new value to insert in correct position
            Node current = new Node();
            current.item = item;
            current.next = finger;
            current.prev = previous;
            previous.next = current;
            finger.prev = current;
            
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
	        while (index > 0)
	        {
	            previous = finger;
	            finger = finger.next;
	            index--;
	        }
	        previous.next = finger.next;
	        finger.next.prev = previous;
	        
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
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
		dll.insertFront(1);
		System.out.println(dll);
		dll.insert(0, 2);
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
		dll.insertBack(1);
		System.out.println(dll);
		dll.insertFront(3);
		System.out.println(dll);
		dll.removeFront();
		System.out.println(dll);
		dll.removeFront();
		System.out.println(dll);
		dll.removeFront();
		System.out.println(dll);
	}
}