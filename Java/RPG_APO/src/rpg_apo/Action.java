package rpg_apo;

public class Action {

	private Character target;
	private Character src;
	private Capacity cap;
	private ConsumableItem consum;
        
        public Action(Character t, Character s){
            this.target=t;
            this.src=s;
            this.cap=null;
            this.consum=null;
        }

        
        
        public void SetCapacity(){
            
        }
        
}