package rpg_apo;

import java.util.Map;

public class Boxer extends Character {

    private int weightMax;
    private Map<Characteristic, Integer> characsMax;

    public Boxer(String nameCharacter) {
        super(nameCharacter,"Boxeur", "Vous êtes un boxeur, poids lourd. Vous corpulence, vos marques sur le visage et vos tatouages vous donne l'air agressif. Votre puissance vous accorde un bonus de Force.");    
    }

    public void calculateMaximumCharacteristics() {
    	// TODO - implement Boxer.calculateMaximumCharacteristics
	throw new UnsupportedOperationException();
    }
    
    
}