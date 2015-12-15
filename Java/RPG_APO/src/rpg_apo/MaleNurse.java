package rpg_apo;

import java.util.Map;

public class MaleNurse extends Character {

	private int weightMax;
	private Map<Characteristic, Integer> characsMax;

    public MaleNurse(String nameCharacter,CharacterType charT) {
        super(nameCharacter,"Infirmier", "Vous êtes un Infirmier. Vous savez comment maintenir votre santé au plus haut. Vous avez plus de chance de rester en bonne santé. \nSanté fortement augmenté",charT);    
    }

	public void calculateMaximumCharacteristics() {
		// TODO - implement MaleNurse.calculateMaximumCharacteristics
		throw new UnsupportedOperationException();
	}

}