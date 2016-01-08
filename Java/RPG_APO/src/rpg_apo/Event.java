package rpg_apo;

import static view.Console.*;


public class Event {
    //Message de l'evenement qui sera affiché à l'écran
    protected String message;
    
    //Constructeur
    public Event(String msg){
        message = msg;
    }
    
    //Affichage du message
    public void display(){
        displayBlack(message);
    }
}