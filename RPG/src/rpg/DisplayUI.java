/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package rpg;

import Controller.ControllerUI;
import java.util.Arrays;
import java.util.HashSet;
import me.grea.antoine.utils.Log;

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
     * Ask for a class
     * List : Warrior - Athlete - Healer
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
}
