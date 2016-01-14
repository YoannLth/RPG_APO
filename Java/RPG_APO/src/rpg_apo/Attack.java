package rpg_apo;

public abstract class Attack implements Capacity {
    private Character source;
    private Character cible;
    
    public Attack(Character s, Character c){
        this.source=s;
        this.cible=c;
    }
    
    
    
    
    
}