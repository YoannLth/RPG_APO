/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package rpg;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author seljo
 */
public class Round
{
    private List<Action> playerActions; //List of actions for a player
    private List<Action> computerActions;   //List of actions for the AI
    private List<Action> finalActions;  //merged list of playerActions and computerActions

    //-------------------- Constructor ----------------------------
    public Round(List<Action> playerActions, List<Action> computerActions)
    {
        this.playerActions = playerActions;
        this.computerActions = computerActions;
        this.finalActions = this.merge(finalActions, finalActions);
    }
    
    
    
    /**
     * Method to make an alternate merge of two lists
     * 
     * @param <T> Generic type of list
     * @param a First list
     * @param b Second List
     * @return  Merged List
     */
    public <T> List<T> merge(List<T> a, List<T> b) {
        List<T> result = new ArrayList<>();
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
        this.executeActions();
        this.initNextRound();
    }
    
    /**
     * Update the different data  of the character for the next round
     */
    public void initNextRound()
    {
        List<Character> characters = this.getPlayingCharacter();
        for(Character c: characters)
        {
            c.removeEffect();
            c.initHealth();
        }
    }
    
    
    
    /**
     * @return List of all characters taking part in an action
     */
    public List<Character> getPlayingCharacter()
    {
        List<Character> res = new ArrayList<>();
        for(Action a:this.finalActions)
        {
            if(!res.contains(a.getSource()))
            {
                res.add(a.getSource());
            } else if(!res.contains(a.getTarget()))
            {
                res.add(a.getTarget());
            }
        }
        return res;
    }
    
    /**
     * Executes the actions of the merged list
     */
    public void executeActions()
    {
        for(Action a : this.finalActions)
        {
            if(a.getCapacity() != null)
            {
                a.useCapacity();
            } else
            {
                a.useItem();
            }
        }
    }
    
}
