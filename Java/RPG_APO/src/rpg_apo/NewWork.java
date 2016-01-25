package rpg_apo;


import static rpg_apo.ControlerUI.readInt;
import rpg_apo.Event;
import static view.Console.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matthieu
 */
public class NewWork extends Event{
    Character c;
    
    public NewWork(Character c){
        this.c=c;
    }

    public void display(){
        displayBlue("\t- GARDE : C'est bien d'être venu travailler le nouveau, tu va pouvoir aider a la reconstruction du bloc A");
        displayBlue("            Tout travail mérite salaire tu sera payé 1$ de l'heure.");
        displayBlue("            Une journé de travail dure 8h tu pourra donc te faire 8$ par jour.");
        
        displayContinue();

        displayBlue("Le temps passe... passe... toujours aussi lentement...");
        
        displayContinue();
        
        displayBlue("La journe est maintenant terminé. Vous avez bien travaillé!");
        displayBlue("Vous avez gagné 100$ aujourd'hui.");  
        
        c.addMoney(600);
        displayContinue();
    }
        
}