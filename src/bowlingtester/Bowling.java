/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bowlingtester;

/**
 *
 * @author etwat3497
 */
public class Bowling {
    private String bowler;
    private int pinsDown;
    public int numOfPlayers;
    
    
    public Bowling(){
        bowler = "Unknown Bowler";
        numOfPlayers = 0;
    }
    
    public Bowling(String name){
        bowler = name;
        numOfPlayers++;
    }
}
