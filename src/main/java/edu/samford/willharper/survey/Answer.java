package edu.samford.willharper.survey;

import java.util.Scanner;

/**
 *Represents the answer to a survey question.
 * @author user
 */
public class Answer {
    //Attributes
    protected Question q;    //reference to the question being answered
    protected int scaleResponse; //user selected response... should be within q's range
    protected String additionalResponse; //user comments
    
    /**
     * Convenience Constructor that provides some meaningful defaults
     */
    public Answer(Question q) {
        this.q = q;
        this.scaleResponse = q.minscale;
        this.additionalResponse = "N/A";
    }
    
    public Answer(Question q, int scaleResponse, String additionalResponse){
        this.q = q;
        this.scaleResponse = scaleResponse;
        this.additionalResponse = additionalResponse;
    }
    
    /**
     * Retrieve the answer to the scale question from stdin (ie, the keyboard 
     * and store the answer in the scale response attribute
     * @param stdin 
     */
    public void getScaleResponse(Scanner stdin) { //stdin = standard input
        //1. Get the user response (for the scale prompt)
        //2. Check the response to make sure it is within the question's range
        //3. If not, display error message and go back to step 1
        do {
            scaleResponse = Integer.parseInt(stdin.nextLine());
            if (!q.checkResponse(scaleResponse)) { //right click the lightbulb on the side and create method
                System.out.println("Please try again. Outside valid range.");
            }
        } while (!q.checkResponse(scaleResponse));
    }
    
    /**
     * Stores the second response in the additionalResponse attribute. 
     * @param stdin 
     */
    public void getAdditionalResponse(Scanner stdin) {
        additionalResponse = stdin.nextLine();
    }
    
}
