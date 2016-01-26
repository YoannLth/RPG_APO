package rpg_apo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static rpg_apo.Characteristic.*;
import static rpg_apo.ControlerUI.readInt;
import view.Console;
import static view.Console.*;

public class Character  {

    protected String name;
    protected int level;
    protected Map<Characteristic, Integer> characs;
    protected Map<Item, Integer> inventary;
    protected Weapon activeWeapon;
    protected ArrayList<Armor> activeArmors;
    protected String className;
    protected String characterDescription;
    protected CharacterType charType;
    protected Controler characterControler;
    protected int life;
    protected int money;

    protected int MAX_POINT=50;


    public Character(String nameCharacter, String className, String characterDescription, CharacterType charT){
        this.name = nameCharacter;
        this.level = 1;
        this.characs = new HashMap();
        this.inventary = new HashMap();
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

    public void setLvl(int i){
        this.level=i;
    }

    public int getLvl(){
        return this.level;
    }

    public void upLvlFromInt(int val){
        this.level = level + val;
    };
    
    public void upLvl(){
        displayBlue("" + this.getName() + " augmente d'un niveau!");
        displayContinue();
    };

    public void modifyCharacteristics() {
            // TODO - implement Character.modifyCharacteristics
            throw new UnsupportedOperationException();
    }

    public void checkMaximumCharacteristics() {
            // TODO - implement Character.checkMaximumCharacteristics
            throw new UnsupportedOperationException();
    }

    //Ajout d'un Item dans l'inventaire
    public void addInventary(Item i, int quant) {
            // TODO - implement Character.addInventary
            if(this.inventary.containsKey(i)){
                int quantity = this.inventary.get(i);
                quantity = quantity + quant;
                this.inventary.replace(i, quantity);
            }
            else{
                this.inventary.put(i, quant);
            }
    }

    public void deleteInventary(Item i) {
            // TODO - implement Character.deleteInventary
            this.inventary.remove(i);
    }

    public void activateWeapon() {
            // TODO - implement Character.activateWeapon
            throw new UnsupportedOperationException();
    }

    public void activateArmor() {
            // TODO - implement Character.activateArmor
            throw new UnsupportedOperationException();
    }

    public void useItem() {
            // TODO - implement Character.useItem
            throw new UnsupportedOperationException();
    }

    public void useConsumableItem() {
            // TODO - implement Character.useConsumableItem
            throw new UnsupportedOperationException();
    }

    public String getClassName(){
        String res = this.className;
        return res;
    }

    public String getClassDesc(){
        String res = this.characterDescription;
        return res;
    }





    //Return vrai si l'item appartient a l'inventaire
    public boolean itemIsInInventary(Item i){
        return this.inventary.containsKey(i);
    }

    //retourne le poid de notre inventaire
    public int getWeightInventary(){
        int somme=0;

        for(Map.Entry<Item, Integer> item : inventary.entrySet()){
            int itemWeight = item.getKey().getWeight() * item.getValue();
            somme = itemWeight + somme;
        }
        return somme;
    }

    //Affiche chaque nom d'item de l'inventaire
    public void afficherInventary(){
        for(Map.Entry<Item, Integer> item : inventary.entrySet()){
            displayBlack("\t" + item.getKey().getName() + " x" + item.getValue());
        }
    }



    

    public void setCharacteristics(Map<Characteristic, Integer> c){
        this.characs = c;
    }

    public Map<Characteristic, Integer> getCharacteristics(){
        return this.characs;
    }

    public Map<Item, Integer> getInventary(){
        return this.inventary;
    }

    public void setActiveWeapon(Weapon w){
        this.activeWeapon = w;
    }

    public Weapon getActiveWeapon(){
        return this.activeWeapon;
    }

    public void setActiveArmors(ArrayList<Armor> activeArmrs){
        this.activeArmors = activeArmrs;
    }

    public ArrayList<Armor> getActiveArmors(){
        return this.activeArmors;
    }

    public String testGetInfos(){
        String res = this.name + " , le " + this.className;

        return res;
    }

    public String getName(){
        return this.name;
    }

    public int getHealth(){
        return characs.get(HEALTH);
    }

    public Controler getControler(){
        return this.characterControler;
    }

//    public void initCharacterPlayer(){
//        int pointRestant=0;
//        int str, def, dex;
//        str = 0;
//        def = 0;
//        dex = 0;
//        displayBlue("Vous disposé de "+this.MAX_POINT+" points a répartir sur vos 3 characateristique");
//        pointRestant=this.MAX_POINT;
//        while(pointRestant>0){
//            str = ControlerUI.readInt("\tSTRENGTH : (max = "+this.MAX_STR+") : ",1,this.MAX_STR);
//            pointRestant=this.MAX_POINT - str;
//            if(pointRestant == 0){
//                break;
//            }
//            else{
//                dex = ControlerUI.readInt("\tDEXTERITY : (max = "+this.MAX_DEX+") : ",1,pointRestant);
//                pointRestant=pointRestant - dex;
//            }
//            if(pointRestant == 0){
//                break;
//            }
//            else{
//                def = ControlerUI.readInt("\tDEFENCE : (max = "+this.MAX_DEF+") : ",1,pointRestant);
//                pointRestant=pointRestant - dex;
//            }
//        }
//        initCharacteristic(str,dex,getMaxHealth(),def);
//    }
    
    public void initCharacteristic(int s, int d, int h, int def)
    {
        this.characs = new HashMap();
        this.characs.put(Characteristic.STRENGTH, s);
        this.characs.put(Characteristic.DEXTERITY, d);
        this.characs.put(Characteristic.HEALTH, this.getMaxHealth());
        this.characs.put(Characteristic.DEFENCE, def);
    }
    
    public int getCharacteristicValue(Characteristic c){
        return this.characs.get(c);
    }
    
//    public void setMax(int def,int str,int dext){
//        this.MAX_DEF=def;
//        this.MAX_STR=str;
//        this.MAX_DEX=dext;
//    }
    
    public int getMaxHealth(){
        return 200+this.level*3;
    }
    
    public void setMaxHealth(){
        int maxLife = getMaxHealth();
        this.characs.replace(HEALTH, maxLife);
    }
    
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
   
    public void addMoney(int i){
        this.money+=i;
    }
    
    
    //Initialisaton d'un personnage ennemie appellé boss caracteristique max
//    public void initCharacteristicBoss(){
//        initCharacteristic(this.MAX_STR, this.MAX_DEX, this.MAX_HEALTH, this.MAX_DEF);
//    }
    
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
    
    public void alterCharacteristic(Characteristic characteristicToAlter, int valueAlteration){
        int characteristicValue = characs.get(characteristicToAlter);
        characteristicValue = characteristicValue + valueAlteration;
        
        characs.replace(characteristicToAlter, characteristicValue);
    }
    
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

    
    public void initCharacteristics(int difficulty){
        
    };
    
    public int getMoney(){
        return this.money;
    }
    
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

    
    public Weapon getWeapon(){
        return this.activeWeapon;
    }
    
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
    
    public void deleteItem(Item i){
        int numberOfOccurenceItem = inventary.get(i);
        
        if(numberOfOccurenceItem > 1){
            inventary.replace(i, (numberOfOccurenceItem-1));
            displayBlue("Un exemplaire de l'objet à été supprimé!");
        }
        else{
            inventary.remove(i);
            displayBlue("L'objet à été supprimé de l'inventaire!");
        }
    }
    
    public String getArmorsInfos(){
        String res = "";
        
        for(int i=0;i<this.activeArmors.size();i++){
            res = res + activeArmors.get(i).getItemInfos();
            res = res + " / ";
        }
        
        return res;
    }
    
    public String getWeaponInfos(){
        String res = "";
        
        res = res + activeWeapon.getName() + "(" + activeWeapon.getDamage() + ")";
        
        return res;
    }
}



