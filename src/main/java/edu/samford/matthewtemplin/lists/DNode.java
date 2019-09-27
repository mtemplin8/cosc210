/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.matthewtemplin.lists;

/**
 *
 * @author 
 */
public class DNode<T> {
    
    private T data;       // the data being stored in this node
    private DNode<T> prev;   // link to the previous node in the list
    private DNode<T> next;   // link to the next node in the list
    
    public DNode() {
        data = null;
        prev = next = null;
    }
    
    public DNode(T data, DNode prev, DNode next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
    
    public DNode getPrev() {
        return prev;
    }
    public DNode getNext() {
        return next;
    }
    public void setPrev(DNode node) {
        prev = node;
    }
    public void setNext(DNode node) {
        next = node;
    }
    public T element() {
        return data;
    }
    public void setElement(T data) {
        this.data = data;
    }
    
}
