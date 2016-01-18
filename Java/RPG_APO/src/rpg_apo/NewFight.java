/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg_apo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static view.Console.displayBlue;
import static view.Console.displayRed;

/**
 *
 * @author Matthieu
 */
public class NewFight extends Event{
    private Map<Integer, Character> team1;
    private Map<Integer, Character> team2;
    
    public NewFight(Map<Integer, Character> t1, Map<Integer, Character> t2){
        team1 = new HashMap();
        team2 = new HashMap();
        
        this.team1 = t1;
        this.team2 = t2;
    }
    
    
    
    public void display(){
        displayRed("Bonjour et bienvenue dans la simulation de combats");
        displayBlue("Le combat oppose l'equipe 1 constitué de :");
        for(int i=1;i<=team1.size();i++){
            displayRed(team1.get(i).testGetInfos());
        }
        displayBlue("A l'équipe 2 constitué de :");
        for(int i=1;i<=team2.size();i++){
            displayRed(team2.get(i).testGetInfos());
        }
        
        Turn t = new Turn(team1,team2);
        t.launchTurnHumanVersusHuman();
    }
    
    public void TestIfPlayerIsAlive(Map<Integer, Character> t){
        for(int i=1;i<=t.size();i++){
            Character currentUser = t.get(i);
            if(currentUser.isAlive()){
                
            }
            else{
                t.remove(i);
                
            }
        }
    }
    
}
