/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.matthewtemplin.lists;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 *
 * @author kartoone
 */
public class DLinkedList<T> implements Iterable<T>{
    
    private DNode<T> header;   // "special" node without data that marks beginning of list
    private DNode<T> trailer;  // "special" node without data that marks end of list
    private int size;       // the number of items (real nodes) in the list
    
    public DLinkedList() {
        size = 0;
        header = new DNode<>();
        trailer = new DNode<>(null, header, null);
        header.setNext(trailer);
    }
    
    public DNode<T> insertLast(T data) {
        // 1. Create the new DNode<T> with the following: 
        //      - our data
        //      - trailer's prev node as our prev node
        //      - trailer as our next node
        DNode<T> newnode = new DNode<>(data,trailer.getPrev(),trailer);
        
        // 2. Break the link between the last real node and the trailer
        trailer.getPrev().setNext(newnode);
        
        // 3. Break the link between the trailer and the last real node 
        trailer.setPrev(newnode);

        size++; // we are adding an item, so go ahead and increment the size
        
        return newnode;
    }
    
    public DNode<T> insertFirst(T data) {
        // 1. Create the new DNode<T> with the following: 
        //      - our data
        //      - header
        //      - header's next node as our next node
        DNode<T> newnode = new DNode<>(data,header,header.getNext());
        
        // 2. Break the link between the header and the first real node
        header.setNext(newnode);
        
        // 3. Break the link between the first real node and the header
        newnode.getNext().setPrev(newnode);

        size++; // we are adding an item, so go ahead and increment the size
        
        return newnode;
    }
    
    public DNode<T> prev(DNode<T> pos) {
        if (pos==first()) {
            return null;
        }
        return pos.getPrev();
    }

    public DNode<T> next(DNode<T> pos) {
        if (pos==last()) {
            return null;
        }
        return pos.getNext();
    }
    
    // create a new node and add it before pos {
    public DNode<T> insertBefore(DNode<T> p, T data) {
        DNode<T> pos = (DNode<T>)p;
        
        // 1. Create the new node
        DNode<T> newnode = new DNode<>(data, pos.getPrev(), pos);
        
        // 2. Tell pos's prev node that its next node should be the new node
        pos.getPrev().setNext(newnode);
        
        // 3. Tell pos that it's prev node should be the new node
        pos.setPrev(newnode);
        
        // 4. increment the size b/c we just added a new node
        size++;
        
        return newnode;
    }
    
    // create a new node and add it after pos
    public DNode<T> insertAfter(DNode<T> p, T data) {
        DNode<T> pos = (DNode<T>)p;
        
        // 1. Create the new node
        DNode<T> newnode = new DNode<>(data, pos, pos.getNext());
        
        // 2. Tell pos's next node that its previous node should be the new node
        pos.getNext().setPrev(newnode);
        
        // 3. Tell pos that its next node should be the new node
        pos.setNext(newnode);
        
        // 4. increment the size
        size++;
        
        return newnode;
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public int size() {
        return size;
    }
    
    @Override
    public String toString() {
        String output = "[";
        DNode<T> cur = header.getNext();
        while(cur!=trailer) {
            output += cur.element();
            cur = cur.getNext();
            if(cur!=trailer) {
                output += ",";
            }
        }
        output = output + "]";
        return output;
    }
    
    // returns the DNode<T> containing the data if found
    // returns null otherwise (if not found)
    // NOTE: stops searching after finding the first occurence
    public DNode<T> search(String data) {
        DNode<T> cur = header.getNext();
        while(cur!=trailer) {
            if(cur.element().equals(data)) {
                return cur; // we found a hit! return the current node
            }
            cur = cur.getNext();
        }
        // if we make it to here, that means we didn't find the data!
        return null;
    }
    
    // remove doomed node from the list
    // assumptions - doomed node is actually in the list AND its links are valid
    public void remove(DNode<T> d) {
        DNode<T> doomed = (DNode<T>)d;
        doomed.getPrev().setNext(doomed.getNext());
        doomed.getNext().setPrev(doomed.getPrev());
        doomed.setNext(null);
        doomed.setPrev(null);
        size--;
    }
    
    // returns a reference to the first node in the list
    public DNode<T> first() {
        if (isEmpty()) {
            return null;
        }
        return header.getNext();
    }
    
    // returns a reference to the last node in the list
    public DNode<T> last() {
        if (isEmpty()) {
            return null;
        }
        return trailer.getPrev();
    }
    
    // insertion sort algorithm (ascending order)
//    public static void insertionSort(String[] a) {
//        for (int i=1; i<a.length; i++) {
//            String cur = a[i]; // this is the value that we are trying to insert in the correct place
//            int j = i-1;    // this is immediately left of the value we are trying to insert
//            while(j>=0 && a[j].compareTo(cur)>0) {  // keep going to the left if a[j] is bigger than cur
//                a[j+1] = a[j--];   // move a[j] to the right because cur is smaller
//            }
//            a[j+1] = cur;
//        }
//    }
    public void sort() {
        if(size()<=1) {
            return; // refuse to sort a one item or empty list
        }
        // at least two items must be in the list if we make it to here
        DNode<T> i = header.getNext().getNext();
        for (; i!=trailer; i=i.getNext()) {
            T cur = i.element();
            DNode<T> j = i.getPrev();
            while(j!=header && ((Comparable)j.element()).compareTo(cur)>0) {
                remove(i);
                j = j.getPrev();
                i=insertAfter(j,cur);
            }
        }
    }

    public void replace(DNode<T> p, T e) {
        DNode<T> pos = (DNode<T>) p;
        pos.setElement(e);
    }

    @Override
    public Iterator<T> iterator() {
        return new DLinkedListIterator<>(this);
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action); //To change body of generated methods, choose Tools | Templates.
    }

}
