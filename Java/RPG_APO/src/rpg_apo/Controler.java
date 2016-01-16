package rpg_apo;


public abstract class Controler {
    protected Character charac;
        
        public Controler(Character c){
            this.charac = c;
        }
        
        public abstract Action getAction();
        
	public Action act() {
		// TODO - implement Controler.act
		throw new UnsupportedOperationException();
	}
        
}