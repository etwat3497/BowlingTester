/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bowlingtester;

//Add imports
import java.util.ArrayList;

/**
 *
 * @author etwat3497
 */
public class Bowling {
    //Declare global variables
    private String bowler;
    private int pinsDownFirstThrow, pinsDownSecondThrow, score;

    
  /**
   * pre: none
   * post: none
   * Default constructor to assign base values to variables
   */
    public Bowling(){
        bowler = "Unknown Bowler";
    }
    
    
  /**
   * pre: bowler name
   * post: none
   * Constructor to look for bowler name and assign that string to the global variable
   */
    public Bowling(String name){
        bowler = name;
    }
    
    
  /**
   * pre: none
   * post: void
   * Method to calculate how many pins are hit down on the first throw
   */
    public void firstThrow(){
        
        System.out.println("\n"+bowler+"\n----------");
        
        //Generate a random number of pins down for each bowler between 0 and 10
        pinsDownFirstThrow = (int)(Math.random()*11);
        System.out.println(bowler+" hit down "+pinsDownFirstThrow+ " pin(s) on their first shot.");

    }
    
    
  /**
   * pre: none
   * post: void
   * Method to determine if a strike was thrown; If not, determine how many pins are hit down on second throw
   */
    public void secondThrow(){
 
        if(pinsDownFirstThrow ==10){ 
            //If the first throw was 10, do not find out second throw
        }
        
        else{
        //Generate a random number of pins down for each bowler between 0 and the number of pins remaining
        pinsDownSecondThrow = (int)(Math.random()*(11-pinsDownFirstThrow));
        System.out.println(bowler+" hit down "+pinsDownSecondThrow+" pin(s) on their second shot.");
        }
        
       
    }
    
    
  /**
   * pre: none
   * post: void
   * Method to calculate the objects score after each frame, depending on how many pins they hit down
   */
    public void calculatingScore(){
        //Set total to how many pins they hit down
        int total = pinsDownFirstThrow+pinsDownSecondThrow;
        
        if(pinsDownFirstThrow == 10){
            //Check if the player got a strike
            System.out.println(bowler+" got a strike! "+bowler+" recieves 20 points.");
            score += 20;
        }
        
        else if(total == 10 && pinsDownFirstThrow != 10){
            //If the player got 10 pins down after 2 shots and not a strike
            System.out.println(bowler+" got a spare! "+ bowler+" recieves 15 points.");
            score += 15;
        }
        else{
            //Otherwise add however many pins the player got to their total score
            System.out.println(bowler+" hit down a total of "+total+" pin(s).");
            score+= total;
        }
        
        //Output the score
        System.out.println(bowler+"'s current score is "+score+".");
    }
    
    
  /**
   * pre: none
   * post: score
   * Method to return each objects score after each frame
   */
    public int getScore(){
        return score;
    }
    
    
  /**
   * pre: number of players, objects arraylist, and player name arraylist
   * post: void
   * Method to calculate the winner of the bowling game and display the final scores
   */
    public void calculateWinner(int players, ArrayList<Bowling> objcts, ArrayList<String> playrNames){
        
        ArrayList<Integer> playerScore = new ArrayList();
        //Determine the winner of the bowling game
        
        System.out.println("\nFINAL SCORES\n------------");
        
        for(int m=0; m<players; m++){
            //Add the final score of each player into an arraylist where the index of the score corresponds to each player from the get score method in bowling class
            playerScore.add(objcts.get(m).getScore());
            //Display the final score
            System.out.println(playrNames.get(m)+ " had a final score of "+playerScore.get(m)+".");
        }
        
        //Find the max value in the player score array
        
        int max = playerScore.get(0);

        for (int i = 1; i < playerScore.size(); i++) {
            //Run the size of the array to check every index value
            if (playerScore.get(i) > max) {
                //Each time a higher value is found than the element in index 1, update the max value
                max = playerScore.get(i);
            }      
        }
        //Determine the index of the max value
        int maxPosition = playerScore.indexOf(max);
        //Output the winner of the bowling game
        System.out.println("\n\nThe winner is "+playrNames.get(maxPosition)+" with a score of "+playerScore.get(maxPosition));    
    }
    
}
