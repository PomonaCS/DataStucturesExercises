package algs4ex;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.IndexOutOfBoundsException;

/**
 * The {@code ArrayList} class represents a resizing list. It has been
 * implemented based on Sedgewick and Wayne's Algorithms textbook (4th edition).
 * <p>
 * It doubles the underlying array when it is full and halves the underlying
 * array when it is one-quarter full.
 * 
 * @author TODO: Your name
 *
 */
public class ArrayList<Item> implements Iterable<Item> {
	private Item[] a; // underlying array of items
	private int n; // number of items in arraylist

	/**
	 * Constructs an ArrayList with an initial capacity of 2.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList() {
		a = (Item[]) new Object[2];
		n = 0;
	}

	/**
	 * Constructs an ArrayList with capacity of size.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		//TODO: fill the constructor

	}

	/**
	 * Returns true if the ArrayList contains no items.
	 * 
	 * @return true if the ArrayList does not contain any item
	 */
	public boolean isEmpty() {
		//TODO: check whether is empty
		return false;
	}

	/**
	 * Returns the number of items in the ArrayList.
	 * 
	 * @return the number of items in the ArrayList
	 */
	public int size() {
		//TODO: return number of elements in the ArrayList.
		return 0;
	}

	/**
	 * Resizes the ArrayList's capacity to the specified capacity.
	 */
	@SuppressWarnings("unchecked")
	private void resize(int capacity) {
		assert capacity >= n;
		Item[] temp = (Item[]) new Object[capacity];
		
		// TODO Copy the elements from the old underlying array a to the temp array.
		
		// TODO Reference a to temp.
	}

	/**
	 * Appends the item to the end of the ArrayList. Doubles its capacity if necessary.
	 * 
	 * @param item
	 *            the item to be inserted
	 */
	public void add(Item item) {
		if (n == a.length)
			resize(2 * a.length);

		a[n++] = item;
	}

	/**
	 * Inserts the item at the specified index. Shifts existing elements
	 * to the right and doubles its capacity if necessary.
	 * 
	 * @param index
	 *            the index to insert the item
	 * @param item
	 *            the item to be inserted
	 */
	public void add(int index, Item item) {
		rangeCheck(index);

		//TODO Check to see if doubling of the underlying array is needed, and if yes, perform it.
		
		//TODO Shift elements to the right to make space for new item.
		
		//TODO Set the new item at position index.
	}

	/**
	 * Replaces the item at the specified index with the specified item. 
	 * 
	 * @param index
	 *            the index of the item to replace
	 * @param item
	 *            item to be stored at specified index
	 * @return the old item that was changed.
	 */
	public Item set(int index, Item item) {
		//TODO Check for a correct index
		
		//TODO Set the new item
		
		return null; //TODO Return the old item
	}

	/**
	 * Returns the item at the specified index.
	 * 
	 * @param index
	 *            the index of the item to return
	 * @return the item at the specified index
	 */
	public Item get(int index) {
		return null; //TODO Return the item at the desired index
	}

	/**
	 * Retrieves and removes the item from the end of the ArrayList.
	 * @return the removed item
	 * @pre n>0
	 */
	public Item remove() {
		//TODO Empty check
		
		//TODO Remove the item

		//TODO Shrink the underlying array if its a quarter of it only is filled

		return null; //TODO Return the removed item
	}

	/**
	 * Retrieves and removes the item at the specified index.
	 * 
	 * @param index
	 *            the index of the item to be removed
	 * @return the removed item
	 */
	public Item remove(int index) {
		//TODO Implement a similar method to the above method, except at any index
		
		//TODO Move the other elements over
		
		return null;
	}

	/**
	 * Checks if the ArrayList contains the specified item.
	 * 
	 * @param item
	 *            the item to check if it is included in the ArrayList
	 * @return true if the item is in the list
	 */
	public boolean contains(Item item) {
		return indexOf(item) >= 0;
	}

	/**
	 * Check for the first index of an item in the ArrayList.
	 * 
	 * @param item
	 *            the item to check for
	 * @return the index of first occurrence of the specified item
	 */
	public int indexOf(Item item) {
		//TODO Go through ArrayList and check when there is a match. Pay special attention to null case.
		
		return -1;
	}

	/**
	 * Clears the ArrayList of all elements.
	 */
	public void clear() {

		// Help garbage collector.
		for (int i = 0; i < n; i++)
			a[i] = null;

		n = 0;
	}

	/**
	 * A helper method to check if an index is in range 0<=index<n
	 * 
	 * @param index
	 *            the index to check if it is within range
	 */
	private void rangeCheck(int index) {
		if (index >= n || index < 0)
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
	}

	/**
	 * Converts the ArrayList to a String.
	 */
	public String toString() {
		if (isEmpty()) {
			return "ArrayList: []";
		}

		String ret = "ArrayList: [";

		Iterator<Item> i = this.iterator();
		while (i.hasNext()) {
			ret += i.next();
			ret += "; ";
		}

		ret += "]";
		return ret;
	}

	/**
	 * Constructs an iterator for the ArrayList
	 */
	public Iterator<Item> iterator() {
		return new ArrayIterator();
	}

	/**
	 * A subclass that defines the iterator for the ArrayList.
	 */
	private class ArrayListIterator implements Iterator<Item> {
		private int i = 0;

		public boolean hasNext() {
			return i < n;
		}

		public Item next() {
			return a[i++];
		}

		public void remove() {
		}
	}

	public static void main(String args[]) {
		//TODO: Create an ArrayList of Integers and experiment with the different operations.
		//Always print the contents to see if they worked correctly.
	}
}