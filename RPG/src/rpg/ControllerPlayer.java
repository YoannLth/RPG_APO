/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package rpg;

import java.io.Console;
import java.text.ParseException;
import java.util.Scanner;
import me.grea.antoine.utils.Log;

/**
 * Class managing the interactions with the player
 *
 * @author p1509413
 */
public class ControllerPlayer extends Controller
{
    private final Scanner scanner;

    /**
     * Constructor : instanciante a new Scanner to manage console line I/O
     */
    public ControllerPlayer()
    {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Read an integer from the console
     * The message is repeated until a correct value is typed in
     * 
     * @return the integer typed in by the user
     */
    public int readInt(String message)
    {
        int nombre = 0;
        try
        {
            System.out.println(message);
            String result = scanner.next();
            nombre = Integer.parseInt(result);
        } catch (Exception e)
        {
            // Log.e("Please, type in an integer");
            return readInt("Please, type in an integer");
        }
        return nombre;
    }
    
    /**
     * Read a string from the console
     * 
     * @return the string typed in
     */
    public String readString(String message)
    {
        System.out.println(message);
        String result = scanner.next();
        return result;
    }
    
    /**
     * Ask the player to do an action 
     * @return a new Action
     */
    public Action getAction()
    {
        return new Action(null, null, new Edible(null, 0, true, null));
    }

}
