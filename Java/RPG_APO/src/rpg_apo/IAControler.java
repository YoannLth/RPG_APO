package rpg_apo;

import java.util.ArrayList;
import static view.Console.displayBlack;
import static view.Console.displayRed;

public class IAControler extends Controler {
    
    public IAControler(Character c){
        super(c);
    }

    
    public Action getCapacity(int choosenInt, ArrayList<Character> adversaires, ArrayList<Character> partners)
    {
        Action a = null;
        Character target;
        
        switch (choosenInt)
        {
            case 1: // Attack
                int i = (int)(Math.random()*(adversaires.size()))+ 1;
                target = adversaires.get((i-1));
                Attack atk = new Attack(charac,target);
                a = new Action(charac, target, atk);
                break;
            case 2: // Defence
                Defence def = new Defence(charac);
                a = new Action(charac, charac, def);
                break;
            case 3: // Soin
                i = (int)(Math.random()*(partners.size()))+ 1;
                target = partners.get((i-1));
                Treatment trtmnt = new Treatment(charac, target);
                a = new Action(charac, target, trtmnt);
                break;
            default:
                displayBlack("OK");
                break;
        }
        
        return a;
    }
    
    public Action getAction(ArrayList<Character> adversaires, ArrayList<Character> partners)
    {
        Action choosenAction = null;
        // Notre inteligence ne réalise que des capacité pour le moment
        
        int choixCapacite = (int)(Math.random()*3)+1;
        choosenAction = getCapacity(choixCapacite,adversaires,partners);
        return choosenAction;
    }
    
    
    
    @Override
    public Action getItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    


}