/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.willharper.survey;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author user
 */
public class SurveyResponse {

        protected Answer[] answers;
        protected int numanswers;
    
        public SurveyResponse(int size) {
        //Attributes
            this.numanswers = 0;
            this.answers = new Answer[size];
    }

        /**
         * Record the answer into our answers array.
         * @param answer 
         */
    public void addAnswer(Answer answer) {
        answers[numanswers++] = answer;
    }

    /**
     * Writes the survey response answers out to a file in this format:
     * 7|I know this topic pretty well
     * 10|I have written a bunch of programs that do file I/O
     * @param filename
     * @throws FileNotFoundException 
     */
    public void save(String filename) throws FileNotFoundException {
        File f = new File(filename);
        PrintWriter out = new PrintWriter(f);
        for (int i = 0; i < numanswers; i++) {
            Answer answer = answers[i];
            out.println(answer.scaleResponse + "|" + answer.additionalResponse);
        }
        out.close();
    }
    
}
