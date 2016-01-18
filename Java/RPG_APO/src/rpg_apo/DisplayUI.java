package rpg_apo;

import java.util.ArrayList;
import java.util.Map;
import static view.Console.displayRed;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yoann
 */
public class DisplayUI {
    public static int getAction(Character character)
    {
        int maxAction = 2;

        displayRed("Selectionner une action pour : " + character.getName());
        displayRed("\t 1. Utiliser une capacité");
        displayRed("\t 2. Utiliser un item");
        
        int choice = ControlerUI.readInt("Selectionner une action : ", 1, maxAction);
        return choice;
    }
    
    public static int getCapacity(Character character)
    {
        int maxCapacity = 3;

        displayRed("Selectionner une capacité :");
        displayRed("\t 1. Attaque");
        displayRed("\t 2. Défense");
        displayRed("\t 3. Soin");
        
        int choice = ControlerUI.readInt("Selectionner une action : ", 1, maxCapacity);
        return choice;
    }
    
    public static Character getOpponent(ArrayList<Character> opponents){
        int maxPlayer = opponents.size();
        
        displayRed("Selectionner une adversaire :");
        
        for(int i=0;i<opponents.size();i++){
            displayRed("\t " + (i+1) + "." + opponents.get(i).getNameAndInfos());
        }
        
        int choice = ControlerUI.readInt("Entrez un nombre entre 1 et " + maxPlayer, 1, maxPlayer);
        Character target = opponents.get((choice-1));
        return target;
    }
    
    public static Character getPartner(ArrayList<Character> partners){
        int maxPlayer = partners.size();
        
        displayRed("Selectionner une partenaire :");
        
        for(int i=0;i<partners.size();i++){
            displayRed("\t " + (i+1) + "." + partners.get(i).getName());
        }
        
        int choice = ControlerUI.readInt("Entrez un nombre entre 1 et " + maxPlayer, 1, maxPlayer);
        Character target = partners.get((choice-1));
        return target;
    }
    
}
