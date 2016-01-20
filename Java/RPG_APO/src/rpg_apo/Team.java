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
public class Team {
    private String name;
    private ArrayList<Character> characters;
    
    public Team(String n, ArrayList<Character> chars){
        this.name = n;
        this.characters = chars;
    }
    
    public Team(String n){
        this.name = n;
        this.characters = new ArrayList<Character>();
    }
    
    public void addMember(Character c){
        this.characters.add(c);
    }
    
    public int getTeamSize(){
        return 0;
        
    }
}
