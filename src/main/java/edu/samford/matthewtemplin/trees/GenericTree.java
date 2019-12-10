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
public class GenericTree<T> implements Tree<T> {
    
    protected TreeNode<T> root; // this tree's root node
    protected int size;         // how many nodes are in the tree.
    protected int height;       // keep track of the greatest depth leaf here so that we don't have to calculate it later.
    
    public GenericTree(){
        this.root = null;
        this.size = 0;
        this.height = 0;
    }
    
    public GenericTree(T rootdata){
        this.root = new GenericTreeNode(rootdata);
        this.size = 1;
        this.height = 0;
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

    // will not work if the tree has a lot of nodes
    @Override
    public int depth(TreeNode<T> node) {
        if (node == root)
            return 0;
        else
            return 1+depth(node.parent());
    }
    
    // example - iterative version of depth
    public int depthIterative(TreeNode<T> node){
        int count = 0;
        while (node!=root){
            count++;
            node=node.parent();
        }
        return count;
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
    
    public TreeNode<T> addChild(TreeNode<T> parent, T childdata){
        TreeNode<T> child = new GenericTreeNode<>(childdata, parent, null);
        ((GenericTreeNode<T>) parent).addChild(child);
        size++;
        if (height == depth(parent)){
            height++;
        }
        return child;
    }

    @Override
    public boolean ancestor(TreeNode<T> node, TreeNode<T> ancestornode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean descendant(TreeNode<T> node, TreeNode<T> descendantnode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString(){
        String treestr = "Generic tree: " + size + "," + height + "\n";
        treestr += displayTree(root, 0);
        return treestr;
    }
    
    protected String displayTree(TreeNode<T> node, int indent){
        //String spaces = " ".repeat(indent); // only works with JDK 11 +
        String spaces = new String(new char[indent]).replace("\0", " ");
        String treecontent = spaces + node.element().toString() + "\n";
        if(!node.isLeaf()){
        TreeNode<T> children[] = node.children();
        for (int i = 0; i < children.length; i++) {
            TreeNode<T> childNode = children[i];
            treecontent += displayTree(childNode, indent+2);
        }
        }
        return treecontent;
    }

    @Override
    public TreeNode<T> search(T searchdata) {
        if (isEmpty()){
            return null;
        }
        // if we make it here, tree was not empty
        //return searchHelper(searchdata, root);
        return searchHelperBFS(searchdata, root);
    }

    protected TreeNode<T> searchHelper(T searchdata, TreeNode<T> node) {
        if (node.element().equals(searchdata))
            return node; // we found it!!! return up the recursive call hierarchy
        
        if (node.isLeaf()){
            return null;
        }
        
        // we didn't find it let's check the children!
        TreeNode<T> children[] = node.children();
        
        for (int i = 0; i < children.length; i++) {
            TreeNode<T> child = children[i];
            TreeNode<T> hit = searchHelper(searchdata, child);
            if (hit!=null){
                return hit;
        }
        }
        return null;
    }
    
    protected TreeNode<T> searchHelperBFS(T searchdata, TreeNode<T> root){
          if (root.element().equals(searchdata))
            return root; // we found it!!! return up the recursive call hierarchy
        
        if (root.isLeaf()){
            return null;
    }
        
        return searchLevel(searchdata, root.children());
    }
    
    protected TreeNode<T> searchLevel(T searchdata, TreeNode<T> children[]){
        // step 0 - prepare the big merged cousins array
        java.util.ArrayList<TreeNode<T>> cousins = new java.util.ArrayList<>();
        
        // step 1 - search the list of children
        if (children == null){
            return null; // wee made it to the end and never found it.
        }
        
        for (int i = 0; i < children.length; i++) {
            TreeNode<T> child = children[i];
            if (child.element().equals(searchdata)){
                return child;
            }
            //add this child's children to the list of cousins.
            if (child.children()!=null){
                TreeNode<T> grandchildren[] = child.children();
                for (int j=0; j<grandchildren.length; j++){
                    cousins.add(grandchildren[j]);
                }
            }
        }
        // step 2 - recursively search the grandchildren
        TreeNode<T> cousinsarray[] = new TreeNode[cousins.size()];
        cousins.toArray(cousinsarray);
        return searchLevel(searchdata, cousinsarray);
    }
}
