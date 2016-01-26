package rpg_apo;

public interface Capacity {

	/**
	 * 
	 * @param src
	 * @param target
	 */
	Effect effect() ;

	/**
	 * 
	 * @param src
	 */
	double probaSuccess();

        
        
        String readCapacity();
        
        String getDisplayMessage();
}