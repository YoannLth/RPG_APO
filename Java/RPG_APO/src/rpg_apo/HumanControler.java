package rpg_apo;

import java.util.Map;
import java.util.Scanner;
import static view.Console.*;

public class HumanControler extends Controler {
    
    public HumanControler(Character c){
        super(c);
    }
    
    public Action getAction(Map<Integer, rpg_apo.Character> adversaires, Map<Integer, rpg_apo.Character> partners)
    {
        int choice = DisplayUI.getAction(charac);
        Action choosenAction = null;

        switch (choice)
        {
            case 1: // Capacity
                displayBlack(charac.getName() + " à choisi une capacité");
                int choixCapacite = DisplayUI.getCapacity(charac);
                choosenAction = getCapacity(choixCapacite,adversaires,partners);
                break;
            case 2: // Item 
                displayBlack(charac.getName() + " à choisi un item");
                break;
            default:
                displayBlack("OK");
                break;
        }
        
        return choosenAction;
    }
    
    public Action getCapacity(int choosenInt, Map<Integer, rpg_apo.Character> adversaires, Map<Integer, rpg_apo.Character> partners)
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
                Treatment trtmnt = new Treatment(target);
                a = new Action(charac, target, trtmnt);
                break;
            default:
                displayBlack("OK");
                break;
        }
        
        return a;
    }
    
    public Action getItem()
    {
        int choice = DisplayUI.getAction(charac);

        switch (choice)
        {
            case 1: // Capacity
                displayBlack(charac.getName() + " à choisi une capacité");
                int choixCapacite = DisplayUI.getCapacity(charac);
                break;
            case 2: // Item 
                displayBlack(charac.getName() + " à choisi un item");
                break;
            default:
                displayBlack("OK");
                break;
        }
        
        return null;
    }
    
    
    public Character getTarget()
    {
        Character target;
        
//        switch (choosenInt)
//        {
//            case 1: // Capacity
//                Attack atk = new Attack();
//                break;
//            case 2: // Item 
//                Defence def = new Defence();
//                break;
//            case 3: // Item 
//                Treatment trtmnt = new Treamtment();
//                break;
//            default:
//                displayBlack("OK");
//                break;
//        }
        
        return null;
    }    

    @Override
    public Action getAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}