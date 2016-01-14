/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package Controller;

import java.util.ArrayList;
import rpg.Action;
import rpg.Attack;
import rpg.Character;

/**
 * Class managing the actions of the AI
 *
 * @author p1509413
 */
public class ControllerAI extends Controller
{

    /**
     * List of the player Characters - Needed to chose a target
     */
    ArrayList<Character> playerCharacters;

    /**
     * List of the ai Characters - Needed to chose a target (i.e : for a heal)
     */
    ArrayList<Character> aiCharacters;

    public ControllerAI(Character ai,
            ArrayList<Character> playerCharacters,
            ArrayList<Character> aiCharacters)
    {
        super(ai);
        this.playerCharacters = playerCharacters;
        this.aiCharacters = aiCharacters;
    }

    /**
     * Get the action of the AI
     * @return 
     */
    public Action getAction()
    {
        // TODO : Implement this AI
        return new Action(character, character, new Attack(character, character));
    }

}
