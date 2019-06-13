package algs4;

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
 * @author Aden Siebel
 * @author Alexandra Papoutsaki
 *
 */
public class ArrayList<Item> implements Iterable<Item> {
	private Item[] a; // underlying array of items
	private int n; // number of items in arraylist

	/**
	 * Constructs an ArrayList with capacity of 2.
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
	public ArrayList(int size) {
		a = (Item[]) new Object[size];
		n = 0;
	}

	/**
	 * Checks if the ArrayList is empty.
	 * 
	 * @return true if the ArrayList is empty; false otherwise.
	 */
	public boolean isEmpty() {
		return n == 0;
	}

	/**
	 * Returns the number of elements in the ArrayList.
	 * 
	 * @return the number of elements in the ArrayList.
	 */
	public int size() {
		return n;
	}

	/**
	 * Resizes the ArrayList's capacity.
	 */
	@SuppressWarnings("unchecked")
	private void resize(int capacity) {
		assert capacity >= n;
		// textbook implementation.
		Item[] temp = (Item[]) new Object[capacity];
		for (int i = 0; i < n; i++)
			temp[i] = a[i];

		a = temp;

		// alternative implementation
		// a = java.util.Arrays.copyOf(a, capacity);
	}

	/**
	 * Adds an item to the end of the ArrayList, doubling its capacity if necessary.
	 * 
	 * @param item
	 *            the item to add
	 */
	public void add(Item item) {
		if (n == a.length)
			resize(2 * a.length);

		a[n++] = item;
	}

	/**
	 * Adds an item to the ArrayList at a specific index, shifting existing elements
	 * to the right, and doubling its capacity if necessary.
	 * 
	 * @param index
	 *            the place to add the element
	 * @param item
	 *            the item to add
	 */
	public void add(int index, Item item) {
		rangeCheck(index);

		if (n == a.length)
			resize(2 * a.length);

		// shift elements to the right
		for (int i = n++; i > index; i--)
			a[i] = a[i - 1];

		a[index] = item;
	}

	/**
	 * Replaces an item at a specific index with a new item. 
	 * 
	 * @param index
	 *            the index to replace the item.
	 * @param item
	 *            what to change the item to.
	 * @return the old item that was changed.
	 */
	public Item set(int index, Item item) {
		rangeCheck(index);

		Item old = a[index];
		a[index] = item;

		return old;
	}

	/**
	 * Accesses an item at a specific index.
	 * 
	 * @param index
	 *            the index to access.
	 * @return the item at the specified index.
	 */
	public Item get(int index) {
		rangeCheck(index);

		return a[index];
	}

	/**
	 * Removes the item at the end of the ArrayList.
	 * @return the removed item.
	 * @pre n>0
	 */
	public Item remove() {
		if (isEmpty())
			throw new NoSuchElementException("The list is empty");

		Item item = a[--n];
		a[n] = null; // Avoid loitering (see text).

		// Shrink to save space if possible
		if (n > 0 && n == a.length / 4)
			resize(a.length / 2);

		return item;
	}

	/**
	 * Removes an item at a specific index.
	 * 
	 * @param index
	 *            the index to remove the item.
	 * @return the removed item.
	 */
	public Item remove(int index) {
		rangeCheck(index);

		Item item = a[index];
		n--;

		for (int i = index; i < n; i++)
			a[i] = a[i + 1];

		a[n] = null; // Avoid loitering (see text).

		// shrink to save space if necessary
		if (n > 0 && n == a.length / 4)
			resize(a.length / 2);

		return item;
	}

	/**
	 * Checks if the ArrayList contains a specific item.
	 * 
	 * @param item
	 *            the item to check for.
	 * @return true if the item is in the list.
	 */
	public boolean contains(Item item) {
		return indexOf(item) >= 0;
	}

	/**
	 * Check for the first index of an item in the ArrayList.
	 * 
	 * @param item
	 *            the item to check for.
	 * @return the first index of the item.
	 */
	public int indexOf(Item item) {
		if (item == null) { // Special check for null elements
			for (int i = 0; i < n; i++)
				if (a[i] == null)
					return i;
		} else { // Regular check
			for (int i = 0; i < n; i++)
				if (item.equals(a[i]))
					return i;
		}

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
	 *            the index to check
	 */
	private void rangeCheck(int index) {
		if (index >= n || index < 0)
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
	}

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
	 * A method for creating an iterator for the ArrayList
	 */
	public Iterator<Item> iterator() {
		return new ArrayIterator();
	}

	/**
	 * A subclass that defines the iterator.
	 */
	private class ArrayIterator implements Iterator<Item> {
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
		ArrayList<Integer> al = new ArrayList<Integer>();
		System.out.println(al.isEmpty());
		al.add(1);
		al.add(2);
		al.add(3);
		System.out.println(al);

		al.set(1, 5);
		System.out.println(al);
		al.remove(2);
		System.out.println(al);

		for (int i = 0; i < 30; i++)
			al.add(i);
		System.out.println(al);

		for (int i = 0; i < 30; i++)
			al.remove();

		System.out.println(al.contains(1));
		al.clear();
		System.out.println(al);
		al.get(20);
	}
}
