package rpg_apo;

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
        int maxAction = 1;

        displayRed("Selectionner une action pour : " + character.getName());
        displayRed("\t 1. Use a Capacity");
        displayRed("\t 2. Use an Item");
        
        int choice = ControlerUI.readInt("Please select an action : ", 1, maxAction);
        return choice;
    }
}
