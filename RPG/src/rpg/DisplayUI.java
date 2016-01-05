/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package rpg;

/**
 * Class used to display text to the user
 * In future, change that with text files reader
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
}
