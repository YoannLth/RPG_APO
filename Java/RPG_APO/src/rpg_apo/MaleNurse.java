package rpg_apo;

import java.util.Map;
import static rpg_apo.ControlerUI.readInt;
import static view.Console.displayRed;

public class MaleNurse extends Character {

    private int weightMax;
    private Map<Characteristic, Integer> characsMax;
    
    private int DEFENCE_MAX = 40;
    private int STRENGTH_MAX = 30;
    private int DEXTERITY_MAX = 30;
    
    public MaleNurse(String nameCharacter,CharacterType charT) {
        super(nameCharacter,"Infirmier", "Vous êtes un Infirmier. Vous savez comment maintenir votre santé au plus haut. Vous avez plus de chance de rester en bonne santé. \nSanté fortement augmenté",charT);    
//        setMax(this.MAX_DEFENCE,this.MAX_STRENGTH,this.MAX_DEXTERITY);
        initMaleNurseInventary(); 
    }


    public void upLvl(){
        super.upLvlFromInt(1);
        int newDefence = 2;
        int newStrength = 1;
        int newDexterity = 1;
        
        super.upCharacteristic(Characteristic.DEFENCE, newDefence, DEFENCE_MAX);
        super.upCharacteristic(Characteristic.STRENGTH, newStrength, STRENGTH_MAX);
        super.upCharacteristic(Characteristic.DEXTERITY, newDexterity, DEXTERITY_MAX);
    };
    
    
    private void initMaleNurseInventary()
    {
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
    
    public void initCharacteristics(int difficulty) {
        switch(difficulty){
            case 1:
                super.initCharacteristic((((STRENGTH_MAX)/10)*3), (((DEXTERITY_MAX)/10)*3), super.getMaxHealth(), (((DEFENCE_MAX)/10)*3));
                break;
            case 2:
                super.initCharacteristic((((STRENGTH_MAX)/10)*6), (((DEXTERITY_MAX)/10)*6), super.getMaxHealth(), (((DEFENCE_MAX)/10)*6));
                break;
            case 3:
                super.initCharacteristic(STRENGTH_MAX, DEXTERITY_MAX, super.getMaxHealth(), DEFENCE_MAX);
                break;    
            default:
                super.initCharacteristic(STRENGTH_MAX, DEXTERITY_MAX, super.getMaxHealth(), DEFENCE_MAX);
                break;
        }
    }
        
}