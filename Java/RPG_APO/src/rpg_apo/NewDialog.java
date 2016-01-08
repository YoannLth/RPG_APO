package rpg_apo;

import static view.Console.*;

public class NewDialog extends Event {
    
    public NewDialog(String message){
        super(message);
    }
    
    public void display(){
        displayContinueMessage(super.message);
    }
}