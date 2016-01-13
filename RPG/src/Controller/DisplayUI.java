/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package Controller;

import Controller.ControllerUI;
import java.util.Arrays;
import java.util.HashSet;
import me.grea.antoine.utils.Log;
import rpg.Capacity;
import rpg.Character;

/**
 * Class used to display text to the user In future, change that with text files
 * reader
 *
 * @author Gaetan
 */
public class DisplayUI
{

    /**
     * Display the very first text
     */
    public static void displayStartText()
    {
        String text = "Welcome in the RPG ! Please, select an option \n";
        text += "\t 1. Start a new game \n";
        text += "\t 2. Load last game saved \n";
        text += "\t 0. Quit \n";
        System.out.println(text);
    }

    /**
     * Display the text of a new game
     */
    public static void displayNewGameText()
    {
        String text = "A long time ago in a galaxy far far away ... \n";
        System.out.println(text);
    }

    /**
     * Ask the player for the number of characters
     *
     * @return the number of characters
     */
    public static int getNbCharacters(int max)
    {
        int nbCharac = ControllerUI.readInt("Please select the number of characters"
                + " you want to have in your team");
        if (nbCharac <= 0 || nbCharac > max)
        {
            System.out.println("Incorrect value, max number of characters is 3");
            return DisplayUI.getNbCharacters(max);
        } else
        {
            return nbCharac;
        }
    }

    /**
     * Display the final message when the player leaves the game
     */
    public static void displayQuitGameMessage()
    {
        System.out.println("Thanks for playing, hope you enjoyed");
    }

    /**
     * Ask for the name of a character
     *
     * @return the name of a character
     */
    public static String getCharacterName()
    {
        String name = ControllerUI.readString("Please enter the name of the character");
        return name;
    }

    /**
     * Ask for a class List : Warrior - Athlete - Healer
     *
     * @return the string describing the class chosen
     */
    public static String getPlayerClass()
    {
        HashSet<String> classes = new HashSet<>(Arrays.asList(new String[]
        {
            "Warrior",
            "Athlete",
            "Healer",
        }));

        String textAskingForClass = "List of classes : ";
        for (String c : classes)
        {
            textAskingForClass += "\n\t" + c;
        }
        System.out.println(textAskingForClass);

        String classTypedIn = "";
        boolean contained = false;
        while (!contained)
        {
            classTypedIn = ControllerUI.readString("Type in your class !");
            for (String classI : classes)
            {
                if (classI.contains(classTypedIn))
                {
                    contained = true;
                    classTypedIn = classI;
                }
            }
        }

        return classTypedIn;
    }

    /**
     * Ask the user for an action for the character given
     *
     * @param character : the action will be executed by this character
     * @return 1 - For a capacity // 2 - For an item
     */
    public static int getAction(Character character)
    {
        int maxAction = 1;

        System.out.println("Actions for the character : " + character.getName());
        System.out.println("\t 1. Use a Capacity");
        if (character.getInventory().size() > 0)
        {
            maxAction++;
            System.out.println("\t 2. Use an Item");
        }

        int choice = ControllerUI.readInt("Please select an action : ");
        if (choice <= 0 || choice > maxAction)
        {
            System.out.println("Incorrect value - Range : [1 - " + maxAction + "]");
            return DisplayUI.getAction(character);
        } else
        {
            return choice;
        }
    }
    
    /**
     * Ask the user for a capacity
     * 
     * @return 
     */
    public static int getCapacityChoice()
    {
        System.out.println("Capacities : ");
        System.out.println("\t 1. Attack");
        System.out.println("\t 2. Heal");
        System.out.println("\t 3. Parry");

        int choice = ControllerUI.readInt("Please select a capacity : ");
        if (choice <= 0 || choice > Capacity.NUMBER_OF_CAPACITY)
        {
            System.out.println("Incorrect value - Range : [1 - " + Capacity.NUMBER_OF_CAPACITY + "]");
            return DisplayUI.getCapacityChoice();
        } else
        {
            return choice;
        }
    }

    /**
     * Ask the user for a "little action"
     *
     * @return an int describing his choice
     */
    public static int getActionTurn()
    {
        System.out.println("What do you want to do : ");
        System.out.println("\t 0. Leave the game");
        System.out.println("\t 1. Display Inventory");
        System.out.println("\t 2. Display Information About your character");
        System.out.println("\t 3. Continue");
        
        int choice = ControllerUI.readInt("Please have a choice : ");
        if (choice < 0 || choice > 3)
        {
            System.out.println("Incorrect value - Range : [0 - 3]");
            return DisplayUI.getActionTurn();
        } else
        {
            return choice;
        }
    }
    
    /**
     * Ask the user to select an item to use
     * 
     * @param character
     * @return 
     */
    public static int getItemToUse(Character character)
    {
        System.out.println("What item do you want to use : ");
        new DisplayCharacter(character).displayInventory();
        
        int nbItem = character.getInventory().size();
        
        int choice = ControllerUI.readInt("Please have a choice : ");
        if (choice < 0 || choice > nbItem)
        {
            System.out.println("Incorrect value - Range : [0 - " + nbItem + "]");
            return DisplayUI.getItemToUse(character);
        } else
        {
            return choice;
        }
    }
}
