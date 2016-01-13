/*
 * Projet - APO Création d'un RPG
 * Décembre 2015
 * Gaëtan MARTIN & Jensen JOYMANGUL
 */
package rpg;

import Controller.ControllerAI;
import Controller.DisplayUI;
import Controller.ControllerPlayer;
import Controller.ControllerUI;
import Controller.DisplayCharacter;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
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

//        Character c = new Character("Selwyn");
//        Character c2 = new Character("Gaetan");
//        DisplayCharacter dc = new DisplayCharacter(c);
//        DisplayCharacter dc2 = new DisplayCharacter(c2);
//        dc.displayName();
//        dc.displayAbilities();
//        dc2.displayName();
//        dc2.displayAbilities();
//        Effect e1 = new Effect(Ability.DEXTERITY, 20, 2);
//        Item i = new Item("Item 1", 20, false);
//        i.setEffect(e1);
//        dc.addItem(i);
//        Weapon w = new Weapon("arme", 60, 90, 50);
//        Armor a = new Armor("armure", 20, 50);
//        dc.addItem(w);
//        dc2.addItem(a);
//        dc.displayAbilities();
//        dc2.displayAbilities();
//        Attack att = new Attack(c, c2);
//        Action act = new Action(c, c2, att);
//        act.useCapacity();
//        Heal hl = new Heal(c2);
//        Action act2 = new Action(c2, hl);
//        dc2.displayAbilities();
//        act2.useCapacity();

        start();
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
        int nbCharacs = DisplayUI.getNbCharacters(MAX_NB_CHARACTERS);
        initGame(nbCharacs);
    }

    /**
     * Initialize the game
     *
     * @param nbCharac
     */
    private void initGame(int nbCharac)
    {
        for (int i = 0; i < nbCharac; i++)
        {
            createNewPlayerCharacter();
        }
        createNewAICharacter();
        
        this.displayCharacters();
        
        this.runGame();
    }

    /**
     * Creation of the characters of the player
     */
    private void createNewPlayerCharacter()
    {
        String name = DisplayUI.getCharacterName();
        String classChosen = DisplayUI.getPlayerClass();
        
        Character character;
        
        switch (classChosen) {
            case "Athlete" : character = new Athlete(); break;
            case "Healer" : character = new Healer(); break;
            default : character = new Warrior(); break;
        }

        character.setName(name);
        
        playerCharacters.add(character);

    }

    /**
     * Creation of the characters of the AI
     */
    private void createNewAICharacter()
    {
        Stack charactersNames = new Stack<>();
        charactersNames.add("John");
        charactersNames.add("Brice");
        charactersNames.add("Chuck");
        charactersNames.add("Frodo");
        for (int i = 0; i < MAX_NB_CHARACTERS; i++)
        {
            Warrior w = new Warrior();
            w.setName((String) charactersNames.pop());
            aiCharacters.add(w);
        }
    }

    /**
     * Load a previous game
     */
    private void loadGame()
    {
        Log.e("Not implemented yet");
        start();
    }

    /**
     * Quit the game
     */
    private void quitGame()
    {
        DisplayUI.displayQuitGameMessage();
        System.exit(0);
    }
    
    /**
     * Display all the characters
     */
    private void displayCharacters()
    {
        this.displayPlayerCharacters();
        this.displayAICharacters();
    }
    
    /**
     * Display all the characters of the player
     */
    private void displayPlayerCharacters()
    {
        System.out.println("List of the player characters : ");
        for (int i = 0; i < playerCharacters.size(); i++)
        {
            System.out.println(playerCharacters.get(i).toString());
        }
    }
    
    /**
     * Display all the characters of the AI
     */
    private void displayAICharacters()
    {
        System.out.println("List of the AI characters : ");
        for (int i = 0; i < aiCharacters.size(); i++)
        {
            System.out.println(aiCharacters.get(i).toString());
        }
    }
    
    /**
     * Ask for a target among the AI Characters
     * 
     * @return AI character corresponding to the name typed in
     */
    private Character getAICharacterByName()
    {
        this.displayAICharacters();
        String name = DisplayUI.getCharacterName();
        for(Character aiCharacter : aiCharacters)
        {
            if (aiCharacter.getName().equals(name))
                return aiCharacter;
        }
        return this.getAICharacterByName();
    }
    
    /**
     * Ask for a target among the Player Characters
     *
     * @return player character corresponding to the name typed in
     */
    private Character getPlayerCharacterByName()
    {
        this.displayPlayerCharacters();
        String name = DisplayUI.getCharacterName();
        for(Character playerCharacter : playerCharacters)
        {
            if (playerCharacter.getName().equals(name))
                return playerCharacter;
        }
        return this.getPlayerCharacterByName();
    }

    /**
     * Launch the game after everything is set & prepared
     */
    private void runGame()
    {
        // Todo : Gérer le jeu, appeler event & co
        ArrayList<ControllerPlayer> playerControllers = new ArrayList<>();
        ArrayList<ControllerAI> aiControllers = new ArrayList<>();
        
        for (Character player : playerCharacters)
        {
            playerControllers.add(new ControllerPlayer(player));
        }
        
        for (Character ai : aiCharacters)
        {
            aiControllers.add(new ControllerAI(ai));
        }
        
        for (ControllerPlayer cp : playerControllers)
        {
            System.out.println("***********************");
            System.out.println("Round of " + cp.getCharacter().getName());
            turn(cp.getCharacter());
            
            System.out.println("Select a target : ");
            Character target = this.getAICharacterByName();
            Action a = cp.getAction(target);
            new DisplayCharacter(target).displayAll();
        }
        
    }
    
    /**
     * Show all the actions possible : continue, leave game, consult Inventory, etc..
     */
    private void turn(Character character)
    {
        int choice = DisplayUI.getActionTurn();
        switch (choice)
        {
            case 0 : this.quitGame(); break;
            case 1 : new DisplayCharacter(character).displayInventory(); break;
            case 2 : new DisplayCharacter(character).displayAll(); break;
            case 3 : return;
            default : break;
        }
        turn(character);
    }

}
