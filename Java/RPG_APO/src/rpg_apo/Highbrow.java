package rpg_apo;

import java.util.Map;
import static rpg_apo.ControlerUI.readInt;
import static view.Console.displayRed;

public class Highbrow extends Character {

    private int weightMax;
    private Map<Characteristic, Integer> characsMax;
    private int MAX_POINT=75;
    
    private int MAX_HEALTH = 35;
    private int MAX_DEFENCE = 10;
    private int MAX_STRENGTH = 5;
    private int MAX_DEXTERITY = 35;
    
    public Highbrow(String nameCharacter,CharacterType charT) {
        super(nameCharacter,"Intellectuel", "Vous êtes un Intellectuel. Votre intelligence vous pousse instinctivement a vous entourez des bonnes personnes pour vous survivre. \nAucun bonus pour le moment",charT);    
        setMax(this.MAX_HEALTH,this.MAX_DEFENCE,this.MAX_STRENGTH,this.MAX_DEXTERITY, this.MAX_POINT);
    }
    

}