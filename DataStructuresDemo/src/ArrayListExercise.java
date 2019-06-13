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
		//TODO: fill the constructor

	}

	/**
	 * Checks if the ArrayList is empty.
	 * 
	 * @return true if the ArrayList is empty; false otherwise.
	 */
	public boolean isEmpty() {
		//TODO: check whether is empty
		return false;
	}

	/**
	 * Returns the number of elements in the ArrayList.
	 * 
	 * @return the number of elements in the ArrayList.
	 */
	public int size() {
		//TODO: return number of elements in the ArrayList.
		return 0;
	}

	/**
	 * Resizes the ArrayList's capacity.
	 */
	@SuppressWarnings("unchecked")
	private void resize(int capacity) {
		assert capacity >= n;
		Item[] temp = (Item[]) new Object[capacity];
		
		// TODO Copy the elements from the old underlying array a to the temp array.
		
		// TODO Reference a to temp.
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

		//TODO Check to see if doubling of the underlying array is needed, and if yes, perform it.
		
		//TODO Shift elements to the right to make space for new item.
		
		//TODO Set the new item at position index.
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
		//TODO Check for a correct index
		
		//TODO Set the new item
		
		return null; //TODO Return the old item
	}

	/**
	 * Accesses an item at a specific index.
	 * 
	 * @param index
	 *            the index to access.
	 * @return the item at the specified index.
	 */
	public Item get(int index) {
		return null; //TODO Return the item at the desired index
	}

	/**
	 * Removes the item at the end of the ArrayList.
	 * @return the removed item.
	 * @pre n>0
	 */
	public Item remove() {
		//TODO Empty check
		
		//TODO Remove the item

		//TODO Shrink the underlying array if its a quarter of it only is filled

		return null; //TODO Return the removed item
	}

	/**
	 * Removes an item at a specific index.
	 * 
	 * @param index
	 *            the index to remove the item.
	 * @return the removed item.
	 */
	public Item remove(int index) {
		//TODO Implement a similar method to the above method, except at any index
		
		//TODO Move the other elements over
		
		return null;
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
		//TODO: Create an ArrayList of Integers and experiment with the different operations.
		//Always print the contents to see if they worked correctly.
	}
}