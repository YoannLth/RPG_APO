/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package rpgException;
import rpg.Character;

/**
 *  Exception generated when a player is not found
 */
public class CharatcerExistsException extends Exception
{
    /**
     * Default constructor
     * Indicates that item in not in inventory
     */
    public CharatcerExistsException()
    {
        super("The character is not found");
    }
    
    /**
     * @param c item subjected to the verification
     */
    public CharatcerExistsException(Character c)
    {
        super("Character : " + c.getName()  + " not found in inventory");
    }
}
