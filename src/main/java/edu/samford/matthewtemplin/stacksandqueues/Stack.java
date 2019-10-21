/*Operations required for a stack,
 * LIFO - last in, first out.
 * push - add an item to the top of the stack
 * pop - remove the item on top of the stack
 * top - return the item on top of the stack without removing it.
 * isEmpty - return true or false whether or not there is anything in the stack
 * size - return the number of items on the stack
 */
package edu.samford.matthewtemplin.stacksandqueues;

/**
 *
 * @author Matthew
 */
public interface Stack<T> {
   public void push(T data);
   public T pop();
   public T top();
   public int size();
   public boolean isEmpty();
}
