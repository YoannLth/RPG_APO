/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package rpg;

/**
 * Class representing a capacity of defense (parry)
 *
 * @author Gaetan
 */
public class Parry implements Capacity
{

    private static final int PARRY_DEFAULT_DEFENSE = 10;

    private static final int PARRY_DURATION = 1;

    private static final Ability PARRY_ABILITY = Ability.DEFENSE;

    /**
     * Effect of the attack
     *
     * @return
     */
    @Override
    public Effect getEffect()
    {
        return new Effect(PARRY_ABILITY, PARRY_DEFAULT_DEFENSE, PARRY_DURATION);
    }

    @Override
    public double probaWin(Character source )
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
