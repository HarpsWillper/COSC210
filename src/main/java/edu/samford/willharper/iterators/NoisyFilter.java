/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.willharper.iterators;

import edu.samford.willharper.lists.DLinkedList;
import java.util.Iterator;

/**
 *
 * @author user
 */
public class NoisyFilter {

    static DLinkedList<Integer> temps = new DLinkedList<>();

    public static void main(String[] args) {
        double rate = 0;
        double total = 0;
        while (total / 20 < 1) {
            total = 0;
            for (int i = 0; i < 20; i++) {
                generateNoisyData(90, 110, rate);
                double avg1 = calculateAverage();
                System.out.println("average with noisy data: " + avg1);
                filterNoisyData(90, 110);
                double avg2 = calculateAverage();
                System.out.println("average without noisy data: " + avg2);
                total += Math.abs(avg2 - avg1);
            }
            System.out.println("rate: " + rate + ", average difference: " + (total / 20));
            rate += 0.0001;
        }
    }

    /**
     * Generate data between low and high with one minus noiseprob probability.
     * Otherwise generate something anomalous
     *
     * @param low
     * @param high
     * @param noiseprob
     */
    private static void generateNoisyData(int low, int high, double noiseprob) {
        java.util.Random r = new java.util.Random();
        temps = new DLinkedList<>();
        for (int i = 0; i < 1000; i++) { //ctrl e deletes a line
            if (Math.random() < noiseprob) {
                //generate a noisy reading
                temps.insertLast(r.nextInt(50));
            } else {
                //generate typical Alabama summer reading
                temps.insertLast(low + r.nextInt(high - low));
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
     * Remove any data outside the expected range
     */
    private static void filterNoisyData(int low, int high) {
        Iterator<Integer> it = temps.iterator();
        while (it.hasNext()) {
            int temp = it.next();
            if (temp < low || temp > high) {
                it.remove();
            }
        }
    }
}

//alt + shift + f ORGANIZES YOUR CODE
