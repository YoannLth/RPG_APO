
import static rpg_apo.ControlerUI.readInt;
import rpg_apo.Event;
import static view.Console.displayBlue;
import static view.Console.displayPurple;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matthieu
 */
public class NewTravail extends Event{
    rpg_apo.Character c;
    public NewTravail(rpg_apo.Character c){
        this.c=c;
    }


    //Proposer d'appeller 3 personne parents frere Petite amis
    //chacun un petit dialogue
    //puis une recompense
    public void display(){
        displayBlue("C'est bien d'être venu travailler tu va pouvoir aider a la reconstruction du bloc A");
        displayBlue("Tout travail mérite salaire tu sera payer 1$ de l'heur presque le SMIC tu en a de la chance");
        displayBlue("Une journé de travail est de 8h tu pourra donc te faire 8$ par jour.");
        displayBlue("Si jamais tu travail bien tu pourra revenir de temps en temps");
        displayBlue("Le temps passe... passe... toujours aussi lentement...");
        displayBlue("La journe est maintenant bien entamer mais alors que c'est long...");
        displayBlue("Heureusement la journé arrive à sa fin est vous pouvez rentrer au bloc avec en poche 8$");        
    }
    
}