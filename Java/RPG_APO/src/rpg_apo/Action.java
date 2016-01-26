package rpg_apo;

public class Action {
        // An action is made of a target, a source, and a capacity or an item
	private Character target;
	private Character src;
	private Capacity cap;
	private ConsumableItem consum;
        
        // Constructor for a capacity
        public Action( Character s, Character t, Capacity c){
            this.target=t;
            this.src=s;
            this.cap=c;
            this.consum=null;
        }
        
        // Contructor for an item
        public Action(Character t, Character s, ConsumableItem cons){
            this.target=t;
            this.src=s;
            this.cap=null;
            this.consum=cons;
        }
        
        // Function who return the script displayed action reading 
        public String readAction(){
            String actionDisplay = "";
            
            if(consum == null){
                Effect e = cap.effect();
                if(src.isAlive()){
                    if(target.isAlive()){
                    e.applyEffect(e, target);
                    actionDisplay = cap.getDisplayMessage();  
                    }
                    else{
                        actionDisplay = src.getName() + " esseye d'utiliser une capacité sur " + target.getName() + ", mais il est KO, cela ne fait aucun effet!";
                    }
                }
                else{
                    actionDisplay = src.getName() + " est KO, il ne peut pas utiliser de capacités!";
                }
            }
            else{
                Effect e = consum.getEffect();
                if(src.isAlive()){
                    if(target.isAlive()){
                    e.applyEffect(e, target);
                    actionDisplay = src.getName() + consum.getDisplayMessage(); 
                    src.deleteInventary(consum);
                    }
                    else{
                        actionDisplay = src.getName() + " est KO, il ne peut pas utiliser d'item! ";
                    }
                }
                else{
                    actionDisplay = src.getName() + " est KO, il ne peut pas utiliser d'item!";
                }
            }
            return actionDisplay;
        }
                
}