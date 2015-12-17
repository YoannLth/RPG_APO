/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package rpg;

/**
 * Class representing an action of a character : use of an item or use of a
 * capacity
 *
 * @author Gaetan
 */
public class Action
{

    /**
     * Character launching the action
     */
    private Character source;

    /**
     * Character getting the effect of the action
     */
    private Character target;

    /**
     * Utilization of an item
     *
     * @param s : Character using the item
     * @param t : Character receiving the effect of the item
     * @param i : Edible item to use / consume
     */
    public Action(Character s, Character t, Edible i)
    {
        this.source = s;
        this.target = t;
        this.useItem(i);
    }

    /**
     * Utilization of a capacity
     *
     * @param s : Character using the capacity
     * @param t : Character receiving the capacity
     * @param c : Capacity to use
     */
    public Action(Character s, Character t, Capacity c)
    {
        this.source = s;
        this.target = t;
        this.useCapacity(c);

    }

    /**
     * Use of an item : apply effect on the characters
     *
     * @param i : Edible item used
     */
    private void useItem(Edible i)
    {
        this.target.applyEffect(i.getEffect());
        this.source.removeItem(i);
    }

    /**
     * Use of a capacity : apply effect on the characters
     *
     * @param c : Capacity used
     */
    private void useCapacity(Capacity c)
    {
    }

}
