/**
 * Queue.java
 *
 * Interface for queue operations.
 *
 * @author Greg Gagne December 2017.
 */

public interface Queue<T>
{
	/**
	 * Add item to the rear of the queue
	 * 
	 * @param item
	 */
    public void add(T item);

    /**
     * Remove the item at the front of the queue.
     * 
     * @return Item at front of queue, or null if queue is empty
     */
    public T remove();

    /**
     * Determines if the queue is empty.
     * 
     * @return True if empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in the queue.
     * 
     * @return
     */
    public int size();
}
