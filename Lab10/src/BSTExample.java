/**
 * Demo program of the binary search tree
 * 
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import bridges.connect.Bridges;
import bridges.validation.RateLimitException;

public class BSTExample {
	public static void main(String[] args) throws IOException, RateLimitException {
		//create the Bridges object
		// Use YOUR API Sha1 key and user name
		Bridges bridges = new Bridges(4, "48353018792", "hy1006");
		
		//Create elements and insert them into the tree
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		
		
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(50);
		list.add(75);
		list.add(20);
		list.add(10);
		list.add(30);
		list.add(5);
		list.add(15);
		list.add(25);
		list.add(35);
		list.add(3);
		list.add(8);
		list.add(13);
		list.add(28);
		list.add(33);
		list.add(38);
		list.add(85);
		list.add(95);
		
		//insert elements into the tree by iterate the array-list
		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext())
		{
			tree.add(itr.next());
		}
		
		// Now perform some operations on the tree
		// 1. iterator();
		Iterator<Integer> inOrder_itr = tree.iterator();
		System.out.println("in order: ");
		while(inOrder_itr.hasNext()== true)
		{
			String obj = new Integer(inOrder_itr.next()).toString() + " ";
			System.out.print(obj);
		}
		System.out.println();
		// 2. remove();
		System.out.println("remove: "+tree.remove(13));
		// 3. contains();
		System.out.println("is it contians 13: " + tree.contains(13));
		System.out.println("is it contians 33: " + tree.contains(33));
		// 4. size();
		System.out.println("size: "+tree.size());
		// 5. isEmpty();
		System.out.println("is empty: "+tree.isEmpty());
		// 6. getLargest() and getSmallest();
		System.out.println("largest: "+tree.getLargest());
		System.out.println("smallest: "+tree.getSmallest());
		
		// finally visualize the tree
		bridges.setDataStructure(tree.getRoot());
		bridges.visualize();
		
	}

}
