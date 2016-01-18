/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package model;

import rpg.Ability;
import rpg.Armor;
import rpg.Character;
import rpg.Edible;
import rpg.Effect;
import rpg.Weapon;

/**
 * Class representing the "class" of character warrior
 *
 * @author p1509413
 */
public final class Athlete extends Character
{

    public Athlete()
    {
        super();
        this.setMaxHealth(MAX_HEALTH_ATHLETE);
        this.initInventory();
    }
    
    @Override
    protected void initInventory()
    {
        super.inventory.add(new Edible("MinorHealthPotion", 10, true, new Effect(Ability.HEALTH, 50, 1)));
        super.inventory.add(new Edible("MajorHealthPotion", 10, true, new Effect(Ability.HEALTH, 100, 1)));
        super.inventory.add(new Edible("MajorHealthPotion", 10, true, new Effect(Ability.HEALTH, 100, 1)));
        super.inventory.add(new Weapon("NotThatBadWeapon", 60, 90, 50));
        super.inventory.add(new Armor("PrettyCoolArmor", 20, 50));
    }
}
