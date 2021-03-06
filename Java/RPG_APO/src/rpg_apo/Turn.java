package rpg_apo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import rpg_apo.Action;
import rpg_apo.DisplayUI;
import static view.Console.displayBlack;
import static view.Console.displayBlue;
import static view.Console.displayRed;

public class Turn {
    private ArrayList<Character> team1;
    private ArrayList<Character> team2;
    private Map<rpg_apo.Character, Action> actionsT1;
    private Map<rpg_apo.Character, Action> actionsT2;
    
    public Turn (ArrayList<Character> t1, ArrayList<Character> t2){
        this.team1 = t1;
        this.team2 = t2;
        this.actionsT1 = new HashMap();
        this.actionsT2 = new HashMap(); 
    }
    
    public void launchTurnHumanVersusIA(){
        displayRed("\n------------------------------------------------------\n");
        
        for(int i=0;i<team1.size();i++){
            Character currentCharacter = team1.get(i);
            Action currentAction = currentCharacter.getControler().getAction(team2,team1);
            actionsT1.put(currentCharacter, currentAction);
        }
        
        for(int i=0;i<team2.size();i++){
            Character currentCharacter = team2.get(i);
            Action currentAction = currentCharacter.getControler().getAction(team1,team2);
            actionsT2.put(currentCharacter, currentAction);
        }
        
        for(int i=0;i<team1.size();i++){
            Character currentCharacter = team1.get(i);
            Action currentAction = actionsT1.get(currentCharacter);
            displayBlue(currentAction.readAction());
        }
        
        for(int i=0;i<team2.size();i++){
            Character currentCharacter = team2.get(i);
            Action currentAction = actionsT2.get(currentCharacter);
            displayBlue(currentAction.readAction());
        }
        
        displayRed("------------------------------------------------------------------------------------");
        displayRed("-------------------------------------- Team 1 --------------------------------------");  
        for(int i=0;i<team1.size();i++){
            Character currentCharacter = team1.get(i);
            displayBlack(currentCharacter.getNameAndInfos());
        }
        
        
        displayRed("------------------------------------------------------------------------------------");
        displayRed("-------------------------------------- Team 2 --------------------------------------"); 
        for(int i=0;i<team2.size();i++){
            Character currentCharacter = team2.get(i);
            displayBlack(currentCharacter.getNameAndInfos());
        }
    }
    
    
    public void ListMembreEquipe(ArrayList<rpg_apo.Character> team){
        for (int i = 0; i < team.size(); i++)
        {
            displayRed("\t"+ i + ") " + team.get(i).getClassName()+"\n");
        }
    }
}
