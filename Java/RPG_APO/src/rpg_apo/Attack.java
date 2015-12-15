package rpg_apo;

public abstract class Attack implements Capacity {
    private Character source;
    private Character cible;
    
    public Attack(Character s, Character c){
        this.source=s;
        this.cible=c;
    }
    
    public Effect effect(){
        Characteristic c = null;
        int value = -10;
        int permanent = 0;
        
        Effect e = new Effect(c,value,permanent);
        return e;
    }
    
    
    
    
}