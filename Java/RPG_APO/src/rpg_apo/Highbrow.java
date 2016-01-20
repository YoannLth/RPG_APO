package rpg_apo;

import java.util.Map;
import static rpg_apo.ControlerUI.readInt;
import static view.Console.displayRed;

public class Highbrow extends Character {

    private int weightMax;
    
    private int DEFENCE_MAX = 30;
    private int STRENGTH_MAX = 30;
    private int DEXTERITY_MAX = 40;
    
    public Highbrow(String nameCharacter,CharacterType charT) {
        super(nameCharacter,"Intellectuel", "Vous êtes un Intellectuel. Votre intelligence vous pousse instinctivement a vous entourez des bonnes personnes pour vous survivre. \nAucun bonus pour le moment",charT);    
//        setMax(this.MAX_DEFENCE,this.MAX_STRENGTH,this.MAX_DEXTERITY);
        initHighbrowInventary(); 
//        int str,dex,health,def;
//        int pointAttribuer=0;
//        displayRed("En tant qu'intellectuel vous disposé de "+this.MAX_POINT+" points a répartir sur vos 4 characateristique");
//        str = readInt("STRENGTH : (max = "+this.MAX_STRENGTH+") : ",1,this.MAX_STRENGTH);
//        dex = readInt("DEXTERITY : (max = "+this.MAX_DEXTERITY+") : ",1,this.MAX_DEXTERITY);
//        health = readInt("HEALTH : (max = "+this.MAX_HEALTH+") : 3*",1,this.MAX_HEALTH);
//        def = readInt("DEFENCE : (max = "+this.MAX_DEFENCE+") : ",1,this.MAX_DEFENCE);
//        pointAttribuer=str+dex+health+def;
//        while(pointAttribuer!=this.MAX_POINT){
//            displayRed("Il vous reste "+(this.MAX_POINT-pointAttribuer)+"points a attribuer");
//            str = readInt("STRENGTH : (max = "+this.MAX_STRENGTH+", actuel = "+str+") : ",1,this.MAX_STRENGTH);
//            dex = readInt("DEXTERITY : (max = "+this.MAX_DEXTERITY+", actuel = "+dex+") : ",1,this.MAX_DEXTERITY);
//            health = readInt("HEALTH : (max = "+this.MAX_HEALTH+", actuel = "+health+") : 3*",1,this.MAX_HEALTH);
//            def = readInt("DEFENCE : (max = "+this.MAX_DEFENCE+", actuel = "+def+") : ",1,this.MAX_DEFENCE);
//            pointAttribuer=str+dex+health+def;
//        }
//        //On pourrai ajouter ici un bonus de force ici 
//        initCharacteristic(str+5,dex,3*health,def);
    }
    
    public void upLvl(){
        super.upLvlFromInt(1);
        int newDefence = 1;
        int newStrength = 1;
        int newDexterity = 2;
        
        super.upCharacteristic(Characteristic.DEFENCE, newDefence, DEFENCE_MAX);
        super.upCharacteristic(Characteristic.STRENGTH, newStrength, STRENGTH_MAX);
        super.upCharacteristic(Characteristic.DEXTERITY, newDexterity, DEXTERITY_MAX);
    };
    
    private void initHighbrowInventary()
    {
        Weapon startWeapon = new Weapon("Mains nues", 0, 10, 10, "Combat a main nues");
        super.addInventary(startWeapon, 1);
        
        Armor startArmor = new Armor("Gants tactique",1, 2, "Gants en tissus qui protège les mains");
        super.addInventary(startArmor, 1);
        
        super.activeWeapon = startWeapon;
        super.activeArmors.add(startArmor);
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
    
    public void calculateMaximumCharacteristics() {
            // TODO - implement Highbrow.calculateMaximumCharacteristics
            throw new UnsupportedOperationException();
    }
    

}