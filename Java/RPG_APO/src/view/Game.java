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
import java.util.HashMap;
import java.util.Map;
import rpg_apo.Boxer;
import rpg_apo.Highbrow;
import rpg_apo.MaleNurse;
import rpg_apo.NewAnswer;
import rpg_apo.NewMessage;
import rpg_apo.NewDialog;
import rpg_apo.NewMenu;
import rpg_apo.Character;
import rpg_apo.CharacterType;
import rpg_apo.Characteristic;
import rpg_apo.Event;
import rpg_apo.NewFight;
import rpg_apo.NewPlayer;
import static view.Console.*;

public class Game {
    private String gameName;
    
    private Map<Integer, Character> team1;
    private Map<Integer, Character> team2;
    
    private Character playableCharacter;
    
    private Map<Integer, Event> introGame;
    private Map<Integer, Event> introContext;
    private Map<Integer, Event> newPlayableCharacter;
    
    private Map<Integer, Map<Integer, Event>> events_game;
    
    public Game(String name){
        gameName = name;
        events_game = new HashMap();
    }
    
    public void launchGame(){
        //initializeEvents();
        //readEvents();
        testCombat();
    }
    
    public void initializeEvents(){
        introGame = new HashMap();
        introContext = new HashMap();
        newPlayableCharacter = new HashMap();

        Map<Integer, String> introGameMessage = new HashMap();
        Map<Integer, String> introContextMessage = new HashMap();
        Map<Integer, String> characterInitialisationMessage = new HashMap();
        
        introGameMessage.put(1,"Bonjour et bienvenue dans " + gameName + "\nLa partie va commencer");
        NewDialog introGame1 = new NewDialog(introGameMessage);
        introGame.put(1, introGame1);
        
        
        //Affichage du script qui introduit le contexte du jeu
        introContextMessage.put(1,"Vous partez au Pérou en voyage \nVous esseyez de faire passer de la drogue en revennant \nVous vous faites chopper \nDirection la Prison");
        NewDialog introContext1 = new NewDialog(introContextMessage); 
        introContext.put(1, introContext1);
     
        //Affichage du script pour initialiser le personnage (en fonction des choix du joueur)
        characterInitialisationMessage.put(1, "Une fois dans votre cellule, un homme vous interpelle... \nQui est tu?");
        NewPlayer mainCharacterInitialisation = new NewPlayer(); 
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
        team1 = new HashMap();
        team2 = new HashMap();
        
        Map<Characteristic, Integer> c = new HashMap();
        c.put(Characteristic.HEALTH, 100);
        c.put(Characteristic.DEFENCE, 10);
        c.put(Characteristic.DEXTERITY, 10);
        c.put(Characteristic.STRENGTH, 10);
        
        Character c1a = new Boxer("Combatant_1_t1",CharacterType.HUMAN);
        Character c1b = new MaleNurse("Combatant_2_t1",CharacterType.HUMAN);
        Character c1c = new Highbrow("Combatant_3_t1",CharacterType.HUMAN);
        
        Character c2a = new Boxer("Combatant_1_t2",CharacterType.HUMAN);
        Character c2b = new MaleNurse("Combatant_2_t2",CharacterType.HUMAN);
        Character c2c = new Highbrow("Combatant_3_t2",CharacterType.HUMAN);
        
        team1.put(1, c1a);
        team1.put(2, c1b);
        team1.put(3, c1c);
        
        team2.put(1, c2a);
        team2.put(2, c2b);
        team2.put(3, c2c);
        
        NewFight fightTest = new NewFight(team1,team2);
        fightTest.display();
    }
}
