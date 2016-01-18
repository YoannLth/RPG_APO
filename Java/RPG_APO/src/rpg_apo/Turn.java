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
    //private int nbAttaque;
    //private int nbDef;
    //private ArrayList<rpg_apo.Character> attaque;
    //private ArrayList<rpg_apo.Character> def;
    //Les attaquant toujours en premier
    private Map<Integer, rpg_apo.Character> team1;
    private Map<Integer, rpg_apo.Character> team2;
    private Map<rpg_apo.Character, Action> actionsT1;
    private Map<rpg_apo.Character, Action> actionsT2;
    
    public Turn (Map<Integer, rpg_apo.Character> t1, Map<Integer, rpg_apo.Character> t2){
        this.team1 = t1;
        this.team2 = t2;
        this.actionsT1 = new HashMap();
        this.actionsT2 = new HashMap();
    }
    
    public void launchTurnHumanVersusHuman(){
        
        
//        for(int i=1;i<=team1.size();i++){
//            int choice = DisplayUI.getAction(team1.get(i));
//            actionsT1.put(team1.get(i), choice);
//        }
        
        displayRed("-------------");
        
        for(int i=1;i<=team1.size();i++){
            Character currentCharacter = team1.get(i);
            Action currentAction = currentCharacter.getControler().getAction(team2,team1);
            actionsT1.put(currentCharacter, currentAction);
        }
        
        for(int i=1;i<=team1.size();i++){
            Character currentCharacter = team1.get(i);
            Action currentAction = actionsT1.get(currentCharacter);
            displayBlue(currentAction.readAction());
            
        }
        
        displayRed("-------------");
                
        for(int i=1;i<=team2.size();i++){
            Character currentCharacter = team2.get(i);
            displayBlue(currentCharacter.getNameAndInfos());
        }
        
//        for(int i=1;i<=team2.size();i++){
//            int choice = DisplayUI.getAction(team2.get(i));
//            actionsT2.put(team2.get(i), choice);
//        }
    }
    
    public void ListMembreEquipe(ArrayList<rpg_apo.Character> team){
        for (int i = 0; i < team.size(); i++)
        {
            displayBlue("\t%"+ i + ") " + team.get(i).getClassName()+"\n");
        }
    }
    
    //prend en parmetre un joueur
    public void JoueurUseItem(rpg_apo.Character c){
        
    }
    
    //Prend en argument le joueur qui attaquer
    public void JoueurAttack(rpg_apo.Character c){
//        Action a;
//        displayBlue("Voici la liste des personnes que tu peut attaquer :\n");
//        ListMembreEquipe(def);
//        int option = readInt("Choisis le nombre de ton choix : ");
//        while(option>=nbDef)
//        {
//            option = readInt("Choisis le nombre de ton choix : ");
//        }
        
        //a=new Action(c,def.get(option));
        
        
    }
}