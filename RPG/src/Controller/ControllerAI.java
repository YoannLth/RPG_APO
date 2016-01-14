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
    
    /**
     * Indicates that an aiCharacter needs a heal
     */
    private boolean healNeeded = false;

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
     * @return the action of the AI
     */
    public Action getAction()
    {
        Character target = this.choseTarget();        
        
        return new Action(character, character, new Attack(character, character));
    }

    /**
     * 
     * @return 
     */
    private Character choseTarget()
    {
        if (healNeeded)
        {
            return getCharacterWithLowerHealth(aiCharacters);
        }
        else
        {
            return getCharacterWithLowerHealth(playerCharacters);
        }
    }

    /**
     * 
     * 
     * @param listCharacters
     * @return the character with the lower health from the list given
     */
    private Character getCharacterWithLowerHealth(ArrayList<Character> listCharacters)
    {
        Character characterWithLowerHealth = listCharacters.get(0); // Init to the first
        for(Character c : listCharacters)
        {
            if (characterWithLowerHealth.getCurrentHealth() <= c.getCurrentHealth())
                characterWithLowerHealth = c;
        }
        return characterWithLowerHealth;
    }

}
