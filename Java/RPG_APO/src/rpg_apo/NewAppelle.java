/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg_apo;

import java.util.ArrayList;
import static rpg_apo.ControlerUI.readInt;
import static view.Console.displayBlack;
import static view.Console.displayBlue;
import static view.Console.displayPurple;
import static view.Console.displayRed;

/**
 *
 * @author Matthieu
 */
public class NewAppelle extends Event{
    Character c;
    public NewAppelle(Character c){
        this.c=c;
    }
    

    
    public boolean donne(int i){
        int pr=1+((int)(Math.random()*(99)));
        if (pr>i){
            return false;
        }else return true;
    }
    //Proposer d'appeller 3 personne parents frere Petite amis
    //chacun un petit dialogue
    //puis une recompense
    public void display(){
        int gagner=0;
        displayBlue("Les journées en prison sont longue appellé un proche remonte toujours le moral.");
        displayBlue("Liste des personnes que vous pouvez appellé : ");
        displayBlue("\t1) Parents");
        displayBlue("\t2) Frere");
        displayBlue("\t3) Petite amis");
        displayBlue("\t4) Meilleur amis");
        int rep = readInt("Qui veut tu appeller : ",1,4);
        displayBlue("Le telephone sonne ...");
        switch(rep){
            case 1 : 
                if(donne(50)) gagner = ((int)(Math.random()*(20)));
                displayBlue("Allo ?!");
                displayPurple("Oui maman c'est moi ton fils ! ");
                displayBlue("C'est pas ta mere c'est ton pere à l'appareil!!");
                displayPurple("Papa?... Comment va tu?");
                displayBlue("J'allais mieux il y a 5 minutes... Tu veut encore de l'argent je paris? ");
                displayPurple("Oui pour m'acheter des affaire de toilette...");
                displayBlue("Pff un vrai bon a rien... Bon on créditera ton compte de "+gagner+"$ mais ne nous rappelle pas tout les jours");
                displayPurple("Merci papa, à demain alors!");
                break;
            case 2 : 
                if(donne(75)) gagner = 5+((int)(Math.random()*(5)));
                displayBlue("Allo ?!");
                displayPurple("Ouais fréro c'est moi comment tu va? ");
                displayBlue("Bien bien et toi petit frére pas trop dure l'hotel?");
                displayPurple("Si un peut sa serais plus facile avec un peut d'argent...");
                displayBlue("Si ce n'est que sa il fallait le dire plus tot, demain je te fait un virement de "+gagner+"$ sur ton compte");
                displayPurple("Merci c'est gentil. A ... On m'appelle désolé je te rappellerais... Tchiao mon frère");
                displayBlue("Bah salut alors");
                break;
                
            case 3 : 
                if(donne(10)) gagner = 5+((int)(Math.random()*(80)));
                displayBlue("Allo ?!");
                displayPurple("Hey c'est moi chérie comment sa va? et les enfants ils vons bien?");
                displayBlue("Oui tout le monde va bien mais on s'inquiete pour toi tu sais...");
                displayPurple("Oui bah justement avec un peut d'argents sa serais plus facile tu sais...");
                displayBlue("Encore et bien dit donc sa part vite avec toi... Bon je pense je peut te passer "+gagner+" mais pas plus");
                displayPurple("Merci du soutient !! Non mais serieux... Bon bah a la prochaine fois alors. Bisous");
                displayBlue("Ouais a la prochaine c'est sa ! ");
                break;
            case 4 : 
                displayBlue("Malheureusement vous n'avez pas d'amis...");
                break;
        }
        
        c.addMoney(gagner);
        
    }
    
}
