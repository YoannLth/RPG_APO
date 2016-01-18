package rpg_apo;

public class Action {

	private Character target;
	private Character src;
	private Capacity cap;
	private ConsumableItem consum;
        
        public Action( Character s, Character t, Capacity c){
            this.target=t;
            this.src=s;
            this.cap=c;
            this.consum=null;
        }
        
        public Action(Character t, Character s, ConsumableItem cons){
            this.target=t;
            this.src=s;
            this.cap=null;
            this.consum=cons;
        }

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
                        actionDisplay = src.getName() + " esseye d'utiliser une capacité sur " + target.getName() + ", mais il est mort, cela ne fait aucun effet!";
                    }
                }
                else{
                    actionDisplay = src.getName() + " est mort, il ne peut pas utiliser de capacités!";
                }
            }
            else{
                actionDisplay = "Tu as choisi un objet";
            }
            return actionDisplay;
        }
        
        public void SetCapacity(){
            
        }
        
}