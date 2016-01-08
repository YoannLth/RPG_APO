/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rpg_apo;

import java.util.Scanner;
import static view.Console.*;

public class NewPlayer extends Event {
    Character playableCharacter;
    
    public NewPlayer(String message){
        super(message);
    }
    
    public void display(){
        displayBlack(message);
        displayRed("Entrez votre nom :");
        Scanner scanner = new Scanner(System.in);
        String pCharacterName = scanner.nextLine();
        displayBlack("Ok " + pCharacterName + ". Qu'est-ce que tu faisait avant d'arriver ici?");
        displayRed("Choisissez une classe :");
        displayBlack("1 - Boxeur");
        displayBlack("2 - Infirmier");
        displayBlack("3 - Intellectuel");
        
        String answer = scanner.nextLine();
        int pCharacterClass = Integer.parseInt(answer);
        switch (pCharacterClass){
                case 1:
                    playableCharacter = new Boxer(pCharacterName);
                    break;
                case 2:
                    playableCharacter = new MaleNurse(pCharacterName);
                    break;
                case 3:
                    playableCharacter = new Highbrow(pCharacterName);
                    break;
        }
        displayRed(playableCharacter.getClassDesc());
        clearConsole();
        
        
        String className = playableCharacter.getClassName();
        switch (className){
                case "Boxeur":
                    displayBlack("- J'était boxeur, champion de France poids lourd");
                    displayBlack("  On m'a choppé avec 1 kilo de Cocaïne");
                    displayBlack("  Une blessure m'a tout fait arreté. J'avait aucune rentrée d'argent depuis 5 mois. Je pensait que c'était un coup facile");
                    lineBreak();
                    displayBlue("- Moi c'est Hector, lui le grand, c'est Jese, mon frère.");
                    displayBlue("  On a quelque emmerdes avec des mecs du bloc C");
                    displayBlue("  Si tu assure mes arrières le temps qu'il s'en remette, on te le revaudra.");
                    lineBreak();
                    displayRed("Vous acceptez d'aider Hector, votre premier contact avec vos compagnons de cellule c'est bien passé");
                    break;
                case "Infirmier":
                    displayBlack("- Heuuuu.... Je... J'était infirmier en France...");
                    displayBlack("  On m'a choppé avec 1 kilo de Cocaïne");
                    displayBlack("  Je voulais juste me faire un peu d'argent, mon boulot ne paye pas très bien...");
                    lineBreak();
                    displayBlue("- Moi c'est Hector, lui le grand, c'est Jese, mon frère.");
                    displayBlue("  Tu tombe bien, Jese c'est fait planté hier pendant la promenade.");
                    displayBlue("  Si tu veut qu'on reste ami, commence par le soigner");
                    lineBreak();
                    displayRed("Vous soignez Jese, votre premier contact avec vos compagnons de cellule c'est plutôt bien passé");
                    break;
                case "Intellectuel":
                    displayBlack("- Heuuuu.... Je... J'était étudiant en Psychologie...");
                    displayBlack("  J'ai esseyé de passer l'aéroport avec 1 kilo de Cocaïne");
                    displayBlack("  Je voulais juste me faire un peu d'argent, pour rembourser mon prêt étudiant...");
                    lineBreak();
                    displayBlue("- Ho ho ho... Monsieur l'étudiant en Psychologie... Sache que t'es pas le bienvenue ici.");
                    displayBlue("  Le lit de libre il est a nous, ta place a toi elle est par terre");
                    lineBreak();
                    displayRed("Vous soignez Jese, votre premier contact avec vos compagnons de cellule c'est plutôt bien passé");
                    break;
            }
    }    
}
