/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.willharper.survey;

/**
 * Represents a survey of questions.
 * @author user
 */
public class Survey {
    //Attributes
    protected Question[] questions;
    protected int numQuestions; //size of our survey in terms of the number of questions
    
    //Default constructor
    public Survey() {
        this(10); //defaults to an array with room for 10 questions
    }
    
    public Survey(int size){
        this.numQuestions = 0;
        questions = new Question[size];
    }
 
    /**
     * Adds a new question to our array of questions using the given prompt and
     * all the other defaults for a question
     * @param prompt 
     */
    public void addQuestion(String prompt){
        //1. Create the question
        Question q = new Question(prompt);
        
        //2. Add the question to the "end"of our array
        questions[numQuestions++] = q;
    }
    
    /**
     * Asks all the questions in the survey and gets answers
     * to each question and puts all the answers into a new SurveyResponse object
     * @return 
     */
    public SurveyResponse conduct(){
        //1. Create the new empty SurveyResponse
        SurveyResponse response = new SurveyResponse(this.questions.length);
        //2. Repeat the following for all questions:
        //  a. Ask the question (both parts)
        //  b. Get the answers to both parts
        //  c. Add the answer to the survey response
        //3. Return the now-completed response
        return response;
    }
    
}
