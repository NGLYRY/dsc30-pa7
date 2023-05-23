/*
 * Name: Ryan Ly
 * PID:  A17395629
 */

/**
 * Priority Queue Implementation using dHeap.
 *
 * @author Ryan Ly
 * @since 5/21/2023
 *
 * @param <T> the type of elements held in this collection
 */
public class MyPriorityQueue<T extends Comparable<? super T>> {

    private dHeap<T> pQueue;

    private int d = 4;
    /**
     * Constructor that creates a new priority queue
     *
     * @param initialSize the given size
     */
    public MyPriorityQueue(int initialSize) {
        pQueue = new dHeap<>(d, initialSize, false);
    }

    /**
     * Inserts an element into the Priority Queue. The element received cannot be
     * null.
     *
     * @param element Element to be inserted.
     * @throws NullPointerException if the element received is null.
     * @return returns true
     */
    public boolean offer(T element) throws NullPointerException {
        if (element == null) {
            throw new NullPointerException();
        }
        pQueue.add(element);
        return true;
    }

    /**
     * Retrieve and remove the head of this Priority Queue (largest element), or null if the
     * queue is empty.
     *
     * @return The head of the queue (largest element), or null if queue is empty.
     */
    public T poll() {
        if (pQueue.size() <= 0) {
            return null;
        }
        return pQueue.remove();
    }

    /**
     * Clears the contents of the queue
     */
    public void clear() {
       pQueue.clear();
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if
     * this queue is empty.
     *
     * @return the head of the queue, null if the queue is empty
     */
    public T peek() {
        if (pQueue.size() == 0) {
            return null;
        }
        return pQueue.element();
    }

    /**
     * Indicates whether the queue is empty.
     * @return true is the queue is empty, false otherwise
     */
    public boolean isEmpty() {
            return pQueue.size() == 0;
    }

}