/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.matthewtemplin.trees;

import java.util.ArrayList;

/**
 *
 * @author briantoone
 */
public class BST<T extends Comparable> extends BinaryTreeImpl<T> {
    
    public BST(T rootdata) {
        super(rootdata);
    }
    
    public BST() {
        super();
    }

    // now let's add the appropriate tree manipulation method, which is simply "add"
    public BinaryTreeNode<T> add(T nodedata) {
        // if for some reason we started with an empty tree, let's go ahead and create the root node
        if (isEmpty()) {
            root = new BinaryTreeNodeImpl<>(nodedata, null, null, null);
            size = 1;
            height = 0;
            return root; // nothing else to do
        } 
        
        // go ahead and handle the normal case here
        // first let's find the spot where the data goes
        BinaryTreeNode<T> parent = findParent(root, nodedata);
        
        // now let's determine (again) whether this should be to the left or right of parent
        if (nodedata.compareTo(parent.element())<=0)
            return super.setLeft(parent, nodedata);
        else 
            return super.setRight(parent, nodedata);
    }

    protected BinaryTreeNode<T> findParent(BinaryTreeNode<T> node, T nodedata) {
        if (node.isLeaf())
            return node;
        
        // not a leaf, let's decide which side to recurse on!
        if (nodedata.compareTo(node.element())<=0) {
            if (!node.hasLeft())
                return node;  // yay! we found where this one goes!
            
            // we didn't find it so we need to keep searching down the left branch
            return findParent(node.left(), nodedata);
        } else {
            if (!node.hasRight())
                return node;  // yay! we found where this one goes!
            
            // we didn't find it so we need to keep searching down the left branch
            return findParent(node.right(), nodedata);
        }
    }
    
    
    @Override
    public BinaryTreeNode<T> search(T searchdata) {
        if (isEmpty()) // handle special case of empty tree
            return null;
        
        return searchHelperBST(root, searchdata);
    }

    protected BinaryTreeNode<T> searchHelperBST(BinaryTreeNode<T> node, T searchdata) {
        int comparison = searchdata.compareTo(node.element());
        if (comparison == 0) {
            // yay! we found it!!!
            return node;
        } else if (comparison < 0) {
            // search down the left branch or return null if there is no left branch
            return node.hasLeft() ? searchHelperBST(node.left(), searchdata) : null; 
        } else {
            // search down the right branch or return null if there is no right branch
            return node.hasRight() ? searchHelperBST(node.right(), searchdata) : null; 
        }
    }
    
    // make this public to allow end-user to decide when to rebalance the tree
    public void rebalance() {
        // REFUSE to do anything on an empty arra
        if (isEmpty())
            return;
        
        // first get a flat array of all the node data
        ArrayList<T> alldata = new ArrayList<>();
        
        // use helper function to add the root node and all its children to the flat array
        rebalanceHelper(alldata, root);
        
        // now that alldata should have all the data from the entire tree
        // we can use the following algorithm to construct a balanced tree
        // first SORT the array
        java.util.Collections.sort(alldata);

        // now let's wipe out everything in this tree and start from scratch adding the "middle" item in the array as the root
        size = 0;
        height = 0;
        root = addHelper(alldata, 0, alldata.size()-1);
    }

    // performs in-order traversal ... so technically alldata should be sorted by the time this finishes but we will call sort again for good measure
    private void rebalanceHelper(ArrayList<T> alldata, BinaryTreeNode<T> node) {
        // recursively add the left branch first
        if (node.hasLeft())
            rebalanceHelper(alldata, node.left());

        // now add the node to the list
        alldata.add(node.element());
        
        // finally, recursively add the right branch last
        if (node.hasRight())
            rebalanceHelper(alldata, node.right());
    }

    private BinaryTreeNode<T> addHelper(ArrayList<T> alldata, int start, int end) {
        if (start>end)
            return null; // base case
        
        int mid = (start+end)/2;
        BinaryTreeNode<T> newnode = add(alldata.get(mid));
        setLeft(newnode, addHelper(alldata, start, mid-1));
        setRight(newnode, addHelper(alldata, mid+1, end));
        return newnode;
    }

}
