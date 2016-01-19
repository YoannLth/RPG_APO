/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package model;

import rpg.Character;

/**
 * Class ennemy used for AI characters
 * @author Gaetan
 */
public final class Ennemy extends Character
{
    /**
     * Constructor
     */
    public Ennemy()
    {
        super();
        this.setMaxHealth(MAX_HEALTH_ENNEMY);
        this.initInventory();
    }
}
