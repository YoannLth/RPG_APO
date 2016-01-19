/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package rpg;

import me.grea.antoine.utils.Dice;

/**
 * Class representing an action of a character : use of an item or use of a
 * capacity
 *
 * @author Gaetan
 */
public class Action
{
    private Character source; //Character launching the action
    private Character target; //Character getting the effect of the action
    private Edible edible;     
    private Capacity capacity;

    /**
     * Utilization of an item
     *
     * @param s : Character using the item
     * @param t : Character receiving the effect of the item
     * @param i : Edible item to use / consume
     */
    public Action(Character s, Character t, Edible i)
    {
        this.source = s;
        this.target = t;
        this.edible = i;
        this.capacity = null;
    }
    
    public Character getSource()
    {
        return source;
    }

    //---------------------- Getter -----------------------------------
    public Character getTarget()    
    {
        return target;
    }

    public Edible getEdible()
    {
        return edible;
    }

    public Capacity getCapacity()
    {
        return capacity;
    }

    //---------------------- Constructor -------------------------------
    /**
     * Utilization of a capacity
     *
     * @param s : Character using the capacity
     * @param t : Character receiving the capacity
     * @param c : Capacity to use
     */
    public Action(Character s, Character t, Capacity c)
    {
        this.source = s;
        this.target = t;
        this.capacity = c;
        this.edible = null;
    }
    
    public Action(Character s, Capacity c)
    {
        this(s,null,c);
    }
    
    public void useAction()
    {
        if(this.edible != null)
        {
            this.useItem();
        }else 
        {
            this.useCapacity();
        }
    }

    /**
     * Use of an item : apply effect on the characters
     */
    public void useItem()
    {
        if(this.canExecute())
        {
            this.target.applyEffect(this.edible.getEffect());
            System.out.println(this.edible.toString());
            this.edible.getEffect().reduceDuration();
            
        }
    }

    /**
     * Use of a capacity : apply effect on the characters
     */
    public void useCapacity()
    {
        if(this.canExecute()) 
        {
                this.target.applyEffect(this.capacity.getEffect());
        }
    }
    
    /**
     * Check if an action can be executed
     * @return true if can execute  action otherwise return false
     */
    public boolean canExecute()
    {
        if(this.edible == null) //if actions consists of a capacity
        {
            int diceRoll = Dice.roll(0,10); //generate a random ulber between 0 and 10
            System.out.println(Main.ANSI_CYAN + "Dice is rolling... and the result is " + diceRoll + Main.ANSI_RESET);
            if(diceRoll <= (this.capacity.probaWin(this.source)*10)) 
            {
                System.out.println(Main.ANSI_GREEN + "\\\\\\\\\\Action will be performed//////////" + Main.ANSI_RESET);
                return true;
            }
            System.out.println(Main.ANSI_RED + "\\\\\\\\\\Unfortunately action cannot be executed//////////" + Main.ANSI_RESET);
            return false;
        }
        else //if action consists of using an edible
        {
            System.out.println("The edible will be used");
            return true;
        }
    }

}
