/*
 * Projet - APO Création d'un RPG
 * Décembre 2015
 * Gaëtan MARTIN & Jensen JOYMANGUL
 */
package rpg;

import rpgException.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.grea.antoine.utils.Log;


/**
 * Character class : Represents a character of the game
 *
 * @author p1509413
 */
public class Character
{
    // -------------- Attributes

    private String name;            //Name of the character
    private Map<Ability, Integer> abilities;    //Stats of the character
    private int level = 1;          //Current level of the character
    private int maxWeight = 100;    //Max weight of carriable items
    private int maxHealth;          //Max Health reachable by the character
    private int maxDexterity;       //Max Dexterity reachable by the character
    private List<Item> inventory;   //Inventory of the characters

    // -------------- Constructors ----------------------------------
    /**
     * Default constructor
     */
    public Character()
    {
        this.abilities = new HashMap<>();
    }

    // -------------- Getters And Setters -------------------------------
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

    // ---------------------------- Methods --------------------------------------
    /**
     * Apply an effect onto the character
     *
     * @param e : The effect to apply
     */
    public void applyEffect(Effect e)
    {
        Ability a = e.getAbility();
        int newValue = this.abilities.get(a) + e.getValue();
        this.abilities.put(a, newValue);
    }

    /**
     * Equip a weapon, the effect is applied if there is enough room in the inventory
     *
     * @param w
     */
    public void equipWeapon(Weapon w)
    {
        try
        {
            this.checkMaxInventory(w);
            this.applyEffect(w.getEffect());
        } catch (MaxInventoryException ex)
        {
            Log.e(ex.getMessage());
        }
    }

    /**
     * Equip an armor, the effect is applied if there is enough room in the
     * inventory
     *
     * @param a
     */
    public void equipArmor(Armor a)
    {
        try
        {
            this.checkMaxInventory(a);
            this.applyEffect(a.getEffect());
        } catch (MaxInventoryException ex)
        {
            Log.e(ex.getMessage());
        }
    }

    /**
     * Get the current weight of the inventory
     *
     * @return the weight of the inventory
     */
    public int getInventoryWeight()
    {
        int sum = 0;
        for (Item item : inventory)
        {
            sum += item.getWeight();
        }
        return sum;
    }

    /**
     * Remove an item from the inventory
     *
     * @param i
     */
    public void removeItem(Item i)
    {
        this.inventory.remove(i);
    }

    /**
     * Add an item in the inventory
     *
     * @param i
     */
    public void addItem(Item i)
    {
        this.inventory.add(i);
    }

    /**
     * Increment the level
     */
    public void incrementLevel()
    {
        this.level++;
    }

    /**
     * Calculate the sum of the abilities
     *
     * @return the sum of the abilities
     */
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

    /**
     * Return the value of the given ability
     *
     * @param ability
     * @return the value of the given ability
     */
    public int getAbilityValue(Ability ability)
    {
        return this.abilities.get(ability);
    }

    /**
     * Initialize the four abilities present with default values
     */
    public void initAbilities()
    {
        this.abilities = new HashMap();
        this.abilities.put(Ability.DEFENSE, 10);
        this.abilities.put(Ability.HEALTH, 100);
        this.abilities.put(Ability.STRENGTH, 10);
        this.abilities.put(Ability.DEXTERITY, 10);
    }

    public void checkAbilities()
    {
        // TODO : Implement this method
    }

    public void initCapacity()
    {
        // TODO : Implement this method
    }

    /**
     * Check that there is space available in the inventory
     *
     * @param i : The item to add to inventory
     * @throws MaxInventoryException if the limit of the inventory is reached
     */
    private void checkMaxInventory(Item i) throws MaxInventoryException
    {
        if (this.getInventoryWeight() + i.weight > this.maxWeight)
        {
            throw new MaxInventoryException(i);
        }
    }
    
    /**
     * 
     * @param i: Item to check if present in inventory
     * @throws ExistsInventoryException if item i is not in inventory
     */
    public void checkInInventory(Item i) throws ExistsInventoryException
    {
        if (!this.inventory.contains(i))
        {
            throw new ExistsInventoryException(i);
        }
    }
}
