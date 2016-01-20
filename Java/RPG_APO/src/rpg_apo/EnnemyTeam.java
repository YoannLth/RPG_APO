/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg_apo;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Yoann
 */
public class EnnemyTeam extends Team{
    private int difficulty;
    private ArrayList<Item> rewardItems;
    
    public EnnemyTeam(String n, ArrayList<Character> chars, int difficult, ArrayList<Item> rewardItms){
        super(n, chars);
        this.difficulty = difficult;
        this.rewardItems = rewardItms;
    }

    public int getDifficulty(){
        return this.difficulty;
    }
    
    public int moneyGivenWhenLoose(){
        int givenMoney = (difficulty*10) * super.getTeamSize();
        return givenMoney;
    }
    
    public Item giveRandomItem(){
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(rewardItems.size());
        
        Item randomItem = rewardItems.get(index);
        return randomItem;
    }
}
