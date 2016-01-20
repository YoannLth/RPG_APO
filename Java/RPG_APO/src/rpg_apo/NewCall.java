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
import static view.Console.displayContinue;
import static view.Console.displayPurple;
import static view.Console.displayRed;

/**
 *
 * @author Matthieu
 */
public class NewCall extends Event{
    Character c;
    
    public NewCall(Character c){
        this.c=c;
    }
        
    public boolean actionSuccess(int i){
        int pr=1+((int)(Math.random()*(99)));
        if (pr>i){
            return false;
        }else return true;
    }
    //Proposer d'appeller 3 personne parents frere Petite amis
    //chacun un petit dialogue
    //puis une recompense
    public void display(){
        int earnedMoney=0;
        displayBlue("Vous avez choisi d'appeler quelqu'un pour demander de l'argent. Qui voulez vous appeler?");
        displayBlue("\t 1. Parents (Réussite : 60% / Récompense : 40$ max)");
        displayBlue("\t 2. Frere (Réussite : 5% / Récompense : 110$ max)");
        displayBlue("\t 3. Petite amie (Réussite : 80% / Récompense : 20$ max)");
        int rep = readInt("Choisissez une personne : ",1,3);
        displayBlue("Le telephone sonne ...");
        switch(rep){
            case 1 : 
                if(actionSuccess(60)){
                    earnedMoney = ((int)(Math.random()*(40)));
                    displayBlue("\t- MERE : Allo ?!");
                    displayPurple("\t- PERSONNAGE : Oui maman c'est moi, ton fils ! ");
                    displayPurple("    Comment va tu?");
                    displayBlue("\t- MERE : J'allais mieux il y a 5 minutes... Tu veut encore de l'argent j'imagine? ");
                    displayPurple("\t- PERSONNAGE : Oui pour m'acheter des affaire de toilette...");
                    displayBlue("\t- MERE : Tu sait bien que ce n'est pas facile pour nous... Bon on créditera ton compte de "+earnedMoney+"$ mais ne nous rappelle pas tout les jours");
                    displayPurple("\t- PERSONNAGE : Merci!");
                }
                else{
                    earnedMoney = 0;
                    displayBlue("\t- MERE : Allo ?!");
                    displayPurple("\t- PERSONNAGE : Oui maman c'est moi, ton fils ! ");
                    displayPurple("    Comment va tu?");
                    displayBlue("\t- MERE : J'allais mieux il y a 5 minutes... Tu veut encore de l'argent j'imagine?");
                    displayPurple("\t- PERSONNAGE : Oui pour m'acheter des affaire de toilette...");
                    displayBlue("\t- MERE : Tu sait bien que ce n'est pas facile pour nous... Je ne peut vraiment pas me le permettre... Je suis désolé");
                    displayPurple("\t- PERSONNAGE : Ce n'est pas grave!");    
                }
                break;
            case 2 : 
                if(actionSuccess(5)){
                    earnedMoney = ((int)(Math.random()*(110)));
                    displayBlue("\t- FRERE : Allo ?!");
                    displayPurple("\t- PERSONNAGE : Oui c'est moi, ton frère ! ");
                    displayPurple("    Comment va tu?");
                    displayBlue("\t- FRERE : Moyen, j'aime pas te savoir derrière les barreaux...");
                    displayPurple("\t- PERSONNAGE : Oui... En attendant de pouvoir sortir, j'ai besoin de ton aide... Un peu d'argent");
                    displayBlue("\t- FRERE : Tu peut compter sur moi... Je t'envoi " + earnedMoney + "$ tout a l'heure");
                    displayPurple("\t- PERSONNAGE : Merci!");
                }
                else{
                    earnedMoney = 0;
                    displayBlue("\t- FRERE : Allo ?!");
                    displayPurple("\t- PERSONNAGE : Oui c'est moi, ton frère ! ");
                    displayPurple("    Comment va tu?");
                    displayBlue("\t- FRERE : Moyen, j'aime pas te savoir derrière les barreaux...");
                    displayPurple("\t- PERSONNAGE : Oui... En attendant de pouvoir sortir, j'ai besoin de ton aide... Un peu d'argent");
                    displayBlue("\t- FRERE : J'ai rien en ce moment, je suis désolé...");
                    displayPurple("\t- PERSONNAGE : Tkt, c'est pas grave!");
                }
                break;
                
            case 3 : 
                if(actionSuccess(80)){
                    earnedMoney = ((int)(Math.random()*(20)));
                    displayBlue("\t- PETITE-AMIE : Allo ?!");
                    displayPurple("\t- PERSONNAGE : Ma chérie, c'est moi!");
                    displayPurple("    Comment va tu?");
                    displayBlue("\t- PETITE-AMIE : Mal, tu me manque terriblement... Je m'inquiete pour toi tu sais...");
                    displayPurple("\t- PERSONNAGE : Je m'en doute... J'en peut plus, il me faut de l'argent pour m'acheter à manger. T'aurai quelque chose a m'envoyer?");
                    displayBlue("\t- PETITE-AMIE : Oui! Je peut t'envoyer " + earnedMoney + " mais pas plus");
                    displayPurple("\t- PERSONNAGE : Merci pour ton soutient !! Je t'aime...");
                }
                else{
                    earnedMoney = 0;
                    displayBlue("\t- PETITE-AMIE : Allo ?!");
                    displayPurple("\t- PERSONNAGE : Ma chérie, c'est moi!");
                    displayPurple("    Comment va tu?");
                    displayBlue("\t- PETITE-AMIE : Mal, tu me manque terriblement... Je m'inquiete pour toi tu sais...");
                    displayPurple("\t- PERSONNAGE : Je m'en doute... J'en peut plus, il me faut de l'argent pour m'acheter à manger. T'aurai quelque chose a m'envoyer?");
                    displayBlue("\t- PETITE-AMIE : Non, il ne me reste plus rien... Je suis désolé");
                    displayPurple("\t- PERSONNAGE : Merci quand même! Je t'aime...");                    
                }
                break;
            default : 
                earnedMoney = 0;
                displayBlue("Le téléphone sonne, mais personne ne répond...");
                break;
        }
        
        displayContinue();
        displayBlue("Vous avez gagné " + earnedMoney + "$ aujourd'hui.");
        c.addMoney(earnedMoney);
        displayContinue();
    }
    
}
