package rpg_apo;

public class Boxer extends Character  {
    // A Boxer is an extension of a character, caracterised by :
    private int weightMax; // Maximum of inventary weight
    private final int DEFENCE_MAX = 25; // Max defence
    private final int STRENGTH_MAX = 50; // Max strength
    private final int DEXTERITY_MAX = 25; // Max dexterity
    
            
    // Constructor of the boxer
    public Boxer(String nameCharacter,CharacterType charT) {
        super(nameCharacter,"Boxeur", "Vous êtes un boxeur, poids lourd. Vous corpulence, vos marques sur le visage et vos tatouages vous donne l'air agressif. Votre puissance vous accorde un bonus de Force.",charT);
        initBoxerInventary();
    }

    
    @Override
    // Overrided function called when the character win a level (Characteristics will up differently if function of character class)
    public void upLvl(){
        super.upLvlFromInt(1);
        super.upLvl();
        int newDefence = 1;
        int newStrength = 2;
        int newDexterity = 1;
        
        super.upCharacteristic(Characteristic.DEFENCE, newDefence, DEFENCE_MAX);
        super.upCharacteristic(Characteristic.STRENGTH, newStrength, STRENGTH_MAX);
        super.upCharacteristic(Characteristic.DEXTERITY, newDexterity, DEXTERITY_MAX);
    };

    // Initialize the boxer basic inventary
    private void initBoxerInventary(){
        Weapon startWeapon = new Weapon("Mains nues", 0, 10, 10, "Compétences de combat a main nues");
        super.addInventary(startWeapon, 1);
        
        Armor startArmor = new Armor("Bandes de boxe",1, 2, "Bandes en tissus qui protège les mains");
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