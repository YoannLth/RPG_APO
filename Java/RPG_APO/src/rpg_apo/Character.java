package rpg_apo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static rpg_apo.Characteristic.*;
import static rpg_apo.ControlerUI.readInt;
import static view.Console.*;

public class Character {

<<<<<<< HEAD
    private String name;
    protected int level;
    protected Map<Characteristic, Integer> characs;
    private List<Item> inventary;
    private Weapon activeWeapon;
    private Map<Armor, Integer> activeArmors;
    private String className;
    private String characterDescription;
    private CharacterType charType;
    private Controler characterControler;
    private int life;
    
    protected int MAX_STR;
    protected int MAX_DEF;
    protected int MAX_DEX;
    protected int MAX_HEALTH;
    protected int MAX_POINT;
=======
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


>>>>>>> e0ac102e2f4fab213ee54bd18502e796f556ed3e
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
            somme = item.getKey().getWeight() + somme;
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
<<<<<<< HEAD


    public void initCharacterPlayer(){
        int pointAttribuer=0;
        int str, def, health, dex;
        displayRed("Vous disposé de "+this.MAX_POINT+" points a répartir sur vos 4 characateristique");
        str = readInt("STRENGTH : (max = "+this.MAX_STR+") : ",1,this.MAX_STR);
        dex = readInt("DEXTERITY : (max = "+this.MAX_DEX+") : ",1,this.MAX_DEX);
        health = readInt("HEALTH : (max = "+this.MAX_HEALTH+") : 3*",1,this.MAX_HEALTH);
        def = readInt("DEFENCE : (max = "+this.MAX_DEF+") : ",1,this.MAX_DEF);
        pointAttribuer=str+dex+health+def;
        while(pointAttribuer!=this.MAX_POINT){
            displayRed("Il vous reste "+(this.MAX_POINT-pointAttribuer)+"points a attribuer");
            str = readInt("STRENGTH : (max = "+this.MAX_STR+", actuel = "+str+") : ",1,this.MAX_STR);
            dex = readInt("DEXTERITY : (max = "+this.MAX_DEX+", actuel = "+dex+") : ",1,this.MAX_DEX);
            health = readInt("HEALTH : (max = "+this.MAX_HEALTH+", actuel = "+health+") : 3*",1,this.MAX_HEALTH);
            def = readInt("DEFENCE : (max = "+this.MAX_DEF+", actuel = "+def+") : ",1,this.MAX_DEF);
            pointAttribuer=str+dex+health+def;
        }
        initCharacteristic(str,dex,health,def);
    }
=======
>>>>>>> e0ac102e2f4fab213ee54bd18502e796f556ed3e
    
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
    
<<<<<<< HEAD
    public void setMax(int health,int def,int str,int dext, int point){
        this.MAX_HEALTH=health;
        this.MAX_DEF=def;
        this.MAX_STR=str;
        this.MAX_DEX=dext;
        this.MAX_POINT=point;
    }
    
    public String putCaracteristics(){
=======
    public String getNameAndInfos(){
        String infos = "";
        
        if(this.isAlive()){
            infos = this.getName() + " ( Santé : " + characs.get(HEALTH)+" sur "+this.life + "/ Defence : " + characs.get(DEFENCE) + "/ Force : " + characs.get(STRENGTH) + "/ Dexterité : " + characs.get(DEXTERITY) + ")";
        }
        else{
            infos = this.getName() + " (Viens juste de mourir)";
        }
        return infos;
    }
    
    public String afficherCaracteristiques(){
>>>>>>> e0ac102e2f4fab213ee54bd18502e796f556ed3e
        String s;
        s="--------------------------------Caracteristic de "+this.name+"----------------------------------";
        s+="\n\tLevel : "+this.level;
        s=s+"\n\tHEALTH : "+getCharacteristicValue(HEALTH)+"/"+this.life;
        s=s+"\n\tSTRENGTH : "+getCharacteristicValue(STRENGTH);
        s=s+"\n\tDEFENCE : "+getCharacteristicValue(DEFENCE);
        s=s+"\n\tDEXTERITY : "+getCharacteristicValue(DEXTERITY);
        return s;
    }
    
<<<<<<< HEAD
    public void increaseLvl() {
        this.level++;
        this.characs.put(Characteristic.STRENGTH, (this.characs.get(Characteristic.STRENGTH)+(this.MAX_STR/5)));
        this.characs.put(Characteristic.DEXTERITY, this.characs.get(Characteristic.DEXTERITY)+(this.MAX_DEX/5));
        this.characs.put(Characteristic.HEALTH, this.characs.get(Characteristic.HEALTH)+(this.MAX_HEALTH/5));
        this.characs.put(Characteristic.DEFENCE, this.characs.get(Characteristic.DEFENCE)+(this.MAX_DEF/5));
    }
    
    //Initialisaton d'un personnage ennemie appellé boss caracteristique max
    public void initCharacteristicBoss(){
        initCharacteristic(this.MAX_STR, this.MAX_DEX, this.MAX_HEALTH, this.MAX_DEF);
    }
    
=======
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
>>>>>>> e0ac102e2f4fab213ee54bd18502e796f556ed3e
}



