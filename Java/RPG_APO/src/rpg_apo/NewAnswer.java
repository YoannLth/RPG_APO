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
public class NewAnswer  extends Event{
    private String answer;
    private String instruction;
    
    public NewAnswer(String i){
        instruction = i;
    }
    
    //Affichage du message
    public void display(){ 
        displayRed(instruction);
        Scanner scanner = new Scanner(System.in);
        String res = scanner.nextLine();
        
        setAnswer(res);
    }
    
    public String getAnswer(){
        return this.answer;
    }
    
    public void setAnswer(String a){
        this.answer = a;
    }
    
}
