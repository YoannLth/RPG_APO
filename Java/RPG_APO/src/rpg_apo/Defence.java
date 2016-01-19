package rpg_apo;

import java.util.Random;
import static rpg_apo.Characteristic.*;

public class Defence implements Capacity {
    private Character source;
    private Character cible;
    private String displayedMessage;
    
    public Defence(Character s){
        this.source = s;
        this.displayedMessage = "";
    }
    
    @Override
    public Effect effect() {
        Effect e;
        double succesProbability = 0.0;
        double randomNumber = 0.0;
        int characterDefence;
        
        characterDefence = source.getCharacteristicValue(DEFENCE );
        succesProbability = probaReussite();
                
        Random rand = new Random();
        randomNumber = (100.0 - 0.0) * rand.nextDouble();
        
        if(randomNumber <= succesProbability){
            Characteristic c = DEFENCE;
            int value = 1 + ((characterDefence * 20)/100);
            displayedMessage = source.getName() + " utilise sa capacité 'défense', " + source.getName() + " gagne " + value + " points de défense!";
            
            int permanent = 0;
            
            e = new Effect(c,value,permanent);
        }
        else{
            Characteristic c = DEFENCE;
            int value = 0;
            int permanent = 0;
            displayedMessage = source.getName() + " tente d'utiliser sa capacité 'défense', mais cela échoue!";
            
            e = new Effect(c,value,permanent);
        }
        
        return e;
    }

    @Override
    public double probaReussite() {
        // 70% de réussite de base + défense
        // 90% max
        double probaR = 70.0;
        int characterDefence = 0;
        characterDefence = source.getCharacteristicValue(DEFENCE);
        
        probaR = probaR + characterDefence;
        
        if(probaR < 90.0){
            probaR = 90.0;
        }
        else{}
                
        return probaR;
    }

    @Override
    public String readCapacity() {
        String readCap = "'défense'";
        
        return readCap;
    }

    @Override
    public String getDisplayMessage() {
        return this.displayedMessage;
    }
    
}