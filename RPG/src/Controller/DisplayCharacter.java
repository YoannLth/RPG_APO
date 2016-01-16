/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package Controller;
import java.util.Map.*;
import me.grea.antoine.utils.Log;
import rpg.Ability;
import rpg.Character;
import rpg.Item;
import rpgException.ExistsInventoryException;
import rpgException.MaxInventoryException;
/**
 *
 * @author seljo
 */
public class DisplayCharacter
{
    private final Character character;
    
    public DisplayCharacter(Character c)
    {
        this.character = c;
    }
    
    /**
     * Display information when adding an item
     * @param i item to add to inventory
     */
    public void addItem(Item i)
    {
        try
        {
            this.character.checkMaxInventory(i);
            this.character.addItem(i);
            System.out.println("Item : " + i.getName() + " a été ajouté");
        }
        catch (MaxInventoryException ex)
        {
            Log.e(ex.getMessage());
        }
    }
    
    /**
     * Display information when removing an item in inventory
     * @param i item to remove in inventory
     */
    public void removeItem(Item i)
    {
        try
        {
            this.character.checkInInventory(i);
            if("rpg.Weapon".equals(i.getClass().getName()) || "rpg.Armor".equals(i.getClass().getName()))
                Log.e("Cannot remove an armor in inventory");
            else
            {
                this.character.removeItem(i);
                System.out.println("Item : " + i.getName() + " was removed in inventory");
            }
        }
        catch (ExistsInventoryException ex)
        {
            Log.e(ex.getMessage());
        }    
    }
    
    /**
     * Display inventory of player
     */
    public void displayInventory()
    {
        String s = "Yout inventory : \n";
        int itemId = 0;
        for(Item i: this.character.getInventory())
        {
            s+= itemId + ". " + i.toString();
            itemId ++;
        }
        System.out.println(s);
    }
    
    public void displayAbilities()
    {
        String s = "Your Abilities : \n";
        for(Entry<Ability, Integer> e : this.character.getAbilities().entrySet())
        {
            String ability = e.getKey().name();
            int value = e.getValue();
            s += "        - "+ ability + " : " + value + "\n";        
        }
        System.out.println(s);
    }
    
    public void displayWeight()
    {
        System.out.println("You have " + (this.character.getMaxWeight() - this.character.getInventoryWeight()) + " weight unused");
    }
    
    public void displayHealth()
    {
        System.out.println("You have " + this.character.getCurrentHealth() + " Health Point");
    }
    
    public void displayName()
    {
        System.out.println("The player game : " + this.character.getName());
    }

    /**
     * Display all the information about the character
     */
    public void displayAll()
    {
        this.displayName();
        this.displayAbilities();
        this.displayHealth();
        this.displayWeight();
    }
}
