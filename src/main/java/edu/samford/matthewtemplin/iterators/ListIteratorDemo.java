/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.matthewtemplin.iterators;

import edu.samford.matthewtemplin.lists.DLinkedList;
import java.util.Iterator;

/**
 *
 * @author Matthew
 */
public class ListIteratorDemo {
    public static void main(String[] args) {
        DLinkedList<Integer> highs = new DLinkedList<>();
        highs.insertLast(100);
        highs.insertLast(99);
        highs.insertLast(102);
        highs.insertLast(95);
        highs.insertLast(97);
        Iterator<Integer> it = highs.iterator();
        int total = 0;
        while(it.hasNext()){
            Integer temp = it.next();
            total += temp;
        }
        double average = (double) total / highs.size();
        
        total = 0;
        for (Integer high : highs) {
          total += high;  
        }
        double average2 = total / highs.size(); // incorrect b/c withoug casting one side or the other to double, Java performs truncation division.
        
        
        System.out.println("Avg: " + average);
        System.out.println("Avg2: " + average2);
    }
 
}
