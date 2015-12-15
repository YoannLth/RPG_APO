package rpg_apo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static view.Console.*;

public class Character {

	private String name;
	private int level;
	private Map<Characteristic, Integer> characs;
	private List<Item> inventary;
	private Weapon activeWeapon;
	private Map<Armor, Integer> activeArmors;
        private String className;
        private String characterDescription;
        private CharacterType charType;
        
        public Character(String nameCharacter, String className, String characterDescription, CharacterType charT){
            this.name = nameCharacter;
            this.level = 0;
            this.characs = new HashMap();
            this.inventary = null;
            this.activeWeapon = null;
            this.activeArmors = new HashMap();
            this.className = className;
            this.characterDescription = characterDescription;
            this.charType = charT;
        }
        
	public int increaseLvl(int lvl) {
		// TODO - implement Character.increaseLvl
		//throw new UnsupportedOperationException();
                return lvl+1;
	}
        
        public int getLvl(){
            return this.level;
        }
        

	public void modifyCharacteristics() {
		// TODO - implement Character.modifyCharacteristics
		throw new UnsupportedOperationException();
	}

	public void checkMaximumCharacteristics() {
		// TODO - implement Character.checkMaximumCharacteristics
		throw new UnsupportedOperationException();
	}
        
        //Ajout d'un Item dans l'inventaire
	public void addInventary(Item i) {
		// TODO - implement Character.addInventary
                this.inventary.add(i);
	}

	public void deleteInventary(Item i) {
		// TODO - implement Character.deleteInventary
                this.inventary.remove(i);
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

        public String getClassName(){
            String res = this.className;
            return res;
        }

        public String getClassDesc(){
            String res = this.characterDescription;
            return res;
        }
        
        
        
        
        
        //Return vrai si l'item appartient a l'inventaire
        public boolean itemIsInInventary(Item i){
            return this.inventary.contains(i);
        }
        
        //retourne le poid de notre inventaire
        public int getWeightInventary(){
            int somme=0;
            
            for(Item i : inventary){
                somme = i.getWeight() + somme;
            }
            return somme;
        }
        
        //Affiche chaque nom d'item de l'inventaire
        public void afficherInventary(){
            for(Item i : inventary){
                displayBlack("\n"+i.getName());
            }
        }
        
        
        public void setCharacteristics(Map<Characteristic, Integer> c){
            this.characs = c;
        }
       
        public Map<Characteristic, Integer> getCharacteristics(){
            return this.characs;
        }
        

        public void setInventary(List<Item> invent){
            
        }
        
        public List<Item> getInventary(){
            return this.inventary;
        }
        
        public void setActiveWeapon(Weapon w){
            this.activeWeapon = w;
        }
        
        public Weapon getActiveWeapon(){
            return this.activeWeapon;
        }

        public void setActiveArmors(Map<Armor, Integer> activeArmrs){
            this.activeArmors = activeArmrs;
        }
        
        public Map<Armor, Integer> getActiveArmors(){
            return this.activeArmors;
        }
        
        public String testGetInfos(){
            String res = this.name + " , le " + this.className;
            
            return res;
        }
        
        public String getName(){
            return this.name;
        }
}