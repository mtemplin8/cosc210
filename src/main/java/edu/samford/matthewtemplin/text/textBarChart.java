/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.matthewtemplin.text;

/**
 *
 * @author Matthew
 */
public class textBarChart {
   //Attributes
    protected String labels[];
    protected double values[];
    protected int numrows;
    
    
    //Constructor
    
    /**
     * Displays the chart using the populated labels and values.
     */
    public void display(){
        
    }
    
    /**
     * Add the label/value combo to our attributes.
     */
    
    public void addRow(String label, float value){
      labels[numrows] = label;
      values[numrows++] = value;
    }
}
