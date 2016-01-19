package rpg_apo;

import java.util.Map;
import static rpg_apo.ControlerUI.readInt;
import static view.Console.displayRed;

public class MaleNurse extends Character {

    private int weightMax;
    private Map<Characteristic, Integer> characsMax;
    private int MAX_POINT=75;
    
    private int MAX_HEALTH = 50;
    private int MAX_DEFENCE = 10;
    private int MAX_STRENGTH = 10;
    private int MAX_DEXTERITY = 25;
    
    public MaleNurse(String nameCharacter,CharacterType charT) {
        super(nameCharacter,"Infirmier", "Vous êtes un Infirmier. Vous savez comment maintenir votre santé au plus haut. Vous avez plus de chance de rester en bonne santé. \nSanté fortement augmenté",charT);    
        setMax(this.MAX_HEALTH,this.MAX_DEFENCE,this.MAX_STRENGTH,this.MAX_DEXTERITY, this.MAX_POINT);
        initMaleNurseInventary(); 
    }

        
//        int str,dex,health,def;
//        int pointAttribuer=0;
//        displayRed("En tant qu'infirmier vous disposé de "+this.MAX_POINT+" points a répartir sur vos 4 characateristique");
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