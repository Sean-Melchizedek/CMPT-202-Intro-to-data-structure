

public class HashDictionaryChained<K,V> implements DictionaryInterface<K, V> 
{

		// initial size of hash table
		private static int DEFAULT_SIZE = 13; 
		
		// When capacity exceeds this threshold, a new addition will trigger rehashing
		private static double CAPACITY_THRESHOLD = 1.0;
		
		// the number of elements in the hash table
		private int numberOfElements;

		// the hash table(an list of linked list)
		// i just found out that Java can't use generic array creation. 
		// so i create a list of list...
		private List<TableElement<K, V>>[] dictionary;
		
		// the current capacity of the hash table
		// this is a prime number
		private int currentCapacity;
		
		// each index the hash table contains a linked list.
		
		
		/**
		 * Inner class representing an element in the hash table
		 *  This consists of a [Key:Value] mapping
		 *
		 * @param <K> Key	
		 * @param <V> Value
		 */
		@SuppressWarnings("hiding")
		private class TableElement<K, V>
		{
			private K key;
			private V value;
			private boolean flag = false;
			
			private TableElement(K key, V value) 
			{
				this.key = key;
				this.value = value;
			}
				
			/**
			 * Two TableElement objects are equal if they both have the same key
			 */
			@SuppressWarnings("unchecked")
			public boolean equals(Object other) 
			{
				boolean flag = false;
				if (other instanceof TableElement) 
				{
					TableElement<K, V> candidate = (TableElement<K, V>)other;
					if ( (this.getKey()).equals(candidate.getKey()) )
					{
						flag = true;
					}
				}
					
				return flag;
			}
						
			// appropriate getters/setters
			private K getKey()
			{
				return key;
			}

			private V getValue() 
			{
				return value;
			}

			private void setKey(K key) 
			{
				this.key = key;
			}

			private void setValue(V value) 
			{
				this.value = value;
			}
		}
	

		

	
	
	public HashDictionaryChained() 
	{
		this(DEFAULT_SIZE);
	}
	
	@SuppressWarnings("unchecked")
	public HashDictionaryChained(int size)
	{
		if (size < 0)
		{
			throw new IllegalArgumentException();
		}
		numberOfElements = 0;
		currentCapacity = size;
		dictionary = new LinkedList[size];
	}
	
	
	
	
	
///////////////////////////////////////////////private helper method area////////////////	
	/**
	 * Return the current load factor
	 * @return
	 */
	private double getLoadFactor() 
	{
		return numberOfElements / (double)currentCapacity; 
	}
	
	/**
	 * Returns the hash value in the range [0 .. currentCapacity-1]
	 * @param key
	 * @return int
	 */
	private int hashValue(K key) 
	{
		return (Math.abs(key.hashCode()) % currentCapacity);
	}
	

	@Override
	public V put(K key, V value)
	{
		return seperateChaining(key,value);
	}
	
	
	/**
	 * Private helper method that implements appropriate hashing strategy
	 * @param key
	 * @param value
	 * @return
	 */
	private V seperateChaining(K key, V value)
	{
		// Separate chaining never rehash.
		// thus no need for ensureCapicity();
		
		
		int hash = hashValue(key);
		int index = 0;
		TableElement<K,V> newElement = new TableElement<K,V>(key,value);
		
		//if this hash to a new position
		if(ensureChaining(key) == false)
		{
			// if the key is already exist, updating the value on that key
		
			if(contains(key) == true)
			{
				
				dictionary[hash].get(0).value = value;
			
			}
			// if dictionary not contains this key
			else 
			{
				
				dictionary[hash] = new LinkedList<TableElement<K,V>>();
				dictionary[hash].add(newElement);
				this.numberOfElements++;
			
			}
		}
		// if it collision
		else
		{
			index++;
			dictionary[hash].add(newElement, index);
			this.numberOfElements++;
		}
		
		
		return value;
	}
	
	private boolean ensureChaining(K key)
	{
		int hash = hashValue(key);
		if(contains(key)==true)
		{
			if(dictionary[hash].isEmpty())
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		else
			return false;
	}
	
	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
     * Determines if the dictionary contains the specified key.
     *
     * @return boolean - True if the dictionary contains the key, false otherwise.
     */
	public boolean contains(K key) 
	{
		int hash = hashValue(key);
		//in Separate chaining, one key may related to several table Elements.
		if (dictionary[hash] != null)
		{
			return true;
		}
		else 
		{
			return false;
		}
		
		
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		
		return this.numberOfElements;
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<V> valueSet() {
		// TODO Auto-generated method stub
		return null;
	}

}
