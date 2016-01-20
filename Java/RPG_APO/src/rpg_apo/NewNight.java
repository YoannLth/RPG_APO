/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg_apo;

import java.util.ArrayList;
import static view.Console.displayBlack;
import static view.Console.displayContinue;
import static view.Console.displayRed;

/**
 *
 * @author Yoann
 */
public class NewNight extends Event{
    private Character playableCharacter;
    
    public NewNight(Character playCharacter){
        this.playableCharacter = playCharacter;
    }
    
    @Override
    public void display() {
        displayBlack("*Nouvelle nuit dans votre cellule*");
        displayRed("Que voulez vous faire?");
        displayBlack("\t 1. Gérer son inventaire");
        displayBlack("\t 2. S'échapper avec Jese et Hector");
        
//        int answer = ControlerUI.readInt("Choisissez une activité", 1, 3);
//        
//        switch(answer){
//            case 1 :
//                NewCall nc = new NewCall(playableCharacter);
//                nc.display();
//                break;
//            case 2 :
//                NewWork nw = new NewWork(playableCharacter);
//                nw.display();
//                break;
//            case 3 :
//                NewFight nf = new NewFight(playableCharacter, playerTeam, ennemies);
//                nf.display();
//                break;
//        }  
//        
//        displayBlack("La journée se termine maintenant, vous regagnez votre cellule*");
        displayContinue();
    }
    
}
