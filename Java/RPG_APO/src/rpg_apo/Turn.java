
import java.util.ArrayList;
import rpg_apo.Action;
import static rpg_apo.HumanControler.readInt;
import static view.Console.displayBlue;

public class Turn {
    private int nbAttaque;
    private int nbDef;
    private ArrayList<rpg_apo.Character> attaque;
    private ArrayList<rpg_apo.Character> def;
    //Les attaquant toujours en premier
    
    public Turn (ArrayList<rpg_apo.Character> a, ArrayList<rpg_apo.Character> d){
        this.nbAttaque=a.size();
        this.nbDef=d.size();
        this.attaque=a;
        this.def=d;
    }
    
    public void TeamAttack(){
        for (int i = 0; i < attaque.size(); i++)
        {
            displayBlue("Au joueur " + attaque.get(i).getClassName()+" de faire ces choix\n");
            displayBlue("1) Vous attaquez !!!\n2)  Vous utiliser un objet de votre sac.\n");
            int option = readInt("Choisis le nombre de ton choix : ");
            while(!(option==1 || option==2))
            {
                if(option==1){
                    JoueurAttack(attaque.get(i));
                }else if(option==2){
                    JoueurUseItem(attaque.get(i));
                }else option = readInt("Choisis le nombre de ton choix : ");
            }
            
        }
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
        Action a;
        displayBlue("Voici la liste des personnes que tu peut attaquer :\n");
        ListMembreEquipe(def);
        int option = readInt("Choisis le nombre de ton choix : ");
        while(option>=nbDef)
        {
            option = readInt("Choisis le nombre de ton choix : ");
        }
        
        //a=new Action(c,def.get(option));
        
        
    }
}