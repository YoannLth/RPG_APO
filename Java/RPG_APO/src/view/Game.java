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
import rpg_apo.Event;
import rpg_apo.NewDialog;
import rpg_apo.NewPlayer;
import static view.Console.*;

public class Game {
    private String gameName;
    private Map<Integer, Event> events;
    
    public Game(String name){
        gameName = name;
    }
    
    public void launchGame(){
        initializeEvents();
        readEvents();
    }
    
    public void initializeEvents(){
        events = new HashMap();
        String introGameMessage = "Bonjour et bienvenue dans " + gameName + "\nLa partie va commencer";
        NewDialog introGame = new NewDialog(introGameMessage);
            //introGame.displayNewDialog();
        events.put(1, introGame);
        
        
        //Affichage du script qui introduit le contexte du jeu
        String introContextMessage = "Vous partez au Pérou en voyage \nVous esseyez de faire passer de la drogue en revennant \nVous vous faites chopper \nDirection la Prison";
        NewDialog introContext = new NewDialog(introContextMessage);
            //introContext.displayNewDialog(); 
        events.put(2, introContext);
     
        //Affichage du script pour initialiser le personnage (en fonction des choix du joueur)
        String characterInitialisationMessage = "Une fois dans votre cellule, un homme vous interpelle... \nQui est tu?";
        NewPlayer mainCharacterInitialisation = new NewPlayer(characterInitialisationMessage);
            //introContext.displayNewDialog(); 
        events.put(3, mainCharacterInitialisation);
    }
    
    public void readEvents(){
        int sizeEvents = events.size();
        
        for(int i=1;i<=sizeEvents;i++){
            Event currentEvent = events.get(i);
            currentEvent.display();
        }
    }
}
