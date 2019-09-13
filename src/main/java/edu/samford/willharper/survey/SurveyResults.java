/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.willharper.survey;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class SurveyResults {
//Attributes
    protected Survey survey;
    protected SurveyResponse responses[];
    protected int numResponses;
    public static int MAXFILES = 100; //assuming that we will never have more than 100 responses
    
    SurveyResults(Survey survey) {
        this.survey = survey;
        this.numResponses = 0;
        this.responses = new SurveyResponse[MAXFILES];
    }
    
    /**
     * Read all the responses from text files in the given directory
     * @path The relative path where all the responses are stored
     */
    public void readResponses(String path) throws FileNotFoundException{
        File dir = new File(path);
        File files[] = dir.listFiles();
        for (File file : files) {
            if (file.isFile()){
                Scanner filein = new Scanner(file);
                SurveyResponse response = new SurveyResponse(survey.numQuestions);
                int qi = 0; //current question number (index)
                while(filein.hasNextLine()){
                    String line = filein.nextLine();
                    String parts[] = line.split("\\|"); //the character | has additional functions so you must do \\ for it to work
                    if(parts.length!=2){
                        continue;
                    }
                    int scaleResponse = Integer.parseInt(parts[0]);
                    Answer answer = new Answer(survey.questions[qi], scaleResponse, parts[1]);
                    qi++; //advance to the next question
                    response.addAnswer(answer);
                }
                    responses[numResponses++] = response;
            }
        }
    }
    
    /**
     * Process all the responses by calculating the averages and joining all the freeform responses by pipes
     */
    public void processResponses(){
        //Data we need for the calculations
        double totals[] = new double[survey.numQuestions];
        double averages[] = new double[survey.numQuestions];
        String comments[] = new String[survey.numQuestions];
        
        for(SurveyResponse response: responses){
            if(response!=null)
            for(int qi=0; qi<response.numanswers; qi++){
                totals[qi] += response.answers[qi].scaleResponse;
                comments[qi] += "|" + response.answers[qi].additionalResponse;
            }
        }
     
        //Calculate the averages by dividing all the totals by the number of 
        for(int ti=0; ti<totals.length; ti++){
            totals[ti] = totals[ti]/numResponses;
        }
     
        for(int qi=0; qi<survey.numQuestions; qi++){
            Question q = survey.questions[qi];
            System.out.println(q.prompt + " - " + totals[qi] + " - " + comments[qi]);
        }
        
    }
    
}
