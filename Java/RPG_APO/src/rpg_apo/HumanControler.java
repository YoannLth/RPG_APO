package rpg_apo;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import static view.Console.*;

public class HumanControler extends Controler {
    
    public HumanControler(Character c){
        super(c);
    }
    
    
    public Action getAction(ArrayList<Character> adversaires, ArrayList<Character> partners)
    {
        int choice = DisplayUI.getAction(charac);
        Action choosenAction = null;

        switch (choice) 
        {
            case 1: // Capacity
                int choixCapacite = DisplayUI.getCapacity(charac);
                choosenAction = getCapacity(choixCapacite,adversaires,partners);
                break;
            case 2: // Item 
                ConsumableItem choosenItem = DisplayUI.getConsomableItem(charac);
                if(choosenItem == null){
                    displayBlue("PAS D'ITEMS DISPONIBLE!!");
                    choixCapacite = DisplayUI.getCapacity(charac);
                    choosenAction = getCapacity(choixCapacite,adversaires,partners);
                }
                else{
                    choosenAction = new Action(charac, charac, choosenItem);
                }
                break;
            default:
                displayBlue("ERROR");
                break;
        }
        
        return choosenAction;
    }
    
    public Action getItem()
    {
        int choice = DisplayUI.getAction(charac);

        switch (choice)
        {
            case 1: // Capacity
                displayBlue(charac.getName() + " à choisi une capacité");
                int choixCapacite = DisplayUI.getCapacity(charac);
                break;
            case 2: // Item 
                displayBlue(charac.getName() + " à choisi un item");
                break;
            default:
                displayBlue("OK");
                break;
        }
        
        return null;
    }  
    
    public Action getCapacity(int choosenInt, ArrayList<Character> adversaires, ArrayList<Character> partners)
    {
        Action a = null;
        Character target;
        
        switch (choosenInt)
        {
            case 1: // Capacity
                target = DisplayUI.getOpponent(adversaires);
                Attack atk = new Attack(charac,target);
                a = new Action(charac, target, atk);
                break;
            case 2: // Item 
                Defence def = new Defence(charac);
                a = new Action(charac, charac, def);
                break;
            case 3: // Item 
                target = DisplayUI.getPartner(partners);
                Treatment trtmnt = new Treatment(charac, target);
                a = new Action(charac, target, trtmnt);
                break;
            default:
                displayBlack("OK");
                break;
        }
        
        return a;
    }
    
}