/**
 * An Association class to replace the one from structure5, for Pomona's CS62
 * class. Associations store two values together, one as a key and one as a value.
 * 
 * @author Aden
 *
 * @param <K> The type of the Key
 * @param <V> The type of the Value
 */
public class Association<K, V> {
	protected K key;
	protected V value;
	
	Association(K key){
		this.key = key;
		value = null;
	}
	
	Association(K key, V value){
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}

	public void setValue(V item) {
		value = item;
	}
	
	public boolean equals(Association<K, V> other) {
		if(other.getKey().equals(this.getKey()))
			return true;
					
		return false;
	}
	
	public String toString() {
		return "Association<Key,Value>: (" + key + ", " + value + ")";
	}

}
