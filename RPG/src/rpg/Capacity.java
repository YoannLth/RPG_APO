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
    public Effect getEffect();
}
