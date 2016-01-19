/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rpg_apo;

import java.util.Map;
import java.util.Scanner;
import static view.Console.displayBlack;

/**
 *
 * @author Yoann
 */
public class ControlerUI {
    
    private static Scanner scanner = new Scanner(System.in);

    public static int readInt(String message, int min, int max)
    {
        displayBlack(message);
        int number = scanner.nextInt();
        
        if (number < min || number > max)
        {
            return readInt("Erreur, Selectionner un nombre entre " + min + " et " + max, min, max);
        } else
        {
            return number;
        }
    }
}
