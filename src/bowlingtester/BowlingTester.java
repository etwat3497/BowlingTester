/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bowlingtester;

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
        System.out.println("How many bowlers are there?");
        int bowlers = 0;
        Boolean run = true;
        String playerName = "";
        
        try{
            while(run){
                bowlers = sc.nextInt();

                if(bowlers<=0){
                    System.out.println("Please input a positive number of bowlers");
                }
                else{
                    run = false;
                }
            }
        }
        catch(NumberFormatException e){
            System.out.println("Please input a positive integer value");
        }
        
        for(int i=0; i<bowlers; i++){
            System.out.println("Please input the name of bowler "+(i+1));
            playerName = sc.nextLine();
            
            Bowling user1 = new Bowling(playerName);
            
        }
                
        
    }
    
}
