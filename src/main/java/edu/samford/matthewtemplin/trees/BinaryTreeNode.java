/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.matthewtemplin.trees;

/**
 *
 * @author briantoone
 */
public interface BinaryTreeNode<T> extends TreeNode<T> {
    
    public BinaryTreeNode<T> left();                // returns reference to left child
    public BinaryTreeNode<T> right();               // returns reference to right child
    public boolean hasLeft();                       // returns true or false whether or not there is a left child
    public boolean hasRight();                      // returns true or false whether or not there is a right child
    public void setLeft(BinaryTreeNode<T> left);
    public void setRight(BinaryTreeNode<T> right);

}
