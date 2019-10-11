/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.matthewtemplin.iterators;

/**
 *
 * @author Matthew
 */
public class ArrayIteratorDemo {
    public static void main(String[] args) {
//        int highs[] = new int[5];
int highs[] = new int[] {100, 95, 96, 97, 98};
        System.out.println(highs.length);
        for (int high : highs) {
            System.out.println(high);
             }
        System.out.println(highs[4]);
        System.out.println(highs[5]); // will throw IndexOutOfBoundsException.
    }
   
}
