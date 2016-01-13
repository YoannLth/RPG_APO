/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package rpg;

import Controller.ControllerUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author seljo
 */
public class Event
{
    private Stack<Character> playerChacraters;
    private Stack<Character> aiChacraters;

    //------------------------- Constructor ------------------------------
    /**
     * 
     * @param playerChacraters List of player character
     * @param aiChacraters  List of AI character
     */
    public Event(Stack<Character> playerChacraters, Stack<Character> aiChacraters)
    {
        this.playerChacraters = playerChacraters;
        this.aiChacraters = aiChacraters;
    }
    
    /**
     * Method use to generate the actions for a fight and play a round according to these actions
     */
    public void fight()
    {
        List<Action> actionPlayer = new ArrayList<>();
        
        for (Character c : this.playerChacraters)
        {
            ControllerUI cp = new ControllerUI();
            // actionPlayer.add(cp.getAction()); // TODO : update this
        }
        for (Character c : this.aiChacraters)
        {

        }
    }
    
}
