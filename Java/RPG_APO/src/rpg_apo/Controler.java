package rpg_apo;

import java.util.ArrayList;
import java.util.Map;


public abstract class Controler {
    protected Character charac;
        
        public Controler(Character c){
            this.charac = c;
        }
        
        public abstract Action getAction(ArrayList<Character> team2, ArrayList<Character> team1);
        
        public abstract Action getItem();
        
        public abstract Action getCapacity(int choosenInt, ArrayList<Character> adversaires, ArrayList<Character> partners);
        
        //public abstract Armor getArmor();
}