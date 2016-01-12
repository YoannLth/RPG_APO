<<<<<<< HEAD
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
	public Weapon(int name, int weight, int damage, int treatment, int manageability) {
		// TODO - implement Weapon.Weapon
		throw new UnsupportedOperationException();
	}

=======
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

>>>>>>> 9d67c8317edecf5580fa5d8354e419156e5cd81a
}