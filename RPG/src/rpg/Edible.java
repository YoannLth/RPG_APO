/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package rpg;

/**
 * Class representing an edible item (Consommable) Can represent a health potion
 * for instance
 *
 * @author Gaetan
 */
public class Edible extends Item
{

    /**
     * Number of turns for the effect of an edible Default = 1
     */
    private final int EDIBLE_DURATION = 1;

    /**
     * Constructor
     *
     * @param n : Name of the edible item
     * @param w : Weight of the edible item
     * @param using : using or not the edible
     * @param e : Effect of the edible item
     */
    public Edible(String n, int w, boolean using, Effect e)
    {
        super(n, w, using);
        this.effect = e;
        this.effect.setDuration(this.EDIBLE_DURATION);
    }

}
