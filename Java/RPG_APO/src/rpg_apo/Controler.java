package rpg_apo;

import java.util.ArrayList;
import java.util.Map;


public abstract class Controler {
    protected Character charac;
        
        public Controler(Character c){
            this.charac = c;
        }
        
        public abstract Action getAction();
        
	public Action act() {
		// TODO - implement Controler.act
		throw new UnsupportedOperationException() ;
	}

    Action getAction(ArrayList<Character> team2, ArrayList<Character> team1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}