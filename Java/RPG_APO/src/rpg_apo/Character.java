package rpg_apo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static rpg_apo.Characteristic.*;
import static view.Console.*;

public class Character {

    private String name;
    private int level;
    private Map<Characteristic, Integer> characs;
    private List<Item> inventary;
    private Weapon activeWeapon;
    private Map<Armor, Integer> activeArmors;
    private String className;
    private String characterDescription;
    private CharacterType charType;
    private Controler characterControler;
    private int life;


    /*
    private Map<Characteristic, Integer> characsMaxB;
    private Map<Characteristic, Integer> characsMaxH;
    private Map<Characteristic, Integer> characsMaxN;
    private int MAX_POINTS_B = 100;
    private int MAX_POINTS_H = 100;
    private int MAX_POINTS_N = 100;
    */

    public Character(String nameCharacter, String className, String characterDescription, CharacterType charT){
        this.name = nameCharacter;
        this.level = 0;
        this.characs = new HashMap();
        this.inventary = null;
        this.activeWeapon = new Weapon("Mains nues", 0, 10, 100);
        this.activeArmors = new HashMap();
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

    public int increaseLvl(int lvl) {
            // TODO - implement Character.increaseLvl
            //throw new UnsupportedOperationException();
            return lvl+1;
    }

    public int getLvl(){
        return this.level;
    }


    public void modifyCharacteristics() {
            // TODO - implement Character.modifyCharacteristics
            throw new UnsupportedOperationException();
    }

    public void checkMaximumCharacteristics() {
            // TODO - implement Character.checkMaximumCharacteristics
            throw new UnsupportedOperationException();
    }

    //Ajout d'un Item dans l'inventaire
    public void addInventary(Item i) {
            // TODO - implement Character.addInventary
            this.inventary.add(i);
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
        return this.inventary.contains(i);
    }

    //retourne le poid de notre inventaire
    public int getWeightInventary(){
        int somme=0;

        for(Item i : inventary){
            somme = i.getWeight() + somme;
        }
        return somme;
    }

    //Affiche chaque nom d'item de l'inventaire
    public void afficherInventary(){
        for(Item i : inventary){
            displayBlack("\n"+i.getName());
        }
    }




    public void setCharacteristics(Map<Characteristic, Integer> c){
        this.characs = c;
    }

    public Map<Characteristic, Integer> getCharacteristics(){
        return this.characs;
    }


    public void setInventary(List<Item> invent){

    }

    public List<Item> getInventary(){
        return this.inventary;
    }

    public void setActiveWeapon(Weapon w){
        this.activeWeapon = w;
    }

    public Weapon getActiveWeapon(){
        return this.activeWeapon;
    }

    public void setActiveArmors(Map<Armor, Integer> activeArmrs){
        this.activeArmors = activeArmrs;
    }

    public Map<Armor, Integer> getActiveArmors(){
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



    
    
    public void initCharacteristic(int s, int d, int h, int def)
    {
        this.characs = new HashMap();
        this.characs.put(Characteristic.STRENGTH, s);
        this.characs.put(Characteristic.DEXTERITY, d);
        this.characs.put(Characteristic.HEALTH, h);
        this.characs.put(Characteristic.DEFENCE, def);
        this.life=h;
    }
    
    public int getCharacteristicValue(Characteristic c){
        return this.characs.get(c);
    }
    
    public String getNameAndInfos(){
        String infos = "";
        
        if(this.isAlive()){
            infos = this.getName() + " ( Santé : " + characs.get(HEALTH) + "/ Defence : " + characs.get(DEFENCE) + ")";
        }
        else{
            infos = this.getName() + " (Viens juste de mourir)";
        }
        return infos;
    }
    
    public String afficherCaracteristiques(){
        String s;
        s="--------------------------------Caracteristic de "+this.name+"----------------------------------";
        s+="\n\tLevel : "+this.level;
        s=s+"\n\tHEALTH : "+getCharacteristicValue(HEALTH)+"/"+this.life;
        s=s+"\n\tSTRENGTH : "+getCharacteristicValue(STRENGTH);
        s=s+"\n\tDEFENCE : "+getCharacteristicValue(DEFENCE);
        s=s+"\n\tDEXTERITY : "+getCharacteristicValue(DEXTERITY);
        return s;
    }
    
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
        
        characs.put(characteristicToAlter, characteristicValue);
    }
}
