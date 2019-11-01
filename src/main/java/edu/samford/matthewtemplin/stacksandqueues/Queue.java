
package edu.samford.matthewtemplin.stacksandqueues;

/**
 * Interface for a FIFO data structure.
 * @author Matthew
 */
public interface Queue<T> {
    public void enqueue(T data); //enqueue is the equivalent of push in a stack
    public T dequeue(); //equivalent of pop
    public T front(); //equivalent of top
    public boolean isEmpty();
    public int size();
    
}
