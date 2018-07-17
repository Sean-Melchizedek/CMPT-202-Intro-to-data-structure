import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * Unit test for Max heap class.
 * 
 * @author Sean
 *
 */
public class MaxHeapTest {

	/**
	 * Test method for {@link MaxHeap#MaxHeap()}.
	 */
	@Test
	public void testMaxHeap() {
		MaxHeap heapMax = new MaxHeap();
		assertTrue(heapMax.getSize() == 0);
	}

	/**
	 * Test method for {@link MaxHeap#MaxHeap(int)}.
	 */
	@Test
	public void testMaxHeapInt()
	{
		MaxHeap heapMax = new MaxHeap(30);
		assertTrue(heapMax.getSize() == 0);
		System.out.println(heapMax);
	}

	/**
	 * Test method for {@link MaxHeap#add(java.lang.Comparable)}.
	 */
	@Test
	public void testAdd() 
	{
		MaxHeap<Integer> heapMax = new MaxHeap<Integer>();
		
		heapMax.add(10);
		heapMax.add(2);
		heapMax.add(15);
		heapMax.add(19);
		heapMax.add(6);
		heapMax.add(7);
		heapMax.add(4);
		heapMax.add(14);
		heapMax.add(6);
		heapMax.add(22);
		heapMax.add(1);
		heapMax.add(3);
		heapMax.add(35);
		heapMax.add(44);
		heapMax.add(29);
		heapMax.add(16);
		heapMax.add(50);

		assertTrue(heapMax.front() == 50);
		
		heapMax.remove();
		assertTrue(heapMax.front() == 44);
		heapMax.remove();
		assertTrue(heapMax.front() == 35);
		heapMax.remove();
		assertTrue(heapMax.front() == 29);
		heapMax.remove();
		assertTrue(heapMax.front() == 22);
		heapMax.remove();
		assertTrue(heapMax.front() == 19);
		heapMax.remove();
		assertTrue(heapMax.front() == 16);
		heapMax.remove();
		assertTrue(heapMax.front() == 15);
		heapMax.remove();
		assertTrue(heapMax.front() == 14);
		heapMax.remove();
		assertTrue(heapMax.front() == 10);
		heapMax.remove();
		assertTrue(heapMax.front() == 7);
		heapMax.remove();
		assertTrue(heapMax.front() == 6);
		heapMax.remove();
		assertTrue(heapMax.front() == 6);
		heapMax.remove();
		assertTrue(heapMax.front() == 4);
		heapMax.remove();
		assertTrue(heapMax.front() == 3);
		heapMax.remove();
		assertTrue(heapMax.front() == 2);
		heapMax.remove();
		assertTrue(heapMax.front() == 1);
		heapMax.remove();
		
		
		
	}

	/**
	 * Test method for {@link MaxHeap#remove()}.
	 */
	@Test
	public void testRemove() 
	{
		MaxHeap<Integer> heapMax = new MaxHeap<Integer>();
		
		heapMax.add(10);
		heapMax.add(2);
		heapMax.add(15);
		heapMax.add(19);
		heapMax.add(6);
		heapMax.add(7);
		heapMax.add(4);
		heapMax.add(14);
		heapMax.add(6);
		heapMax.add(22);
		heapMax.add(1);
		heapMax.add(3);
		heapMax.add(35);
		heapMax.add(44);
		heapMax.add(29);
		heapMax.add(16);
		heapMax.add(50);

		assertTrue(heapMax.front() == 50);
		
		heapMax.remove();
		assertTrue(heapMax.front() == 44);
		heapMax.remove();
		assertTrue(heapMax.front() == 35);
		heapMax.remove();
		assertTrue(heapMax.front() == 29);
		heapMax.remove();
		assertTrue(heapMax.front() == 22);
		heapMax.remove();
		assertTrue(heapMax.front() == 19);
		heapMax.remove();
		assertTrue(heapMax.front() == 16);
		heapMax.remove();
		assertTrue(heapMax.front() == 15);
		heapMax.remove();
		assertTrue(heapMax.front() == 14);
		heapMax.remove();
		assertTrue(heapMax.front() == 10);
		heapMax.remove();
		assertTrue(heapMax.front() == 7);
		heapMax.remove();
		assertTrue(heapMax.front() == 6);
		heapMax.remove();
		assertTrue(heapMax.front() == 6);
		heapMax.remove();
		assertTrue(heapMax.front() == 4);
		heapMax.remove();
		assertTrue(heapMax.front() == 3);
		heapMax.remove();
		assertTrue(heapMax.front() == 2);
		heapMax.remove();
		assertTrue(heapMax.front() == 1);
		heapMax.remove();
	}

	/**
	 * Test method for {@link MaxHeap#front()}.
	 */
	@Test
	public void testFront() 
	{
		MaxHeap<Integer> heapMax = new MaxHeap<Integer>();
		
		heapMax.add(10);
		heapMax.add(2);
		heapMax.add(15);
		heapMax.add(19);
		
		assertTrue(heapMax.front() == 19);
		heapMax.remove();
		assertTrue(heapMax.front() == 15);
		heapMax.remove();
		assertTrue(heapMax.front() == 10);
		heapMax.remove();
		assertTrue(heapMax.front() == 2);
		heapMax.remove();
		assertTrue(heapMax.front() == null);
	}

	/**
	 * Test method for {@link MaxHeap#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		MaxHeap<Integer> heapMax = new MaxHeap<Integer>();
		heapMax.add(10);
		heapMax.add(2);
		heapMax.add(15);
		heapMax.add(19);
		
		heapMax.remove();
		heapMax.remove();
		heapMax.remove();
		heapMax.remove();
		assertTrue(heapMax.isEmpty() == true);
	}

	/**
	 * Test method for {@link MaxHeap#getSize()}.
	 */
	@Test
	public void testGetSize() 
	{
		MaxHeap<Integer> heapMax = new MaxHeap<Integer>();
		heapMax.add(10);
		heapMax.add(2);
		heapMax.add(15);
		heapMax.add(19);
		assertTrue(heapMax.getSize() == 4);
	}



}
