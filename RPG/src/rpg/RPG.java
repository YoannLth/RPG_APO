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
        Item i = new Item("Item 1",20);
        i.setEffect(e1);
        c.addItem(i);
        dc.displayInventory();
        dc.displayAbilities();
        c.applyEffect(e1);
        dc.displayAbilities();
    }

}
