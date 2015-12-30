/*
 * Projet - APO Création d'un RPG
 * Décembre 2015
 * Gaëtan MARTIN & Jensen JOYMANGUL
 */
package rpg;
import Controller.DisplayCharacter;
import me.grea.antoine.utils.Log;
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
        Character c2 = new Character("Gaetan");
        DisplayCharacter dc = new DisplayCharacter(c);
        DisplayCharacter dc2 = new DisplayCharacter(c2);
        dc.displayName();
        dc.displayAbilities();
        dc2.displayName();
        dc2.displayAbilities();
        Effect e1 = new Effect(Ability.DEXTERITY, 20, 2);
        Item i = new Item("Item 1",20,false);
        i.setEffect(e1);
        dc.addItem(i);
        Weapon w = new Weapon("arme", 60, 30, 50);
        Armor a = new Armor("armure",20,50); 
        dc.addItem(w);
        dc2.addItem(a);
        dc.displayInventory();
        dc2.displayInventory();
        dc2.displayAbilities();
        Attack att = new Attack(w);
        Log.d(att.getEffect(c, c2).toString());
    }

}
