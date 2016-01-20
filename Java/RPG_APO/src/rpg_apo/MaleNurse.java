package rpg_apo;

import java.util.Map;
import static rpg_apo.ControlerUI.readInt;
import static view.Console.displayRed;

public class MaleNurse extends Character {

    private int weightMax;
    private Map<Characteristic, Integer> characsMax;
    
    private int MAX_DEFENCE = 30;
    private int MAX_STRENGTH = 10;
    private int MAX_DEXTERITY = 30;
    
    public MaleNurse(String nameCharacter,CharacterType charT) {
        super(nameCharacter,"Infirmier", "Vous êtes un Infirmier. Vous savez comment maintenir votre santé au plus haut. Vous avez plus de chance de rester en bonne santé. \nSanté fortement augmenté",charT);    
        setMax(this.MAX_DEFENCE,this.MAX_STRENGTH,this.MAX_DEXTERITY);
        initMaleNurseInventary(); 
    }


    private void initMaleNurseInventary()
    {
        Item money = new Item("Dollars", 0, "Argent à dépenser");
        super.addInventary(money, 10);
        
        Weapon startWeapon = new Weapon("Mains nues", 0, 10, 10, "Combat a main nues");
        super.addInventary(startWeapon, 1);
        
        Armor startArmor = new Armor("Gants ",1, 2, "Gants en tissus qui protège les mains");
        super.addInventary(startArmor, 1);
        
        Item cafeine = new Item("Caféine", 1, new Effect(Characteristic.DEFENCE, 10,1), "Objet consomable qui augmente la force pour la durée du combat");
        super.addInventary(cafeine, 1);
        
        super.activeWeapon = startWeapon;
        super.activeArmors.add(startArmor);
    }    
    
    public void calculateMaximumCharacteristics() {
            // TODO - implement MaleNurse.calculateMaximumCharacteristics
            throw new UnsupportedOperationException();
    }
        
}