/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg_apo;

import java.util.Map;
import java.util.Scanner;
import static view.Console.*;

/**
 *
 * @author Yoann
 */
public class NewMenu extends Event{
    private String menuMessage;
    private Map<Integer,String> items;
    private int choice;
    
    public NewMenu(String msg, Map<Integer,String> itms){
         items = itms;
         menuMessage = msg;         
    }

    public void display() {
        displayRed(menuMessage);
        for(int i = 1; i<=items.size(); i++){
            displayRed(items.get(i)); 
        }
        
        Scanner scanner = new Scanner(System.in);
        int res = Integer.parseInt(scanner.nextLine());
        
        choice = res;
    }
    
    public int getChoice(){
        return choice;
    }
}
