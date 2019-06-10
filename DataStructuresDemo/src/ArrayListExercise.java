
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.IndexOutOfBoundsException;

/**
 * An ArrayList implementation based on the resizable stack array present in
 * Sedgewick and Wayne's Algorithms textbook. Can have methods added if necessary,
 * as this implementation is meant as a teaching exercise and is missing some 
 * potentially useful ArrayList methods. 
 * 
 * @author Aden Siebel
 *
 * @param <Item> The type of the ArrayList
 */
@SuppressWarnings("unchecked")
public class ArrayListExercise<Item> implements Iterable<Item> {
	private Item[] a; // stack items
	private int N; // number of items

	/**
	 * A default constructor that creates an ArrayList of size 10
	 */
	public ArrayListExercise() {
		a = (Item[]) new Object[10];
		N = 10;
	}
	
	/**
	 * A constructor that creates an ArrayList of variable size
	 * 
	 * @param size  the initial size of the ArrayList
	 */
	public ArrayListExercise(int size) {

	}

	/** 
	 * Checks if the ArrayList is empty
	 * 
	 * @return true if the ArrayList is empty
	 */
	public boolean isEmpty() { return false; }

	/**
	 * Returns the number of elements in the list
	 * 
	 * @return the number of elements in the list
	 */
	public int size() { return 0; }
	

	/**
	 * Resizes the ArrayList in order to contain more elements or reduce
	 * space in memory
	 * 
	 * @param max the new size of the array
	 */
	private void resize(int max) { 
		Item[] temp = (Item[]) new Object[max];
	}
	
	/**
	 * Adds an item to the end of the list, expanding the size of the ArrayList
	 * if necessary
	 * 
	 * @param item the item to add
	 */
	public void add(Item item) { 
		if (N == a.length)
			resize(2 * a.length);

		a[N++] = item;
	}

	/**
	 * Adds an item to the list at a specific index, expanding the size of the 
	 * ArrayList if necessary
	 * 
	 * @param index  the place to add the element 
	 * @param item   the item to add 
	 */
	public void add(int index, Item item) {
		rangeCheck(index);
	}
	/**
	 * Change an item at a specific index
	 * 
	 * @param index  the index to change the item
	 * @param item   what to change the item to 
	 * @return 		 the item that was changed
	 */
	public Item set(int index, Item item) {
		return null;
	}

	/**
	 * Get an item at a specific index 
	 * 
	 * @param index  the index to check
	 * @return  	 the item at that index
	 */
	public Item get(int index) {
		return null;
	}

	/**
	 * Remove the item at the end of the list
	 * 
	 * @return  the removed item
	 */
	public Item remove() {
		if(isEmpty())
			throw new NoSuchElementException("The list is empty");
		
		Item item = a[--N];
		a[N] = null; // Avoid loitering (see text).

		// Resize to save space if possible
		if (N > 0 && N == a.length / 4)
			resize(a.length / 2);

		return item;
	}

	/**
	 * Remove an item at a specific index
	 * 
	 * @param index  the index to remove the item
	 * @return		 the removed item
	 */
	public Item remove(int index) {
		return null;
	}

	/**
	 * Check to see if the list contains a specific item
	 * 
	 * @param item  the item to check for 
	 * @return      true if the item is in the list
	 */
	public boolean contains(Item item) {
		return indexOf(item) >= 0;
	}

	/**
	 * Check for the first index of an item in the list
	 * 
	 * @param  item  the item to check for
	 * @return 		 the first index of the item
	 */
	public int indexOf(Item item) {
		return -1;
	}

	/**
	 * Clear the list completely
	 */
	public void clear() {
		
		// Let GarbageCollector work automatically
		for (int i = 0; i < N; i++)
			a[i] = null;

		N = 0;
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
		return new ReverseArrayIterator();
	}

	/**
	 * A subclass that defines the iterator
	 */
	private class ReverseArrayIterator implements Iterator<Item> { // Support LIFO iteration.
		private int i = N;

		public boolean hasNext() {
			return i > 0;
		}

		public Item next() {
			return a[--i];
		}

		public void remove() {
		}
	}
}