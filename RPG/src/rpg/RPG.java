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

    private static ControllerPlayer cp;

    /**
     * Launch of the project
     */
    public static void main(String[] args)
    {
        cp = new ControllerPlayer();

//        Character c = new Character("Selwyn");
//        Character c2 = new Character("Gaetan");
//        DisplayCharacter dc = new DisplayCharacter(c);
//        DisplayCharacter dc2 = new DisplayCharacter(c2);
//        dc.displayName();
//        dc.displayAbilities();
//        dc2.displayName();
//        dc2.displayAbilities();
//        Effect e1 = new Effect(Ability.DEXTERITY, 20, 2);
//        Item i = new Item("Item 1",20,false);
//        i.setEffect(e1);
//        dc.addItem(i);
//        Weapon w = new Weapon("arme", 60, 30, 50);
//        Armor a = new Armor("armure",20,50); 
//        dc.addItem(w);
//        dc2.addItem(a);
//        dc.displayInventory();
//        dc2.displayInventory();
//        dc2.displayAbilities();
//        Attack att = new Attack(w);
//        Log.d(att.getEffect(c, c2).toString());
        start();
    }

    /**
     * Start the game
     */
    private static void start()
    {
        DisplayUI.displayStartText();
        int option = cp.readInt("Please select the number corresponding to your choice : ");
        switch (option)
        {
            case 1:
                newGame(); break;
            case 2:
                loadGame(); break;
            case 0:
                quitGame(); break;
            default: 
                System.out.println("No action corresponding to the number typed in");
                start();
        }
    }

    /**
     * Launch a new game
     */
    private static void newGame()
    {
        
    }
    
    /**
     * Load a previous game
     */
    private static void loadGame()
    {
        System.out.println("Not implemented yet");
        start();
    }
    
    /**
     * Quit the game
     */
    private static void quitGame()
    {
        // Ask for save before quiting
        System.out.println("Thanks for playing, hope you enjoyed");
        System.exit(0);
    }

}
