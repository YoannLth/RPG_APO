package rpg_apo;

import java.util.Map;

public class Highbrow extends Character {

	private int weightMax;
	private Map<Characteristic, Integer> characsMax;

    public Highbrow(String nameCharacter,CharacterType charT) {
        super(nameCharacter,"Intellectuel", "Vous êtes un Intellectuel. Votre intelligence vous pousse instinctivement a vous entourez des bonnes personnes pour vous survivre. \nAucun bonus pour le moment",charT);    
    }

	public void calculateMaximumCharacteristics() {
		// TODO - implement Highbrow.calculateMaximumCharacteristics
		throw new UnsupportedOperationException();
	}

}