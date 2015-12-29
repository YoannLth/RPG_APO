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
            Log.i("Item : " + i.getName() + " a été ajouté");
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
            if("Weapon".equals(i.getClass().getName()) || "Armor".equals(i.getClass().getName()))
                Log.e("Impossible de retirer une arme ou une armure dans l'inventaire");
            else
            {
                this.character.removeItem(i);
                Log.i("Item : " + i.getName() + " a été retiré dans l'inventaire");
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
        String s = "Vous avez dans votre inventaire : \n";
        for(Item i: this.character.getInventory())
        {
            s+= i.toString();
        }
        Log.i(s);
    }
    
    public void displayAbilities()
    {
        String s = "Vous avez les Carastisques suivantes : \n";
        for(Entry<Ability, Integer> e : this.character.getAbilities().entrySet())
        {
            String ability = e.getKey().name();
            int value = e.getValue();
            s += "        - "+ ability + " : " + value + "\n";        
        }
        Log.i(s);
    }
    
    public void displayWeight()
    {
        Log.i("Vous avez :" + (this.character.getMaxWeight() - this.character.getInventoryWeight()) + " poid restant");
    }
    
    public void displayHealth()
    {
        Log.i("Vous avez :" + this.character.getMaxHealth() + " point de vie");
    }
    
    public void displayName()
    {
        Log.i("Le nom du joueur est : " + this.character.getName());
    }
}
