package rpg_apo;

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
    public ConsumableItem(String name, int poid, Characteristic c, int puissance){
        super(name, poid,new Effect(c, puissance,1));
    }
}