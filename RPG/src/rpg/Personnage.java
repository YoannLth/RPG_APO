/*
 * Projet - APO Création d'un RPG
 * Décembre 2015
 * Gaëtan MARTIN & Jensen Joymangul
 */

package rpg;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe Personnage : Représente un personnage du RPG
 * @author p1509413
 */
public class Personnage {
    
    /**
     * Carractéristiques du personnage
     */
    private Map<Caracteristique, Integer> carracs;
    
    /**
     * Constructeur par défaut
     */
    public Personnage()
    {
        this.carracs = new HashMap<>();
    }
}
