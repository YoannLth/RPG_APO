package rpg_apo;

import java.util.HashMap;
import java.util.Map;
import static rpg_apo.ControlerUI.readInt;
import static view.Console.displayRed;

public class Boxer extends Character {

    private int weightMax;
    private Map<Characteristic, Integer> characsMax;
    private int MAX_POINT=75;
    
    private int MAX_HEALTH = 50;
    private int MAX_DEFENCE = 25;
    private int MAX_STRENGTH = 25;
    private int MAX_DEXTERITY = 10;
    
            
            
    public Boxer(String nameCharacter,CharacterType charT) {
        super(nameCharacter,"Boxeur", "Vous êtes un boxeur, poids lourd. Vous corpulence, vos marques sur le visage et vos tatouages vous donne l'air agressif. Votre puissance vous accorde un bonus de Force.",charT);
        setMax(this.MAX_HEALTH,this.MAX_DEFENCE,this.MAX_STRENGTH,this.MAX_DEXTERITY, this.MAX_POINT);
    }

    
}