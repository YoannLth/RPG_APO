/*
 * Projet - APO Création d'un RPG
 * Décembre 2015
 * Gaëtan MARTIN & Jensen JOYMANGUL
 */
package rpg;

import java.util.HashMap;
import java.util.Map;

/**
 * Character class : Represents a character of the game
 *
 * @author p1509413
 */
public class Character
{
    // -------------- Attributes
    
    /**
     * Name of the character
     */
    private String name;

    /**
     * Stats of the character
     */
    private Map<Ability, Integer> abilities;
    
    /**
     * Current level of the character
     */
    private int level = 1;
    
    /**
     * Max weight of carriable items
     */
    private int maxWeight = 100;
    
    /**
     * Max Health reachable by the character
     */
    private int maxHealth;
    
    /**
     * Max Dexterity reachable by the character
     */
    private int maxDexterity;

    // -------------- Constructors
    
    /**
     * Default constructor
     */
    public Character()
    {
        this.abilities = new HashMap<>();
    }

    // -------------- Getters And Setters
    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Map<Ability, Integer> getAbilities()
    {
        return abilities;
    }

    public void setAbilities(Map<Ability, Integer> abilities)
    {
        this.abilities = abilities;
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public int getMaxWeight()
    {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight)
    {
        this.maxWeight = maxWeight;
    }

    public int getMaxHealth()
    {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth)
    {
        this.maxHealth = maxHealth;
    }

    public int getMaxDexterity()
    {
        return maxDexterity;
    }

    public void setMaxDexterity(int maxDexterity)
    {
        this.maxDexterity = maxDexterity;
    }
    
    // -------------- Methods
    
    // TODO uncomment methods and write doc
    
    // public void applyEffect(Effect e){}
    // public void equipWeapon(Weapon w){}
    // public void equipArmor(Armor a){}
    public int getInventoryWeight()
    {
        return 100; // TODO implement method
    }
    //public void removeItem(Item i){}
    //public void addItem(Item i){}
    //public void incrementLevel(){}
    
    public int sumAbilities()
    {
        int sum = 0;
        for (Map.Entry<Ability, Integer> map : abilities.entrySet())
        {
            Ability ability = map.getKey();
            Integer value = map.getValue();
            sum += value;            
        }
        return sum;
    }
    
    public int getAbilityValue(Ability ability)
    {
        return this.abilities.get(ability);
    }
    
    public void initAbilities()
    {
        
    }
    
    public void checkAbilities()
    {
        
    }
    
    public void initCapacity()
    {
        
    }
}
