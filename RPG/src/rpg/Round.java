/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package rpg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import me.grea.antoine.utils.Log;
import rpgException.CharatcerExistsException;
import rpgException.ExistsInventoryException;
import rpgException.MaxInventoryException;

/**
 *
 * @author seljo
 */
public class Round
{
    private Stack<Action> playerActions; //List of actions for a player
    private Stack<Action> computerActions;   //List of actions for the AI
    private Stack<Action> finalActions;  //merged list of playerActions and computerActions
    private ArrayList<Character> playerCharacters;  //list of player character
    private ArrayList<Character> aiCharacters;      //List of ai character

    //-------------------- Constructor ----------------------------
    public Round(ArrayList<Character> playerCharacters, Stack<Action> playerActions, ArrayList<Character> aiCharacters, Stack<Action> computerActions)
    {
        this.playerActions = playerActions;
        this.computerActions = computerActions;
        this.finalActions = this.merge(playerActions, computerActions);
    }
    
    
    
    /**
     * Method to make an alternate merge of two lists
     * 
     * @param <T> Generic type of list
     * @param a First list
     * @param b Second List
     * @return  Merged List
     */
    public <T> Stack<T> merge(List<T> a, List<T> b) {
        Stack<T> result = new Stack<>();
        int size = Math.max(a.size(), b.size());

        for (int i = 0; i < size; i++) {
            if (i < a.size()) 
            {
                result.add(a.get(i));
            }
            if (i < b.size())
            {
                result.add(b.get(i));
            }
        }
        return result;
    }
    
    /**
     * Method to play a round (execute the actions and reinitialize for next round) 
     */
    public void play()
    {
        Log.i("Round is starting...");
        this.executeActions();
        this.initNextRound();
    }
    
    /**
     * Update the different data  of the character for the next round
     */
    public void initNextRound()
    {
        for(Character c: this.playerCharacters)
        {
            c.removeEffect();
            c.initHealth();
        }
        for(Character c: this.aiCharacters)
        {
            c.removeEffect();
            c.initHealth();
        }
        Log.i("Round finished");
    }
    
    /**
     * Executes the actions of the merged list
     */
    public void executeActions()
    {
        Iterator iterator = this.finalActions.iterator();
        while(!this.finalActions.empty())
        {
            Action a = this.finalActions.pop();
            Log.i("Action launched by : " + a.getSource().getName());
            if(a.getTarget() != null)
            {   
                Log.i("Action target : " +a.getTarget().getName());
            }
            if(a.getCapacity() != null)
            {
                a.useCapacity();
            } else
            {
                a.useItem();
            }
            //check if the target dies if true then remove all actiosn concerning this character
            if(a.getTarget() != null)  //if action is not a heal or using an item
            {
                if(a.getTarget().getCurrentHealth()<=0)
                {
                    System.out.println("The character " + a.getTarget().getName() + " was killed by " + a.getSource().getName());
                    this.removeDieCharacter(a.getTarget());
                }           
            }
        }
    }
    
    /**
     * Method that remove all actions in the list when a character dies
     * @param c the dead character
     */
    public void removeDieCharacter(Character c)
    {
        try
        {
            this.characterExists(c);
            if(this.playerCharacters.contains(c))
                this.playerCharacters.remove(c);
            else
                this.aiCharacters.remove(c);
        } 
        catch(CharatcerExistsException ex)
        {
            Log.e(ex.getMessage());
        }
        
        if(this.finalActions !=null)
        {
            for(Action a: this.finalActions)
            {
                if(a.getTarget() == c || a.getSource() == c)
                {
                    this.finalActions.remove(a);
                }
            }
        }

    }
    
    public void addAction(Action a)
    {
        this.finalActions.push(a);
    }
    
    /**
     * @param c the tested character
     * @throws rpgException.CharatcerExistsException Exception if exception is not found in list
     */
    public void characterExists(Character c) throws CharatcerExistsException
    {
        if (!this.aiCharacters.contains(c) || !this.playerCharacters.contains(c))
        {
            throw new CharatcerExistsException(c);
        }
    }
}
