package rpg_apo;

import java.util.Map;
import static view.Console.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yoann
 */
public class NewMessage extends Event{
    private final Map<Integer,String> quotes;
    
    public NewMessage(Map<Integer, String> qts){
        quotes = qts;
    }
    
    public void display() {
        for(int i=1;i<=quotes.size();i++){
            displayBlack(quotes.get(i));
        }
    }
        
}
