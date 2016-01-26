package rpg_apo;

import java.util.ArrayList;
import java.util.Map;
import static view.Console.displayBlack;
import static view.Console.displayBlue;
import static view.Console.displayRed;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yoann
 */
public class DisplayUI  {
    public static int getAction(Character character)
    {
        int maxAction = 2;

        displayBlue(character.getName()+" vous avez les possibilité suivantes : ");
        displayBlack("\t 1. Utiliser une capacité");
        displayBlack("\t 2. Utiliser un item");
        
        int choice = ControlerUI.readInt("Selectionner une action : ", 1, maxAction);
        return choice;
    }
    
    public static int getCapacity(Character character)
    {
        int maxCapacity = 3;

        displayBlue(character.getName()+" vous avez les possibilité suivantes : ");
        displayBlack("\t 1. Utiliser 'Attaque'");
        displayBlack("\t 2. Utiliser 'Défense'");
        displayBlack("\t 3. Utiliser 'Soin'");
        
        int choice = ControlerUI.readInt("Selectionner une capacité : ", 1, maxCapacity);
        return choice;
    }
    
    public static Character getOpponent(ArrayList<Character> opponents){
        int maxPlayer = opponents.size();
        
        displayBlue("Selectionner une cible : ");
        
        for(int i=0;i<opponents.size();i++){
            displayBlack("\t " + (i+1) + "." + opponents.get(i).getNameAndInfos());
        }
        
        int choice = ControlerUI.readInt("Entrez un nombre entre 1 et " + maxPlayer, 1, maxPlayer);
        Character target = opponents.get((choice-1));
        return target;
    }
    
    public static Character getPartner(ArrayList<Character> partners){
        int maxPlayer = partners.size();
        
        displayBlue("Selectionner un partenaire :");
        
        for(int i=0;i<partners.size();i++){
            displayBlack("\t " + (i+1) + "." + partners.get(i).getName());
        }
        
        int choice = ControlerUI.readInt("Entrez un nombre entre 1 et " + maxPlayer, 1, maxPlayer);
        Character target = partners.get((choice-1));
        return target;
    }
    
    public static ConsumableItem getConsomableItem(Character character){
        Map<Item, Integer> inv = character.getInventory();
        ArrayList<ConsumableItem> availableItems = new ArrayList<ConsumableItem>();
        
        
        displayRed("Selectionner un objet à utiliser :");
        
        for(Map.Entry<Item, Integer> item : inv.entrySet()){
            if(item.getKey().getClass() == ConsumableItem.class){
                availableItems.add((ConsumableItem) item.getKey());
            }
            else{
                
            }
        }
        
        int maxItem = availableItems.size();
        
        if(maxItem == 0){
            return null;
        }
        
        else{
            for(int i=0; i<availableItems.size();i++){
            displayBlack("\t" + (i+1) + "." + availableItems.get(i).getItemInfos() + " x " + inv.get(availableItems.get(i)));
            }

            int choice = ControlerUI.readInt("Entrez un nombre entre 1 et " + maxItem, 1, maxItem);
            ConsumableItem choosenItem = availableItems.get((choice-1));
            return choosenItem;
        }
        
    }
    
    public static void getInventaryActionChoice(Character character){
        int maxChoice = 4;
        
        displayBlue("Selectionner une actop :");
        
        displayBlue("Vous avez les possibilité suivantes : ");
        displayBlack("\t 1. Equiper armure");
        displayBlack("\t 2. Equiper arme");
        displayBlack("\t 3. Supprimer un objet");
        displayBlack("\t 4. Quitter la gestion de l'inventaire");
        
        int choice = ControlerUI.readInt("Entrez un nombre entre 1 et " + maxChoice, 1, maxChoice);
        
        switch(choice){
            case 1 :
                Armor a = DisplayUI.getArmors(character);
                if(a == null){
                    displayBlue("PAS D'ARMURES DISPONIBLES");
                }
                else{
                    character.equipArmor(a);
                }
                getInventaryActionChoice(character);
                break;
            case 2 :
                Weapon w = DisplayUI.getWeapons(character);
                if(w == null){
                    displayBlue("PAS D'ARMES DISPONIBLES");
                }
                else{
                    character.equipWeapon(w);
                }
                getInventaryActionChoice(character);
                break;
            case 3 :
                Item i = DisplayUI.getItem(character);
                if(i == null){
                    displayBlue("PAS D'ITEMS DISPONIBLES");
                }
                else{
                    character.deleteItem(i);
                }
                getInventaryActionChoice(character);
                break;
            case 4 :
                break;
        }
    }
    
    public static Armor getArmors(Character character){
        
        Map<Item, Integer> inv = character.getInventory();
        ArrayList<Armor> availableArmors = new ArrayList<Armor>();
        
        
        displayRed("Selectionner un objet à utiliser :");
        
        for(Map.Entry<Item, Integer> item : inv.entrySet()){
            if(item.getKey().getClass() == Armor.class){
                availableArmors.add((Armor) item.getKey());
            }
            else{
                
            }
        }
        
        int maxItem = availableArmors.size();
        
        if(maxItem == 0){
            return null;
        }
        else{
            for(int i=0; i<availableArmors.size();i++){
            displayBlack("\t" + (i+1) + "." + availableArmors.get(i).getItemInfos() + " x " + inv.get(availableArmors.get(i)));
            }

            int choice = ControlerUI.readInt("Entrez un nombre entre 1 et " + maxItem, 1, maxItem);
            Armor choosenArmor = availableArmors.get((choice-1));
            return choosenArmor;
        }
    }
    
    public static int getActiveArmors(Character character){
        ArrayList<Armor> activeArmors = character.getActiveArmors();
        
        displayRed("Selectionner une armure à remplacer :");
        
        int maxArmors = activeArmors.size();

            for(int i=0; i<activeArmors.size();i++){
            displayBlack("\t" + (i+1) + "." + activeArmors.get(i).getItemInfos());
            }

            int choice = ControlerUI.readInt("Entrez un nombre entre 1 et " + maxArmors, 1, maxArmors);
            return choice;
    }
    
    public static Weapon getWeapons(Character character){
        Map<Item, Integer> inv = character.getInventory();
        Weapon activeWeapon = character.getWeapon();
        ArrayList<Weapon> availableWeapons = new ArrayList<Weapon>();
        
        
        displayRed("Selectionner une arme à équiper :");
        
        for(Map.Entry<Item, Integer> item : inv.entrySet()){
            if(item.getKey().getClass() == Weapon.class){
                availableWeapons.add((Weapon) item.getKey());
            }
            else{
                
            }
        }
        
        int maxItem = availableWeapons.size();
        
        if(maxItem == 0){
            return null;
        }
        else{
            for(int i=0; i<availableWeapons.size();i++){
            displayBlack("\t" + (i+1) + "." + availableWeapons.get(i).getItemInfos() + " x " + inv.get(availableWeapons.get(i)));
            }

            int choice = ControlerUI.readInt("Entrez un nombre entre 1 et " + maxItem, 1, maxItem);
            Weapon choosenWeapon = availableWeapons.get((choice-1));
            return choosenWeapon;
        }
    }
    
    public static Item getItem(Character character){
       Map<Item, Integer> inv = character.getInventory();
       ArrayList<Item> availableItems = new ArrayList<Item>();
        
        
       displayRed("Selectionner un item à supprimers :");
        
        for(Map.Entry<Item, Integer> item : inv.entrySet()){
                availableItems.add(item.getKey());
        }
        
        int maxItem = availableItems.size();
        
        if(maxItem == 0){
            return null;
        }
        else{
            for(int i=0; i<availableItems.size();i++){
            displayBlack("\t" + (i+1) + "." + availableItems.get(i).getItemInfos() + " x " + inv.get(availableItems.get(i)));
            }

            int choice = ControlerUI.readInt("Entrez un nombre entre 1 et " + maxItem, 1, maxItem);
            Item choosenItem = availableItems.get((choice-1));
            return choosenItem;
        }        
    }
}
