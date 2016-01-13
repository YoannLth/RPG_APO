/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package Controller;

import rpg.Action;
import rpg.Attack;
import rpg.Capacity;
import rpg.Character;

/**
 * Class managing the actions of the player
 *
 * @author Gaetan
 */
public class ControllerPlayer extends Controller
{

    public ControllerPlayer(Character c)
    {
        super(c);
    }
    
    public Action getAction(Character target)
    {
        int choice = DisplayUI.getAction(character);
        
        switch(choice)
        {
            case 1 : // Capacity
                return super.useCapacity(character, target, askCapacity(target));
            case 2 : // Item 
                // this.setIem(); break;
            default : 
                return super.useCapacity(character, target, askCapacity(target));
        }
    }

    /**
     * Ask the player for a capacity
     * @param target the target selected before
     * @return 
     */
    private Capacity askCapacity(Character target)
    {
        Capacity capacity;
        
        int choice = DisplayUI.getCapacityChoice();
        
        capacity = new Attack(character, target);
        return capacity;
    }
}
