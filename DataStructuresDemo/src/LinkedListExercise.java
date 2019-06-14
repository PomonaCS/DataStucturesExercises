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
public class LinkedListExercise<Item> implements Iterable<Item> {
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
	public boolean isEmpty() { return false; } // Or: N == 0.
	//TODO Implement a correct isEmpty method 

	/**
	 * Returns the number of elements in the list
	 * 
	 * @return the number of elements in the list
	 */
	public int size() {	return 0; }
	//TODO Implement a correct size method 
	
	/**
	 * Returns the item at a given index
	 * 
	 * @param index  the index to get the item from
	 * @return	     the value of the item at that index
	 */
	public Item get(int index) {
		rangeCheck(index);
		
		// TODO Simple cases for the head and tail		
		
		// TODO Otherwise a slow iteration through the list
		
		return null;
	}

	/**
	 * Inserts an item at the front of the list
	 * 
	 * @param item the item to be inserted
	 */
	public void insertFront(Item item) {
		//TODO Save the old node
		
		//TODO Create new node and change the pointers
		
		//TODO Check for empty case
		
		//TODO Increment size counter
	}

	/**
	 * Inserts an item at the back of the list
	 * 
	 * @param item the item to be inserted
	 */
	public void insertBack(Item item) {
		//TODO Save the old node
		
		//TODO Create new node and change the pointers
				
		//TODO Check for empty case
				
		//TODO Increment size counter
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
		// TODO Remove the back element and fix pointers
		
		return null;
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

		//TODO Go through and find the desired element
		
		//TODO Set that item's pointers

		//TODO Set the pointers on either side
			// if empty, only set head and tail
			// if at the front, correct for new front
			// otherwise, set pointers for the ones before current
			
		return null; //TODO Return the item at the index
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

		//TODO Go through and find the desired element
		
		//TODO Set that item's pointers

		//TODO Set the pointers on either side
			// if empty, only set head and tail
			// if at the tail, correct for new tail
			// otherwise, set pointers for the ones after current
			
		return null; //TODO Return the item at the index
	}

	/**
	 * Removes an item at the given index
	 * 
	 * @param index the index to remove the item
	 * @return the removed item
	 */
	public Item remove(int index) {
		rangeCheck(index);

		//TODO Go through and find the desired element
		
		//TODO Change the pointers to eliminate the given node

		return null;

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
		
	}
}
