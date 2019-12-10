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
public interface Tree<T> {
    public TreeNode<T> root();
    public TreeNode<T> parent(TreeNode<T> node);
    public TreeNode<T>[] children(TreeNode<T> node);
    public int depth(TreeNode<T> node);
    public int size(); 
    public boolean isEmpty();
    public int height();
    public TreeNode<T> search(T searchdata);
    /**
     * returns true if ancestornode is in fact an ancestor of node.
     * @param node
     * @param ancestornode
     * @return 
     */
    public boolean ancestor(TreeNode<T> node, TreeNode<T> ancestornode);
    
      /**
     * returns true if dscendantnode is in fact an descendant of node.
     * @param node
     * @param ancestornode
     * @return 
     */
    public boolean descendant(TreeNode<T> node, TreeNode<T> descendantnode);
}
