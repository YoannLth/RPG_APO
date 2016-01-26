package rpg_apo;

import java.util.Random;
import static rpg_apo.Characteristic.*;

public class Attack implements Capacity {
    // An attack is composed of a source, a target and an execution message
    private Character source;
    private Character cible;
    private String displayedMessage;
    
    // Constructor
    public Attack(Character s, Character c){
        this.source=s;
        this.cible=c;
        this.displayedMessage = "";
    }
    
    // Function who return the effect of the attack
    @Override
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
        succesProbability = probaSuccess();
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
    
    // Function who return the probability of the attack success
    @Override
    public double probaSuccess(){
        // 70% of basic success + character dexterity
        // 90% max
        double basicProbability = 70.0;
        int characterDexterity = 0;
        characterDexterity = source.getCharacteristicValue(DEXTERITY);
        
        basicProbability = basicProbability + characterDexterity;
        
        if(basicProbability < 90.0){
            basicProbability = 90.0;
        }
        else{}
                
        return basicProbability;        
    }

    @Override
    // Function for attack effect displaying
    public String readCapacity() {
        String readCap = "'attaque'";
        
        return readCap;
    }

    @Override
    // Function who return the string for attack effect displaying
    public String getDisplayMessage() {
        return this.displayedMessage;
    }


    
    
}