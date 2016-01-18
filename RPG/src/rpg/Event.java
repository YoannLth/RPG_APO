/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package rpg;

import java.util.ArrayList;

/**
 *
 * @author seljo
 */
public abstract class Event
{

    protected ArrayList<Character> playerCharacters;
    protected ArrayList<Character> aiCharacters;

    /**
     * Constructor setting the list of characters
     *
     * @param playerChacraters List of player character
     * @param aiChacraters List of AI character
     */
    public Event(ArrayList<Character> playerChacraters, ArrayList<Character> aiChacraters)
    {
        this.playerCharacters = playerChacraters;
        this.aiCharacters = aiChacraters;
    }

    /**
     * Launch the event
     */
    public void launch()
    {
        System.out.println("New Event !");
    }

}
