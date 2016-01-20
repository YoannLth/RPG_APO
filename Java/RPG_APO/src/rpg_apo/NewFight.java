/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg_apo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import static rpg_apo.Characteristic.*;
import static rpg_apo.ControlerUI.readInt;
import static view.Console.*;

/**
 *
 * @author Matthieu
 */
public class NewFight extends Event{
    private Team team1;
    private EnnemyTeam team2;
    private ArrayList<Character> team1Characters;
    private ArrayList<Character> team2Characters;
    private ArrayList<Character> deadCharactersTeam1;
    private ArrayList<Character> deadCharactersTeam2;
    private ArrayList<EnnemyTeam> ennemies;
    private Map<Character, Map<Characteristic, Integer>> currentCharacteristics;
    private Character playableCharac;
    
    public NewFight(Character playableChar, Team t1, ArrayList<EnnemyTeam> ennemis){        
        this.ennemies = ennemis;
        this.team1 = t1;         
        this.team2 = this.getEnnemyTeam();
        this.team1Characters = team1.getTeam();
        this.team2Characters = team2.getTeam();
        this.playableCharac = playableChar;
        
        deadCharactersTeam1 = new ArrayList<Character>();
        deadCharactersTeam2 = new ArrayList<Character>();
        currentCharacteristics = new HashMap();
    }
    
    
    
    public void display(){
        setCharactersStartCharacteristics();
        
        displayBlue("Vous avez choisi de défier " + team2.getName() + ".");
        displayBlue("Le combat oppose votre equipe constitué de :");
        for(int i=0;i<team1Characters.size();i++){
            displayBlack("\t"+team1Characters.get(i).getNameAndInfos());
        }
        displayBlue("\nContre le " + team2.getName() + " constitué de :");
        for(int i=0;i<team2Characters.size();i++){
            displayBlack("\t"+team2Characters.get(i).getNameAndInfos());
        }
        
        
        
        while(team1Characters.size() >= 1 && team2Characters.size() >= 1){
            
            Turn t = new Turn(team1Characters,team2Characters);
            t.launchTurnHumanVersusIA(); 
            
            TestIfPlayerIsAlive(team1Characters);
            TestIfPlayerIsAlive(team2Characters);
        }
        
        postFightReward(team1Characters,team2Characters);
        fealTeams();
        refillCharactersStartCharacteristics();
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
    
    public void postFightReward(ArrayList<Character> t1, ArrayList<Character> t2){
        int t1Members;
        int t2Members;
        String res = "";
        
        t1Members = t1.size();
        t2Members = t2.size();
        
        if(t1Members > t2Members){
            displayBlue("Vous avez gagné le combat!");
            displayContinue();
            Item earnedItem = team2.giveRandomItem();
            int earnedMoney = team2.moneyGivenWhenLoose();
            playableCharac.addInventary(earnedItem, 1);
            playableCharac.addMoney(earnedMoney);
            displayBlue("Vous remportez un(e) " + earnedItem.getName() + "!");
            displayContinue();
            displayBlue("Vous gagnez " + earnedMoney + "$!");
            displayContinue();
            upLevels(t1);
        }
        else{
            displayBlue("Vous avez perdu!");
            displayContinue();
            int currentMoney = playableCharac.getMoney();
            int loosedMoney = (currentMoney*10)/100;
            loosedMoney = -loosedMoney;
            playableCharac.addMoney(loosedMoney);
            displayBlue("Vous perdez " + loosedMoney + "$!");
        }
    }
    
    public void upLevels(ArrayList<Character> c){
        for(int i=0;i<c.size();i++){
            c.get(i).upLvl();
            displayContinue();
        }
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
    
    public EnnemyTeam getEnnemyTeam(){
        displayBlue("Quel Gang voulez vous affronter?");
        for(int i=0; i<ennemies.size(); i++){
            displayBlue("\t " + (i+1) + ". " + ennemies.get(i).getName() + "(Difficulté : " + ennemies.get(i).getDifficulty() + ")");
        }
        int rep = readInt("Choisissez une gang a affronter : ",1,ennemies.size());
        
        return ennemies.get((rep-1));    
    }
    
    public void fillMaxHealthFighters(){
        for(int i=0;i<team1Characters.size();i++){
            team1Characters.get(i).setMaxHealth();
        }
        
        for(int i=0;i<team2Characters.size();i++){
            team2Characters.get(i).setMaxHealth();
        }
    }
    
    public void setCharactersStartCharacteristics(){
        fillMaxHealthFighters();
        
        for(int i=0;i<team1Characters.size();i++){
            int tempForce = team1Characters.get(i).getCharacteristicValue(STRENGTH);
            int tempDext = team1Characters.get(i).getCharacteristicValue(DEXTERITY);
            int tempSante = team1Characters.get(i).getMaxHealth();
            int tempDef = team1Characters.get(i).getCharacteristicValue(DEFENCE);
            Map<Characteristic, Integer> tempCharacs;
            tempCharacs = new HashMap();
            tempCharacs.put(STRENGTH, tempForce);
            tempCharacs.put(DEXTERITY, tempDext);
            tempCharacs.put(HEALTH, tempSante);
            tempCharacs.put(DEFENCE, tempDef);
            
            currentCharacteristics.putIfAbsent(team1Characters.get(i), tempCharacs);
        }
        
        for(int i=0;i<team2Characters.size();i++){
            int tempForce = team2Characters.get(i).getCharacteristicValue(STRENGTH);
            int tempDext = team2Characters.get(i).getCharacteristicValue(DEXTERITY);
            int tempSante = team2Characters.get(i).getMaxHealth();
            int tempDef = team2Characters.get(i).getCharacteristicValue(DEFENCE);
            Map<Characteristic, Integer> tempCharacs;
            tempCharacs = new HashMap();
            tempCharacs.put(STRENGTH, tempForce);
            tempCharacs.put(DEXTERITY, tempDext);
            tempCharacs.put(HEALTH, tempSante);
            tempCharacs.put(DEFENCE, tempDef);
            
            currentCharacteristics.putIfAbsent(team2Characters.get(i), tempCharacs);
        }
    }
    
    public void refillCharactersStartCharacteristics(){        
        for(int i=0;i<team1Characters.size();i++){
            team1Characters.get(i).setCharacteristics(currentCharacteristics.get(team1Characters.get(i)));
        }
        
        for(int i=0;i<team2Characters.size();i++){
            team2Characters.get(i).setCharacteristics(currentCharacteristics.get(team2Characters.get(i)));
        }
    }
}
