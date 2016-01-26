package rpg_apo;

public interface Capacity {
        
        // Function who return the effect of a capacity
	Effect effect() ;

        // Function who define success probability of the success
	double probaSuccess();

        // Function for effect displaying
        String readCapacity();
        
        // Function who return the string for effect displaying
        String getDisplayMessage();
}