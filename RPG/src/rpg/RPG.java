/*
 * Projet - APO Création d'un RPG
 * Décembre 2015
 * Gaëtan MARTIN & Jensen JOYMANGUL
 */
package rpg;

import java.util.ArrayList;
import java.util.Stack;
import me.grea.antoine.utils.*;

/**
 * Main class executable
 *
 * @author p1509413
 */
public class RPG
{

    /**
     * Controller
     */
    private static ControllerPlayer cp;
    
    /**
     * Maximum number of characters in the team of the player
     */
    private static final int MAX_NB_CHARACTERS = 3;
    
    /**
     * List of the characters of the player
     */
    private static ArrayList<Character> playerCharacters;
    
    /**
     * List of the characters of the AI
     */
    private static ArrayList<Character> aiCharacters;

    /**
     * Launch of the project
     * @param args
     */
    public static void main(String[] args)
    {
        cp = new ControllerPlayer();
        
        aiCharacters = new ArrayList<>();
        playerCharacters = new ArrayList<>();

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
                newGame();
                break;
            case 2:
                loadGame();
                break;
            case 0:
                quitGame();
                break;
            default:
                System.out.println("No action corresponding to the number : " + option);
                start();
        }
    }

    /**
     * Launch a new game
     */
    private static void newGame()
    {
        DisplayUI.displayNewGameText();
        int nbCharac = cp.readInt("Please select the number of characters"
                + " you want to have in your team");
        if (nbCharac <= 0 || nbCharac > MAX_NB_CHARACTERS)
        {
            System.out.println("Incorrect value, max number of characters is 3");
            newGame();
        }
        else 
        {
            initGame(nbCharac);
        }
    }
    
    /**
     * Initialize the game
     * @param nbCharac 
     */
    private static void initGame(int nbCharac)
    {
        for (int i = 0; i < nbCharac; i++)
        {
            createNewPlayerCharacter();
        }
        createNewAICharacter();
    }
    
    /**
     * Creation of the characters of the player
     */
    private static void createNewPlayerCharacter()
    {
        
    }
    
    /**
     * Creation of the characters of the AI
     */
    private static void createNewAICharacter()
    {
        Stack charactersNames = new Stack<String>();
        charactersNames.add("John");
        charactersNames.add("Brice");
        charactersNames.add("Chuck");
        charactersNames.add("Frodo");
        for (int i = 0; i < MAX_NB_CHARACTERS; i++)
        {
            aiCharacters.add(new Character((String) charactersNames.pop()));
        }
        
        for (Character c : aiCharacters) 
        {
            System.out.println(c.getName());
        }
        
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
