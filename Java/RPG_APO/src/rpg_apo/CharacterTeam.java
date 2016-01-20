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
public class CharacterTeam {
    private String name;
    private ArrayList<Character> characters;
    private ArrayList<Item> rewardItems;
    
    public CharacterTeam(String n, ArrayList<Character> chars, ArrayList<Item> rewardItms){
        this.name = n;
        this.characters = chars;
        this.rewardItems = rewardItms;
    }
    
    public void addMember(){
        
    }
    
    public int getTeamSize(){
        return 0;
        
    }
    
    public int getDifficulty(){
        return 0;
        
    }
}
