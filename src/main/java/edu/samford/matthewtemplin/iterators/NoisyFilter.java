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
public class NoisyFilter {
    static DLinkedList<Integer> temps = new DLinkedList<>();
        
    
    public static void main(String[] args) {
        double noise = 0;
        double percentagechange = 0;
        
        while (percentagechange < 1){
    generateNoisyData(90, 110, noise);
    double avg1 = calculateAverage();
        System.out.println("average with noisy data: " + avg1);
    filterNoisyData(90, 110);
    double avg2 = calculateAverage();
     System.out.println("average without noisy data: " + avg2);
        
     
   //   calculate percentage of change if average increases or decreases from noisy data.
     if(avg2 > avg1){
     double difference = avg2 - avg1;
        percentagechange = (difference / avg1) * 100;
         System.out.println("Percentage of change is: " + percentagechange + "%");
     }else{
     double difference = avg1 - avg2;
        percentagechange = (difference / avg2) * 100;
        System.out.println("Percentage of change is: " + percentagechange + "%");

// 
        
        //increments the noise percentage variable by the given amount.
        noise = noise + 0.0001;
     }
     if(percentagechange > 1)
            System.out.println("the rate of noise required to affect the amount of change by 1% is: " + noise);
    }
    }
    /**
     * Generate data between low and high with 1-noiseprob probability. Otherwise generate something anomalous.
     * @param low
     * @param high 
     * @param noiseprob
     */

    private static void generateNoisyData(int low, int high, double noiseprob) {
        java.util.Random r = new java.util.Random();
        temps = new DLinkedList<>();
        for (int i = 0; i < 1000; i++) {
            if(Math.random()<noiseprob){
                //generate a noisy reading
                temps.insertLast(r.nextInt(50));
            }else{
                //generate typical Alabama summer reading
                temps.insertLast(low + r.nextInt(high-low));
            }
        }
    }

    private static double calculateAverage() {
        double total = 0;
        for (Integer temp : temps) {
            total += temp;
            
        }
        double average = total / temps.size();
        return average;
    }
    
    /**
     * Remove any data outside the expected range.
     */
    private static void filterNoisyData(int low, int high) {
        Iterator<Integer> it = temps.iterator();
        while(it.hasNext()){
         int temp = it.next();
         if(temp < low || temp > high){
             it.remove();
         }
    }
    }
}
