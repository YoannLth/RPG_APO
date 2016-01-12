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
    
    public int getDamage(){
        return this.damage;
    }
    public int getManageability(){
        return this.manageability;
    }
    
    public Weapon(String name, int poid, int damage, int m){
        super(name, poid,new Effect(Characteristic.STRENGTH, damage,10000));
        this.manageability=m;
    }
}