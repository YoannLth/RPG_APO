/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package rpg;

/**
 * Class representing a spell of healing
 *
 * @author Gaetan
 */
public class Heal implements Capacity
{

    private static final int HEAL_VALUE = 10;

    private static final int HEAL_DURATION = 1;

    private static final Ability HEAL_ABILITY = Ability.DEXTERITY; // TODO : Change that with intellect

    /**
     * Effect of the attack
     *
     * @param source : Character launching the attack
     * @param target : Character suffering the attack
     * @return
     */
    @Override
    public Effect getEffect(Character source, Character target)
    {
        return new Effect(HEAL_ABILITY, HEAL_VALUE, HEAL_DURATION);
    }
}
