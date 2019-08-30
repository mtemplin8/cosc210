package edu.samford.matthewtemplin.survey;

/**
 * Represents a question in our survey. 
 * @author Matthew
 */
public class Question {
    // Attributes
   protected String prompt;   // the message displayed to the user when the question is asked.
   protected int minScale;    // the minimum response value (inclusive)
   protected int maxScale;    // the maximum response value (inclusive)
   protected String secondPrompt;   // the prompt in front of the "open ended" section of the question.
   
   // Constructors
   /**
    *  Initialize to some meaningful defaults.
    */
   public Question() {
      // This is the default constructor because it takes no parameters.
      prompt = "Please enter something.";
      minScale = 1;
      maxScale = 10;
      secondPrompt = "Additional comments:";
   }
   
   /**
    * Use the given prompt with all the other default attributes.
    */
   public Question(String prompt) {
       this();
       this.prompt = prompt;
   }
   
   /**
    * Constructs a question with these specific attributes.
    */
   public Question(String prompt, int minScale, int maxScale, String secondPrompt){
       this.prompt = prompt;
       this.minScale = minScale;
       this.maxScale = maxScale;
       this.secondPrompt = secondPrompt;
   }
   
   /**
    * Displays the prompt for the main question.
    */
   
   public void display() {
       System.out.println(prompt + "[" + minScale + "-" + maxScale + "]"); 
   }
   
   public void displaySecond(){
       System.out.println(secondPrompt);  
   }
   
}
