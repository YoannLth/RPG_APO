/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg_apo;

import static java.lang.System.exit;
import java.util.ArrayList;
import view.Console;
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
        
       displayScript();
        
       displayBlack("*La nuit se termine maintenant, vous vous rendez dans la cours*");
       displayContinue();
    }
    
    public void displayScript(){
        displayRed("Que voulez vous faire?");
        displayBlack("\t 1. Gérer son inventaire");
        displayBlack("\t 2. Voir état du joueur");
        displayBlack("\t 3. S'échapper avec Jese et Hector");
        displayBlack("\t 4. Dormir");
        
        int answer = ControlerUI.readInt("Choisissez une activité :", 1, 4);
        
        switch(answer){
            case 1 :
                DisplayUI.getInventaryActionChoice(playableCharacter);
                Console.displayContinue();
                displayScript();
                break;
            case 2 :
                playableCharacter.getPlayerInfos();
                Console.displayContinue();
                displayScript();
                break;
            case 3 :
                checkEscapePossibility();
                Console.displayContinue();
                displayScript();
                break;
            case 4 :
                break;
        }          
    }
    
    public void checkEscapePossibility(){
        if(playableCharacter.getMoney() > 1000){
            Console.displayRed("Vous vous échappez avec Jese & Hector, merci d'avoir joué");
            exit(0);
        }
        else{
            displayRed("Pas assez d'argent pour le moment, réessayez plus tard!");
        }
    }
}
