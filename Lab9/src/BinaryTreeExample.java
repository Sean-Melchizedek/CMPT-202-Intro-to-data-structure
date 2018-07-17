/*
 * Lab 9
 * Sean Yan
 * 
 * This is a example class in main method for Binary Tree class.
 * this class will create a binary tree and graphed online by bridge.
 * when hit run it will out print the height and size of the tree for you.
 * moreover, it will traversal the pre,in and the post order of the tree and print into an array separately.
 * finally will print the url of the graph.
 */
import bridges.connect.Bridges;
import bridges.validation.RateLimitException;
import bridges.base.BinTreeElement;

import java.io.IOException;
import java.util.Iterator;

public class BinaryTreeExample {

	/**
	 * @param args
	 * @throws RateLimitException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, RateLimitException {
		//create the Bridges object
		// Use YOUR API Sha1 key and user name
		Bridges bridge = new Bridges(3,"48353018792", "hy1006");

		// create elements
		// First parameter is String depicted when using mouseover with bridges animation
		// Second parameter is data object stored at that tree element
		BinTreeElement<String> root = new BinTreeElement<String>("M", "Mango");

		BinaryTree<String> tree = new BinaryTree<String>(root);
		
		// set the color and label of an Element
		

		BinTreeElement<String> fTree = new BinTreeElement<String>("F", "Fig");
		BinTreeElement<String> rTree = new BinTreeElement<String>("R", "Ramen");
		BinTreeElement<String> tTree = new BinTreeElement<String>("T", "Tea");
		BinTreeElement<String> dTree = new BinTreeElement<String>("D", "Dog");
		BinTreeElement<String> qTree = new BinTreeElement<String>("Q", "Queen");
		BinTreeElement<String> hTree = new BinTreeElement<String>("H", "Hill");
		BinTreeElement<String> gTree = new BinTreeElement<String>("G", "Google");
		BinTreeElement<String> lTree = new BinTreeElement<String>("L", "Life");
		BinTreeElement<String> aTree = new BinTreeElement<String>("A", "ALife");
		BinTreeElement<String> bTree = new BinTreeElement<String>("B", "BLife");
		BinTreeElement<String> cTree = new BinTreeElement<String>("C", "CLife");
		BinTreeElement<String> kTree = new BinTreeElement<String>("K", "KLife");
		

		// link elements
		root.setLeft(fTree);
		root.setRight(rTree);
		rTree.setRight(tTree);
		fTree.setLeft(dTree);
		fTree.setRight(hTree);
		dTree.setRight(qTree);
		hTree.setLeft(gTree);
		hTree.setRight(lTree);
		tTree.setLeft(aTree);
		aTree.setRight(bTree);
		aTree.setLeft(kTree);
		
		Iterator<String> pre_itr = tree.getPreOrderIterator();
		Iterator<String> in_itr = tree.getInOrderIterator(); 
		Iterator<String> post_itr = tree.getPostOrderIterator(); 
	
		
		if (tree.getRoot() != null) {
			// make sure we have a data structure to visualize!
			
			//pass root element of data structure
			bridge.setDataStructure(root);
			tree.getLeftMostData();
			tree.getRightMostData();
			System.out.println("Height: "+tree.getHeight(root));
			System.out.println("Size: "+ tree.getSize());
//			tree.removeLeftMostNode();
//			tree.removeRightMostNode();
			
			//iterator
			//1. pre
			System.out.println("pre order: ");
			while(pre_itr.hasNext()== true)
			{
				String obj = pre_itr.next();
				System.out.print(obj + " ");
			}
			System.out.println();
			System.out.println("in order: ");
		    //2. in
			while(in_itr.hasNext()== true)
			{
				String obj = in_itr.next();
				System.out.print(obj + " ");
			}
			System.out.println();
			System.out.println("post order: ");
			//3. post
			while(post_itr.hasNext()== true)
			{
				String obj = post_itr.next();
				System.out.print(obj + " ");
			}
			System.out.println();
			
			//visualize data structure
			
			//tree.printLevels();
			
			// THIS SHOULD BE THE LAST METHOD YOU CALL!
			bridge.visualize();
		}
	}

	private static Iterator<String> getPreOrderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
