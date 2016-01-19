package rpg_apo;

import java.util.ArrayList;
import java.util.Map;


public abstract class Controler {
    protected Character charac;
        
        public Controler(Character c){
            this.charac = c;
        }
        
        
	public Action act() {
		// TODO - implement Controler.act
		throw new UnsupportedOperationException() ;
	}

        public abstract Action getAction(ArrayList<Character> team2, ArrayList<Character> team1);
        
}