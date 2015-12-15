/*
 * Projet - APO Création d'un RPG
 * Décembre 2015
 * Gaëtan MARTIN & Jensen JOYMANGUL
 */
package rpg;

import java.util.HashMap;
import java.util.List;
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

    /**
     * Inventory of the characters
     */
    private List<Item> inventory;

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
     * Equip a weapon, the effect is applied if there is enough room in the
     * inventory
     *
     * @param w
     */
    public void equipWeapon(Weapon w)
    {
        try
        {
            this.checkInventory(w);
            this.applyEffect(w.getEffect());
        } catch (MaxInventoryException ex)
        {
            System.out.println(ex.getMessage());
            // TODO : Replace with log system
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
            this.checkInventory(a);
            this.applyEffect(a.getEffect());
        } catch (MaxInventoryException ex)
        {
            System.out.println(ex.getMessage());
            // TODO : Replace with log system
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

    public void initAbilities()
    {
    }

    public void checkAbilities()
    {
    }

    public void initCapacity()
    {
    }

    /**
     * Check that there is space available in the inventory
     *
     * @param i : The item to add to inventory
     * @throws MaxInventoryException if the limit of the inventory is reached
     */
    private void checkInventory(Item i) throws MaxInventoryException
    {
        if (this.getInventoryWeight() + i.weight > this.maxWeight)
        {
            throw new MaxInventoryException(i);
        }
    }
}
