/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.willharper.text;

/**
 *
 * @author user
 */
public class textBarChart {
    //Attributes
    protected String[] labels; //you can put [] either after the String OR after the name of the array
    protected double values[];
    protected int numrows;
    //Constructor
    
    /**
     * Displays the chart using the populated labels and 
     */ 
    public void display(){
        
    }
    
    /**
     * Add the label/value combo to our attributes
     */
    public void addRow(String label, float value){
        labels[numrows] = label;
        values[numrows++] = value; //if it was ++numrows then it would've added 1 before the array, but this way it adds 1 after the array input
    }
    
}