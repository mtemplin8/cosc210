/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.matthewtemplin.stacksandqueues;

/**
 *
 * @author desip
 */
public class StackDemo {
    public static void main(String[] args) {
        Stack<String> urls = new ArrayStack<>();
        //urls is currently empty our browser is on the home page
        System.out.println("Stack Size: " + urls.size());
        //user navigates to samford.edu
        // we push homepage onto the stack
        urls.push("home page");
        //user navigates to bsc.edu
        //we push samford to the stack
        urls.push("www.samford.edu");
        System.out.println("Stack Size: "  + urls.size());
        
        String url = urls.pop();
        System.out.println(url);
        
        url = urls.pop();
        System.out.println(url);
        
        //This should through an error
        url = urls.pop();
    }
    
}
