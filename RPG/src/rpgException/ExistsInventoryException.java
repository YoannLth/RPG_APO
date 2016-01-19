/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package rpgException;

import rpg.Item;

/**
 *Exception generated when Item in not found in inventory
 */
public class ExistsInventoryException extends Exception
{

    /**
     * Default constructor
     * Indicates that item in not in inventory
     */
    public ExistsInventoryException()
    {
        super("Item in not found in inventory");
    }
    
    /**
     * @param i item subjected to the verification
     * indicates item i is not in inventory
     */
    public ExistsInventoryException(Item i)
    {
        super("Item : " + i.getName() + " not found in inventory");
    }
}
