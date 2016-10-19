/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bowlingtester;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author etwat3497
 */
public class BowlingTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        //Declare variables
        ArrayList<Bowling> objects = new ArrayList<Bowling>();
        ArrayList<String> players = new ArrayList();
        ArrayList<Integer> playerScore = new ArrayList();
        
        int bowlers = 0, pinsFirst = 0, pinsSecond = 0;
        
        Boolean frameLoop = true;
        String playerName = "";
        
        Boolean run = true;
        while(run){
            try{
                System.out.println("How many bowlers are there?");
                bowlers = Integer.parseInt(sc.nextLine());

                if(bowlers<=0){
                    //Catch bad user input
                    System.out.println("Please input a positive number of bowlers");
                }
                else{
                    //End the while loop and continue with the program
                    run = false;
                }
            }
            catch(NumberFormatException e){
                //Catch bad user input
                System.out.println("\nPlease input a positive integer value");
            }
        }
        
        
        for(int i=0; i<bowlers; i++){
            System.out.println("Please input the name of bowler "+(i+1));
            playerName = sc.nextLine();
            //Each playername creates its own object in an arraylist and runs the bowling class
            objects.add(new Bowling(playerName));
            //Add the actual playername to a seperate arraylist to determine which player correlates to each object
            players.add(playerName);
            
        }
        
        int frames = 1;
        //Run while loop 10 times for each frame
        while(frames<=10){
            System.out.println("\n----------\n FRAME "+frames+" \n----------");
            frames++; //Increase frames counter to end while loop after 10 frames
            
            //Run for however many bowlers there are
            for(int j=0; j<bowlers; j++){
                
                System.out.println("\n"+players.get(j)+"\n----------");
                //Check how many pins the player got down in their first shot for each object
                objects.get(j).firstThrow();
                //Check if the player got a strike and if not determine how many pins are hit down in their second shot for each object
                objects.get(j).secondThrow();
                //Calculate the score for each object after the frame is completed
                objects.get(j).calculatingScore();
                
                
                
                
                
            }
            
        }
        
        //Determine the winner of the bowling game
        System.out.println("\nFINAL SCORES\n------------");
        for(int m=0; m<bowlers; m++){
            //Add the final score of each player into an arraylist where the index of the score corresponds to each player
            playerScore.add(objects.get(m).getScore());
            //Display the final score
            System.out.println(players.get(m)+ " had a final score of "+playerScore.get(m)+".");
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
        System.out.println("\n\nThe winner is "+players.get(maxPosition)+" with a score of "+playerScore.get(maxPosition));    
        
    }
    
}
