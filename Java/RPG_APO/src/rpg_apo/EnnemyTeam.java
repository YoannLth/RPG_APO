/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg_apo;

import java.util.ArrayList;

/**
 *
 * @author Yoann
 */
public class EnnemyTeam extends Team{
    private int difficuly;
    private ArrayList<Item> rewardItems;
    
    public EnnemyTeam(String n, ArrayList<Character> chars, int difficult, ArrayList<Item> rewardItms){
        super(n, chars);
        this.difficuly = difficult;
        this.rewardItems = rewardItms;
    }
    
    public void addMember(){
        
    }
    
    public int getTeamSize(){
        return 0;
        
    }
    
    public int moneyGivenWhenLoose(){
        return 0;
        
    }
}
