package rpg_apo;

public class Armor extends Item {

	/**
	 * 
	 * @param name
	 * @param weight
	 * @param resistance
	 * @param manageability
	 */
    private int resistance;
        /*
	public Armor(int name, int weight, int resistance, int manageability) {
		// TODO - implement Armor.Armor
		throw new UnsupportedOperationException();
                
	}
        */
    
    public int getResistance(){
        return this.resistance;
    }
    
    
    public Armor(String name, int poid, int resistance, String itExplaination)
    {
        super(name, poid,new Effect(Characteristic.DEFENCE, resistance,10000), itExplaination);
    }

}