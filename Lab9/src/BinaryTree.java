/**
 * Lab 9 
 * Sean Yan
 * finished by 3/27/2018 8:07PM 6hs
 * 
 * this class is a Implementation of a binary tree
 * Using the Bridges plug ins to show the graph of the tree.
 * 
 * 
 */
import bridges.base.BinTreeElement;
import java.util.Iterator;

public class BinaryTree<T>  {
	// the root of the binary tree
	private BinTreeElement<T> root;

	/**
	 * sets the root of this binary tree
	 * @param root
	 */
	public BinaryTree(BinTreeElement<T> root) {
		this.root = root;
	}
	
	/**
	 * Returns the root of a tree.
	 * @return
	 */
	public BinTreeElement<T> getRoot() {
		return root;
	}

	/**
	 * prints out the level that each node appears.
	 * also sets the color of each node to yellow
	 */
	public void printLevels() {
		/**
		 * We start at the root and do an in-order traversal
		 */
		printLevelHelper(root,0);
	}

	/**
	 * Helper method to print the levels
	 * @param node
	 * @param level
	 */
	private void printLevelHelper(BinTreeElement<T> node, int level)
	{
		if (node != null)
		{
			printLevelHelper(node.getLeft(), level + 1);
			System.out.println(node.getValue()); // i.e. "visit"
			
			// now set the node to yellow as well as set the label to the level
			String levellable = String.valueOf(level);
			node.getVisualizer().setColor("yellow");
			node.setLabel(levellable);
			
			printLevelHelper(node.getRight(), level + 1);
		}
	}

	/**
	 * Highlights the left most node to green and
	 * returns the value associated with the node.
	 * @return
	 */
	public T getLeftMostData() {
		if (root == null)
			return null;
		else
			return getLeftMostHelper(root);
	}

	/**
	 * Helper method to get the value and highlight the
	 * node to green.
	 * @param node
	 * @return
	 */
	private T getLeftMostHelper(BinTreeElement<T> node)
	{
		if(node.getLeft() == null)
		{
			node.getVisualizer().setColor("green");
			return node.getValue();
		}
		else
		{
			getLeftMostHelper(node.getLeft());
		}
		return null;
	}
	
	/**
	 * Returns the size of the tree (as the number of elements)
	 * 
	 * @return
	 */
	public int getSize()
	{
		if(this.getRoot() == null)
		{
			return 0;
		}
		else
		{return getSizeHelper(root);}
	}
	
	// helper method for getSize.
	private int getSizeHelper(BinTreeElement<T> node)
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
	 * Returns the height of the tree.
	 * 
	 * @return
	 */
	public int getHeight(BinTreeElement<T> node) 
	{
		if(node == null)
		{
			return 0;
		}
		else 
		{
			return getHeightHelper(node)-1;
		}
	}
	
	// helper method for get height.
	private int getHeightHelper(BinTreeElement<T> node)
	{
		int maxHeight = 0;
		if(node == null)
		{
			return 0;
		}
		else
		{
			maxHeight = max(getHeightHelper(node.getLeft()), getHeightHelper(node.getRight()));
			return maxHeight+1;
		}
		
		
	}
	// helper method: compare two values from the getHeightHelper();
	// return the bigger one.
	private int max(int num1, int num2)
	{
		if(num1 > num2)
		{
			return num1;
		}
		else
		{
			return num2;
		}
	}
	/**
	 * Highlights the right most node to green and
	 * returns the value associated with the node.
	 * @return
	 */
	public T getRightMostData() 
	{
		if (root == null)
			return null;
		else
			return getRightMostHelper(root);
	}
	
	/**
	 * Helper method to get the value and highlight the
	 * node to green.
	 * @param node
	 * @return
	 */
	private T getRightMostHelper(BinTreeElement<T> node)
	{
		if(node.getRight() == null)
		{
			node.getVisualizer().setColor("red");
			return node.getValue();
		}
		else
		{
			getRightMostHelper(node.getRight());
		}
		return null;
	}


	/**
	 * Removes and returns the left most node in the tree
	 * @return
	 */
	public T removeLeftMostNode() 
	{
		if (root == null)
			return null;
		else if (root.getLeft() == null) 
		{
			// special case - the root is the left most node
			T data = root.getValue();
			root = root.getRight();
			return data;
		}
		else 
		{
			// call helper method
			return removeLeftMostNodeHelper(root);
		}
	}

	/**
	 * Private helper method to remove the left most node in the tree
	 * @param node
	 * @return
	 */
	private T removeLeftMostNodeHelper(BinTreeElement<T> node) 
	{
		if ( (node.getLeft()).getLeft() == null ) {
			// node is the parent whose reference must be adjusted
			// node.getLeft() is a reference to the left-most node
			// retrieve the value
			T data = node.getLeft().getValue();
			// we must adjust the left child of node so that it
			// now refers to the right child of the node being deleted
			node.setLeft((node.getLeft()).getRight());
			return data;
		}
		else 
		{
			// continue going left
			return removeLeftMostNodeHelper(node.getLeft());
		}
	}

	
	/**
	 * Removes and returns the right most node in the tree
	 * @return
	 */
	public T removeRightMostNode() 
	{
		if (root == null)
			return null;
		else if (root.getRight() == null) 
		{
			// special case - the root is the right most node
			T data = root.getValue();
			root = root.getLeft();
			return data;
		}
		else 
		{
			// call helper method
			return removeRightMostNodeHelper(root);
		}
	}
	
	/**
	 * Private helper method to remove the Right most node in the tree
	 * @param node
	 * @return
	 */
	private T removeRightMostNodeHelper(BinTreeElement<T> node) 
	{
		if ( (node.getRight()).getRight() == null) 
		{
			// node is the parent whose reference must be adjusted
			// node.getRight() is a reference to the Right-most node
			// retrieve the value
			T data = node.getRight().getValue();
			// we must adjust the right child of node so that it
			// now refers to the left child of the node being deleted
			node.setRight((node.getRight()).getLeft());

			return data;
		}
		else {
			// continue going left
			return removeRightMostNodeHelper(node.getRight());
		}
	}


	public Iterator<T> getPreOrderIterator() 
	{
		return new PreOrderIterator();
	}

	public Iterator<T> getInOrderIterator()
	{
		return new InOrderIterator();
	}
	
	public Iterator<T> getPostOrderIterator()
	{
		return new PostOrderIterator();
		
	}

	private class PreOrderIterator implements Iterator<T>
	{
		private T[] elements;
		private int next;

		@SuppressWarnings("unchecked")
		private PreOrderIterator() {
			// create an array large enough to hold all elements in the tree
			elements = (T[])new Object[getSize()];
			next = 0;

			// now perform a pre order traversal
			preOrder(root);

			// reset next back to the beginning of the array
			next = 0;
		}

		private void preOrder(BinTreeElement<T> node)
		{
			if (node != null) {
				elements[next++] = node.getValue();
				preOrder(node.getLeft());
				preOrder(node.getRight());
			}
		}

		public boolean hasNext() 
		{
			return (next < getSize());
		}

		public T next() 
		{
			return elements[next++];
		}
	}
	
	private class InOrderIterator implements Iterator<T>
	{
		private T[] elements;
		private int next;
		
		@SuppressWarnings("unchecked")
		private InOrderIterator()
		{
			// create an array large enough to hold all elements in the tree
			elements = (T[])new Object[getSize()];
			next = 0;

			// now perform an in-order traversal
			InOrder(root);

			// reset next back to the beginning of the array
			next = 0;
		}

		private void InOrder(BinTreeElement<T> node)
		{
			if (node != null)
			{
				InOrder(node.getLeft());
				elements[next++] = node.getValue();
				InOrder(node.getRight());
			}
			
		}

		public boolean hasNext() 
		{
			return (next < getSize());
		}

		public T next() 
		{
			return elements[next++];
		}
	}
	
	
	private class PostOrderIterator implements Iterator<T>
	{
		private T[] elements;
		private int next;

		@SuppressWarnings("unchecked")
		private PostOrderIterator()
		{
			// create an array large enough to hold all elements in the tree
			elements = (T[])new Object[getSize()*10];
			next = 0;

			// now perform a post-order traversal
			PostOrder(root);

			// reset next back to the beginning of the array
			next = 0;
		}

		private void PostOrder(BinTreeElement<T> node) 
		{
			if (node != null)
			{
				PostOrder(node.getLeft());//recursive the left
				PostOrder(node.getRight());//recursive the right 
				elements[next++] = node.getValue();//input the current node into array.
			}
		}

		public boolean hasNext()
		{
			return (next < getSize());
		}

		public T next() 
		{
			return elements[next++];
		}
	}

}
