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
    }

}