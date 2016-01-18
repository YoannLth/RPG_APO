package rpg_apo;

public interface Capacity {

	/**
	 * 
	 * @param src
	 * @param target
	 */
	Effect effect();

	/**
	 * 
	 * @param src
	 */
	double probaReussite(Character src);

        
        
        String readCapacity();
        
        String getDisplayMessage();
}