/*
 * Name: Ryan Ly
 * PID:  A17395629
 */

import java.util.NoSuchElementException;

/**
 * Title: dHeap Description: This program creates a Heap with d branching factor
 *
 * @author Ryan Ly
 * @since 5/21/2023
 *
 * @param <T> the type of elements held in this collection
 */
public class dHeap<T extends Comparable<? super T>> implements HeapInterface<T> {

    private T[] heap;   // backing array
    private int d;      // branching factor
    private int nelems; // number of elements
    private boolean isMaxHeap; // indicates whether heap is max or min

    private final int DEFAULT_SIZE = 6;

    /**
     * Initializes a binary max heap with capacity = 6
     */
    @SuppressWarnings("unchecked")
    public dHeap() {
        this.isMaxHeap = true;
        this.nelems = 0;
        T[] array= (T[]) new Comparable[DEFAULT_SIZE];
        heap = array;
        this.d = 1;
    }

    /**
     * Initializes a binary max heap with a given initial capacity.
     *
     * @param heapSize The initial capacity of the heap.
     */
    @SuppressWarnings("unchecked")
    public dHeap(int heapSize) {
        isMaxHeap = true;
        nelems = 0;
        T[] array= (T[]) new Comparable[heapSize];
        heap = array;
        this.d = 1;
    }

    /**
     * Initializes a d-ary heap (with a given value for d), with a given initial
     * capacity.
     *
     * @param d         The number of child nodes each node in the heap should have.
     * @param heapSize  The initial capacity of the heap.
     * @param isMaxHeap indicates whether the heap should be max or min
     * @throws IllegalArgumentException if d is less than one.
     */
    @SuppressWarnings("unchecked")
    public dHeap(int d, int heapSize, boolean isMaxHeap) throws IllegalArgumentException {
        if (d < 1) {
            throw new IllegalArgumentException();
        }
        this.isMaxHeap = isMaxHeap;
        this.d = d;
        nelems = 0;
        T[] array = (T[]) new Comparable[heapSize];
        heap = array;
    }

    /** Finds the size of heap
     *
     * @return number of elements
     */
    @Override
    public int size() {
        return nelems;
    }

    /** removes root and resorts the heap
     *
     * @return the root element that is removed
     * @throws NoSuchElementException if heap is empty
     */
    @Override
    public T remove() throws NoSuchElementException {
        if (nelems <= 0) {
            throw new NoSuchElementException();
        }
        T root = heap[0];
        heap[0] = heap[nelems - 1];
        heap[nelems-1] = null;
        nelems--;
        trickleDown(0);
        return root;
    }

    /** Adds element to heap and resorts heap
     *
     * @param item The element to add to the heap.
     * @throws NullPointerException if data is null
     */
    @Override
    public void add(T item) throws NullPointerException {
        if (item == null) {
            throw new NullPointerException();
        }
        if (heap.length == nelems) {
            resize();
        }
        heap[nelems] = item;
        nelems++;
        bubbleUp(nelems-1);
    }

    /** Clears heap
     *
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        for (int i = 0; i < heap.length; i++) {
            heap[i] = null;
        }
        nelems = 0;
    }

    /**
     *
     * @return the root
     * @throws NoSuchElementException if there is nothing in the heap
     */
    @Override
    public T element() throws NoSuchElementException {
        if (nelems == 0) {
            throw new NoSuchElementException();
        }
        return  heap[0];
    }

    private void trickleDown(int index) {
        int childStartIndex = d * index + 1;
        int childEndIndex = Math.min(childStartIndex + d, nelems);
        if (childStartIndex >= nelems) {
            return;
        }
        int childIndex = childStartIndex;
        for (int i = childStartIndex + 1; i < childEndIndex; i++) {
            if (compare(heap[i], heap[childIndex]) > 0) {
                childIndex = i;
            }
        }
        if (compare(heap[childIndex], heap[index]) > 0) {
            swap(childIndex, index);
            trickleDown(childIndex);
        }
    }

    private void bubbleUp(int index) {
        if (index == 0 || compare(heap[index], heap[parent(index)]) <= 0) {
            return; // Node is at root or in correct position, return from the method
        }
        int parentIndex = parent(index);
        swap(index, parentIndex); // Swap node with its parent
        bubbleUp(parentIndex); // Recursively bubble up
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int multiple = 2;
        T[] newHeap = (T[]) new Comparable[nelems*multiple];
        for (int i = 0; i < nelems; i++) {
            newHeap[i] = heap[i];
        }
        heap = newHeap;
    }

    private int parent(int index) {
        if (index == 0) {
            return -1;
        }
        return (index - 1)/d;
    }

    private void swap(int index1, int index2){
        T temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
    private int compare(T element1, T element2) {
        if (isMaxHeap) {
            return element1.compareTo(element2);
        } else {
            return element2.compareTo(element1);
        }
    }

}
