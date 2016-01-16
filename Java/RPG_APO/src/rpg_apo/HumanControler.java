package rpg_apo;

import java.util.Map;
import java.util.Scanner;
import static view.Console.*;

public class HumanControler extends Controler {
    
    public HumanControler(Character c){
        super(c);
    }
    
    public Action getAction(Map<Integer, rpg_apo.Character> adversaires)
    {
        int choice = DisplayUI.getAction(charac);

        switch (choice)
        {
            case 1: // Capacity
                displayBlack(charac.getName() + " à choisi une capacité");
                int choixCapacite = DisplayUI.getCapacity(charac);
                //Action choosenAction = getCapacity(choixCapacite,adversaire);
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
    
    public Action getCapacity(int choosenInt, Map<Integer, rpg_apo.Character> adversaires)
    {
        Action a;
        //Character target = DisplayUI.
        
        switch (choosenInt)
        {
            case 1: // Capacity
               // Attack atk = new Attack();
                break;
            case 2: // Item 
               // Defence def = new Defence();
                break;
            case 3: // Item 
                //Treatment trtmnt = new Treamtment();
                break;
            default:
                displayBlack("OK");
                break;
        }
        
        return null;
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