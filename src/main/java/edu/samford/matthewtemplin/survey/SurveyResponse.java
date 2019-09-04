
package edu.samford.matthewtemplin.survey;

/**
 *
 * @author Matthew
 */
public class SurveyResponse {
//Attributes
    protected Answer[] answers;
    protected int numAnswers;
    
    SurveyResponse(int size) {
        this.numAnswers = 0;
        this.answers = new Answer[size];
    }
    
}
