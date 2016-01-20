/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg_apo;

import java.util.ArrayList;
import static view.Console.*;

/**
 *
 * @author Yoann
 */
public class NewDay extends Event{
    private Character playableCharacter;
    
    private ArrayList<EnnemyTeam> ennemies;
    //private ArrayList<Item> itemsGame;
    private Team playerTeam;
    
    public NewDay(Character playCharacter, Team playTeam, ArrayList<EnnemyTeam> ennemis){
        this.playableCharacter = playCharacter;
        this.playerTeam = playTeam;
        this.ennemies = ennemis;
    }
    
    @Override
    public void display() {
        displayBlack("*Nouvelle journée dans la prison*");
        displayRed("Que voulez vous faire?");
        displayBlack("\t 1. Appeler des proches pour demander de l'argent");
        displayBlack("\t 2. Travailler pour gagner de l'argent");
        displayBlack("\t 3. Provoquer un gang pour esseyer de gagner de l'argent et des objets");
        
        int answer = ControlerUI.readInt("Choisissez une activité", 1, 3);
        
        switch(answer){
            case 1 :
                NewCall nc = new NewCall(playableCharacter);
                nc.display();
                break;
            case 2 :
                NewWork nw = new NewWork(playableCharacter);
                nw.display();
                break;
            case 3 :
                NewFight nf = new NewFight(playableCharacter, playerTeam, ennemies);
                nf.display();
                break;
        }  
        
        displayBlack("La journée se termine maintenant, vous regagnez votre cellule*");
    }
    
}
