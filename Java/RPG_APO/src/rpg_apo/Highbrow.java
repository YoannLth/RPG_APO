package rpg_apo;

public class Highbrow extends Character {
    // A Highbrow is an extension of a character, caracterised by :
    private int weightMax; // Maximum of inventary weight
    private int DEFENCE_MAX = 30; // Max defence
    private int STRENGTH_MAX = 30; // Max strength
    private int DEXTERITY_MAX = 40; // Max dexterity
    
    // Constructor of the boxer
    public Highbrow(String nameCharacter,CharacterType charT) {
        super(nameCharacter,"Intellectuel", "Vous êtes un Intellectuel. Votre intelligence vous pousse instinctivement a vous entourez des bonnes personnes pour vous survivre. \nAucun bonus pour le moment",charT);    
        initHighbrowInventary(); 
    }
    
    @Override
    // Overrided function called when the character win a level (Characteristics will up differently if function of character class)
    public void upLvl(){
        super.upLvlFromInt(1);
        int newDefence = 1;
        int newStrength = 1;
        int newDexterity = 2;
        
        super.upCharacteristic(Characteristic.DEFENCE, newDefence, DEFENCE_MAX);
        super.upCharacteristic(Characteristic.STRENGTH, newStrength, STRENGTH_MAX);
        super.upCharacteristic(Characteristic.DEXTERITY, newDexterity, DEXTERITY_MAX);
    };
    
    // Initialize the highbrow basic inventary
    private void initHighbrowInventary()
    {
        Weapon startWeapon = new Weapon("Mains nues", 0, 10, 10, "Combat a main nues");
        super.addInventary(startWeapon, 1);
        
        Armor startArmor = new Armor("Gants tactique",1, 2, "Gants en tissus qui protège les mains");
        super.addInventary(startArmor, 1);
        
        super.activeWeapon = startWeapon;
        super.activeArmors.add(startArmor);
    }
    
    @Override
    // Function who initialize character with purcentage of max characteristics in function of choosen difficulty
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