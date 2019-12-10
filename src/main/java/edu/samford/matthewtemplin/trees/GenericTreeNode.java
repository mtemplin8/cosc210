/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.matthewtemplin.trees;

/**
 *
 * @author Matthew
 */
public class GenericTreeNode<T> implements TreeNode<T> {
    
    protected T data;                   // This node's data
    protected TreeNode<T> parent;       // this node's parent
    protected TreeNode<T> children[];   // this node's children
    
    public GenericTreeNode(T thedata){
        this.data = thedata;
        this.parent = null;
        this.children = null;
    }
    
    public GenericTreeNode(T thedata, TreeNode<T> theparent, TreeNode<T> thechildren[]){
        this.data = thedata;
        this.parent = theparent;
        this.children = thechildren;
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
        return children;
    }

    @Override
    public boolean isLeaf() {
        return children==null;
    }
    
    public void addChild(TreeNode<T> child){
        if (children==null){
            children = new GenericTreeNode[1];
        }else{
            children = java.util.Arrays.copyOf(children, children.length+1);
        }
        children[children.length-1] = child;
    }
    
}
