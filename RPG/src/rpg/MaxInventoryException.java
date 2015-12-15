/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package rpg;

/**
 * Exception generated when then inventory is full
 * @author p1509413
 */
public class MaxInventoryException extends Exception
{    
    /**
     * Default constructor
     * Indicate that the maximum inventory espace has been reached
     */
    public MaxInventoryException()
    {
        super("Maximum inventory reached");
    }
    
    /**
     * Exception with item given : display the name of the item and its weight
     * @param i 
     */
    public MaxInventoryException(Item i)
    {
        super("Maximum inventory reached : " + i.getName() + "(" + i.getWeight() + ")");
    }
}
