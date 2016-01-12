/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg_apo;

import java.util.Map;
import static view.Console.*;

/**
 *
 * @author Yoann
 */
public class NewDialog extends Event{
    private Map<Integer,String> script;
    
    public NewDialog(Map<Integer, String> scrpt){
        script = scrpt;
    }
    
    //Affichage du message
    public void display(){
        for(int i=1;i<=script.size();i++){
            displayBlue(script.get(i));
        }
    }
}
