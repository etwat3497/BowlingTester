/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bowlingtester;

import java.util.ArrayList;

/**
 *
 * @author etwat3497
 */
public class Bowling {
    private String bowler;
    private int pinsDownFirstThrow, pinsDownSecondThrow, score;
    public int numOfPlayers;
    
    
    public Bowling(){
        bowler = "Unknown Bowler";
        numOfPlayers = 0;
    }
    
    public Bowling(String name){
        bowler = name;
        numOfPlayers++;
    }
    
    public void firstThrow(){
        //Generate a random number of pins down for each bowler between 0 and 10
        pinsDownFirstThrow = (int)(Math.random()*11);
        System.out.println("You hit down "+pinsDownFirstThrow+ " pin(s).");

    }
    
    public void secondThrow(){
 
        if(pinsDownFirstThrow ==10){ 
            //If the first throw was 10, do not find out second throw
        }
        
        else{
        //Generate a random number of pins down for each bowler between 0 and the number of pins remaining
        pinsDownSecondThrow = (int)(Math.random()*(11-pinsDownFirstThrow));
        System.out.println("You hit down "+pinsDownSecondThrow+" pin(s).");
        }
        
       
    }
    
    public void calculatingScore(){
        int total = pinsDownFirstThrow+pinsDownSecondThrow;
        
        if(pinsDownFirstThrow == 10){
            //Check if the player got a strike
            System.out.println("You got a strike! You recieve 20 points.");
            score += 20;
        }
        
        else if(total == 10 && pinsDownFirstThrow != 10){
            //If the player got 10 pins down after 2 shots and not a strike
            System.out.println("You got a spare! You recieve 15 points.");
            score += 15;
        }
        else{
            //Otherwise add however many pins the player got to their total score
            System.out.println("You hit down "+total+" pin(s).");
            score+= total;
        }
        
        //Output the score
        System.out.println("Your current score is "+score+".");
    }
    
    public int getScore(){
        return score;
    }
}
