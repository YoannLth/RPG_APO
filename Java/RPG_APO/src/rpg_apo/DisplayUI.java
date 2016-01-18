package rpg_apo;

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
        displayRed("\t 2. Esquive");
        displayRed("\t 3. Soin");
        
        int choice = ControlerUI.readInt("Selectionner une action : ", 1, maxCapacity);
        return choice;
    }
    
    public static Character getOpponent(Map<Integer, rpg_apo.Character> opponents){
        int maxPlayer = opponents.size();
        
        displayRed("Selectionner une adversaire :");
        
        for(int i=1;i<=opponents.size();i++){
            displayRed("\t " + i + "." + opponents.get(i).getNameAndInfos());
        }
        
        int choice = ControlerUI.readInt("Entrez un nombre entre 1 et " + maxPlayer, 1, maxPlayer);
        Character target = opponents.get(choice);
        return target;
    }
    
    public static Character getPartner(Map<Integer, rpg_apo.Character> partners){
        int maxPlayer = partners.size();
        
        displayRed("Selectionner une partenaire :");
        
        for(int i=1;i<=partners.size();i++){
            displayRed("\t " + i + "." + partners.get(i).getName());
        }
        
        int choice = ControlerUI.readInt("Entrez un nombre entre 1 et " + maxPlayer, 1, maxPlayer);
        Character target = partners.get(choice);
        return target;
    }
    
}
