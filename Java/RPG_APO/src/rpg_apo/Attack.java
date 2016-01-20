package rpg_apo;

import java.util.Random;
import static rpg_apo.Characteristic.*;
import static view.Console.*;

public class Attack implements Capacity {
    private Character source;
    private Character cible;
    private String displayedMessage;
    
    public Attack(Character s, Character c ){
        this.source=s;
        this.cible=c;
        this.displayedMessage = "";
    }
    
    public Effect effect(){
        Effect e;
        double succesProbability = 0.0;
        double randomNumber = 0.0;
        int characterStrength;
        Weapon characterEquipedWeampon;
        int characterWeaponDamage;
        int opponentDefence;
        
        characterStrength = source.getCharacteristicValue(STRENGTH);
        characterEquipedWeampon = source.getActiveWeapon();
        characterWeaponDamage = characterEquipedWeampon.getDamage();
        succesProbability = probaReussite();
        opponentDefence = cible.getCharacteristicValue(DEFENCE);
        
        
        Random rand = new Random();
        randomNumber = (100.0 - 0.0) * rand.nextDouble();
        
        if(randomNumber <= succesProbability){
            Characteristic c = HEALTH;
            int value = (characterStrength + characterWeaponDamage) - opponentDefence;
            
            if(value<0){
                value = 0;
                displayedMessage = source.getName() + " tente d'attaquer " + cible.getName() + " mais il n'est pas assez fort, l'ennemie ne subit aucun dégat!";
            }
            else{
                displayedMessage = source.getName() + " attaque " + cible.getName() + " , l'ennemie pert " + value + " points de vie!";
                value = -value;
            }
            int permanent = 0;
            
            value = value * 10;
            e = new Effect(c,value,permanent);
        }
        else{
            Characteristic c = HEALTH;
            int value = 0;
            int permanent = 0;
            displayedMessage = source.getName() + " tente d'attaquer " + cible.getName() + " mais l'attaque échoue, l'ennemie ne subit aucun dégat!";
            
            e = new Effect(c,value,permanent);
        }
        
        return e;
    }
    
    public double probaReussite(){
        // 70% de réussite de base + dexterité
        // 90% max
        double probaR = 70.0;
        int characterDexterity = 0;
        characterDexterity = source.getCharacteristicValue(DEXTERITY);
        
        probaR = probaR + characterDexterity;
        
        if(probaR < 90.0){
            probaR = 90.0;
        }
        else{}
                
        return probaR;        
    }

    @Override
    public String readCapacity() {
        String readCap = "'attaque'";
        
        return readCap;
    }

    @Override
    public String getDisplayMessage() {
        return this.displayedMessage;
    }


    
    
}