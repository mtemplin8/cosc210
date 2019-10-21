/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.matthewtemplin.stacksandqueues;

/**
 *
 * @author desip
 */
public class ArrayStack <T> implements Stack<T>{
protected T[] theStack;
protected int numitems; 

public ArrayStack (){
    this (1000);
}

public ArrayStack (int capacity){
    theStack = (T[]) new Object [capacity];
    numitems = 0;
}
    
    @Override
    public void push(T data) {
        theStack[numitems++] = data;
    }

    @Override
    public T pop() {
        if (isEmpty()){
            throw new Error ("You can't call pop on an empty stack");
        }
        return theStack [--numitems];
    }

    @Override
    public T top() {
        if (isEmpty()){
            throw new Error ("You can't call top on an empty stack");
        }
        return theStack [numitems-1];
    }

    @Override
    public int size() {
        return numitems;
    }

    @Override
    public boolean isEmpty() {
        return numitems == 0;
    }
    
}
