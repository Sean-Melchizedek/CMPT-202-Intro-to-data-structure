/**
 * Binary search tree implementation.
 * ->>>>do not allow duplicates.<<<<-
 * code base from @Preauthor Greg Gagne
 * 
 * Lab 10
 * implemented by @author Sean Yan
 * last modify by 4/3/2018 
 * 	  finished by 4/3/2018 9:43
 * 
 * the remove() is very challenging.
 */
import java.util.Iterator;
import bridges.base.BSTElement;

public class BinarySearchTree <K extends Comparable<? super K>> implements SearchTreeInterface<K> 
{
	// the root of the binary search tree
	private BSTElement<K, String> root;

	/**
	 * Create an empty binary search tree
	 */
	public BinarySearchTree() {
		root = null;
	}

	/**
	 * This method has nothing to do with a binary search tree,
	 * but is necessary to provide the bridges visualization.
	 */
	public BSTElement<K, String> getRoot() {
		return root;
	}

	/*
	 * (implemented)
	 * Determines if the tree is empty or not
     * @return boolean - true if the tree is empty, false otherwise.
	 */
	public boolean isEmpty() 
	{
		if(root == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Solution that uses recursive helper method.
	 * We disallow duplicate elements in the tree. 
	 */
	public K add(K key) 
	{
		if (contains(key))
		{
			return null;
		}
		else 
		{
			root = add(key, root);
			return key;
		}
	}


	/**
	 * private helper method for adding a node to the binary search tree
	 * @param key
	 * @param subtree
	 * @return the root of the tree
	 */
	private BSTElement<K, String> add(K key, BSTElement<K,String> subtree) {
		if (subtree == null) 
		{
			// we have found the spot for the addition

			// create the new node
			// parameters are (1) label (2) key (3) empty string [not used]
			BSTElement<K, String> newNode = new BSTElement<K, String>(key.toString(), key, "");

			// we also set the color of a new node to red
			newNode.getVisualizer().setColor("red");

			return newNode;
		}

		int direction = key.compareTo(subtree.getKey());

		if (direction < 0) {
			subtree.setLeft( add(key, subtree.getLeft()) );
		}
		else if (direction > 0) {
			subtree.setRight( add(key, subtree.getRight()) );
		}

		return subtree;
	}


	/**
	 * Non-recursive algorithm for addition
	 * This only serves the purpose of demonstrating the
	 * differences between the recursive and non-recursive approaches.
	 */
	/*
	public K add(K key) {
		// we disallow duplicates
		if (contains(key))
			return null;

		// create the new node
		// parameters are (1) label (2) key (3) null [not used]
		BSTElement<K, String> newNode = new BSTElement<K, String>(key.toString(), key, "");
		newNode.getVisualizer().setColor("red");

		// if the tree is empty, set the root to the new node
		if (isEmpty()) {
			root = newNode;
		}
		else {
			// else treat it like an unsuccessful search
			BSTElement<K, String> node = root;
			boolean keepLooking = true;

			while (keepLooking) {
				int direction = key.compareTo(node.getKey());

				if (direction < 0) {
					// go left
					if (node.getLeft() == null) {
						// we found the place for the insert
						node.setLeft(newNode);
						keepLooking = false;
					}
					else
						node = node.getLeft();
				}
				else if (direction > 0) {
					// go right
					if (node.getRight() == null) {
						// we found the place for the insert
						node.setRight(newNode);
						keepLooking = false;
					}
					else
						node = node.getRight();
				}
			}
		}

		return key;
	}
	 */

	
	/**
	 * (implemented)
	 * Returns the largest element in the tree
	 */
	public K getLargest()
	{
		if(root == null)
		{
			return null;
		}
		else
		{
			return getLargestHelper(root);
		}
	}
	// private helper method for getLargest().
	private K getLargestHelper(BSTElement<K,String> node)
	{
		K largestElement = null;
		if(node.getRight() == null)
		{
			node.getVisualizer().setColor("green");
			largestElement =  node.getKey();
		}
		else
		{
			return getLargestHelper(node.getRight());
		}
		return largestElement;
	}

	/**
	 * (implemented)
	 * Returns the smallest element in the tree
	 */
	public K getSmallest() 
	{
		if(root == null)
		{
			return null;
		}
		else
		{
			return getSmallestHelper(root);
		}
	}
	// private helper method for getSmallest().
	private K getSmallestHelper(BSTElement<K,String> node)
	{
		K smallestElement = null;
		if(node.getLeft() == null)
		{
			node.getVisualizer().setColor("yellow");
			smallestElement = node.getKey();
		}
		else
		{
			return getSmallestHelper(node.getLeft());
			
		}
		return smallestElement;
	}

	/**
	 * (implemented)
	 * Determines if the tree contains the specified item.
	 * 
	 * @param item
	 * @return boolean
	 */
	public boolean contains(K key)
	{		
		return  contiansHelperSearch(key,root);
	}
	// private helper method for contains().
	private boolean contiansHelperSearch(K key,BSTElement<K,String> node)
	{
		boolean result = false;
		if (node == null) 
		{
			result = false;
		}
		else if(key == node.getKey())
		{
			node.getVisualizer().setColor("pink");
			result = true;
		}
		else
		{
			int direction = key.compareTo(node.getKey());
			if (direction < 0)
			{
				node = node.getLeft();
			}
			else if (direction > 0) 
			{
				node = node.getRight();
			}
			return contiansHelperSearch(key,node);
		}
		return result;
	}

	/**
	 * (implemented C-M-A-O-method)
	 * Removes the specified item from the tree.
	 * 
	 * @param item
	 * @return K - the item(key) that was moved. Returns null if item is
	 * not present in the tree.
	 */
	public K remove(K key) 
	{
		BSTElement<K,String> removedNode = removeHelper(key,root);
		if(removedNode == null)
		{
			return null;
		}
		else
		{
			return key;
		}
	}
	// private helper method for remove().
	private BSTElement<K,String> removeHelper(K key, BSTElement<K,String> subtree)
	{
		BSTElement<K,String> left = null;
		BSTElement<K,String> right = null;
		
		if(subtree == null)
		{
			return null;
		}
		else
		{
			//go left
			if(key.compareTo(subtree.getKey()) < 0)
			{
//				System.out.println("recursive left");
				left =  removeHelper(key,subtree.getLeft());
				subtree.setLeft(left);
			}
			//go right
			else if(key.compareTo(subtree.getKey()) > 0)
			{
//				System.out.println("recursive right");
				right =  removeHelper(key,subtree.getRight());
				subtree.setRight(right);
			}
			//if it have two children
			else if(subtree.getLeft() != null && subtree.getRight() != null)
			{
				//Refresh the deleted's data with (the (left most child) in (the right subtree))'s data
				K successor = getSmallestHelper(subtree.getRight());
				subtree.setKey(successor);
				//remove the left most child in the right subtree
				right = removeHelper(successor,subtree.getRight());
				subtree.setRight(right);
			}
			//one child or no child(leaf node)
			else
			{
				if(subtree.getLeft() != null)
				{
					subtree = subtree.getLeft();
				}
				else
				{
					subtree = subtree.getRight();
				}
			}
			return subtree;
		}
	}



	/**
	 * Returns the number of elements in the tree
	 * @return int - the number of elements in the tree.
	 */
	public int size() 
	{
		if(root == null)
		{
			return 0;
		}
		else
		{
			return getSizeHelper(root);
		}
	}
	// private helper method for getSize.
	private int getSizeHelper(BSTElement<K, String> node)
	{
		int num = 0;
		if(node == null)
		{
			return 0;
		}
		else
		{
			num = getSizeHelper(node.getLeft()) + getSizeHelper(node.getRight());
			return num+1;
		}
	}

	/**
	 * Returns an iterator containing an in order traversal of the tree.
	 * 
	 * @return Iterator
	 */
	public Iterator<K> iterator()
	{
		return new InOrderIterator();
	}
	// private helper class for iterator.
	private class InOrderIterator implements Iterator<K>
	{
		private K[] elements;
		private int next;
		
		@SuppressWarnings("unchecked")
		private InOrderIterator()
		{
			// create an array large enough to hold all elements(keys) in the tree
			elements = (K[])new Comparable[size()];
			next = 0;

			// now perform an in-order traversal
			InOrder(root);

			// reset next back to the beginning of the array
			next = 0;
		}

		private <E> void InOrder(BSTElement<K,E> node)
		{
			if (node != null)
			{
				InOrder(node.getLeft());
				elements[next++] = node.getKey();
				InOrder(node.getRight());
			}
			
		}

		public boolean hasNext() 
		{
			return (next < size());
		}

		public K next() 
		{
			return elements[next++];
		}
	}
}
