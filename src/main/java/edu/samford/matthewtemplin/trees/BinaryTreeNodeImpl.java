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
public class BinaryTreeNodeImpl<T> implements BinaryTreeNode<T> {
    
    protected BinaryTreeNode<T> parent;
    protected BinaryTreeNode<T> left;
    protected BinaryTreeNode<T> right;
    protected T data;
    
    public BinaryTreeNodeImpl(T data, BinaryTreeNode<T> parent, BinaryTreeNode<T> leftchild, BinaryTreeNode<T> rightchild) {
        this.data = data;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
    
    @Override
    public BinaryTreeNode<T> left() {
        return left;
    }

    @Override
    public BinaryTreeNode<T> right() {
        return right;
    }

    @Override
    public boolean hasLeft() {
        return left!=null;
    }

    @Override
    public boolean hasRight() {
        return right!=null;
    }

    @Override
    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    @Override
    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    @Override
    public T element() {
        return data;
    }

    @Override
    public TreeNode<T> parent() {
        return parent;
    }

    @Override
    public TreeNode<T>[] children() {
        if (hasLeft() && hasRight())
            return new TreeNode[] { left, right };
        if (hasLeft())
            return new TreeNode[] { left };
        if (hasRight())
            return new TreeNode[] { right };
        // no children, return empty array
        return new TreeNode[] {};
    }

    @Override
    public boolean isLeaf() {
        return !hasLeft() && !hasRight();
    }

}
