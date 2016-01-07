/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package rpg;

import me.grea.antoine.utils.Dice;

/**
 * Class representing a spell of healing
 *
 * @author Gaetan
 */
public class Heal implements Capacity
{
    private Character source;

    private static final int HEAL_VALUE = 10;

    private static final int HEAL_DURATION = 1;

    private static final Ability HEAL_ABILITY = Ability.DEXTERITY; // TODO : Change that with intellect

    /**
     * Effect of the attack
     *
     * @return
     */
    @Override
    public Effect getEffect()
    {
        int maxHealth = this.source.getMaxHealth();
        int health = this.source.getAbilityValue(Ability.HEALTH);
        int maxHealthGain = maxHealth - health; //the maximum health point a player can gain
        int healthGain = (Dice.roll(1,4)/4) * maxHealthGain;    //calculate health gain
        return new Effect(Ability.HEALTH, healthGain, 1);
    }

    @Override
    public double probaWin(Character source)
    {
        double maxHealth = source.getMaxHealth();
        double health = source.getAbilityValue(Ability.HEALTH);
        return (1-(health-maxHealth));
    }
}
