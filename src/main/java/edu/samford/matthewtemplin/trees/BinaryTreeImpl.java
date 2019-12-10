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
public class BinaryTreeImpl<T> implements BinaryTree<T> {

    protected BinaryTreeNode<T> root;
    protected int size;
    protected int height;
    
    public BinaryTreeImpl(T rootdata) {
        root = new BinaryTreeNodeImpl<>(rootdata,null,null,null);
        size = 1;
        height = 0;
    }
    
    public BinaryTreeImpl() {
        root = null;
        size = 0;
        height = 0;
    }
    
    @Override
    public BinaryTreeNode<T> left(BinaryTreeNode<T> node) {
        return node.left();
    }

    @Override
    public BinaryTreeNode<T> right(BinaryTreeNode<T> node) {
        return node.right();
    }

    @Override
    public TreeNode<T> root() {
        return root;
    }

    @Override
    public TreeNode<T> parent(TreeNode<T> node) {
        return node.parent();
    }

    @Override
    public TreeNode<T>[] children(TreeNode<T> node) {
        return node.children();
    }

    @Override
    public int depth(TreeNode<T> node) {
        if (node!=root) 
            return 1+depth(node.parent());
        else
            return 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int height() {
        return height;
    }

    // let's use DFS since it's easier to implement
    @Override
    public TreeNode<T> search(T searchdata) {
        if (isEmpty())
            return null;
        
        // not an empty tree, so we actually need to search it
        return searchHelperDFS(searchdata, root);
    }

    @Override
    public boolean ancestor(TreeNode<T> node, TreeNode<T> ancestornode) {
        if (node.parent()==ancestornode)
            return true;
        else if (node!=root)
            return ancestor(node.parent(), ancestornode);
        else
            // if we make it to here then the recursive branch above must have made it all the way up to the root without ever returning true
            return false;
    }

    @Override
    public boolean descendant(TreeNode<T> node, TreeNode<T> descendantnode) {
        if (node.isLeaf())
            return false;
        else {
            // recursive check all the children branches
            TreeNode<T> children[] = node.children();
            for (TreeNode<T> child : children) {
                if (child == descendantnode)
                    return true; // we found the descendant
                
                // no hit yet, let's check this child branch
                if (descendant(child, descendantnode))
                    return true; // we found th descendant somewhere in this child branch
            }
            // we didn't find it in any of the child branches, must not be a descendant!
            return false;
        }
    }

    private TreeNode<T> searchHelperDFS(T searchdata, BinaryTreeNode<T> node) {
        if (node.element().equals(searchdata))
            return node;
        else if (node.isLeaf())
            return null;
        else {
            // no need for a loop here, just check left child and then right child
            if (node.hasLeft()) {
                TreeNode<T> hit = searchHelperDFS(searchdata, node.left());
                if (hit!=null)
                    return hit;
            }
            
            // we didn't find a "hit" on the left branch, let's try the right branch now (if it exists)
            if (node.hasRight()) {
                TreeNode<T> hit = searchHelperDFS(searchdata, node.right());
                if (hit!=null)
                    return hit;
            }
            
            // wasn't found on either the left branch or right branch
            return null;
        }
    }
    
    // tree manipulation methods
    
    // sets the left child of parent ... replacing whatever child was there before ... need to recalculate size and height
    public void setLeft(BinaryTreeNode<T> parent, BinaryTreeNode<T> left) {
        boolean recalculate = parent.hasLeft();
        parent.setLeft(left);
        if (recalculate) {
            calculateSize();
            calculateHeight();
        }
    }

    // sets the right child of parent
    public void setRight(BinaryTreeNode<T> parent, BinaryTreeNode<T> right) {
        boolean recalculate = parent.hasRight();
        parent.setRight(right);
        if (recalculate) {
            calculateSize();
            calculateHeight();
        }
    }
    
    public BinaryTreeNode<T> setLeft(BinaryTreeNode<T> parent, T leftdata) {
        // no matter what, we are at least temporarily increasing size of tree
        // if parent already has children then we will be recalculating the size any way
        // so go ahead and increment the size
        size++;
        
        // height is a different story ... we only need to increment height if the parent was currently the longest path
        if (depth(parent)==height) {
            height++;
        }
        
        BinaryTreeNode<T> newleftchild = new BinaryTreeNodeImpl<>(leftdata, parent, null, null);
        setLeft(parent, newleftchild);
        return newleftchild;
    }

    public BinaryTreeNode<T> setRight(BinaryTreeNode<T> parent, T rightdata) {
        // no matter what, we are at least temporarily increasing size of tree
        // if parent already has children then we will be recalculating the size any way
        // so go ahead and increment the size
        size++;
        
        // height is a different story ... we only need to increment height if the parent was currently the longest path
        if (depth(parent)==height) {
            height++;
        }
        
        BinaryTreeNode<T> newrightchild = new BinaryTreeNodeImpl<>(rightdata, parent, null, null);
        setRight(parent, newrightchild);
        return newrightchild;
    }

    protected void calculateSize() {
        size = isEmpty() ? 0 : sizeHelper(root);
    }
    
    private int sizeHelper(BinaryTreeNode<T> node) {
        // base case
        if (node.isLeaf())
            return 1;
        else {
            // recursive steps
            // must have children, let's calculate size of left and right branches
            int leftsize = node.hasLeft() ? sizeHelper(node.left()) : 0;
            int rightsize = node.hasRight() ? sizeHelper(node.right()) : 0;
            return 1 + leftsize + rightsize;
        }
    }

    protected void calculateHeight() {
        height = isEmpty() ? 0 : heightHelper(root);
    }

    private int heightHelper(BinaryTreeNode<T> node) {
        if (node.isLeaf()) {
            return depth(node);
        } else {
            // let's see which side has higher height
            int leftheight = node.hasLeft() ? heightHelper(node.left()) : 0;
            int rightheight = node.hasRight() ? heightHelper(node.right()) : 0;
            return Math.max(leftheight, rightheight);
        }
    }
    
    @Override
    public String toString() {
        String treestr = "Binary Tree: " + size + "," + height + "\n";
        treestr += displayTree(root, 0);
        return treestr;
    }
    
    protected String displayTree(BinaryTreeNode<T> node, int indent) {
        // String spaces = " ".repeat(indent); // jdk 11+
        String spaces = new String(new char[indent]).replace("\0", " ");
        String treecontent = spaces + node.element().toString() + "\n";
        if (!node.isLeaf()) {
            treecontent += node.hasLeft() ? displayTree(node.left(), indent+2) : (spaces + "  null\n");
            treecontent += node.hasRight() ? displayTree(node.right(), indent+2) : (spaces + "  null\n");
        }
        return treecontent;
    }
    
}
