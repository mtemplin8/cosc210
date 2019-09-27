/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.matthewtemplin.lists;

/**
 *
 * @author Matthew
 */
public class TestSLinkedList {
    public static void main(String[] args) {
        SlinkedList<String> list = new SlinkedList<>();
        SlinkedList<Integer> ratings = new SlinkedList<>();
        
        //test an empty list
        System.out.println("size==0       " + list.size());
        System.out.println("toString=='': " + list.toString()  );
        System.out.println("size==0       " + ratings.size()   );
        System.out.println("toString=='': " + ratings.toString()  );
        //test a one item list
        list.addFirst("BHM");
        ratings.addFirst(10);
        System.out.println("size==1              " + list.size());
        System.out.println("toString=='BHM':    " + list.toString()  );
        System.out.println("size==1              " + ratings.size());
        System.out.println("toString=='10':    " + ratings.toString()  );
        
        //test a two item list
        list.addLast("ATL");
        ratings.addLast(7);
        System.out.println("size==2:                 " + list.size());
        System.out.println("toString=='BHM, ATL':   " + list);
        System.out.println("size==2:                 " + ratings.size());
        System.out.println("toString=='10, 7':   " + ratings);
    }
  
}
