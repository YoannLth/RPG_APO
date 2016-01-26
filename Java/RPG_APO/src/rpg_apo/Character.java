package rpg_apo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static rpg_apo.Characteristic.*;
import view.Console;
import static view.Console.*;

public class Character  {
    // A character is composed by :
    protected String name; // name
    protected int level; // level of the character
    protected Map<Characteristic, Integer> characs; // characteristics
    protected Map<Item, Integer> inventory; // inventory of the character
    protected Weapon activeWeapon; // Weapon equiped
    protected ArrayList<Armor> activeArmors; // Armors equiped
    protected String className; // Class name (for text display, class name for displaying is different of class name, we display for exemple "boxeur", not "Boxer")
    protected String characterDescription; // Character description (class description)
    protected CharacterType charType; // Character type (IA or HUMAN) -> Enumeration
    protected Controler characterControler; // Controller of the character
    protected int MAX_POINT=50; //Max point of the character (not used now but conserved for project stability)
    protected int life; // Life 
    protected int money; // Money of the character

    // Constructor of the character (never called directly)
    public Character(String nameCharacter, String className, String characterDescription, CharacterType charT){
        this.name = nameCharacter;
        this.level = 1;
        this.characs = new HashMap();
        this.inventory = new HashMap();
        this.activeWeapon = null;
        this.activeArmors = new ArrayList<Armor>();
        this.className = className;
        this.characterDescription = characterDescription;
        this.charType = charT;

        switch(charType)
        {
            case HUMAN :
                this.characterControler = new HumanControler(this);
                break;
            case IA :
                this.characterControler = new IAControler(this);
                break;
        }
    }

    // Function who up the level by a value in parameters
    public void upLvlFromInt(int val){
        this.level = level + val;
    };
    
    // Function who display message on level up
    public void upLvl(){
        displayBlue("" + this.getName() + " augmente d'un niveau!");
        displayContinue();
    };

    // Function who add an object to inventory
    public void addInventary(Item i, int quant) {
            // TODO - implement Character.addInventary
            if(this.inventory.containsKey(i)){
                int quantity = this.inventory.get(i);
                quantity = quantity + quant;
                this.inventory.replace(i, quantity);
            }
            else{
                this.inventory.put(i, quant);
            }
    }

    // Function who delete an object from inventory
    public void deleteInventary(Item i) {
            this.inventory.remove(i);
    }

    // Function who return the class name
    public String getClassName(){
        String res = this.className;
        return res;
    }

    // Function who return the class description
    public String getClassDesc(){
        String res = this.characterDescription;
        return res;
    }

    //Return vrai si l'item appartient a l'inventaire
    public boolean itemIsInInventary(Item i){
        return this.inventory.containsKey(i);
    }

    //retourne le poid de notre inventaire
    public int getWeightInventary(){
        int somme=0;

        for(Map.Entry<Item, Integer> item : inventory.entrySet()){
            int itemWeight = item.getKey().getWeight() * item.getValue();
            somme = itemWeight + somme;
        }
        return somme;
    }

    // Function who display inventory content and number of items
    public void afficherInventary(){
        for(Map.Entry<Item, Integer> item : inventory.entrySet()){
            displayBlack("\t" + item.getKey().getName() + " x" + item.getValue());
        }
    }

    // Function for set characteristics of the character
    public void setCharacteristics(Map<Characteristic, Integer> c){
        this.characs = c;
    }

    // Function who return characteristics of the character
    public Map<Characteristic, Integer> getCharacteristics(){
        return this.characs;
    }

    // Function who return the inventory of the character
    public Map<Item, Integer> getInventory(){
        return this.inventory;
    }

    // Function who set the active weapon
    public void setActiveWeapon(Weapon w){
        this.activeWeapon = w;
    }

    // Function who return the active weapon
    public Weapon getActiveWeapon(){
        return this.activeWeapon;
    }

    // Function who set active armors
    public void setActiveArmors(ArrayList<Armor> activeArmrs){
        this.activeArmors = activeArmrs;
    }

    // Function who return active armors
    public ArrayList<Armor> getActiveArmors(){
        return this.activeArmors;
    }

    // Function who return the name of the character
    public String getName(){
        return this.name;
    }

    // Function who return the health of the character
    public int getHealth(){
        return characs.get(HEALTH);
    }

    // Function who return the controller of the character
    public Controler getControler(){
        return this.characterControler;
    }

    // Function who init characterstics
    public void initCharacteristic(int s, int d, int h, int def)
    {
        this.characs = new HashMap();
        this.characs.put(Characteristic.STRENGTH, s);
        this.characs.put(Characteristic.DEXTERITY, d);
        this.characs.put(Characteristic.HEALTH, this.getMaxHealth());
        this.characs.put(Characteristic.DEFENCE, def);
    }
    
    // Function who return the value of a characteristics passed in parameter
    public int getCharacteristicValue(Characteristic c){
        return this.characs.get(c);
    }
    
    // Function who return the maximum health of the character, based on character level
    public int getMaxHealth(){
        return 200+this.level*3;
    }
    
    // Function who set the maximum health of the character, based on character level
    public void setMaxHealth(){
        int maxLife = getMaxHealth();
        this.characs.replace(HEALTH, maxLife);
    }
    
    // Function who display character characteristic (called on night and only for the PJ)
    public void getPlayerInfos(){
        Console.displayBlue("--------------------------------"+this.name+"----------------------------------");
        Console.displayBlue("\n\tNiveau : "+this.level);
        Console.displayBlue("\n\tSanté : "+getCharacteristicValue(HEALTH)+"/"+this.getMaxHealth());
        Console.displayBlue("\n\tForce : "+getCharacteristicValue(STRENGTH));
        Console.displayBlue("\n\tDéfense : "+getCharacteristicValue(DEFENCE));
        Console.displayBlue("\n\tDexterité : "+getCharacteristicValue(DEXTERITY));
        Console.displayBlue("--------------------------------------");
        Console.displayBlue("\n\tPoids inventaire: "+getWeightInventary());
        Console.displayBlue("\n\tArgent: "+ getMoney() + "€");
        Console.displayBlue("\n\tArmures : "+getArmorsInfos());
        Console.displayBlue("\n\tArme : "+getWeaponInfos());
    }
    
    // Function who return infos about the character (called during fights)
    public String getNameAndInfos(){
        String infos = "";
        
        if(this.isAlive()){
            infos = this.getName() + " ( Santé : " + characs.get(HEALTH)+" sur "+ this.getMaxHealth() + "/ Defense : " + characs.get(DEFENCE) + "/ Force : " + characs.get(STRENGTH) + "/ Dexterité : " + characs.get(DEXTERITY) + ")";
        }
        else{
            infos = this.getName() + " (Viens juste de tomber KO)";
        }
        return infos;
    }
   
    // Function to add money to the player
    public void addMoney(int i){
        this.money+=i;
    }

    // Function who test if a character is always OK (not KO)
    public boolean isAlive(){
        boolean isAlive = true;
        int health = getCharacteristicValue(HEALTH);
        
        if(health < 1){
            isAlive = false;
        }
        else{
            isAlive = true;
        }
        
        return isAlive;
    }
    
    // Function to alter a characteristics passed in parameter
    public void alterCharacteristic(Characteristic characteristicToAlter, int valueAlteration){
        int characteristicValue = characs.get(characteristicToAlter);
        characteristicValue = characteristicValue + valueAlteration;
        
        characs.replace(characteristicToAlter, characteristicValue);
    }
    
    // Function to alter a characteristics passed in parameter and test if value is not overrided
    public void upCharacteristic(Characteristic characteristicToAlter, int upValue, int maxValueCharacteristic){
        int characteristicValue = characs.get(characteristicToAlter);
        
        characteristicValue = characteristicValue + upValue;
        if(characteristicValue < maxValueCharacteristic){
            //characs.replace(characteristicToAlter, characteristicValue);
            characs.remove(characteristicToAlter);
            characs.put(characteristicToAlter, characteristicValue);
            displayBlue(this.name + " augmente sa " + characteristicToAlter.name() + " de " + upValue + "!");
        }
        else{
            characteristicValue = maxValueCharacteristic;
            characs.remove(characteristicToAlter);
            characs.put(characteristicToAlter, characteristicValue);
            displayBlue(this.name + " a atteind le palier maximum pour sa " + characteristicToAlter.name() + "!");
        }
        
    }

    // Overrided
    public void initCharacteristics(int difficulty){
        
    };
    
    // Function who return character money
    public int getMoney(){
        return this.money;
    }
    
    // Function called when armor is going to be equiped
    public void equipArmor(Armor a){
        displayGreen("" + activeArmors.size());
        if(activeArmors.size() < 2){
            displayBlue("Armure équipée! (" + a.getName() + ")");
            activeArmors.add(a);
            deleteItem(a);
        }
        else{
            displayBlue("Plus de places");
            int choice = DisplayUI.getActiveArmors(this);
            activeArmors.remove((choice-1));
            equipArmor(a);
        }
    }

    // Function who return active weapon
    public Weapon getWeapon(){
        return this.activeWeapon;
    }
    
    // Function called on weapon equiping
    public void equipWeapon(Weapon w){
        displayBlue("Armure équipée!" + w.getItemInfos());
        
        if(activeWeapon ==  null){
            activeWeapon = w;
        }
        else{
            Weapon currentWeapon = activeWeapon;
            addInventary(currentWeapon, 1);
            
            activeWeapon = w;
            
            deleteItem(w);
        }
    }
    
    // Function who delete an item and display a message
    public void deleteItem(Item i){
        int numberOfOccurenceItem = inventory.get(i);
        
        if(numberOfOccurenceItem > 1){
            inventory.replace(i, (numberOfOccurenceItem-1));
            displayBlue("Un exemplaire de l'objet à été supprimé!");
        }
        else{
            inventory.remove(i);
            displayBlue("L'objet à été supprimé de l'inventaire!");
        }
    }
    
    // Function who return armor infos
    public String getArmorsInfos(){
        String res = "";
        
        for(int i=0;i<this.activeArmors.size();i++){
            res = res + activeArmors.get(i).getItemInfos();
            res = res + " / ";
        }
        
        return res;
    }
    
    // Function who return weapon infos 
    public String getWeaponInfos(){
        String res = "";
        
        res = res + activeWeapon.getName() + "(" + activeWeapon.getDamage() + ")";
        
        return res;
    }
}



