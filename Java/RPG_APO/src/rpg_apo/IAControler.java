package rpg_apo;

import java.util.ArrayList;

public class IAControler extends Controler {
    
    public IAControler(Character c){
        super(c);
    }

    @Override
    public Action getAction(ArrayList<Character> team2, ArrayList<Character> team1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Action getItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Action getCapacity(int choosenInt, ArrayList<Character> adversaires, ArrayList<Character> partners) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}