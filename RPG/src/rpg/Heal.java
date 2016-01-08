/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package rpg;

import me.grea.antoine.utils.Dice;
import me.grea.antoine.utils.Log;

/**
 * Class representing a spell of healing
 *
 * @author Gaetan
 */
public class Heal implements Capacity
{
    private Character source;


    public Heal(Character source)
    {
        this.source = source;
    }
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
        double diceResult = ((double)Dice.roll(1,4)/4);
        int healthGain = (int) (diceResult * maxHealthGain);    //calculate health gain
        return new Effect(Ability.HEALTH, healthGain, 1);
    }

    @Override
    public double probaWin(Character source)
    {
        double maxHealth = (double)source.getMaxHealth();
        double health = (double)source.getAbilityValue(Ability.HEALTH);
        return (1-(health-maxHealth));
    }
}
