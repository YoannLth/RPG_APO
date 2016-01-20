/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg_apo;

import java.util.ArrayList;
import static view.Console.displayBlack;
import static view.Console.displayBlue;
import static view.Console.displayRed;

/**
 *
 * @author Matthieu
 */
public class NewAppelle extends Event{
    public NewAppelle(){
    }
    
    public int choixAppel(){
        return 1;
    }
    //Proposer d'appeller 3 personne parents frere Petite amis
    //chacun un petit dialogue
    //puis une recompense
    public void display(){
        displayBlue("");
    }
    
}
