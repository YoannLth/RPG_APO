package rpg_apo;

import java.util.Random;
import static rpg_apo.Characteristic.HEALTH;

public class ConsumableItem extends Item {
    	/**
	 * 
	 * @param name
	 * @param weight
	 * @param damage
	 * @param treatment
	 * @param manageability
	 */
    /*
    un consommable ne dure qu'un seul tour
    il peut avoir plusieur effet (ajit sur differente characteristique
    avec differente intensité d'ou la puissance
    */
    public ConsumableItem(String name, int poid, Characteristic c, int puissance, String itExplaination, int quantity){
        super(name,  poid,new Effect(c, puissance,1), itExplaination);
    }
    
    public String getDisplayMessage(){
        String res = " utilise " + super.getName() + "ce qui " + super.getEffect().effectString();
        return res;
    }
    
}