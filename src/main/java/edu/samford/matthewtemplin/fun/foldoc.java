/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.matthewtemplin.fun;

import edu.samford.matthewtemplin.lists.DLinkedList;
import edu.samford.matthewtemplin.trees.BST;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Matthew
 */
public class foldoc {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner filein = new Scanner(new File("Dictionary.txt"));
        String currentTerm = "";
        String currentDefinition = "";
        DLinkedList<FOLDOCTerm> list = new DLinkedList<>();
        BST<FOLDOCTerm> bst = new BST<>();
        while(filein.hasNextLine()){
            String nextLine = filein.nextLine();
            if (nextLine.trim().equals("")){
                // we must be still going with the current definition
                 currentDefinition += "\n";
            }else if (nextLine.charAt(0)=='\t'){
                // we must have a blank line ... let's add it to the definition.
                currentDefinition += nextLine.trim() + "\n";
            }else{
                //we must have encountered a new term.
                // so...
                // 1. Add the old term (if there was one) to our data structure(s)
                if (!currentTerm.equals("")){
                FOLDOCTerm newterm = new FOLDOCTerm(currentTerm.trim(), currentDefinition.trim());
                list.insertLast(newterm);
                bst.add(newterm);
                }
                
                // 2. Grab the new term.
                currentTerm = nextLine.trim();
                
                // 3. Reset the current definition
                currentDefinition = "";
            }
        }
        System.out.println("Linked list: " + list.size() + " terms.");
        System.out.println("Binary search tree: " + bst.size() + " terms.");
        
        Scanner stdin = new Scanner(System.in);
        bst.rebalance();
        while(true){
            System.out.println("What term would you like to find?");
            String searchstr = stdin.nextLine(); //retrieves the search term
            if(searchstr.equals("-exit-"))
                break; //exit out of the loop because the user must have entered -exit-
            
            // now perform the search on both data structures measuring how long it takes
            System.out.println("Searching for: " + searchstr); // temporary debugging display.
            
            FOLDOCTerm faketerm = new FOLDOCTerm(searchstr,""); // note the empty definition
            long start1 = System.nanoTime();
             Object listhit = list.search(faketerm);
            long finish1 = System.nanoTime();
            long duration1 = finish1-start1;
            
            long start2 = System.nanoTime();
             Object bsthit = bst.search(faketerm);
             long finish2 = System.nanoTime();
             long duration2 = finish2-start2;
             System.out.println(listhit + "," + bsthit);
             
             System.out.println(duration1 + "," + duration2);
        }
    }
}
