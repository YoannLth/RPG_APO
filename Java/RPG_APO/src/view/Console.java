/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.util.Scanner;

/**
 *
 * @author Yoann
 */
public class Console {
    
    //Couleurs des messages a afficher dans la console
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    public static void displayBlack(String msg){
        System.out.println(ANSI_BLACK + msg + ANSI_RESET);
    }
    
    public static void displayRed(String msg){
        System.out.println(ANSI_RED + msg + ANSI_RESET);
    }
    
    public static void displayBlue(String msg){
        System.out.println(ANSI_BLUE + msg + ANSI_RESET);
    }
    
    
    public static void displayContinueMessage(String msg){
        System.out.println(ANSI_BLACK + msg + ANSI_RESET);
        System.out.println(ANSI_RED + "Appuyez sur entrée pour continuer" + ANSI_RESET);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        clearConsole();
    }
    
    public static void displayContinue(){
        System.out.println(ANSI_RED + "Appuyez sur entrée pour continuer" + ANSI_RESET);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        clearConsole();
    }
    
    public static void clearConsole()
    {
        for(int clear = 0; clear < 3; clear++)
            {
               System.out.println(".") ;
            }
    }
    
    public static void lineBreak()
    {
        System.out.println("") ;
    }
}
