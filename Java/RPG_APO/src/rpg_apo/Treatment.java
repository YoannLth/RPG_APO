package rpg_apo;

import java.util.Random;
import static rpg_apo.Characteristic.*;

public class Treatment implements Capacity {
    private Character source;
    private Character cible;
    private String displayedMessage;
    
    public Treatment(Character s, Character t){
        this.cible = t;
        this.source = s;
        this.displayedMessage = "";
    }
    
    @Override
    public Effect effect() {
        Effect e;
        double succesProbability = 0.0;
        double randomNumber = 0.0;

        int targetHealth;
        
        succesProbability = probaSuccess();
        targetHealth = cible.getCharacteristicValue(HEALTH);
        
        
        Random rand = new Random(); 
        randomNumber = (100.0 - 0.0) * rand.nextDouble();
        
        if(randomNumber <= succesProbability){
            Characteristic c = HEALTH;
            int value = (targetHealth * 25) / 100;
            
            if( (value + cible.getMaxHealth()) > cible.getMaxHealth() ){
                value = cible.getMaxHealth() - targetHealth;
                if(value ==0){
                displayedMessage = source.getName() + " tente d'utiliser 'soin' sur " + cible.getName() + " , mais sa santé est au maximum!";
                }
                else{
                    displayedMessage = source.getName() + " tente d'utiliser 'soin' sur " + cible.getName() + " , mais sa santé est presque au maximum," + cible.getName() + " gagne seulement " + value + " points de vie!";
                }
            }
            else{
                displayedMessage = source.getName() + " utilise 'soin' sur " + cible.getName() + " , " + cible.getName() + " gagne " + value + " points de vie!";
            }
            
            int permanent = 0;
            e = new Effect(c,value,permanent);
        }
        else{
            Characteristic c = HEALTH;
            int value = 0;
            int permanent = 0;
            displayedMessage = source.getName() + " tente d'utiliser 'soin' sur " + cible.getName() + " , mais cela échoue!";
 
            e = new Effect(c,value,permanent);
        }
        
        return e;
    }

    @Override
    public double probaSuccess() {
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
        String readCap = "'soin'";
        
        return readCap;
    }

    @Override
    public String getDisplayMessage() {
        return this.displayedMessage;
    }
}