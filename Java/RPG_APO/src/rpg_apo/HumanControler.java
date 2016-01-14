package rpg_apo;

import java.util.Scanner;
import static view.Console.displayBlue;

public class HumanControler extends Controler {
    private static Scanner scanner = new Scanner(System.in);
    public static int readInt(String message)
    {
        int nombre = 0;
        try
        {
            displayBlue(message);
            String result = scanner.next();
            nombre = Integer.parseInt(result);
        } catch (Exception e)
        {
            // Log.e("Please, type in an integer");
            return readInt("Stp mais moi un entier plutot");
        }
        return nombre;
    }
}