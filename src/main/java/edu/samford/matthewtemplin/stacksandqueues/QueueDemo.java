/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.matthewtemplin.stacksandqueues;

/**
 *
 * @author Matthew
 */
public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> helpQueue = new ListQueue<>();
        helpQueue.enqueue("lauren");
        helpQueue.enqueue("ty");
        System.out.println(helpQueue.dequeue());
        System.out.println(helpQueue.size());
        System.out.println(helpQueue.isEmpty());
        helpQueue.enqueue("will");
        System.out.println(helpQueue.dequeue());
        System.out.println(helpQueue.size());
        System.out.println(helpQueue.isEmpty());
        System.out.println(helpQueue.dequeue());
        // this next line should crash the program.
        System.out.println(helpQueue.dequeue());
    }
}
