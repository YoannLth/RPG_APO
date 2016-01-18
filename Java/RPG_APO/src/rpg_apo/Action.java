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
                //actionDisplay = src.getName() + " à choisi d'utiliser " + cap.readCapacity() + " sur " + target.getName();
                Effect e = cap.effect();
                e.applyEffect(e, target);
                actionDisplay = cap.getDisplayMessage();
            }
            else{
                actionDisplay = "Tu as choisi un objet";
            }
            return actionDisplay;
        }
        
        public void SetCapacity(){
            
        }
        
}