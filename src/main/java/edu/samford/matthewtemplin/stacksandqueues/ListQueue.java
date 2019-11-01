
package edu.samford.matthewtemplin.stacksandqueues;

import edu.samford.matthewtemplin.lists.DLinkedList;

/**
 *
 * @author Matthew
 */
public class ListQueue<T> implements Queue<T> {

    protected DLinkedList<T> theQueue = new DLinkedList<>();
    
    @Override
    public void enqueue(T data) {
        theQueue.insertLast(data);
    }

    @Override
    public T dequeue() {
        if (theQueue.isEmpty()){
            throw new Error("Cannot remove from an empty queue. Did you remember to call isEmpty first???");
        }
        T data = theQueue.first().element();
        theQueue.remove(theQueue.first());
        return data;
    }

    @Override
    public T front() {
        if (theQueue.isEmpty()){
            throw new Error("This method does not work with an empty queue. Did you remember to call isEmpty?");
        }
        T data = theQueue.first().element();
        return data;    }

    @Override
    public boolean isEmpty() {
        return theQueue.isEmpty();
    }

    @Override
    public int size() {
        return theQueue.size();
    }

    @Override
    public String toString() {
        String strval = theQueue.toString();
        return strval;
    }
    
}
