package rpg_apo;

public class Armor extends Item {

    // Resistance of the armor (defence)
    private int resistance;
    
    // Constructor
    public Armor(String name, int poid, int resistance, String itemExplaination)
    {
        super(name, poid,new Effect(Characteristic.DEFENCE, resistance,10000), itemExplaination );
    }
    
    // Return the resitance of the armor
    public int getResistance(){
        return this.resistance;
    }
}