package rpg_apo;

public class Weapon extends Item {

	/**
	 * 
	 * @param name
	 * @param weight
	 * @param damage
	 * @param treatment
	 * @param manageability
	 */
    private int damage;
    private int manageability;
    
    public Weapon(String name, int poid, int damage, int m, String itExplaination){
        super(name, poid, new Effect(Characteristic.STRENGTH, damage,10000), itExplaination);
        this.manageability=m;
        this.damage = damage;
    }
    
    public int getDamage(){
        return this.damage;
    }
    public int getManageability(){
        return this.manageability; 
    }
    
}