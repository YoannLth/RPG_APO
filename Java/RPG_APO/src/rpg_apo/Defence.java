package rpg_apo;

public class Defence implements Capacity {
    private Character source;
    private Character cible;
    private String displayedMessage;
    
    public Defence(Character s){
        this.source = s;
        this.displayedMessage = "";
    }
    
    @Override
    public Effect effect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double probaReussite(Character src) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String readCapacity() {
        String readCap = "'défense'";
        
        return readCap;
    }

    @Override
    public String getDisplayMessage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}