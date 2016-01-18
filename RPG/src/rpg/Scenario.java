/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package rpg;

import java.util.ArrayList;

/**
 * Class scenario representing an event without a fight, i.e where the
 * characters can find items, etc ..
 *
 * @author Gaetan
 */
public class Scenario extends Event
{

    /**
     * Default constructor initializing the list of characters
     *
     * @param playerChacraters
     * @param aiChacraters
     */
    public Scenario(ArrayList<Character> playerChacraters, ArrayList<Character> aiChacraters)
    {
        super(playerChacraters, aiChacraters);
    }

    /**
     * Launch the scenario
     */
    @Override
    public void launch()
    {
        
    }

}
