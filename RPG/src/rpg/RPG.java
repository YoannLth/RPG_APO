/*
 * Projet - APO Création d'un RPG
 * Décembre 2015
 * Gaëtan MARTIN & Jensen JOYMANGUL
 */
package rpg;
import Controller.DisplayCharacter;
/**
 * Main class executable
 *
 * @author p1509413
 */
public class RPG
{

    /**
     * Launch of the project
     */
    public static void main(String[] args)
    {
        ControllerPlayer co = new ControllerPlayer();
        Character c = new Character("Selwyn");
        DisplayCharacter dc = new DisplayCharacter(c);
        dc.displayName();
        dc.displayWeight();
        dc.displayHealth();
        
        Effect e1 = new Effect(Ability.DEXTERITY, 20, 2);
        Item i = new Item("Item 1",20,false);
        i.setEffect(e1);
        dc.addItem(i);
        dc.addItem(new Item("Item 2",20,false,e1));
        Item i2 = new Item("Item to remove",20,false);
        Weapon w = new Weapon("arme", 60, 30, 10);
        Armor a = new Armor("armure",20,50); 
         dc.displayInventory();
         
        dc.removeItem(i);
        dc.removeItem(i2);
        dc.displayInventory();
        dc.displayAbilities();
        dc.addItem(a);
        dc.displayAbilities();
    }

}
