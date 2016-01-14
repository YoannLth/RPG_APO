/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package rpg;

/**
 * Class ennemy used for AI characters
 * @author Gaetan
 */
public class Ennemy extends Character
{
    /**
     * Constructor
     */
    public Ennemy()
    {
        super();
        this.setMaxHealth(MAX_HEALTH_ENNEMY);
        this.initInventoryEnnemy();
    }
    
    /**
     * Init the inventory of the Ennemy
     */
    private void initInventoryEnnemy()
    {
        // No item for the moment
    }
}
