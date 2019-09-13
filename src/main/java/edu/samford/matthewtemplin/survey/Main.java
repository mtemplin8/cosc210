
package edu.samford.matthewtemplin.survey;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;


/**
 *
 * @author Matthew
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to COSC 210!");
        
        //1. Create the survey
        Survey survey = new Survey(9);
        
        //2. add all the questions to the survey
        survey.addQuestion("How familiar are you with Netbeans?");
        survey.addQuestion("How well do you understand the differences between classes, objects, and types?");
        survey.addQuestion("How well do you understand creating and using methods?");
        survey.addQuestion("How well can you formulate mathematical or logical expressions (e.g., if statements)");
        survey.addQuestion("How familiar are you with control flow statements such as if, while, for, switch, etc...");
        survey.addQuestion("How familiar are you with arrays?");
        survey.addQuestion("How good are you at reading from/writing to files?");
        survey.addQuestion("How familiare are you with the concept of packages?");
        survey.addQuestion("How comfortable are you with designing, coding, testing, and debugging a complete program?");
        
        
        //3. Conduct the survey
        SurveyResponse response = survey.conduct();
        
        //4. Write the survey results out to a file.
        //First, setup the filename
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        String filename = date + time.toString().replace(':', '_') + ".txt";
        //now, save the file using that filename
        response.save(filename);
    }
  
}
