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
        this.initBoxerInventary();
        //int str,dex,health,def;
        //int pointAttribuer=0;
//        displayRed("En tant que boxeur vous disposé de "+this.MAX_POINT+" points a répartir sur vos 4 characateristique");
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
        //On pourrai ajouter ici un bonus de force ici 
        //initCharacteristic(str+5,dex,3*health,def);
    }
    
    private void initBoxerInventary()
    {
        Item money = new Item("Dollars", 0, "Argent à dépenser");
        super.addInventary(money, 10);
        
        Weapon startWeapon = new Weapon("Mains nues", 0, 10, 10, "Combat a main nues");
        super.addInventary(startWeapon, 1);
        
        Armor startArmor = new Armor("Bandes de boxe",1, 2, "Bandes en tissus qui protège les mains");
        super.addInventary(startArmor, 1);
        
        ConsumableItem cafeine = new ConsumableItem("Caféine", 1, Characteristic.DEFENCE, 10, "Objet consomable qui augmente la force pour la durée du combat", 1);
        super.addInventary(cafeine, 1);
        
        super.activeWeapon = startWeapon;
        super.activeArmors.add(startArmor);
    }
    
}