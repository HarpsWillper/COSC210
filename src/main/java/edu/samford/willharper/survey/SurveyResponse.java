/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.willharper.survey;

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
    
}
