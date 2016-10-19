/*
 * Created by Ethan Watt
 * On October 19, 2016
 * Designed to make a bowling emulator
 */

package bowlingtester;

//Import classes
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author etwat3497
 */
public class BowlingTester {

    /**
     * pre: String array
     * post: void
     * Main method to have the the bowling tester communicate with the bowling class and emulate a 10 frame bowling game
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        
        //Declare array lists; objects arraylist creates unique object names
        ArrayList<Bowling> objects = new ArrayList();
        ArrayList<String> players = new ArrayList();
        ArrayList<Integer> playerScore = new ArrayList();
        
        //Declare and assign values to variables
        int bowlers = 0;
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
                
                
                //Check how many pins the player got down in their first shot for each object
                objects.get(j).firstThrow();
                //Check if the player got a strike and if not determine how many pins are hit down in their second shot for each object
                objects.get(j).secondThrow();
                //Calculate the score for each object after the frame is completed
                objects.get(j).calculatingScore();
            }
        }
        //Run calculate winner method in bowling class to determine which player wins
        objects.get(0).calculateWinner(bowlers, objects, players);
        
    }
    
}
