/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package rpg;

/**
 * Class representing a physical attack
 *
 * @author Gaetan
 */
public class Attack implements Capacity
{

    private static final int ATTACK_DEFAULT_DAMAGE = 10;

    private static final int ATTACK_DURATION = 1;

    private static final Ability ATTACK_ABILITY = Ability.STRENGTH;

    /**
     * Effect of the attack
     *
     * @return
     */
    @Override
    public Effect getEffect()
    {
        return new Effect(ATTACK_ABILITY, ATTACK_DEFAULT_DAMAGE, ATTACK_DURATION);
    }
}
