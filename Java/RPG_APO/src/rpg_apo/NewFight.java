/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg_apo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static rpg_apo.ControlerUI.readInt;
import static view.Console.*;

/**
 *
 * @author Matthieu
 */
public class NewFight extends Event{
    private Team team1;
    private Team team2;
    private ArrayList<Character> team1Characters;
    private ArrayList<Character> team2Characters;
    private ArrayList<Character> deadCharactersTeam1;
    private ArrayList<Character> deadCharactersTeam2;
    private ArrayList<EnnemyTeam> ennemies;
    
    public NewFight(Team t1, ArrayList<EnnemyTeam> ennemis){        
        this.ennemies = ennemis;
        this.team1 = t1;         
        this.team2 = this.getEnnemyTeam();
        this.team1Characters = team1.getTeam();
        this.team2Characters = team2.getTeam();
        
        deadCharactersTeam1 = new ArrayList<Character>();
        deadCharactersTeam2 = new ArrayList<Character>();
    }
    
    
    
    public void display(){
        displayBlue("Vous avez choisi de défier " + team2.getName() + ".");
        displayBlue("Le combat oppose votre equipe constitué de :");
        for(int i=0;i<team1Characters.size();i++){
            displayBlack("\t"+team1Characters.get(i).testGetInfos());
        }
        displayBlue("\nContre " + team2.getName() + " constitué de :");
        for(int i=0;i<team2Characters.size();i++){
            displayBlack("\t"+team2Characters.get(i).testGetInfos());
        }
        
        while(team1Characters.size() >= 1 && team2Characters.size() >= 1){
            
            Turn t = new Turn(team1Characters,team2Characters);
            t.launchTurnHumanVersusIA(); 
            
            TestIfPlayerIsAlive(team1Characters);
            TestIfPlayerIsAlive(team2Characters);
        }
        
        displayRed(TestWinnerTeam(team1Characters,team2Characters));
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
        
        displayGreen("" + team1Characters.size());
        displayGreen("" + team2Characters.size());
        displayGreen("deadCharactersTeam1 :" + deadCharactersTeam1.size());
        displayGreen("deadCharactersTeam2 :" + deadCharactersTeam2.size());
        
        return res;
    }
    
    public ArrayList<Character> getTeam(Character charac){
        if(this.team1Characters.contains(charac)){
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
            team1Characters.add(currentUser);
        }
        
        for(int i=0;i<deadCharactersTeam2.size();i++){
            Character currentUser = deadCharactersTeam2.get(i);
            team2Characters.add(currentUser);
        }
        
        deadCharactersTeam1.clear();
        deadCharactersTeam2.clear();
    }
    
    public Team getEnnemyTeam(){
        displayBlue("Quel Gang voulez vous affronter?");
        for(int i=0; i<ennemies.size(); i++){
            displayBlue("\t " + (i+1) + ". " + ennemies.get(i).getName() + "(Difficulté : " + ennemies.get(i).getDifficulty() + ")");
        }
        int rep = readInt("Choisissez une gang a affronter : ",1,ennemies.size());
        
        return ennemies.get((rep-1));    
    }
}
