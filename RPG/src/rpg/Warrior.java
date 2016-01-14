/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package rpg;

/**
 * Class representing the "class" of character warrior
 * @author p1509413
 */
public class Warrior extends Character
{
   
    public Warrior()
    {
        super();
        this.setMaxHealth(MAX_HEALTH_WARRIOR);
        this.initInventoryWarrior();
    }
    
    /**
     * Init the inventory of the warrior
     */
    private void initInventoryWarrior()
    {
        super.inventory.add(new Edible("MinorHealthPotion", 10, true, new Effect(Ability.HEALTH, 50, 1)));
        super.inventory.add(new Edible("MinorHealthPotion", 10, true, new Effect(Ability.HEALTH, 50, 1)));
        super.inventory.add(new Edible("MinorHealthPotion", 10, true, new Effect(Ability.HEALTH, 50, 1)));
        super.inventory.add(new Edible("MajorHealthPotion", 10, true, new Effect(Ability.HEALTH, 100, 1)));
    }
}
