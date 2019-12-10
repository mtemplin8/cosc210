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
public interface BinaryTree<T> extends Tree<T> {
    
    public BinaryTreeNode<T> left(BinaryTreeNode<T> node);
    public BinaryTreeNode<T> right(BinaryTreeNode<T> node);
    
}
