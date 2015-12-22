/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package rpg;

import me.grea.antoine.utils.Log;
import rpgException.ExistsInventoryException;

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
        try {
            this.target.checkInInventory(i);
            this.target.applyEffect(i.getEffect());
            this.source.removeItem(i);
        }catch(ExistsInventoryException e)
        {
            Log.e(e.getMessage());
        }
        
    }

    /**
     * Use of a capacity : apply effect on the characters
     *
     * @param c : Capacity used
     */
    private void useCapacity(Capacity c)
    {
        this.target.applyEffect(c.getEffect());
    }

}
