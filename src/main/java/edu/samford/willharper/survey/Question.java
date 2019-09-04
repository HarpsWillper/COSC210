/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.willharper.survey;

/**
 * Represents a question in our survey
 *
 * @author user
 */
public class Question {

    //Attributes
    protected String prompt;
    protected int minscale;
    protected int maxscale;
    protected String secondPrompt;

    //Constructors
    public Question() {
        prompt = "Please enter something:";
        minscale = 1;
        maxscale = 10;
        secondPrompt = "Additional comments";
    }

    //convenience constuctor- uses all defaults EXCEPT the actual project
    public Question(String prompt) {
        this(); //parenthesis means that you are calling a method, and in this case a constructor. It calls the default constructor. 
        this.prompt = prompt;
    }

    //fully specified constructor
    public Question(String prompt, int minscale, int maxscale, String secondPrompt) {
        this.prompt = prompt;
        this.minscale = minscale;
        this.maxscale = maxscale;
        this.secondPrompt = secondPrompt;
    }

    /**
     * Displays the question prompt and the scale hint.
     */
    public void display() {
        System.out.println(prompt + "[" + minscale + "-" + maxscale);
    }
    
    public void displaySecond() {
        System.out.println(secondPrompt);
    }
    //"alt shift f" will organize all the lines

    /**
     * Returns true if the given response is within the range.
     * @param scaleResponse -the user replied response
     * @return true if scaleResponse between min and max
     */
    public boolean checkResponse(int scaleResponse) {
        return scaleResponse>=minscale && scaleResponse<=maxscale;
    }
}//end of public class question
