/*
 * Projet - APO Création d'un RPG
 * Décembre 2015
 * Gaëtan MARTIN & Jensen JOYMANGUL
 */
package rpg;

import Controller.ControllerUI;
import Controller.DisplayCharacter;
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
    private static ControllerUI cp;
    
    /**
     * Maximum number of characters in the team of the player
     */
    private static final int MAX_NB_CHARACTERS = 3;
    
    /**
     * List of the characters of the player
     */
    private ArrayList<Character> playerCharacters;
    
    /**
     * List of the characters of the AI
     */
    private ArrayList<Character> aiCharacters;

    /**
     * Constructor
     */
    public RPG()
    {
        cp = new ControllerUI();
        
        aiCharacters = new ArrayList<>();
        playerCharacters = new ArrayList<>();

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
        Weapon w = new Weapon("arme", 60, 90, 50);
        Armor a = new Armor("armure",20,50); 
        dc.addItem(w);
        dc2.addItem(a);
        dc.displayAbilities();
        dc2.displayAbilities();
        Attack att = new Attack(c,c2);
        Action act = new Action(c,c2,att);
        act.useCapacity();
        Heal hl = new Heal(c2);
        Action act2 = new Action(c2,hl);
        dc2.displayAbilities();
        act2.useCapacity();
        
        //start();
    }

    /**
     * Start the game
     */
    private void start()
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
    private void newGame()
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
    private void initGame(int nbCharac)
    {
        for (int i = 0; i < nbCharac; i++)
        {
            createNewPlayerCharacter();
        }
        createNewAICharacter();
        
        System.out.println("List of the player characters : ");
        for (int i = 0; i < playerCharacters.size(); i ++)
            System.out.println("\t" + playerCharacters.get(i).getName());
        
        System.out.println("List of the AI characters : ");
        for (int i = 0; i < aiCharacters.size(); i ++)
            System.out.println("\t" + aiCharacters.get(i).getName());
    }
    
    /**
     * Creation of the characters of the player
     */
    private void createNewPlayerCharacter()
    {        
        String name = cp.readString("Chose a name :");
        Character character = new Warrior();
        
        character.setName(name);
        
        // TODO : Gérer la distribution des carractéristiques
        
        playerCharacters.add(character);
        
    }
    
    /**
     * Creation of the characters of the AI
     */
    private void createNewAICharacter()
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
    }

    /**
     * Load a previous game
     */
    private void loadGame()
    {
        System.out.println("Not implemented yet");
        start();
    }

    /**
     * Quit the game
     */
    private void quitGame()
    {
        // Ask for save before quiting
        System.out.println("Thanks for playing, hope you enjoyed");
        System.exit(0);
    }

}
