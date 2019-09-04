
package edu.samford.matthewtemplin.survey;

/**
 * Represents a survey with Questions.
 * @author Matthew
 */
public class Survey {
  //Attributes:
  protected Question[] questions;
  protected int numQuestions; //size of our survey in terms of the number of questions.

//Default constructor
public Survey(){
    this(10); // defaults to an array with room for 10 questions
}  

public Survey(int size){
    this.numQuestions = 0;
  questions = new Question[size];
  
}

/**
 * Adds a new Question to our array of questions using the given prompt and
 * all the other defaults for a Question.
 * @param prompt 
 */

public void addQuestion(String prompt){
  // 1. Crate the question
  Question q = new Question (prompt);
  
// 2. Add the question to the "end" of our array 
questions[numQuestions++] = q;
}

/**
 * Asks all the questions in the survey and gets answers 
 * to each question and puts all the answers into a new 
 * SurveyResponse object.
 * @return the newly created survey response with all the answers.
 */
public SurveyResponse conduct(){
// 1. Create the new empty SurveyResponse
SurveyResponse response = new SurveyResponse(this.questions.length);
// 2. Repeat the following for all questions:
//  a. ask the question (both parts)
//  b. get the answers to both parts
//  c. add the answer to the Survey response

//3. Return the new-completed response
return response;
}
}
