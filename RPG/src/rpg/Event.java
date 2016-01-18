/*
 *  Projet - APO Creation d'un RPG
 *  Decembre 2015
 *  Gaetan MARTIN & Jensen Joymangul
 */
package rpg;

import Controller.*;
import java.util.ArrayList;
import java.util.Stack;
import me.grea.antoine.utils.Log;


/**
 *
 * @author seljo
 */
public class Event
{
    private ArrayList<Character> playerCharacters;
    private ArrayList<Character> aiCharacters;

    //------------------------- Constructor ------------------------------
    /**
     * 
     * @param playerChacraters List of player character
     * @param aiChacraters  List of AI character
     */
    public Event(ArrayList<Character> playerChacraters, ArrayList<Character> aiChacraters)
    {
        this.playerCharacters = playerChacraters;
        this.aiCharacters = aiChacraters;
    }
    
    
    /**
     * Method use to generate the actions for a fight and play a round according to these actions
     */
    public void fight()
    {
        while(this.haveWinner() == false)
        {
            System.out.println("I'm in fight");
            ArrayList<ControllerPlayer> playerControllers = new ArrayList<>();
            ArrayList<ControllerAI> aiControllers = new ArrayList<>();

            Stack<Action> playerActions = new Stack<>(); 
            Stack<Action> aiAction = new Stack<>();

            for (Character player : playerCharacters)
            {
                playerControllers.add(new ControllerPlayer(player));
            }

            for (Character ai : aiCharacters)
            {
                aiControllers.add(new ControllerAI(ai, playerCharacters, aiCharacters));
            }

            for (ControllerPlayer cp : playerControllers)
            {
                System.out.println("***********************");
                System.out.println("Round of " + cp.getCharacter().getName());
                turn(cp.getCharacter());

                System.out.println("Select a target : ");
                Character target = this.getAICharacterByName();
                Action a = cp.getAction(target);
                playerActions.push(a);
                new DisplayCharacter(target).displayAll();
            }
            Round fightRound = new Round(playerCharacters,playerActions, aiCharacters,playerActions);
            fightRound.play();
        }
    }
    
    /**
     * 
     * @return true if found winner false no winner found 
     */
    private boolean haveWinner()
    {
        if(this.playerCharacters.isEmpty())
        {
            System.out.println("              ~~~~~~~~~");
            System.out.println("            /           \\");
            System.out.println("           /             \\");
            System.out.println("          | )           ( |");
            System.out.println("           \\  /C\\   /C\\  /");
            System.out.println("           /  ~~~   ~~~  \\");
            System.out.println("           \\___  .^,  ___/");
            System.out.println("            `| _______ |'");
            System.out.println("         _   | HHHHHHH |   _");
            System.out.println("        ( )  \\         /  ( )");
            System.out.println("       (_) \\  ~~~~^~~~~ ,/ (_)");
            System.out.println("         ~\\ \"\\         /  /~");
            System.out.println("            \\  \\     /  /");
            System.out.println("              \\  \\v/  /");
            System.out.println("               >     <");
            System.out.println("              /  /^\\  \\");
            System.out.println("            /  /     \\  \\");
            System.out.println("        _~/ \"/         \\  \\~_");
            System.out.println("       ( ) /             \\ ( )");
            System.out.println("        (_)               (_)");
            return true;
        } 
        else if (this.aiCharacters.isEmpty())
        {
            System.out.println("                                            .''.");
            System.out.println("                  .''.             *''*    :_\\/_:     . ");
            System.out.println("                 :_\\/_:   .    .:.*_\\/_*   : /\\ :  .'.:.'.");
            System.out.println("              .''.: /\\ : _\\(/_  ':'* /\\ *  : '..'.  -=:o:=-");
            System.out.println("             :_\\/_:'.:::. /)\\*''*  .|.* '.\\'/.'_\\(/_'.':'.'");
            System.out.println("             : /\\ : :::::  '*_\\/_* | |  -= o =- /)\\    '  *");
            System.out.println("              '..'  ':::'   * /\\ * |'|  .'/.\'.  '._____");
            System.out.println("                  *        __*..* |  |     :      |.   |' .---\"|");
            System.out.println("                   _*   .-'   '-. |  |     .--'|  ||   | _|    |");
            System.out.println("                .-'|  _.|  |    ||   '-__  |   |  |    ||      |");
            System.out.println("                |' | |.    |    ||       | |   |  |    ||      |");
            System.out.println("             ___|  '-'     '    \"\"       '-'   '-.'    '`      |___");
            System.out.println("            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("    `YMM'   `MM'                     `7MMF'     A     `7MF'           ");      
            System.out.println("      VMA   ,V                         `MA     ,MA     ,V       ");            
            System.out.println("       VMA ,V ,pW\"Wq.`7MM  `7MM         VM:   ,VVM:   ,V ,pW\"Wq.`7MMpMMMb.  ");
            System.out.println("        VMMP 6W'   `Wb MM    MM          MM.  M' MM.  M'6W'   `Wb MM    MM  ");
            System.out.println("         MM  8M     M8 MM    MM          `MM A'  `MM A' 8M     M8 MM    MM  ");
            System.out.println("         MM  YA.   ,A9 MM    MM           :MM;    :MM;  YA.   ,A9 MM    MM  ");
            System.out.println("       .JMML. `Ybmd9'  `Mbod\"YML.          VF      VF    `Ybmd9'.JMML  JMML.");
 
            return true;
        }
        return false;
    }
    
    /**
     * Display all the characters
     */
    private void displayCharacters()
    {
        this.displayPlayerCharacters();
        this.displayAICharacters();
    }
    
    /**
     * Display all the characters of the player
     */
    private void displayPlayerCharacters()
    {
        System.out.println("List of the player characters : ");
        for (int i = 0; i < playerCharacters.size(); i++)
        {
            System.out.println(playerCharacters.get(i).getName());
        }
    }
    
    /**
     * Display all the characters of the AI
     */
    private void displayAICharacters()
    {
        System.out.println("List of the AI characters : ");
        for (int i = 0; i < aiCharacters.size(); i++)
        {
            System.out.println(aiCharacters.get(i).getName());
        }
    }
    
    /**
     * Ask for a target among the AI Characters
     * 
     * @return AI character corresponding to the name typed in
     */
    private Character getAICharacterByName()
    {
        this.displayAICharacters();
        String name = DisplayUI.getCharacterName();
        for(Character aiCharacter : aiCharacters)
        {
            if (aiCharacter.getName().equals(name))
                return aiCharacter;
        }
        return this.getAICharacterByName();
    }
    
    /**
     * Ask for a target among the Player Characters
     *
     * @return player character corresponding to the name typed in
     */
    private Character getPlayerCharacterByName()
    {
        this.displayPlayerCharacters();
        String name = DisplayUI.getCharacterName();
        for(Character playerCharacter : playerCharacters)
        {
            if (playerCharacter.getName().equals(name))
                return playerCharacter;
        }
        return this.getPlayerCharacterByName();
    }

    
    /**
     * Show all the actions possible : continue, leave game, consult Inventory, etc..
     */
    private void turn(Character character)
    {
        int choice = DisplayUI.getActionTurn();
        switch (choice)
        {
            case 0 : rpg.RPG.quitGame(); break;
            case 1 : new DisplayCharacter(character).displayInventory(); break;
            case 2 : new DisplayCharacter(character).displayAll(); break;
            case 3 : return;
            default : break;
        }
        turn(character);
    }
    
}
