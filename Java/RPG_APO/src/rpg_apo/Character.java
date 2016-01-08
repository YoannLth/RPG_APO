package rpg_apo;

import java.util.Map;
import static view.Console.*;

public class Character {

	private String name;
	private int level;
	private Map<Characteristic, Integer> characs;
	private Map<Item, Integer> inventary;
	private Weapon activeWeapon;
	private Map<Armor, Integer> activeArmors;
        private String className;
        private String characterDescription;
        
        public Character(String nameCharacter, String className, String characterDescription){
            this.name = nameCharacter;
            this.level = 0;
            this.characs = null;
            this.inventary = null;
            this.activeWeapon = null;
            this.activeArmors = null;
            this.className = className;
            this.characterDescription = characterDescription;
        }
        
	public void increaseLvl() {
		// TODO - implement Character.increaseLvl
		throw new UnsupportedOperationException();
	}

	public void modifyCharacteristics() {
		// TODO - implement Character.modifyCharacteristics
		throw new UnsupportedOperationException();
	}

	public void checkMaximumCharacteristics() {
		// TODO - implement Character.checkMaximumCharacteristics
		throw new UnsupportedOperationException();
	}

	public void addInventary() {
		// TODO - implement Character.addInventary
		throw new UnsupportedOperationException();
	}

	public void deleteInventary() {
		// TODO - implement Character.deleteInventary
		throw new UnsupportedOperationException();
	}

	public void activateWeapon() {
		// TODO - implement Character.activateWeapon
		throw new UnsupportedOperationException();
	}

	public void activateArmor() {
		// TODO - implement Character.activateArmor
		throw new UnsupportedOperationException();
	}

	public void useItem() {
		// TODO - implement Character.useItem
		throw new UnsupportedOperationException();
	}

	public void useConsumableItem() {
		// TODO - implement Character.useConsumableItem
		throw new UnsupportedOperationException();
	}
        
        public void afficherInfosTest(){
            displayBlue("Bonjour je m'appele " + this.name + ".");
        }

        public String getClassName(){
            String res = this.className;
            return res;
        }

        public String getClassDesc(){
            String res = this.characterDescription;
            return res;
        }
}