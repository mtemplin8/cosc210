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
public class GenericTreeDemo {
    public static void main(String[] args) {
        GenericTree<String> airports = new GenericTree<>("BHM");
       TreeNode<String> atlnode = airports.addChild(airports.root(), "ATL");
        airports.addChild(airports.root(), "MSP");
        airports.addChild(atlnode, "BOS");
        airports.addChild(atlnode, "SFO");
        airports.addChild(atlnode, "MCO");
        System.out.println(airports);
        TreeNode<String> bosnode = airports.search("BOS");
        airports.addChild(bosnode, "xyz");
        System.out.println(airports);
    }
}
