/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg_apo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static view.Console.*;

/**
 *
 * @author Matthieu
 */
public class NewFight extends Event{
    private ArrayList<Character> team1;
    private ArrayList<Character> team2;
    private ArrayList<Character> deadCharactersTeam1;
    private ArrayList<Character> deadCharactersTeam2;
    
    public NewFight(ArrayList t1, ArrayList t2){
        team1 = new ArrayList<Character>();
        team2 = new ArrayList<Character>();
        
        deadCharactersTeam1 = new ArrayList<Character>();
        deadCharactersTeam2 = new ArrayList<Character>();
        
        this.team1 = t1; 
        this.team2 = t2;
    }
    
    
    
    public void display(){
        displayRed("Bonjour et bienvenue dans la simulation de combats");
        displayBlue("Le combat oppose l'equipe 1 constitué de :");
        for(int i=0;i<team1.size();i++){
            displayRed(team1.get(i).testGetInfos());
        }
        displayBlue("A l'équipe 2 constitué de :");
        for(int i=0;i<team2.size();i++){
            displayRed(team2.get(i).testGetInfos());
        }
        
        while(team1.size() >= 1 && team2.size() >= 1){
            TestIfPlayerIsAlive(team1);
            TestIfPlayerIsAlive(team2);
            
            Turn t = new Turn(team1,team2);
            t.launchTurnHumanVersusHuman(); 
            
            TestIfPlayerIsAlive(team1);
            TestIfPlayerIsAlive(team2);
            //TestIfPlayerIsAlive(team1);
            //TestIfPlayerIsAlive(team2);
        }
        
        displayRed(TestWinnerTeam(team1,team2));
        fealTeams();
    }
    
    public void TestIfPlayerIsAlive(ArrayList<Character> t){
        for(int i=0;i<t.size();i++){
            Character currentUser = t.get(i);
            if(currentUser.isAlive() == false){
                addDeadCharacter(currentUser);
                t.remove(i);
                TestIfPlayerIsAlive(t);
            }
            else{
                
            }
        }
    }
    
    public String TestWinnerTeam(ArrayList<Character> t1, ArrayList<Character> t2){
        int t1Members;
        int t2Members;
        String res = "";
        
        t1Members = t1.size();
        t2Members = t2.size();
        
        if(t1Members > t2Members){
            res = "L'équipe 1 a gagné!";
        }
        else{
            res = "L'équipe 2 a gagné!";
        }
        
        displayGreen("" + team1.size());
        displayGreen("" + team2.size());
        displayGreen("deadCharactersTeam1 :" + deadCharactersTeam1.size());
        displayGreen("deadCharactersTeam2 :" + deadCharactersTeam2.size());
        
        return res;
    }
    
    public ArrayList<Character> getTeam(Character charac){
        if(this.team1.contains(charac)){
            return this.deadCharactersTeam1;
        }
        else{
            return this.deadCharactersTeam2;
        }
    }
    
    public void addDeadCharacter(Character characterToAdd){
        ArrayList<Character> destinationTeam = getTeam(characterToAdd);
        destinationTeam.add(characterToAdd);
    }
    
    public void fealTeams(){
        for(int i=0;i<deadCharactersTeam1.size();i++){
            Character currentUser = deadCharactersTeam1.get(i);
            team1.add(currentUser);
        }
        
        for(int i=0;i<deadCharactersTeam2.size();i++){
            Character currentUser = deadCharactersTeam2.get(i);
            team2.add(currentUser);
        }
        
        deadCharactersTeam1.clear();
        deadCharactersTeam2.clear();
    }
    
}
