/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package model;

import rpg.Ability;
import rpg.Character;
import rpg.Edible;
import rpg.Effect;

/**
 * Class representing the "class" of character Healer
 *
 * @author p1509413
 */
public class Healer extends Character
{

    public Healer()
    {
        super();
        this.setMaxHealth(MAX_HEALTH_HEALER);
        this.initInventoryHealer();
    }
    
    /**
     * Init the inventory of the healer
     */
    private void initInventoryHealer()
    {
        super.inventory.add(new Edible("MinorHealthPotion", 10, true, new Effect(Ability.HEALTH, 50, 1)));
        super.inventory.add(new Edible("MinorHealthPotion", 10, true, new Effect(Ability.HEALTH, 50, 1)));
        super.inventory.add(new Edible("MinorHealthPotion", 10, true, new Effect(Ability.HEALTH, 50, 1)));
        super.inventory.add(new Edible("MajorHealthPotion", 10, true, new Effect(Ability.HEALTH, 100, 1)));
        super.inventory.add(new Edible("MajorHealthPotion", 10, true, new Effect(Ability.HEALTH, 100, 1)));
        super.inventory.add(new Edible("MajorHealthPotion", 10, true, new Effect(Ability.HEALTH, 100, 1)));
    }
}
