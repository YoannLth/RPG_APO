package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yoann
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import rpg_apo.Armor;
import rpg_apo.Boxer;
import rpg_apo.Highbrow;
import rpg_apo.MaleNurse;
import rpg_apo.NewAnswer;
import rpg_apo.NewMessage;
import rpg_apo.NewDialog;
import rpg_apo.NewMenu;
import rpg_apo.Character;
import rpg_apo.CharacterTeam;
import rpg_apo.CharacterType;
import rpg_apo.Characteristic; 
import rpg_apo.ConsumableItem;
import rpg_apo.Event;
import rpg_apo.Item;
import rpg_apo.NewFight;
import rpg_apo.NewPlayer;
import rpg_apo.Weapon;
import static view.Console.*;

public class Game {
    private String gameName;
    
    private ArrayList<Character> team1;
    private ArrayList<Character> team2;
    
    private Character playableCharacter;
    
    private Map<Integer, Event> introGame;
    private Map<Integer, Event> introContext;
    private Map<Integer, Event> newPlayableCharacter;
    private Map<Integer, Map<Integer, Event>> events_game;
    
    private Map<Integer, Event>  introPremierJour;
    
    private ArrayList<CharacterTeam> ennemies;
    private ArrayList<Item> itemsGame;
    private CharacterTeam playerTeam;
    
    public Game(String name){
        gameName = name;
        events_game = new HashMap();
        introGame = new HashMap();
        introContext = new HashMap();
        newPlayableCharacter = new HashMap();
        ennemies = new ArrayList<CharacterTeam>();
        playerTeam = null;
        itemsGame = new ArrayList<Item>();
    }
    
    public void launchGame(){
        initializeEvents();
        readEvents();
        
        testCombat();
    }
    
    public void initializeEvents(){

        Map<Integer, String> introGameMessage = new HashMap();
        Map<Integer, String> introContextMessage = new HashMap();
        Map<Integer, String> characterInitialisationMessage = new HashMap();
        
        introGameMessage.put(1,"Bonjour et bienvenue dans " + gameName + "\nLa partie commence");
        NewDialog introGame1 = new NewDialog(introGameMessage);
        introGame.put(1, introGame1);
        
        
        //Affichage du script qui introduit le contexte du jeu
        introContextMessage.put(1,"Vous etes partis au Pérou en voyage et avez esseyé de faire passer de la drogue en revennant. Vous vous faites chopper. Direction la Prison");
        NewDialog introContext1 = new NewDialog(introContextMessage); 
        introContext.put(1, introContext1);
     
        //Affichage du script pour initialiser le personnage (en fonction des choix du joueur)
        //characterInitialisationMessage.put(1, "Une fois dans votre cellule, un homme vous interpelle... \nQui est tu?");
        //NewDialog characterInitialisationMessage1 = new NewDialog(characterInitialisationMessage);
        NewPlayer mainCharacterInitialisation = new NewPlayer(); 
        //this.newPlayableCharacter.put(1, characterInitialisationMessage1);
        this.newPlayableCharacter.put(1, mainCharacterInitialisation);
        
      
        
        events_game.put(1, introGame);
        events_game.put(2, introContext);
        events_game.put(3, newPlayableCharacter);
    }
    
    public void readEvents(){
        
        int sizeEvents = events_game.size();
        
        for(int i=1;i<=sizeEvents;i++){
            Map<Integer, Event> currentEvent = events_game.get(i);
            
            int currentEventSize = currentEvent.size();
            
            for(int j=1;j<=currentEventSize;j++){
                Event a = currentEvent.get(j);
                a.display();
            }
        }
    }
    
    
    public void testInitialiseObjets(){
        
    }
    
    
    public void testCombat(){
        team1 = new ArrayList<Character>();
        team2 = new ArrayList<Character>();
        
        //Initialise les caracteristique basique 100 10 10 10
        Map<Characteristic, Integer> c = new HashMap();
        c.put(Characteristic.HEALTH, 100);
        c.put(Characteristic.DEFENCE, 10);
        c.put(Characteristic.DEXTERITY, 10);
        c.put(Characteristic.STRENGTH, 10);
        
        //Initialise les équipe avec nom est CharactereType
        Character c1a = new Boxer("Combatant_1_t1",CharacterType.HUMAN);
        Character c1b = new MaleNurse("Combatant_2_t1",CharacterType.HUMAN);
        //Character c1c = new Highbrow("Combatant_3_t1",CharacterType.HUMAN);
        
        Character c2a = new Boxer("Combatant_1_t2",CharacterType.IA);
        Character c2b = new MaleNurse("Combatant_2_t2",CharacterType.IA);
        //Character c2c = new Highbrow("Combatant_3_t2",CharacterType.HUMAN);
        
        c1a.initCharacteristic(110, 100, 100, 10);
        c1b.initCharacteristic(110, 100, 100, 10);
        //c1c.initCharacteristic(10, 10, 100, 10);
        
        c2a.initCharacteristic(10, 10, 100, 1);
        c2b.initCharacteristic(10, 10, 100, 1);
        //c2c.initCharacteristic(10, 10, 100, 1);
        
        team1.add(c1a);
        team1.add(c1b);
        //team1.add(c1c);
        
        team2.add(c2a);
        team2.add(c2b);
        //team2.add(c2c);
        
        NewFight fightTest = new NewFight(team1,team2);
        fightTest.display();
        
        NewFight fightTest2 = new NewFight(team1,team2);
        fightTest2.display();
    }
    
    public void initializeGameObjects(){
        ConsumableItem growthHormone = new ConsumableItem("Hormone de croissance", 1, Characteristic.STRENGTH, 10, "hormones qui augmente la force temporairement de 10 points");
        ConsumableItem creatin = new ConsumableItem("Créatine", 2, Characteristic.STRENGTH, 20, "substance qui augmente la force temporairement de 20 points");
        ConsumableItem steroid = new ConsumableItem("Stéroides", 3, Characteristic.STRENGTH, 30, "substance qui augmente la force temporairement de 30 points");
    
        ConsumableItem cafein = new ConsumableItem("Caféïne", 1, Characteristic.DEXTERITY, 10, "substance qui augmente la dexterité temporairement de 10 points");
        ConsumableItem ginseng = new ConsumableItem("Ginseng", 2, Characteristic.DEXTERITY, 20, "substance qui augmente la dexterité temporairement de 20 points");
        ConsumableItem taurine = new ConsumableItem("Taurine", 3, Characteristic.DEXTERITY, 30, "substance qui augmente la dexterité temporairement de 30 points");
        
        ConsumableItem miniAdrenaline = new ConsumableItem("Mini dose d'adrénaline", 1, Characteristic.HEALTH, 10, "substance qui augmente la santé de 25 points");
        ConsumableItem superAdrenaline = new ConsumableItem("Super dose d'adrénaline", 2, Characteristic.HEALTH, 20, "substance qui augmente la santé de 50 points");
        ConsumableItem maxiAdrenaline = new ConsumableItem("Maxi dose d'adrénaline", 3, Characteristic.HEALTH, 30, "substance qui augmente la force santé de 100 points");
        
        ConsumableItem vodka = new ConsumableItem("Shot de vodka", 1, Characteristic.DEFENCE, 10, "substance qui augmente votre résitance aux coups temporairement de 10 points");
        ConsumableItem cocaine = new ConsumableItem("Ligne de cocaïne", 2, Characteristic.DEFENCE, 20, "substance qui augmente la force temporairement de 20 points");
        ConsumableItem captagon = new ConsumableItem("Captagon", 3, Characteristic.DEFENCE, 30, "substance qui augmente la force temporairement de 30 points");
        
        Weapon razorBlade = new Weapon("Lame de rasoir", 4, 5, 60, "arme tranchante moyennement maniable qui inflige de faible dégats (5 points)");
        Weapon knuckle = new Weapon("Poing-Américain", 5, 10, 90, "arme extrèmement maniable qui inflige des dégats moyens (10 points)");
        Weapon knife = new Weapon("Couteau de chase", 6, 20, 90, "arme tranchante extrèmement maniable qui inflige de lourds dégats (20 points)");
        
        Armor foamGloves = new Armor("Gants avec renforts en mousse", 4, 5, "gants légers qui protègent faiblement le personnage");
        Armor plasticGloves = new Armor("Gants avec renforts en plastique", 5, 10, "gants qui protègent moyennement le personnage");
        Armor kevlarGloves = new Armor("Gants avec renforts en kevlar", 6, 20, "gants lourds qui protègent fortement le personnage");
        
        Armor foamTShirt = new Armor("Gants avec renforts en mousse", 4, 5, "t-shirt légers qui protègent faiblement le personnage");
        Armor plasticTShirt = new Armor("Gants avec renforts en plastique", 10, 5, "t-shirt lourds qui protègent moyennement le personnage");
        Armor kevlarTShirt = new Armor("Gants avec renforts en kevlar", 6, 20, "t-shirt lourds qui protègent fortement le personnage");
        
        itemsGame.add(growthHormone);
        itemsGame.add(creatin);
        itemsGame.add(steroid);
        itemsGame.add(cafein);
        itemsGame.add(ginseng);
        itemsGame.add(taurine);
        itemsGame.add(miniAdrenaline);
        itemsGame.add(superAdrenaline);
        itemsGame.add(maxiAdrenaline);
        itemsGame.add(vodka);
        itemsGame.add(cocaine);
        itemsGame.add(captagon);
        itemsGame.add(razorBlade);
        itemsGame.add(knuckle);
        itemsGame.add(knife);
        itemsGame.add(foamGloves);
        itemsGame.add(plasticGloves);
        itemsGame.add(kevlarGloves);
        itemsGame.add(foamTShirt);
        itemsGame.add(plasticTShirt);
        itemsGame.add(kevlarTShirt);

                
        ArrayList<Character> gang1Members = new ArrayList<Character>();
        ArrayList<Character> gang2Members = new ArrayList<Character>();
        ArrayList<Character> gang3Members = new ArrayList<Character>();
        
        Character piranha1 = new Boxer("Joaquin",CharacterType.IA);
        Character piranha2 = new Highbrow("Jesus",CharacterType.IA);
        Character piranha3 = new MaleNurse("Cesar",CharacterType.IA);
        piranha1.initCharacteristic(10, 40, 100, 10);
        piranha2.initCharacteristic(10, 40, 100, 10);
        piranha3.initCharacteristic(10, 40, 100, 10);
        gang1Members.add(piranha1);
        gang1Members.add(piranha2);
        gang1Members.add(piranha3);
        
        Character eme1 = new Boxer("Enrique",CharacterType.IA);
        Character eme2 = new Highbrow("Ricardo",CharacterType.IA);
        Character eme3 = new MaleNurse("Horacio",CharacterType.IA);
        eme1.initCharacteristic(20, 50, 125, 20);
        eme2.initCharacteristic(20, 50, 125, 20);
        eme3.initCharacteristic(20, 50, 125, 20);
        gang2Members.add(eme1);
        gang2Members.add(eme2);
        gang2Members.add(eme3);
        
        Character maras1 = new Boxer("Ramiro",CharacterType.IA);
        Character maras2 = new Highbrow("Diego",CharacterType.IA);
        Character maras3 = new MaleNurse("Juan-Carlos",CharacterType.IA);
        maras1.initCharacteristic(30, 60, 150, 30);
        maras2.initCharacteristic(30, 60, 150, 30);
        maras3.initCharacteristic(30, 60, 150, 30);
        gang3Members.add(maras1);
        gang3Members.add(maras1);
        gang3Members.add(maras1);
        
        ArrayList<Item> gang1Rewards = new ArrayList<Item>();
        ArrayList<Item> gang2Rewards = new ArrayList<Item>();
        ArrayList<Item> gang3Rewards = new ArrayList<Item>();
        
        gang1Rewards.add(growthHormone);
        gang2Rewards.add(creatin);
        gang3Rewards.add(steroid);
        gang1Rewards.add(cafein);
        gang2Rewards.add(ginseng);
        gang3Rewards.add(taurine);
        gang1Rewards.add(miniAdrenaline);
        gang2Rewards.add(superAdrenaline);
        gang3Rewards.add(maxiAdrenaline);
        gang1Rewards.add(vodka);
        gang2Rewards.add(cocaine);
        gang3Rewards.add(captagon);
        gang1Rewards.add(razorBlade);
        gang2Rewards.add(knuckle);
        gang3Rewards.add(knife);
        gang1Rewards.add(foamGloves);
        gang2Rewards.add(plasticGloves);
        gang3Rewards.add(kevlarGloves);
        gang1Rewards.add(foamTShirt);
        gang2Rewards.add(plasticTShirt);
        gang3Rewards.add(kevlarTShirt);
        
        
        CharacterTeam gang1 = new CharacterTeam("Gang des Piranhas de Lima", gang1Members, 1, gang1Rewards);
        CharacterTeam gang2 = new CharacterTeam("Gang de la Mara Salvatrucha", gang2Members, 2, gang2Rewards);
        CharacterTeam gang3 = new CharacterTeam("Gang de la eMe de Cuzco", gang3Members, 3, gang3Rewards);
        
        ennemies.add(gang1);
        ennemies.add(gang2);
        ennemies.add(gang3);
    }
}
