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
	double probaReussite();

        
        
        String readCapacity();
        
        String getDisplayMessage();
}