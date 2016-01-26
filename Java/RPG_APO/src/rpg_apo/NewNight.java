/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg_apo;

import static java.lang.System.exit;
import java.util.ArrayList;
import view.Console;
import static view.Console.displayBlack;
import static view.Console.displayContinue;
import static view.Console.displayRed;

/**
 *
 * @author Yoann
 */
public class NewNight extends Event{
    private Character playableCharacter;
    
    public NewNight(Character playCharacter){
        this.playableCharacter = playCharacter;
    }
    
    @Override
    public void display() {
       displayBlack("*Nouvelle nuit dans votre cellule*");
        
       displayScript();
        
       displayBlack("*La nuit se termine maintenant, vous vous rendez dans la cours*");
       displayContinue();
    }
    
    public void displayScript(){
        displayRed("Que voulez vous faire?");
        displayBlack("\t 1. Gérer son inventaire");
        displayBlack("\t 2. Voir état du joueur");
        displayBlack("\t 3. S'échapper avec Jese et Hector");
        displayBlack("\t 4. Dormir");
        
        int answer = ControlerUI.readInt("Choisissez une activité :", 1, 4);
        
        switch(answer){
            case 1 :
                DisplayUI.getInventaryActionChoice(playableCharacter);
                Console.displayContinue();
                displayScript();
                break;
            case 2 :
                playableCharacter.getPlayerInfos();
                Console.displayContinue();
                displayScript();
                break;
            case 3 :
                checkEscapePossibility();
                Console.displayContinue();
                displayScript();
                break;
            case 4 :
                break;
        }          
    }
    
    public void checkEscapePossibility(){
        if(playableCharacter.getMoney() > 1000){
            outro();
            exit(0);
        }
        else{
            displayRed("Pas assez d'argent pour le moment, réessayez plus tard!");
        }
    }
    
    public void outro(){
        displayBlack("Il est maintenant l'heure pour vous de partir. ");
        displayBlack("Apres avoir passé l'intégralité de la somme demandée par votre voisin de cellule celui-ci vous ");
        displayBlack("indique qu'il doit contacter son complice et vous fait patienter quelques jours de plus en vous demandant d'être discret.");
        displayBlack("Vous passez vos journées au travail pénitencier ou à appeller votre famille.");
        displayContinue();
        displayBlack("Cinq jours plus tard HECTOR vous previent que  l'évasion est prévue pour la nuit du lendemin. Il vous prévient qu'une fois sorti de ");
        displayBlack("prison il faudra vous debrouiller.");
        displayContinue();
        displayBlack("C'est maintenant le jour \"J\". Vous n'avez pas réussi à dormir la nuit passée, et avez tant bien que mal essayé");
        displayBlack("de vous reposer pendant la journé pour être en forme.");
        displayBlack("Une fois seul dans la cellule, Hector vous demande de tendre un drap blanc devant celle-ci pour vous cacher de l'exterieur.");
        displayBlack("Septique, cet acte est en effet mal vu par les autres prisoniers pouvant s'induirent en erreur. ");
        displayContinue();
        displayBlack("Une fois à l'abri des regards Hector vous montre qu'il est possible de dévisser le lavabo afin de casser le mur se trouvant derrière");
        displayBlack("donnant sur une galerie. ");
        displayBlack("Intimidé, vous n'hésitez pas longtemps avant de le suivre danc ce couloir. ");
        displayContinue();
        displayBlack("Au bout, vous appercevez une fenêtre donnant sur l'exterieur. Malheureusement vous êtes au cinquième étages de la prison; il est impossible d'envisager de sauter.");
        displayBlack("Hector vous regarde est vous dit de patienter encore quelques instant jusqu'à \"l'annonce du signal\".");
        displayContinue();
        displayBlack("\"BOOOM\" ");
        displayContinue();
        displayBlack("Vous ne voyez rien mais entendez une énorme explosion qui vient sûrement de l'autre côté de la prison.");
        displayBlack("Sans attendre, Hector saisit une corde que vous n'aviez pas vue, l'accroche pour descendre. ");
        displayContinue();
        displayBlack("Abasourdi, vous mettez quelques secondes à vous resaisir avant de suivre Hector.");
        displayBlack("Arrivé en bas, celui-ci vous attend au pied du mur et vous fait signe de vous dêchécher. ");
        displayContinue();
        displayBlack("Vous êtes hors des murs de la prison et vous courez au plus vite vers les bois les plus proches.");
        displayBlack("En effet, Hector avait un second complice qui devait vous attendre quelques kilometres plus loin.");
        displayContinue();
        displayBlack("Quelque jours après vous entendez à la radio que l'explosion devant la prison était une voiture piégée.");
        displayBlack("Cette diversion a empêché la police de réagir rapidement ce qui vous a permi de prendre une longueur d'avance.");
        displayBlack("");
    }
}
