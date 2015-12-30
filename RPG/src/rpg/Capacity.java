/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package rpg;

/**
 * Interface representing a capacity (action) of the player
 * @author Gaetan
 */
public interface Capacity
{ 
    /**
     * Get the effect of a capacity
     * 
     * @return the effect
     */
    public Effect getEffect(Character source, Character targetsss);
    
    /**
     * Calculate probability to execute a capacity
     * @return probability of execution
     */
    public double probaWin(Character source);
}
