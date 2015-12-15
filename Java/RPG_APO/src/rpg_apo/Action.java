package rpg_apo;

public class Action {

	private Character target;
	private Character src;
	private Capacity cap;
	private ConsumableItem consum;
        
        public Action(Character t, Character s, Capacity c){
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

        
        
        public void SetCapacity(){
            
        }
        
}